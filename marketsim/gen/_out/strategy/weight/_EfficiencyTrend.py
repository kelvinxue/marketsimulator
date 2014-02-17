def efficiencyTrend(alpha = None): 
    from marketsim import float
    from marketsim.gen._out.strategy.weight.trader._trader_efficiencytrend import trader_EfficiencyTrend_Float as _strategy_weight_trader_trader_EfficiencyTrend_Float
    from marketsim import rtti
    if alpha is None or rtti.can_be_casted(alpha, float):
        return _strategy_weight_trader_trader_EfficiencyTrend_Float(alpha)
    raise Exception('Cannot find suitable overload for efficiencyTrend('+str(alpha)+')')
from marketsim import IFunction
from marketsim import IAccount
from marketsim import registry
from marketsim import context
from marketsim import float
@registry.expose(["Strategy", "EfficiencyTrend"])
class EfficiencyTrend_IAccountFloat(IFunction[float]):
    """ 
    """ 
    def __init__(self, trader = None, alpha = None):
        from marketsim.gen._out.trader._singleproxy import SingleProxy_ as _trader_SingleProxy_
        from marketsim import rtti
        self.trader = trader if trader is not None else _trader_SingleProxy_()
        self.alpha = alpha if alpha is not None else 0.15
        rtti.check_fields(self)
        self.impl = self.getImpl()
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'trader' : IAccount,
        'alpha' : float
    }
    def __repr__(self):
        return "EfficiencyTrend(%(trader)s, %(alpha)s)" % self.__dict__
    
    def bind(self, ctx):
        self._ctx = ctx.clone()
    
    _internals = ['impl']
    def __call__(self, *args, **kwargs):
        return self.impl()
    
    def reset(self):
        self.impl = self.getImpl()
        ctx = getattr(self, '_ctx', None)
        if ctx: context.bind(self.impl, ctx)
    
    def getImpl(self):
        from marketsim.gen._out.math._derivative import Derivative_IDifferentiable as _math_Derivative_IDifferentiable
        from marketsim.gen._out.math.EW._avg import Avg_IObservableFloatFloat as _math_EW_Avg_IObservableFloatFloat
        from marketsim.gen._out.trader._efficiency import Efficiency_IAccount as _trader_Efficiency_IAccount
        return _math_Derivative_IDifferentiable(_math_EW_Avg_IObservableFloatFloat(_trader_Efficiency_IAccount(self.trader),self.alpha))
    
def EfficiencyTrend(trader = None,alpha = None): 
    from marketsim import IAccount
    from marketsim import float
    from marketsim import rtti
    if trader is None or rtti.can_be_casted(trader, IAccount):
        if alpha is None or rtti.can_be_casted(alpha, float):
            return EfficiencyTrend_IAccountFloat(trader,alpha)
    raise Exception('Cannot find suitable overload for EfficiencyTrend('+str(trader)+','+str(alpha)+')')
