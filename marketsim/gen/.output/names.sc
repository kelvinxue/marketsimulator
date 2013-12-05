
package mathutils {
    package rnd {
        /** Gamma distribution
         *
         *  Conditions on the parameters are |alpha| > 0 and |beta| > 0.
         *
         *  The probability distribution function is: ::
         *
         *               x ** (alpha - 1) * math.exp(-x / beta)
         *     pdf(x) =  --------------------------------------
         *                  math.gamma(alpha) * beta ** alpha
         */
        @python.random()
        def gammavariate(Alpha = 1.0,
                         Beta = 1.0) : () => Float
            
        
        /** Normal distribution
         */
        @python.random()
        def normalvariate(/** |mu| is the mean                  */ Mu = 0.0,
                          /** |sigma| is the standard deviation */ Sigma = 1.0) : () => Float
            
        
        /** Pareto distribution
         */
        @python.random()
        def paretovariate(/** |alpha| is the shape parameter*/ Alpha = 1.0) : () => Float
            
        
        /** Triangular distribution
         *
         * Return a random floating point number *N* such that *low* <= *N* <= *high* and
         *       with the specified *mode* between those bounds.
         *       The *low* and *high* bounds default to zero and one.
         *       The *mode* argument defaults to the midpoint between the bounds,
         *       giving a symmetric distribution.
         */
        @python.random()
        def triangular(Low = 0.0,
                       High = 1.0,
                       Mode = 0.5) : () => Float
            
        
        /** Von Mises distribution
         */
        @python.random()
        def vonmisesvariate(/** |mu| is the mean angle, expressed in radians between 0 and 2|pi|*/ Mu = 0.0,
                            /** |kappa| is the concentration parameter, which must be greater than or equal to zero.
                              *      If |kappa| is equal to zero, this distribution reduces
                              *      to a uniform random angle over the range 0 to 2|pi|        */ Kappa = 0.0) : () => Float
            
        
        /** Uniform distribution
         *
         * Return a random floating point number *N* such that
         * *a* <= *N* <= *b* for *a* <= *b* and *b* <= *N* <= *a* for *b* < *a*.
         * The end-point value *b* may or may not be included in the range depending on
         * floating-point rounding in the equation *a* + (*b*-*a*) * *random()*.
         */
        @python.random()
        def uniform(Low = -10.0,
                    High = 10.0) : () => Float
            
        
        /** Weibull distribution
         */
        @python.random()
        def weibullvariate(/** |alpha| is the scale parameter */ Alpha = 1.0,
                           /** |beta| is the shape parameter  */ Beta = 1.0) : () => Float
            
        
        /** Exponential distribution
         *
         *  Returned values range from 0 to positive infinity
         */
        @python.random()
        def expovariate(/** |lambda| is 1.0 divided by the desired mean. It should be greater zero.*/ Lambda = 1.0) : () => Float
            
        
        /** Log normal distribution
         *
         * If you take the natural logarithm of this distribution,
         *  you'll get a normal distribution with mean |mu| and standard deviation |sigma|.
         *  |mu| can have any value, and |sigma| must be greater than zero.
         */
        @python.random()
        def lognormvariate(Mu = 0.0,
                           Sigma = 1.0) : () => Float
            
        
        /** Beta distribution
         *
         * Conditions on the parameters are |alpha| > 0 and |beta| > 0.
         * Returned values range between 0 and 1.
         */
        @python.random()
        def betavariate(Alpha = 1.0,
                        Beta = 1.0) : () => Float
            
    }
}

