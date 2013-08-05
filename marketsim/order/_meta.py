import _base

class Base(_base.Base):
    
    def _onOrderMatched(self, order, price, volume):
        self.owner._onOrderMatched(self, price, volume)
        
    def _onOrderDisposed(self, order):
        pass
    
    def _onOrderCharged(self, price):
        self.owner._onOrderCharged(price)    
        
    