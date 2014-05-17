package marketsim.orderbook

import marketsim._
import marketsim.MarketOrder
import marketsim.LimitOrder

class Local(processingTime : Time = 0.0) extends OrderbookDispatch {

    val Asks = new Queue[SellEntry]
    val Bids = new Queue[BuyEntry]

    override def toString = "{asks = " + Asks + "; " + "bids = " + Bids + "}"

    private val requests = collection.mutable.Queue[Request]()

    import marketsim.Scheduler.scheduleAfter

    private def wakeUp() {
        requests.dequeue() processIn this
        if (requests.nonEmpty)
            scheduleAfter(processingTime, { wakeUp() })
    }

    def handle(request : Request) = {
        requests enqueue request
        if (requests.length == 1)
            scheduleAfter(processingTime, { wakeUp() })
    }

    import marketsim.Scheduler.async

    def process(order : MarketOrder, events : OrderListener) =
    {
        def inner[T <: Entry](opposite : Queue[T]) = {
            val unmatched = opposite matchWith (order, events)
            async { events OnStopped (order, unmatched) }
        }

        order.side match {
            case Sell => inner(Bids)
            case Buy =>  inner(Asks)
        }
    }

    def process(order : LimitOrder, events : OrderListener) =
    {
        val unmatched = order.side match {
            case Sell =>
                val unmatched = Bids matchWith (order, events)
                if (unmatched > 0)
                    Asks insert SellEntry(order, unmatched, events)
                unmatched
            case Buy =>
                val unmatched = Asks matchWith (order, events)
                if (unmatched > 0)
                    Bids insert BuyEntry(order, unmatched, events)
                unmatched
        }
        if (unmatched == 0)
            async { events OnStopped (order, unmatched)}
    }

    def process(cancel : CancelOrder) =

        cancel.order.side match {
            case Sell => //Asks cancel (cancel.order, cancel.order.owner)
            case Buy  => //Bids cancel (cancel.order, cancel.order.owner)
        }
}
