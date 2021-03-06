# generated with class generator.python.random$Import
from marketsim import registry
from marketsim.gen._out._ifunction._ifunctionfloat import IFunctionfloat
@registry.expose(["Random", "betavariate"])
class betavariate_FloatFloat(IFunctionfloat):
    """ **Beta distribution**
    
    
     Conditions on the parameters are |alpha| > 0 and |beta| > 0.
     Returned values range between 0 and 1.
    
    Parameters are:
    
    **Alpha**
    
    **Beta**
    """ 
    def __init__(self, Alpha = None, Beta = None):
        self.Alpha = Alpha if Alpha is not None else 1.0
        self.Beta = Beta if Beta is not None else 1.0
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'Alpha' : float,
        'Beta' : float
    }
    
    
    
    
    def __repr__(self):
        return "betavariate(%(Alpha)s, %(Beta)s)" % dict([ (name, getattr(self, name)) for name in self._properties.iterkeys() ])
    
    def bind_ex(self, ctx):
        if self.__dict__.get('_bound_ex', False): return
        self.__dict__['_bound_ex'] = True
        if self.__dict__.get('_processing_ex', False):
            raise Exception('cycle detected')
        self.__dict__['_processing_ex'] = True
        
        
        if hasattr(self, '_subscriptions'):
            for s in self._subscriptions: s.bind_ex(self.__dict__['_ctx_ex'])
        self.__dict__['_processing_ex'] = False
    
    def reset_ex(self, generation):
        if self.__dict__.get('_reset_generation_ex', -1) == generation: return
        self.__dict__['_reset_generation_ex'] = generation
        if self.__dict__.get('_processing_ex', False):
            raise Exception('cycle detected')
        self.__dict__['_processing_ex'] = True
        
        
        if hasattr(self, '_subscriptions'):
            for s in self._subscriptions: s.reset_ex(generation)
        self.__dict__['_processing_ex'] = False
    
    def typecheck(self):
        from marketsim import rtti
        rtti.typecheck(float, self.Alpha)
        rtti.typecheck(float, self.Beta)
    
    def registerIn(self, registry):
        if self.__dict__.get('_id', False): return
        self.__dict__['_id'] = True
        if self.__dict__.get('_processing_ex', False):
            raise Exception('cycle detected')
        self.__dict__['_processing_ex'] = True
        registry.insert(self)
        
        if hasattr(self, '_subscriptions'):
            for s in self._subscriptions: s.registerIn(registry)
        self.__dict__['_processing_ex'] = False
    
    def __call__(self, *args, **kwargs):
        import random
        return random.betavariate(self.Alpha, self.Beta)
    
    def _casts_to(self, dst):
        return betavariate_FloatFloat._types[0]._casts_to(dst)
    
def betavariate(Alpha = None,Beta = None): 
    from marketsim import rtti
    if Alpha is None or rtti.can_be_casted(Alpha, float):
        if Beta is None or rtti.can_be_casted(Beta, float):
            return betavariate_FloatFloat(Alpha,Beta)
    raise Exception('Cannot find suitable overload for betavariate('+str(Alpha) +':'+ str(type(Alpha))+','+str(Beta) +':'+ str(type(Beta))+')')
