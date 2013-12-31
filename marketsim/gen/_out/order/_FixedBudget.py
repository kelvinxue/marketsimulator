from marketsim import registry
from marketsim import IOrderGenerator
from marketsim import Order
from marketsim.ops._all import Observable
from marketsim import types
from marketsim import Side
from marketsim import IFunction
@registry.expose(["Order", "FixedBudget"])
class FixedBudget(IOrderGenerator, Observable[Order]):
    """ 
    """ 
    def __init__(self, side = None, budget = None):
        from marketsim import Order
        from marketsim.ops._all import Observable
        from marketsim.gen._out.side._Sell import Sell
        from marketsim import event
        from marketsim import types
        from marketsim.gen._out._constant import constant
        from marketsim import event
        from marketsim import types
        Observable[Order].__init__(self)
        self.side = side if side is not None else Sell()
        if isinstance(side, types.IEvent):
            event.subscribe(self.side, self.fire, self)
        self.budget = budget if budget is not None else constant(1000.0)
        if isinstance(budget, types.IEvent):
            event.subscribe(self.budget, self.fire, self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'side' : types.IFunction[Side]
        ,
        'budget' : IFunction[float]
    }
    def __repr__(self):
        return "FixedBudget(%(side)s, %(budget)s)" % self.__dict__
    
    def __call__(self, *args, **kwargs):
        from marketsim.gen._intrinsic.order.meta.fixed_budget import Order_Impl
        side = self.side()
        if side is None: return None
        
        budget = self.budget()
        if budget is None: return None
        
        return Order_Impl(side, budget)
    

from marketsim import registry
from marketsim import types
from marketsim import IFunction
@registry.expose(["Order", "FixedBudget"])
@types.sig((types.IFunction[Side],), IOrderGenerator)
class side_FixedBudget(object):
    """ 
    """ 
    def __init__(self, budget = None):
        from marketsim.gen._out._constant import constant
        self.budget = budget if budget is not None else constant(1000.0)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'budget' : IFunction[float]
    }
    def __repr__(self):
        return "side_FixedBudget(%(budget)s)" % self.__dict__
    
    def __call__(self, side = None):
        from marketsim.gen._out.side._Sell import Sell
        side = side if side is not None else Sell()
        budget = self.budget
        return FixedBudget(side, budget)
    






