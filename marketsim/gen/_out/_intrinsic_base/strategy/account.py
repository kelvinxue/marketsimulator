class Account_Base(object):
    def get_inner(self):
        return self._back_inner
    
    def set_inner(self, value):
        self._back_inner = value
        self.on_inner_set(value)
    
    inner = property(get_inner, set_inner)
    def on_inner_set(self, value):
        pass
    
class VirtualMarket_Base(object):
    def get_inner(self):
        return self._back_inner
    
    def set_inner(self, value):
        self._back_inner = value
        self.on_inner_set(value)
    
    inner = property(get_inner, set_inner)
    def on_inner_set(self, value):
        pass
    