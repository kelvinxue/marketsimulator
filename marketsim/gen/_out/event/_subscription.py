# generated with class generator.python.intrinsic_function$Import
from marketsim.gen._out.event._isubscription import ISubscription
from marketsim.gen._intrinsic.event import Subscription_Impl

class Subscription_AnyAny(ISubscription,Subscription_Impl):
    """ 
    """ 
    def __init__(self, event , listener ):
        self.event = event
        self.listener = listener
        Subscription_Impl.__init__(self)
    
    @property
    def label(self):
        return repr(self)
    
    _properties = {
        'event' : object,
        'listener' : object
    }
    
    
    
    
    def __repr__(self):
        return "Subscription(%(event)s, %(listener)s)" % dict([ (name, getattr(self, name)) for name in self._properties.iterkeys() ])
    
    def bind_ex(self, ctx):
        if self.__dict__.get('_bound_ex', False): return
        self.__dict__['_bound_ex'] = True
        if self.__dict__.get('_processing_ex', False):
            raise Exception('cycle detected')
        self.__dict__['_processing_ex'] = True
        self.__dict__['_ctx_ex'] = ctx.updatedFrom(self)
        if hasattr(self, '_internals'):
            for t in self._internals:
                v = getattr(self, t)
                if type(v) in [list, set]:
                    for w in v: w.bind_ex(self.__dict__['_ctx_ex'])
                else:
                    v.bind_ex(self.__dict__['_ctx_ex'])
        self.event.bind_ex(self._ctx_ex)
        self.listener.bind_ex(self._ctx_ex)
        self.bind_impl(self.__dict__['_ctx_ex'])
        if hasattr(self, '_subscriptions'):
            for s in self._subscriptions: s.bind_ex(self.__dict__['_ctx_ex'])
        self.__dict__['_processing_ex'] = False
    
    def reset_ex(self, generation):
        if self.__dict__.get('_reset_generation_ex', -1) == generation: return
        self.__dict__['_reset_generation_ex'] = generation
        if self.__dict__.get('_processing_ex', False):
            raise Exception('cycle detected')
        self.__dict__['_processing_ex'] = True
        if hasattr(self, '_internals'):
            for t in self._internals:
                v = getattr(self, t)
                if type(v) in [list, set]:
                    for w in v: w.reset_ex(generation)
                else:
                    v.reset_ex(generation)
        self.event.reset_ex(generation)
        self.listener.reset_ex(generation)
        self.reset()
        if hasattr(self, '_subscriptions'):
            for s in self._subscriptions: s.reset_ex(generation)
        self.__dict__['_processing_ex'] = False
    
    def typecheck(self):
        from marketsim import rtti
        rtti.typecheck(object, self.event)
        rtti.typecheck(object, self.listener)
    
    def registerIn(self, registry):
        if self.__dict__.get('_id', False): return
        self.__dict__['_id'] = True
        if self.__dict__.get('_processing_ex', False):
            raise Exception('cycle detected')
        self.__dict__['_processing_ex'] = True
        registry.insert(self)
        self.event.registerIn(registry)
        self.listener.registerIn(registry)
        if hasattr(self, '_subscriptions'):
            for s in self._subscriptions: s.registerIn(registry)
        if hasattr(self, '_internals'):
            for t in self._internals:
                v = getattr(self, t)
                if type(v) in [list, set]:
                    for w in v: w.registerIn(registry)
                else:
                    v.registerIn(registry)
        self.__dict__['_processing_ex'] = False
    
    def bind_impl(self, ctx):
        Subscription_Impl.bind_impl(self, ctx)
    
    def reset(self):
        Subscription_Impl.reset(self)
    
def Subscription(event = None,listener = None): 
    from marketsim import rtti
    if event is None or rtti.can_be_casted(event, object):
        if listener is None or rtti.can_be_casted(listener, object):
            return Subscription_AnyAny(event,listener)
    raise Exception('Cannot find suitable overload for Subscription('+str(event) +':'+ str(type(event))+','+str(listener) +':'+ str(type(listener))+')')
