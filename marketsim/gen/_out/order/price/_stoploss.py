def StopLoss(maxloss = None,proto = None): 
    from marketsim import IFunction
    from marketsim import float
    from marketsim import IOrderGenerator
    from marketsim import rtti
    if maxloss is None or rtti.can_be_casted(maxloss, IFunction[float]):
        if proto is None or rtti.can_be_casted(proto, IFunction[IOrderGenerator,IFunction[float]]):
            return StopLoss_IFunctionFloatIOrderGenerator(maxloss,proto)
    raise Exception("Cannot find suitable overload")
