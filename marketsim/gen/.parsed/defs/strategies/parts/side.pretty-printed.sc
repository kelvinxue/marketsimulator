@category = "Side function"

package strategy.side() {
    abstract type SideStrategy
    {
        // defined at defs\strategies\parts\side.sc: 6.9
        def Strategy(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
                     /** order factory function*/ orderFactory = order.side.Market()) = Generic(orderFactory(Side),eventGen)
    }
    
    // defined at defs\strategies\parts\side.sc: 12.5
    /** Side function for a noise trading strategy
     */
    def Noise(side_distribution = math.random.uniform(0.0,1.0)) = if side_distribution>0.5 then side.Sell() else side.Buy()
    
    // defined at defs\strategies\parts\side.sc: 19.5
    /** Side function for signal strategy
     */
    @python.observable()
    def Signal(/** signal to be listened to */ signal = constant(0.0),
               /** threshold when the trader starts to act */ threshold = 0.7) = if signal>threshold then side.Buy() else if signal<0-threshold then side.Sell() else side.Nothing()
    
    // defined at defs\strategies\parts\side.sc: 32.5
    /** Side function for trend follower strategy
     */
    def TrendFollower(/** parameter |alpha| for exponentially weighted moving average */ alpha = 0.15,
                      /** threshold when the trader starts to act */ threshold = 0.0,
                      /** asset in question */ book = orderbook.OfTrader()) = Signal(book~>MidPrice~>EW(alpha)~>Avg~>Derivative,threshold)
    
    type CrossingAverages(/** parameter |alpha| for exponentially weighted moving average 1 */ alpha_1 = 0.15,/** parameter |alpha| for exponentially weighted moving average 2 */ alpha_2 = 0.015,/** threshold when the trader starts to act */ threshold = 0.0,/** asset in question */ book = .orderbook.OfTrader()) : SideStrategy
    {
        // defined at defs\strategies\parts\side.sc: 61.9
        def Side() = Signal(book~>MidPrice~>EW(alpha_1)~>Avg-book~>MidPrice~>EW(alpha_2)~>Avg,threshold)
    }
    
    type FundamentalValue(/** observable fundamental value */ fv = .constant(200.0),/** asset in question */ book = .orderbook.OfTrader()) : SideStrategy
    {
        // defined at defs\strategies\parts\side.sc: 79.9
        /** Side function for fundamental value strategy
         */
        def FV_Side() = if book~>Bids~>BestPrice>fv then side.Sell() else if book~>Asks~>BestPrice<fv then side.Buy() else side.Nothing()
        
        // defined at defs\strategies\parts\side.sc: 87.9
        def Side() = FV_Side
    }
    
    type MeanReversion(/** parameter |alpha| for exponentially weighted moving average */ alpha = 0.015,/** asset in question */ book = orderbook.OfTrader()) : SideStrategy
    {
        // defined at defs\strategies\parts\side.sc: 102.9
        /** Side function for mean reversion strategy
         */
        def Side() = FundamentalValue(book~>MidPrice~>EW(alpha)~>Avg,book)~>FV_Side
    }
    
    type PairTrading(/** reference to order book for another asset used to evaluate fair price of our asset */ bookToDependOn = .orderbook.OfTrader(),/** multiplier to obtain fair asset price from the reference asset price */ factor = 1.0,/** asset in question */ book = orderbook.OfTrader()) : SideStrategy
    {
        // defined at defs\strategies\parts\side.sc: 126.9
        /** Side function for pair trading strategy
         */
        def Side() = FundamentalValue(bookToDependOn~>MidPrice*factor,book)~>FV_Side
    }
}
