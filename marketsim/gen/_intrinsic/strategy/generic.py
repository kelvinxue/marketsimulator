from marketsim import (registry, meta, _, types, Side, mathutils, order, 
                       event, ops)
from marketsim.types import *

from basic import Strategy

class _Generic_Impl(Strategy):    
     
    def __init__(self):                
        Strategy.__init__(self)
        event.subscribe(self.eventGen, _(self)._wakeUp, self)
         
    def _wakeUp(self, _):
        # determine side and parameters of an order to create
        order = self.orderFactory()
        # send order to the order book
        if order is not None:
            self._send(order)
