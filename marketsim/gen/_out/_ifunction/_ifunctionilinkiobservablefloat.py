from marketsim.gen._out._iobservable._iobservablefloat import IObservablefloat
from marketsim.gen._out._ilink import ILink
from marketsim import meta
#.IObservable[.Float] => .ILink
class IFunctionILinkIObservablefloat(object):
    _types = [meta.function((IObservablefloat,),ILink)]
    
    pass


