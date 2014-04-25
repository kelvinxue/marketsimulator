def identityF(): 
    from marketsim.gen._out.strategy.weight.f._f_identityf import f_IdentityF_ as _strategy_weight_f_f_IdentityF_
    from marketsim import rtti
    return _strategy_weight_f_f_IdentityF_()
    raise Exception('Cannot find suitable overload for identityF('++')')
# generated with class generator.python.function$Import
from marketsim import registry
from marketsim.gen._out._ifunction._ifunctionfloat import IFunctionfloat
@registry.expose(["Strategy", "IdentityF"])
class IdentityF_Float(IFunctionfloat):
    """ **identity scaling = f(x)**
    
    
    Parameters are:
    
    **f**
    """ 
    def __init__(self, f = None):
        from marketsim.gen._out._constant import constant_Float as _constant_Float
        from marketsim import deref_opt
        from marketsim import rtti
        self.f = f if f is not None else deref_opt(_constant_Float(1.0))
        rtti.check_fields(self)
        self.impl = self.getImpl()
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'f' : IFunctionfloat
    }
    
    
    def __repr__(self):
        return "IdentityF(%(f)s)" % dict([ (name, getattr(self, name)) for name in self._properties.iterkeys() ])
    
    def bind_ex(self, ctx):
        if self.__dict__.get('_bound_ex', False): return
        self.__dict__['_bound_ex'] = True
        if self.__dict__.get('_processing_ex', False):
            raise Exception('cycle detected')
        self.__dict__['_processing_ex'] = True
        self.__dict__['_ctx_ex'] = ctx.updatedFrom(self)
        self.f.bind_ex(self._ctx_ex)
        if hasattr(self, '_subscriptions'):
            for s in self._subscriptions: s.bind_ex(self.__dict__['_ctx_ex'])
        self.impl.bind_ex(self.__dict__['_ctx_ex'])
        self.__dict__['_processing_ex'] = False
    
    def bind(self, ctx):
        self._ctx = ctx.clone()
    
    _internals = ['impl']
    def __call__(self, *args, **kwargs):
        return self.impl()
    
    def reset(self):
        from marketsim import context
        self.impl = self.getImpl()
        ctx_ex = getattr(self, '_ctx_ex', None)
        if ctx_ex: self.impl.bind_ex(ctx_ex)
        ctx = getattr(self, '_ctx', None)
        if ctx: context.bind(self.impl, ctx)
    
    def getImpl(self):
        return self.f
    
    def __getattr__(self, name):
        if name[0:2] != '__' and self.impl:
            return getattr(self.impl, name)
        else:
            raise AttributeError
    
def IdentityF(f = None): 
    from marketsim.gen._out._ifunction._ifunctionfloat import IFunctionfloat
    from marketsim import rtti
    if f is None or rtti.can_be_casted(f, IFunctionfloat):
        return IdentityF_Float(f)
    raise Exception('Cannot find suitable overload for IdentityF('+str(f) +':'+ str(type(f))+')')
