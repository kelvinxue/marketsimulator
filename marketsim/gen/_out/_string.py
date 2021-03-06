class String(object):
    def Quote(self, start = None,end = None):
        from marketsim.gen._out.observable._quote import Quote
        return Quote(self,start,end)
    
    def MarketData(self, start = None,end = None,delta = None,volume = None):
        from marketsim.gen._out.strategy.price._marketdata import MarketData
        return MarketData(self,start,end,delta,volume)
    
    @property
    def Graph(self):
        from marketsim.gen._out.js._graph import Graph
        return Graph(self)
    
    def Local(self, tickSize = None,_digitsToShow = None,timeseries = None):
        from marketsim.gen._out.orderbook._local import Local
        return Local(self,tickSize,_digitsToShow,timeseries)
    
    pass
