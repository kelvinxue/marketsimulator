from marketsim import registry
from marketsim import IOrderGenerator
from marketsim import types
from marketsim import Side
from marketsim import IFunction
from marketsim import IFunction
from marketsim import IOrderGenerator
from marketsim import IFunction
from marketsim import types
from marketsim import Side
@registry.expose(["Order", "FloatingPrice"])
class side_FloatingPrice(IFunction[IOrderGenerator, types.IFunction[Side]
]):
    """ 
    """ 
    def __init__(self, floatingPrice = None, proto = None):
        from marketsim.gen._out._constant import constant
        from marketsim.gen._out.order._curried._side_price_Limit import side_price_Limit
        self.floatingPrice = floatingPrice if floatingPrice is not None else constant(10.0)
        self.proto = proto if proto is not None else side_price_Limit()
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'floatingPrice' : IFunction[float],
        'proto' : IFunction[IFunction[IOrderGenerator, IFunction[float]], types.IFunction[Side]
        ]
    }
    def __repr__(self):
        return "side_FloatingPrice(%(floatingPrice)s, %(proto)s)" % self.__dict__
    
    def __call__(self, side = None):
        from marketsim.gen._out.order._FloatingPrice import FloatingPrice
        floatingPrice = self.floatingPrice
        proto = self.proto
        return FloatingPrice(floatingPrice, proto(side))
    
