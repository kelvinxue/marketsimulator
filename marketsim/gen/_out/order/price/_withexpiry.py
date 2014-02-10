def WithExpiry(expiry = None,proto = None): 
    from marketsim import IFunction
    from marketsim import float
    from marketsim import IOrderGenerator
    from marketsim import rtti
    if expiry is None or rtti.can_be_casted(expiry, IFunction[float]):
        if proto is None or rtti.can_be_casted(proto, IFunction[IOrderGenerator,IFunction[float]]):
            return WithExpiry_IFunctionFloatIOrderGenerator(expiry,proto)
    raise Exception("Cannot find suitable overload")
