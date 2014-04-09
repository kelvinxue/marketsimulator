from marketsim import registry
from marketsim.gen._out.strategy.side._fundamentalvaluestrategy import FundamentalValueStrategy
from marketsim.gen._out._iorderbook import IOrderBook
@registry.expose(["-", "PairTrading"])
class PairTrading_IOrderBookFloat(FundamentalValueStrategy):
    """ 
    """ 
    def __init__(self, bookToDependOn = None, factor = None):
        from marketsim.gen._out.orderbook._oftrader import OfTrader_IAccount as _orderbook_OfTrader_IAccount
        from marketsim import deref_opt
        from marketsim import rtti
        self.bookToDependOn = bookToDependOn if bookToDependOn is not None else deref_opt(_orderbook_OfTrader_IAccount())
        self.factor = factor if factor is not None else 1.0
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'bookToDependOn' : IOrderBook,
        'factor' : float
    }
    
    
    
    
    def __repr__(self):
        return "PairTrading(%(bookToDependOn)s, %(factor)s)" % dict([ (name, getattr(self, name)) for name in self._properties.iterkeys() ])
    

    @property
    def Fundamental_Value(self):
        from marketsim.gen._out.strategy.side._fundamental_value import Fundamental_Value
        return Fundamental_Value(self)
    
    @property
    def book(self):
        from marketsim.gen._out.strategy.side._book import book
        return book(self)
    
    @property
    def Side(self):
        from marketsim.gen._out.strategy.side._side import Side
        return Side(self)
    
    @property
    def Factor(self):
        from marketsim.gen._out.strategy.side._factor import Factor
        return Factor(self)
    
    def Strategy(self, eventGen = None,orderFactory = None):
        from marketsim.gen._out.strategy.side._strategy import Strategy
        return Strategy(self,eventGen,orderFactory)
    
    @property
    def BookToDependOn(self):
        from marketsim.gen._out.strategy.side._booktodependon import BookToDependOn
        return BookToDependOn(self)
    
    pass
PairTrading = PairTrading_IOrderBookFloat