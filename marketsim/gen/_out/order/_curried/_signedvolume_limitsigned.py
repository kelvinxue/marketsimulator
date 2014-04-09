from marketsim import registry
from marketsim.gen._out._ifunction._ifunctioniobservableiorder_from_ifunctionfloat import IFunctionIObservableIOrder_from_IFunctionfloat
from marketsim.gen._out._ifunction._ifunctionfloat import IFunctionfloat
@registry.expose(["Order", "LimitSigned"])
class signedVolume_LimitSigned_Float(IFunctionIObservableIOrder_from_IFunctionfloat):
    """ **Factory creating limit orders**
    
    
      Limit orders ask to buy or sell some asset at price better than some limit price.
      If a limit order is not competely fulfilled
      it remains in an order book waiting to be matched with another order.
    
    Parameters are:
    
    **price**
    	 function defining price of orders to create 
    """ 
    def __init__(self, price = None):
        from marketsim.gen._out._constant import constant_Float as _constant_Float
        from marketsim import deref_opt
        from marketsim import rtti
        self.price = price if price is not None else deref_opt(_constant_Float(100.0))
        rtti.check_fields(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'price' : IFunctionfloat
    }
    
    
    def __repr__(self):
        return "LimitSigned(%(price)s)" % dict([ (name, getattr(self, name)) for name in self._properties.iterkeys() ])
    
    def __call__(self, signedVolume = None):
        from marketsim.gen._out._constant import constant_Float as _constant_Float
        from marketsim import deref_opt
        from marketsim.gen._out.order._limitsigned import LimitSigned
        signedVolume = signedVolume if signedVolume is not None else deref_opt(_constant_Float(1.0))
        price = self.price
        return LimitSigned(signedVolume, price)
    
def signedVolume_LimitSigned(price = None): 
    from marketsim.gen._out._ifunction._ifunctionfloat import IFunctionfloat
    from marketsim import rtti
    if price is None or rtti.can_be_casted(price, IFunctionfloat):
        return signedVolume_LimitSigned_Float(price)
    raise Exception('Cannot find suitable overload for signedVolume_LimitSigned('+str(price) +':'+ str(type(price))+')')