package mathops {
    /** Arc tangent of x, in radians.
     *
     */
    @python.mathops("Trigonometric", "atan", "atan(%(x)s)")
    def Atan(x = constant(0.0)) : () => Float
        
    
    /** Square root of x
     *
     */
    @python.mathops("Log/Pow", "sqrt", "\\sqrt{%(x)s}")
    def Sqrt(x = constant(1.0)) : () => Float
        
    
    /** Exponent of x
     *
     */
    @python.mathops("Log/Pow", "exp", "e^{%(x)s}")
    def Exp(x = constant(1.0)) : () => Float
        
    
    /** Natural logarithm of x (to base e)
     *
     */
    @python.mathops("Log/Pow", "log", "log(%(x)s)")
    def Log(x = constant(1.0)) : () => Float
        
    
    /** Return *x* raised to the power *y*.
     *
     * Exceptional cases follow Annex F of the C99 standard as far as possible.
     * In particular, ``pow(1.0, x)`` and ``pow(x, 0.0)`` always return 1.0,
     * even when *x* is a zero or a NaN.
     * If both *x* and *y* are finite, *x* is negative, and *y* is not an integer then
     * ``pow(x, y)`` is undefined, and raises ``ValueError``.
     */
    @python.mathops("Log/Pow", "pow", "%(base)s^{%(power)s}")
    def Pow(base = constant(1.0),
            power = constant(1.0)) : () => Float
        
}

package observable {
    package orderbook {
        def PriceAtVolume(queue : () => IOrderQueue,
                          volume = 100.0) : () => Float
            
        
        def WeightedPrice(queue : () => IOrderQueue,
                          alpha = 0.015)
             = EWMA(LastTradePrice(queue)*LastTradeVolume(queue),alpha)/EWMA(LastTradeVolume(queue),alpha)
        
        def TickSize(book = OfTrader()) : () => Float
            
        
        def MidPrice(book = OfTrader())
             = (AskPrice(book)+BidPrice(book))/2.0
        
        def Asks(book = OfTrader()) : () => IOrderQueue
            
        
        def AskPrice(book = OfTrader())
             = BestPrice(Asks(book))
        
        def LastTradeVolume(queue : () => IOrderQueue) : IObservable
            
        
        def BidPrice(book = OfTrader())
             = BestPrice(Bids(book))
        
        def Bids(book = OfTrader()) : () => IOrderQueue
            
        
        def BestPrice(queue : () => IOrderQueue) : IObservable
            
        
        @python.intrinsic.function("Proxies", "$(TraderAsset)", "orderbook.of_trader._OfTrader_Impl")
        def OfTrader() : () => IOrderBook
            
        
        def LastPrice(queue : () => IOrderQueue) : IObservable
            
        
        def Spread(book = OfTrader())
             = AskPrice(book)-BidPrice(book)
        
        def LastTradePrice(queue : () => IOrderQueue) : IObservable
            
    }
    @python.observable("Pow/Log", "{%(x)s}^2")
    def Sqr(x = constant())
         = x*x
    
    @python.observable("Basic", "min{%(x)s, %(y)s}")
    def Min(x = constant(),
            y = constant())
         = if x<y then x else y
    
    @python.observable("Basic", "max{%(x)s, %(y)s}")
    def Max(x = constant(),
            y = constant())
         = if x>y then x else y
    
    @python.intrinsic.function("Statistics", "Avg_{\\alpha=%(alpha)s}(%(source)s)", "observable.ewma.EWMA_Impl")
    def EWMA(source = const(),
             alpha = 0.015) : () => Float
        
}

package trash {
    package types {
        type T
        
        type R : T
        
        type U : T, R
        
        type T1 = T
    }
    
    package in1 {
        package in2 {
            def A(x = constant(),
                  y = if 3.0>x+2.0 then x else x*2.0) : () => types.T
                
        }
        def A(x : () => types.T1 = trash.A()) : () => types.U
            
    }
    def A(x = in1.in2.A()) : () => types.R
        
}
@python.function("Basic", "C=%(x)s")
def constant(x = 1.0) : IFunction
     = const(x)

@python.intrinsic.function("Basic", "C=%(x)s", "_constant._Constant_Impl")
def const(x = 1.0) : IObservable
    

type IOrderQueue

type IOrderBook
