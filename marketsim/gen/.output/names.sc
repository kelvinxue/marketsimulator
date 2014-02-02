
@category = "Side"
package side
{
    // defined at defs\side.sc: 10.5
    /** Function always returning Sell side
     */
    @python.intrinsic("side._Sell_Impl")
    def Sell() : () => Side
    
    // defined at defs\side.sc: 16.5
    /** Function always returning Buy side
     */
    @python.intrinsic("side._Buy_Impl")
    def Buy() : () => Side
    
    // defined at defs\side.sc: 22.5
    /** Function always returning None of type Side
     */
    @python.intrinsic("side._None_Impl")
    def Nothing() : () => Side
    
}

@category = "Event"
package event
{
    // defined at defs\event.sc: 4.5
    /** Event that fires every *intervalFunc* moments of time
     */
    @python.intrinsic("event._Every_Impl")
    def Every(/** interval of time between two events */ intervalFunc = math.random.expovariate(1.0)) : IEvent
    
    // defined at defs\event.sc: 11.5
    /** Event that once at *delay*
     */
    @python.intrinsic("event._After_Impl")
    def After(/** when the event should be fired */ delay = constant(10.0)) : IEvent
    
}

@category = "N/A"
package veusz
{
    // defined at defs\graph.sc: 45.5
    /** Graph to render at Veusz. Time series are added to it automatically in their constructor
     */
    @python.intrinsic("veusz._Graph_Impl")
    def Graph(name = "graph") : IGraph
    
}

@category = "Ops"
package ops
{
    // defined at defs\ops.sc: 4.5
    @python.intrinsic.observable("ops._Negate_Impl")
    @label = "-%(x)s"
    def Negate(x = constant(1.0)) : IObservable[Float]
    
    // defined at <undefined filename>: <undefined position>
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @python.intrinsic.observable("ops._Add_Impl")
    @symbol = "+"
    def Add(x = constant(1.0),
            y = constant(1.0)) : IObservable[Float]
    
    // defined at <undefined filename>: <undefined position>
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @python.intrinsic.observable("ops._Less_Impl")
    @symbol = "<"
    def Less(x = constant(1.0),
             y = constant(1.0)) : IObservable[Boolean]
    
    // defined at <undefined filename>: <undefined position>
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @python.intrinsic.observable("ops._Mul_Impl")
    @symbol = "*"
    def Mul(x = constant(1.0),
            y = constant(1.0)) : IObservable[Float]
    
    // defined at defs\ops.sc: 28.5
    @python.intrinsic.observable("ops._ConditionFloat_Impl")
    @label = "(if %(cond)s then %(ifpart)s else %(elsepart)s)"
    def Condition_Float(cond = true() : IFunction[Boolean],
                        ifpart = constant(1.0),
                        elsepart = constant(1.0)) : IObservable[Float]
    
    // defined at <undefined filename>: <undefined position>
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @python.intrinsic.observable("ops._NotEqual_Impl")
    @symbol = "<>"
    def NotEqual(x = constant(1.0),
                 y = constant(1.0)) : IObservable[Boolean]
    
    // defined at defs\ops.sc: 34.5
    @python.intrinsic.observable("ops._ConditionSide_Impl")
    @label = "(if %(cond)s then %(ifpart)s else %(elsepart)s)"
    def Condition_Side(cond = true() : IFunction[Boolean],
                       ifpart = side.Sell(),
                       elsepart = side.Buy()) : IObservable[Side]
    
    // defined at <undefined filename>: <undefined position>
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @python.intrinsic.observable("ops._GreaterEqual_Impl")
    @symbol = ">="
    def GreaterEqual(x = constant(1.0),
                     y = constant(1.0)) : IObservable[Boolean]
    
    // defined at <undefined filename>: <undefined position>
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @python.intrinsic.observable("ops._Sub_Impl")
    @symbol = "-"
    def Sub(x = constant(1.0),
            y = constant(1.0)) : IObservable[Float]
    
    // defined at defs\ops.sc: 8.5
    @python.intrinsic.observable("ops._Div_Impl")
    @label = "\\frac{%(x)s}{%(y)s}"
    def Div(x = constant(1.0),
            y = constant(1.0)) : IObservable[Float]
    
    // defined at <undefined filename>: <undefined position>
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @python.intrinsic.observable("ops._LessEqual_Impl")
    @symbol = "<="
    def LessEqual(x = constant(1.0),
                  y = constant(1.0)) : IObservable[Boolean]
    
    // defined at <undefined filename>: <undefined position>
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @python.intrinsic.observable("ops._Equal_Impl")
    @symbol = "=="
    def Equal(x = constant(1.0),
              y = constant(1.0)) : IObservable[Boolean]
    
    // defined at <undefined filename>: <undefined position>
    @label = "({%(x)s}{{symbol}}{%(y)s})"
    @python.intrinsic.observable("ops._Greater_Impl")
    @symbol = ">"
    def Greater(x = constant(1.0),
                y = constant(1.0)) : IObservable[Boolean]
    
}

@category = "Basic"
package math
{
    package random
    {
        // defined at defs\math\random.sc: 39.1
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
        
        // defined at defs\math\random.sc: 61.1
        /** Normal distribution
         */
        @python.random()
        def normalvariate(/** |mu| is the mean                  */ Mu = 0.0,
                          /** |sigma| is the standard deviation */ Sigma = 1.0) : () => Float
        
        // defined at defs\math\random.sc: 75.1
        /** Pareto distribution
         */
        @python.random()
        def paretovariate(/** |alpha| is the shape parameter*/ Alpha = 1.0) : () => Float
        
        // defined at defs\math\random.sc: 28.1
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
        
        // defined at defs\math\random.sc: 67.1
        /** Von Mises distribution
         */
        @python.random()
        def vonmisesvariate(/** |mu| is the mean angle, expressed in radians between 0 and 2|pi|*/ Mu = 0.0,
                            /** |kappa| is the concentration parameter, which must be greater than or equal to zero.
                              *      If |kappa| is equal to zero, this distribution reduces
                              *      to a uniform random angle over the range 0 to 2|pi|        */ Kappa = 0.0) : () => Float
        
        // defined at defs\math\random.sc: 18.1
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
        
        // defined at defs\math\random.sc: 80.1
        /** Weibull distribution
         */
        @python.random()
        def weibullvariate(/** |alpha| is the scale parameter */ Alpha = 1.0,
                           /** |beta| is the shape parameter  */ Beta = 1.0) : () => Float
        
        // defined at defs\math\random.sc: 11.1
        /** Exponential distribution
         *
         *  Returned values range from 0 to positive infinity
         */
        @python.random()
        def expovariate(/** |lambda| is 1.0 divided by the desired mean. It should be greater zero.*/ Lambda = 1.0) : () => Float
        
        // defined at defs\math\random.sc: 52.1
        /** Log normal distribution
         *
         * If you take the natural logarithm of this distribution,
         *  you'll get a normal distribution with mean |mu| and standard deviation |sigma|.
         *  |mu| can have any value, and |sigma| must be greater than zero.
         */
        @python.random()
        def lognormvariate(Mu = 0.0,
                           Sigma = 1.0) : () => Float
        
        // defined at defs\math\random.sc: 3.1
        /** Beta distribution
         *
         * Conditions on the parameters are |alpha| > 0 and |beta| > 0.
         * Returned values range between 0 and 1.
         */
        @python.random()
        def betavariate(Alpha = 1.0,
                        Beta = 1.0) : () => Float
        
    }
    
    @category = "Statistics"
    @suffix = "_{cumul}(%(source)s)"
    package Cumulative
    {
        // defined at defs\math\moments.sc: 64.13
        /** Cumulative relative standard deviation
         */
        @label = "RSD{{suffix}}"
        def RelStdDev(/** observable data source */ source = const()) = (source-Avg(source))/StdDev(source)
        
        // defined at defs\math\moments.sc: 50.13
        /** Cumulative variance
         */
        @python.intrinsic("moments.cmv.Variance_Impl")
        @label = "\\sigma^2{{suffix}}"
        def Var(/** observable data source */ source = const()) : () => Float
        
        // defined at defs\math\moments.sc: 43.13
        /** Cumulative average
         */
        @python.intrinsic("moments.cma.CMA_Impl")
        @label = "Avg{{suffix}}"
        def Avg(/** observable data source */ source = const()) : () => Float
        
        // defined at defs\math\minmax.sc: 26.9
        /** Cumulative minimum of a function with positive tolerance.
         *
         *  It fires updates only if *source* value becomes less than the old value minus *epsilon*
         */
        @python.intrinsic("observable.minmax_eps.MinEpsilon_Impl")
        @label = "Min_{\\epsilon}(%(source)s)"
        def MinEpsilon(/** observable data source */ source = constant(),
                       /** tolerance step         */ epsilon = constant(0.01)) : IObservable[Float]
        
        // defined at defs\math\minmax.sc: 36.9
        /** Cumulative maximum of a function with positive tolerance.
         *
         *  It fires updates only if *source* value becomes greater than the old value plus *epsilon*
         */
        @python.intrinsic("observable.minmax_eps.MaxEpsilon_Impl")
        @label = "Max_{\\epsilon}(%(source)s)"
        def MaxEpsilon(/** observable data source */ source = constant(),
                       /** tolerance step         */ epsilon = constant(0.01)) : IObservable[Float]
        
        // defined at defs\math\moments.sc: 57.13
        /** Cumulative standard deviation
         */
        @label = "\\sqrt{\\sigma^2{{suffix}}}"
        def StdDev(/** observable data source */ source = const()) = Sqrt(Var(source))
        
    }
    
    @category = "RSI"
    package rsi
    {
        // defined at defs\math\rsi.sc: 32.9
        /** Absolute value for Relative Strength Index
         */
        @label = "RSIRaw_{%(timeframe)s}^{%(alpha)s}(%(source)s)"
        def Raw(/** observable data source */ source = const(),
                /** lag size */ timeframe = 10.0,
                /** alpha parameter for EWMA */ alpha = 0.015) = EW.Avg(UpMovements(source,timeframe),alpha)/EW.Avg(DownMovements(source,timeframe),alpha)
        
    }
    
    @category = "MACD"
    package macd
    {
        // defined at defs\math\macd.sc: 4.5
        /** Moving average convergence/divergence
         */
        @label = "MACD_{%(fast)s}^{%(slow)s}(%(x)s)"
        def MACD(/** source */ x = const(),
                 /** long period */ slow = 26.0,
                 /** short period */ fast = 12.0) = EW.Avg(x,2.0/(fast+1))-EW.Avg(x,2.0/(slow+1))
        
        // defined at defs\math\macd.sc: 14.5
        /** Moving average convergence/divergence signal
         */
        @label = "Signal^{%(timeframe)s}_{%(step)s}(MACD_{%(fast)s}^{%(slow)s}(%(x)s))"
        def Signal(/** source */ x = const(),
                   /** long period */ slow = 26.0,
                   /** short period */ fast = 12.0,
                   /** signal period */ timeframe = 9.0,
                   /** discretization step */ step = 1.0) = EW.Avg(observable.OnEveryDt(step,MACD(x,slow,fast)),2/(timeframe+1))
        
        // defined at defs\math\macd.sc: 26.5
        /** Moving average convergence/divergence histogram
         */
        @label = "Histogram^{%(timeframe)s}_{%(step)s}(MACD_{%(fast)s}^{%(slow)s}(%(x)s))"
        def Histogram(/** source */ x = const(),
                      /** long period */ slow = 26.0,
                      /** short period */ fast = 12.0,
                      /** signal period */ timeframe = 9.0,
                      /** discretization step */ step = 1.0) = MACD(x,slow,fast)-Signal(x,slow,fast,timeframe,step)
        
    }
    
    @category = "Statistics"
    @suffix = "_{\\\\alpha=%(alpha)s}(%(source)s)"
    package EW
    {
        // defined at defs\math\moments.sc: 9.13
        /** Exponentially weighted moving average
         */
        @python.intrinsic("moments.ewma.EWMA_Impl")
        @label = "Avg{{suffix}}"
        def Avg(/** observable data source */ source = const(),
                /** alpha parameter */ alpha = 0.015) : IDifferentiable
        
        // defined at defs\math\moments.sc: 17.13
        /** Exponentially weighted moving variance
         */
        @python.intrinsic("moments.ewmv.EWMV_Impl")
        @label = "\\sigma^2{{suffix}}"
        def Var(/** observable data source */ source = const(),
                /** alpha parameter */ alpha = 0.015) : () => Float
        
        // defined at defs\math\moments.sc: 24.13
        /** Exponentially weighted moving standard deviation
         */
        @label = "\\sqrt{\\sigma^2{{suffix}}}"
        def StdDev(/** observable data source */ source = const(),
                   /** alpha parameter */ alpha = 0.015) = Sqrt(Var(source,alpha))
        
        // defined at defs\math\moments.sc: 31.13
        /** Exponentially weighted moving relative standard deviation
         */
        @label = "RSD{{suffix}}"
        def RelStdDev(/** observable data source */ source = const(),
                      /** alpha parameter */ alpha = 0.015) = (source-Avg(source,alpha))/StdDev(source,alpha)
        
    }
    
    @category = "Statistics"
    @suffix = "_{n=%(timeframe)s}(%(source)s)"
    package Moving
    {
        // defined at defs\math\minmax.sc: 6.9
        /** Running minimum of a function
         */
        @python.intrinsic("observable.minmax.Min_Impl")
        @label = "Min_{n=%(timeframe)s}(%(source)s)"
        def Min(/** observable data source */ source = constant(),
                /** sliding window size    */ timeframe = 100.0) : IObservable[Float]
        
        // defined at defs\math\moments.sc: 99.13
        /** Simple moving relative standard deviation
         */
        @label = "RSD{{suffix}}"
        def RelStdDev(/** observable data source */ source = const(),
                      /** sliding window size    */ timeframe = 100.0) = (source-Avg(source,timeframe))/StdDev(source,timeframe)
        
        // defined at defs\math\moments.sc: 83.13
        /** Simple moving variance
         */
        @python.intrinsic("moments.mv.MV_Impl")
        @label = "\\sigma^2{{suffix}}"
        def Var(/** observable data source */ source = const(),
                /** sliding window size    */ timeframe = 100.0) = math.Max(const(0),Avg(source*source,timeframe)-Sqr(Avg(source,timeframe)))
        
        // defined at defs\math\minmax.sc: 14.9
        /** Running maximum of a function
         */
        @python.intrinsic("observable.minmax.Max_Impl")
        @label = "Max_{n=%(timeframe)s}(%(source)s)"
        def Max(/** observable data source */ source = constant(),
                /** sliding window size    */ timeframe = 100.0) : IObservable[Float]
        
        // defined at defs\math\moments.sc: 75.13
        /** Simple moving average
         */
        @python.intrinsic("moments.ma.MA_Impl")
        @label = "Avg{{suffix}}"
        def Avg(/** observable data source */ source = const(),
                /** sliding window size    */ timeframe = 100.0) : () => Float
        
        // defined at defs\math\moments.sc: 92.13
        /** Simple moving standard deviation
         */
        @label = "\\sqrt{\\sigma^2{{suffix}}}"
        def StdDev(/** observable data source */ source = const(),
                   /** sliding window size    */ timeframe = 100.0) = Sqrt(Var(source))
        
    }
    
    // defined at <undefined filename>: <undefined position>
    /** Function returning minimum of two functions *x* and *y*.
     * If *x* or/and *y* are observables, *Min* is also observable
     */
    @python.observable()
    @label = "min{%(x)s, %(y)s}"
    def Min(x = constant(),
            y = constant()) = if x<y then x else y
    
    // defined at defs\math\rsi.sc: 20.5
    /** Returns negative movements of some observable *source* with lag *timeframe*
     */
    @label = "Downs_{%(timeframe)s}(%(source)s)"
    def DownMovements(/** observable data source */ source = const(),
                      /** lag size */ timeframe = 10.0) = observable.Float(Max(const(0.0),Lagged(source,timeframe)-source))
    
    // defined at <undefined filename>: <undefined position>
    /** Arc tangent of x, in radians.
     *
     */
    @category = "Trigonometric"
    @python.mathops("atan")
    def Atan(x = constant(0.0)) : () => Float
    
    // defined at defs\math\rsi.sc: 3.5
    /** Observable that adds a lag to an observable data source so [Lagged(x, dt)]t=t0 == [x]t=t0+dt
     */
    @python.intrinsic("observable.lagged.Lagged_Impl")
    @label = "Lagged_{%(timeframe)s}(%(source)s)"
    def Lagged(/** observable data source */ source = const(),
               /** lag size */ timeframe = 10.0) : IObservable[Float]
    
    // defined at <undefined filename>: <undefined position>
    /** Function returning maximum of two functions *x* and *y*.
     * If *x* or/and *y* are observables, *Min* is also observable
     */
    @python.observable()
    @label = "max{%(x)s, %(y)s}"
    def Max(x = constant(),
            y = constant()) = if x>y then x else y
    
    // defined at defs\math\rsi.sc: 11.5
    /** Returns positive movements of some observable *source* with lag *timeframe*
     */
    @label = "Ups_{%(timeframe)s}(%(source)s)"
    def UpMovements(/** observable data source */ source = const(),
                    /** lag size */ timeframe = 10.0) = observable.Float(Max(const(0.0),source-Lagged(source,timeframe)))
    
    // defined at <undefined filename>: <undefined position>
    /** Square of *x*
     */
    @category = "Log/Pow"
    @python.observable()
    @label = "{%(x)s}^2"
    def Sqr(x = constant()) = x*x
    
    // defined at defs\math\rsi.sc: 54.5
    /** Log returns
     */
    @label = "LogReturns_{%(timeframe)s}(%(x)s)"
    def LogReturns(/** observable data source */ x = const(),
                   /** lag size */ timeframe = 10.0) = Log(x/Lagged(x,timeframe))
    
    // defined at <undefined filename>: <undefined position>
    /** Square root of *x*
     *
     */
    @category = "Log/Pow"
    @python.mathops("sqrt")
    @label = "\\sqrt{%(x)s}"
    def Sqrt(x = constant(1.0)) : () => Float
    
    // defined at defs\math\rsi.sc: 44.5
    /** Relative Strength Index
     */
    @label = "RSI_{%(timeframe)s}^{%(alpha)s}(%(book)s)"
    def RSI(/** asset price in question  */ book = orderbook.OfTrader(),
            /** lag size */ timeframe = 10.0,
            /** alpha parameter for EWMA */ alpha = 0.015) = 100.0-100.0/(1.0+rsi.Raw(orderbook.MidPrice(book),timeframe,alpha))
    
    // defined at <undefined filename>: <undefined position>
    /** Exponent of *x*
     *
     */
    @category = "Log/Pow"
    @python.mathops("exp")
    @label = "e^{%(x)s}"
    def Exp(x = constant(1.0)) : () => Float
    
    // defined at <undefined filename>: <undefined position>
    /** Natural logarithm of *x* (to base e)
     *
     */
    @category = "Log/Pow"
    @python.mathops("log")
    @label = "log(%(x)s)"
    def Log(x = constant(1.0)) : () => Float
    
    // defined at defs\math\process.sc: 3.5
    /** A discrete signal with user-defined increments.
     */
    @python.intrinsic("observable.randomwalk._RandomWalk_Impl")
    @label = "%(name)s"
    def RandomWalk(/** initial value of the signal */ initialValue = 0.0,
                   /** increment function */ deltaDistr = random.normalvariate(0.0,1.0),
                   /** intervals between signal updates */ intervalDistr = random.expovariate(1.0),
                   name = "-random-") : IObservable[Float]
    
    // defined at <undefined filename>: <undefined position>
    /** Function returning first derivative on time of *x*
     * *x* should provide *derivative* member
     */
    @python.intrinsic("observable.derivative._Derivative_Impl")
    @label = "\\frac{d%(x)s}{dt}"
    def Derivative(x = math.EW.Avg() : IDifferentiable) : () => Float
    
    // defined at <undefined filename>: <undefined position>
    /** Return *x* raised to the power *y*.
     *
     * Exceptional cases follow Annex F of the C99 standard as far as possible.
     * In particular, ``pow(1.0, x)`` and ``pow(x, 0.0)`` always return 1.0,
     * even when *x* is a zero or a NaN.
     * If both *x* and *y* are finite, *x* is negative, and *y* is not an integer then
     * ``pow(x, y)`` is undefined, and raises ``ValueError``.
     */
    @category = "Log/Pow"
    @python.mathops("pow")
    @label = "%(base)s^{%(power)s}"
    def Pow(base = constant(1.0),
            power = constant(1.0)) : () => Float
    
}

@category = "Order"
package order
{
    package side
    {
        package price
        {
            def Limit = .order._curried.side_price_Limit
            
            def ImmediateOrCancel = .order._curried.side_price_ImmediateOrCancel
            
            def StopLoss = .order._curried.side_price_StopLoss
            
            def WithExpiry = .order._curried.side_price_WithExpiry
            
            def FloatingPrice = .order._curried.side_price_FloatingPrice
            
            def Iceberg = .order._curried.side_price_Iceberg
            
            def Peg = .order._curried.side_price_Peg
            
        }
        
        def Limit = .order._curried.side_Limit
        
        def ImmediateOrCancel = .order._curried.side_ImmediateOrCancel
        
        def Market = .order._curried.side_Market
        
        def StopLoss = .order._curried.side_StopLoss
        
        def WithExpiry = .order._curried.side_WithExpiry
        
        def FloatingPrice = .order._curried.side_FloatingPrice
        
        def Iceberg = .order._curried.side_Iceberg
        
        def FixedBudget = .order._curried.side_FixedBudget
        
        def Peg = .order._curried.side_Peg
        
    }
    
    package side_price
    {
        def Limit = .order._curried.sideprice_Limit
        
        def ImmediateOrCancel = .order._curried.sideprice_ImmediateOrCancel
        
        def StopLoss = .order._curried.sideprice_StopLoss
        
        def WithExpiry = .order._curried.sideprice_WithExpiry
        
        def FloatingPrice = .order._curried.sideprice_FloatingPrice
        
        def Iceberg = .order._curried.sideprice_Iceberg
        
        def Peg = .order._curried.sideprice_Peg
        
    }
    
    package side_volume
    {
        package price
        {
            def Limit = .order._curried.sidevolume_price_Limit
            
            def ImmediateOrCancel = .order._curried.sidevolume_price_ImmediateOrCancel
            
            def StopLoss = .order._curried.sidevolume_price_StopLoss
            
            def WithExpiry = .order._curried.sidevolume_price_WithExpiry
            
            def FloatingPrice = .order._curried.sidevolume_price_FloatingPrice
            
            def Iceberg = .order._curried.sidevolume_price_Iceberg
            
            def Peg = .order._curried.sidevolume_price_Peg
            
        }
        
        def Limit = .order._curried.sidevolume_Limit
        
        def ImmediateOrCancel = .order._curried.sidevolume_ImmediateOrCancel
        
        def Market = .order._curried.sidevolume_Market
        
        def StopLoss = .order._curried.sidevolume_StopLoss
        
        def WithExpiry = .order._curried.sidevolume_WithExpiry
        
        def FloatingPrice = .order._curried.sidevolume_FloatingPrice
        
        def Iceberg = .order._curried.sidevolume_Iceberg
        
        def Peg = .order._curried.sidevolume_Peg
        
    }
    
    package price
    {
        def Limit = .order._curried.price_Limit
        
        def ImmediateOrCancel = .order._curried.price_ImmediateOrCancel
        
        def StopLoss = .order._curried.price_StopLoss
        
        def WithExpiry = .order._curried.price_WithExpiry
        
        def FloatingPrice = .order._curried.price_FloatingPrice
        
        def Iceberg = .order._curried.price_Iceberg
        
        def Peg = .order._curried.price_Peg
        
    }
    
    package signed
    {
        def Limit = .order.LimitSigned
        
        def Market = .order.MarketSigned
        
    }
    
    package signedVolume
    {
        def LimitSigned = .order._curried.signedVolume_LimitSigned
        
        def MarketSigned = .order._curried.signedVolume_MarketSigned
        
    }
    
    package _curried
    {
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("ImmediateOrCancel")
        def side_ImmediateOrCancel(/** factory for underlying orders */ proto = side.Limit()) : (() => .Side) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("price_Limit")
        def volume_price_Limit(/** function defining side of orders to create */ side = side.Sell()) : (() => .Float) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("Iceberg")
        def sidevolume_Iceberg(/** maximal size of order to send */ lotSize = constant(10.0),
                               /** underlying orders to create */ proto = side_volume.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("WithExpiry")
        def sidevolume_WithExpiry(/** expiration period for orders */ expiry = constant(10.0),
                                  /** underlying orders to create */ proto = side_volume.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("price_StopLoss")
        def side_price_StopLoss(/** maximal acceptable loss factor */ maxloss = constant(0.1),
                                /** underlying orders to create */ proto = side.price.Limit()) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("Iceberg")
        def price_Iceberg(/** maximal size of order to send */ lotSize = constant(10.0),
                          /** underlying orders to create */ proto = price.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("FloatingPrice")
        def sideprice_FloatingPrice(/** observable defining price of orders to create */ floatingPrice = const(10.0),
                                    /** underlying orders to create */ proto = side.price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("StopLoss")
        def price_StopLoss(/** maximal acceptable loss factor */ maxloss = constant(0.1),
                           /** underlying orders to create */ proto = price.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("ImmediateOrCancel")
        def price_ImmediateOrCancel(/** factory for underlying orders */ proto = price.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("price_WithExpiry")
        def volume_price_WithExpiry(/** expiration period for orders */ expiry = constant(10.0),
                                    /** underlying orders to create */ proto = volume.price.Limit()) : (() => .Float) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("StopLoss")
        def sideprice_StopLoss(/** maximal acceptable loss factor */ maxloss = constant(0.1),
                               /** underlying orders to create */ proto = side_price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("price_Peg")
        def volume_price_Peg(proto = volume.price.Limit()) : (() => .Float) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("Iceberg")
        def side_Iceberg(/** maximal size of order to send */ lotSize = constant(10.0),
                         /** underlying orders to create */ proto = side.Limit()) : (() => .Side) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("price_WithExpiry")
        def sidevolume_price_WithExpiry(/** expiration period for orders */ expiry = constant(10.0),
                                        /** underlying orders to create */ proto = side_volume.price.Limit()) : ((() => .Side),(() => .Float)) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("Peg")
        def volume_Peg(proto = volume.price.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("ImmediateOrCancel")
        def sidevolume_ImmediateOrCancel(/** factory for underlying orders */ proto = side_volume.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating fixed budget orders
         *
         *  Fixed budget order acts like a market order
         *  but the volume is implicitly given by a budget available for trades.
         *  Internally first it sends request.EvalVolumesForBudget
         *  to estimate volumes and prices of orders to sent and
         *  then sends a sequence of order.ImmediateOrCancel to be sure that
         *  cumulative price of trades to be done won't exceed the given budget.
         */
        @python.order.factory.curried("FixedBudget")
        def side_FixedBudget(/** function defining budget on which it may send orders at one time */ budget = constant(1000.0)) : (() => .Side) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("Limit")
        def sideprice_Limit(/** function defining volume of orders to create */ volume = constant(1.0)) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("Peg")
        def sideprice_Peg(proto = side.price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("Peg")
        def sidevolume_Peg(proto = side_volume.price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("Peg")
        def side_Peg(proto = side.price.Limit()) : (() => .Side) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("LimitSigned")
        def signedVolume_LimitSigned(/** function defining price of orders to create */ price = constant(100.0)) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("price_Iceberg")
        def side_price_Iceberg(/** maximal size of order to send */ lotSize = constant(10.0),
                               /** underlying orders to create */ proto = side.price.Limit()) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("price_ImmediateOrCancel")
        def side_price_ImmediateOrCancel(/** factory for underlying orders */ proto = side.price.Limit()) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("WithExpiry")
        def side_WithExpiry(/** expiration period for orders */ expiry = constant(10.0),
                            /** underlying orders to create */ proto = side.Limit()) : (() => .Side) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("StopLoss")
        def side_StopLoss(/** maximal acceptable loss factor */ maxloss = constant(0.1),
                          /** underlying orders to create */ proto = side.Limit()) : (() => .Side) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("price_StopLoss")
        def sidevolume_price_StopLoss(/** maximal acceptable loss factor */ maxloss = constant(0.1),
                                      /** underlying orders to create */ proto = side_volume.price.Limit()) : ((() => .Side),(() => .Float)) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("Peg")
        def price_Peg(proto = price.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("StopLoss")
        def volume_StopLoss(/** maximal acceptable loss factor */ maxloss = constant(0.1),
                            /** underlying orders to create */ proto = volume.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("price_Limit")
        def sidevolume_price_Limit() : ((() => .Side),(() => .Float)) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("StopLoss")
        def sidevolume_StopLoss(/** maximal acceptable loss factor */ maxloss = constant(0.1),
                                /** underlying orders to create */ proto = side_volume.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("WithExpiry")
        def volume_WithExpiry(/** expiration period for orders */ expiry = constant(10.0),
                              /** underlying orders to create */ proto = volume.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("WithExpiry")
        def sideprice_WithExpiry(/** expiration period for orders */ expiry = constant(10.0),
                                 /** underlying orders to create */ proto = side_price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("ImmediateOrCancel")
        def volume_ImmediateOrCancel(/** factory for underlying orders */ proto = volume.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("FloatingPrice")
        def volume_FloatingPrice(/** observable defining price of orders to create */ floatingPrice = const(10.0),
                                 /** underlying orders to create */ proto = volume.price.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating market orders
         *
         *  Market order intructs buy or sell given volume immediately
         */
        @python.order.factory.curried("Market")
        def volume_Market(/** function defining side of orders to create */ side = side.Sell()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating StopLoss orders
         *
         *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
         *  It keeps track of position and balance change induced by trades of the underlying order and
         *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
         *  the meta order clears its position.
         */
        @python.order.factory.on_proto("price_StopLoss")
        def volume_price_StopLoss(/** maximal acceptable loss factor */ maxloss = constant(0.1),
                                  /** underlying orders to create */ proto = volume.price.Limit()) : (() => .Float) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("price_ImmediateOrCancel")
        def volume_price_ImmediateOrCancel(/** factory for underlying orders */ proto = volume.price.Limit()) : (() => .Float) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("Limit")
        def side_Limit(/** function defining price of orders to create */ price = constant(100.0),
                       /** function defining volume of orders to create */ volume = constant(1.0)) : (() => .Side) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("price_FloatingPrice")
        def side_price_FloatingPrice(/** observable defining price of orders to create */ floatingPrice = const(10.0),
                                     /** underlying orders to create */ proto = side.price.Limit()) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("FloatingPrice")
        def side_FloatingPrice(/** observable defining price of orders to create */ floatingPrice = const(10.0),
                               /** underlying orders to create */ proto = side.price.Limit()) : (() => .Side) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("price_WithExpiry")
        def side_price_WithExpiry(/** expiration period for orders */ expiry = constant(10.0),
                                  /** underlying orders to create */ proto = side.price.Limit()) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("price_Limit")
        def side_price_Limit(/** function defining volume of orders to create */ volume = constant(1.0)) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("Iceberg")
        def volume_Iceberg(/** maximal size of order to send */ lotSize = constant(10.0),
                           /** underlying orders to create */ proto = volume.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("price_FloatingPrice")
        def volume_price_FloatingPrice(/** observable defining price of orders to create */ floatingPrice = const(10.0),
                                       /** underlying orders to create */ proto = volume.price.Limit()) : (() => .Float) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating market orders
         *
         *  Market order intructs buy or sell given volume immediately
         */
        @python.order.factory.curried("Market")
        def side_Market(/** function defining volume of orders to create */ volume = constant(1.0)) : (() => .Side) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("FloatingPrice")
        def price_FloatingPrice(/** observable defining price of orders to create */ floatingPrice = const(10.0),
                                /** underlying orders to create */ proto = price.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("FloatingPrice")
        def sidevolume_FloatingPrice(/** observable defining price of orders to create */ floatingPrice = const(10.0),
                                     /** underlying orders to create */ proto = side_volume.price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating WithExpiry orders
         *
         * WithExpiry orders can be viewed as ImmediateOrCancel orders
         * where cancel order is sent not immediately but after some delay
         */
        @python.order.factory.on_proto("WithExpiry")
        def price_WithExpiry(/** expiration period for orders */ expiry = constant(10.0),
                             /** underlying orders to create */ proto = price.Limit()) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("price_Iceberg")
        def volume_price_Iceberg(/** maximal size of order to send */ lotSize = constant(10.0),
                                 /** underlying orders to create */ proto = volume.price.Limit()) : (() => .Float) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating orders with floating price
         *
         *  Floating price order is initialized by an order having a price and an observable that generates new prices.
         *  When the observable value changes the order is cancelled and
         *  a new order with new price is created and sent to the order book.
         */
        @python.order.factory.on_proto("price_FloatingPrice")
        def sidevolume_price_FloatingPrice(/** observable defining price of orders to create */ floatingPrice = const(10.0),
                                           /** underlying orders to create */ proto = side_volume.price.Limit()) : ((() => .Side),(() => .Float)) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("price_ImmediateOrCancel")
        def sidevolume_price_ImmediateOrCancel(/** factory for underlying orders */ proto = side_volume.price.Limit()) : ((() => .Side),(() => .Float)) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating market orders
         *
         *  Market order intructs buy or sell given volume immediately
         */
        @python.order.factory.curried("Market")
        def sidevolume_Market() : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("Limit")
        def price_Limit(/** function defining side of orders to create */ side = side.Sell(),
                        /** function defining volume of orders to create */ volume = constant(1.0)) : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("Limit")
        def sidevolume_Limit(/** function defining price of orders to create */ price = constant(100.0)) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("Iceberg")
        def sideprice_Iceberg(/** maximal size of order to send */ lotSize = constant(10.0),
                              /** underlying orders to create */ proto = side_price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("price_Peg")
        def sidevolume_price_Peg(proto = side_volume.price.Limit()) : ((() => .Side),(() => .Float)) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating market orders
         *
         *  Market order intructs buy or sell given volume immediately
         */
        @python.order.factory.curried("MarketSigned")
        def signedVolume_MarketSigned() : (() => .Float) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Immediate-Or-Cancel orders
         *
         *  Immediate-Or-Cancel order sends an underlying order to the market and
         *  immediately sends a cancel request for it.
         *  It allows to combine market and limit order behaviour:
         *  the order is either executed immediately
         *  at price equal or better than given one
         *  either it is cancelled (and consequently never stored in the order queue).
         */
        @python.order.factory.on_proto("ImmediateOrCancel")
        def sideprice_ImmediateOrCancel(/** factory for underlying orders */ proto = side_price.Limit()) : ((() => .Side),(() => .Float)) => .IOrderGenerator
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating Peg orders
         *
         *  A peg order is a particular case of the floating price order
         *  with the price better at one tick than the best price of the order queue.
         *  It implies that if several peg orders are sent to the same order queue
         *  they start to race until being matched against the counterparty orders.
         */
        @python.order.factory.on_proto("price_Peg")
        def side_price_Peg(proto = side.price.Limit()) : (() => .Side) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating iceberg orders
         *
         *  Iceberg order is initialized by an underlying order and a lot size.
         *  It sends consequently pieces of the underlying order of size equal or less to the lot size
         *  thus maximum lot size volume is visible at the market at any moment.
         */
        @python.order.factory.on_proto("price_Iceberg")
        def sidevolume_price_Iceberg(/** maximal size of order to send */ lotSize = constant(10.0),
                                     /** underlying orders to create */ proto = side_volume.price.Limit()) : ((() => .Side),(() => .Float)) => ((() => .Float) => .IOrderGenerator)
        
        // defined at <undefined filename>: <undefined position>
        /** Factory creating limit orders
         *
         *  Limit orders ask to buy or sell some asset at price better than some limit price.
         *  If a limit order is not competely fulfilled
         *  it remains in an order book waiting to be matched with another order.
         */
        @python.order.factory.curried("Limit")
        def volume_Limit(/** function defining side of orders to create */ side = side.Sell(),
                         /** function defining price of orders to create */ price = constant(100.0)) : (() => .Float) => .IOrderGenerator
        
    }
    
    package volume
    {
        package price
        {
            def Limit = .order._curried.volume_price_Limit
            
            def ImmediateOrCancel = .order._curried.volume_price_ImmediateOrCancel
            
            def StopLoss = .order._curried.volume_price_StopLoss
            
            def WithExpiry = .order._curried.volume_price_WithExpiry
            
            def FloatingPrice = .order._curried.volume_price_FloatingPrice
            
            def Iceberg = .order._curried.volume_price_Iceberg
            
            def Peg = .order._curried.volume_price_Peg
            
        }
        
        def Limit = .order._curried.volume_Limit
        
        def ImmediateOrCancel = .order._curried.volume_ImmediateOrCancel
        
        def Market = .order._curried.volume_Market
        
        def StopLoss = .order._curried.volume_StopLoss
        
        def WithExpiry = .order._curried.volume_WithExpiry
        
        def FloatingPrice = .order._curried.volume_FloatingPrice
        
        def Iceberg = .order._curried.volume_Iceberg
        
        def Peg = .order._curried.volume_Peg
        
    }
    
    // defined at defs\order.sc: 23.5
    /** Factory creating limit orders
     *
     *  Limit orders ask to buy or sell some asset at price better than some limit price.
     *  If a limit order is not competely fulfilled
     *  it remains in an order book waiting to be matched with another order.
     */
    @python.order.factory("order.limit.Order_Impl")
    def Limit(/** function defining side of orders to create */ side = side.Sell(),
              /** function defining price of orders to create */ price = constant(100.0),
              /** function defining volume of orders to create */ volume = constant(1.0)) : IOrderGenerator
    
    // defined at <undefined filename>: <undefined position>
    /** Factory creating market orders
     *
     *  Market order intructs buy or sell given volume immediately
     */
    @python.order.factory("order.market.Order_Impl")
    def MarketSigned(/**signed volume*/ signedVolume : () => .Float = constant(1.0)) : .IOrderGenerator
    
    // defined at defs\order.sc: 54.5
    /** Factory creating Immediate-Or-Cancel orders
     *
     *  Immediate-Or-Cancel order sends an underlying order to the market and
     *  immediately sends a cancel request for it.
     *  It allows to combine market and limit order behaviour:
     *  the order is either executed immediately
     *  at price equal or better than given one
     *  either it is cancelled (and consequently never stored in the order queue).
     */
    @python.order.factory("order.meta.ioc.Order_Impl")
    def ImmediateOrCancel(/** factory for underlying orders */ proto = Limit()) : IOrderGenerator
    
    // defined at defs\order.sc: 12.5
    /** Factory creating market orders
     *
     *  Market order intructs buy or sell given volume immediately
     */
    @python.order.factory("order.market.Order_Impl")
    def Market(/** function defining side of orders to create */ side = side.Sell(),
               /** function defining volume of orders to create */ volume = constant(1.0)) : IOrderGenerator
    
    // defined at defs\order.sc: 68.5
    /** Factory creating StopLoss orders
     *
     *  StopLoss order is initialised by an underlying order and a maximal acceptable loss factor.
     *  It keeps track of position and balance change induced by trades of the underlying order and
     *  if losses from keeping the position exceed certain limit (given by maximum loss factor),
     *  the meta order clears its position.
     */
    @python.order.factory("order.meta.stoploss.Order_Impl")
    def StopLoss(/** maximal acceptable loss factor */ maxloss = constant(0.1),
                 /** underlying orders to create */ proto = Limit()) : IOrderGenerator
    
    // defined at defs\order.sc: 82.5
    /** Factory creating WithExpiry orders
     *
     * WithExpiry orders can be viewed as ImmediateOrCancel orders
     * where cancel order is sent not immediately but after some delay
     */
    @python.order.factory("order.meta.with_expiry.Order_Impl")
    def WithExpiry(/** expiration period for orders */ expiry = constant(10.0),
                   /** underlying orders to create */ proto = Limit()) : IOrderGenerator
    
    // defined at defs\order.sc: 107.5
    /** Factory creating orders with floating price
     *
     *  Floating price order is initialized by an order having a price and an observable that generates new prices.
     *  When the observable value changes the order is cancelled and
     *  a new order with new price is created and sent to the order book.
     */
    @python.order.factory("order.meta.floating_price.Factory_Impl")
    def FloatingPrice(/** observable defining price of orders to create */ floatingPrice = const(10.0),
                      /** underlying orders to create */ proto = price.Limit()) : IOrderGenerator
    
    // defined at defs\order.sc: 94.5
    /** Factory creating iceberg orders
     *
     *  Iceberg order is initialized by an underlying order and a lot size.
     *  It sends consequently pieces of the underlying order of size equal or less to the lot size
     *  thus maximum lot size volume is visible at the market at any moment.
     */
    @python.order.factory("order.meta.iceberg.Order_Impl")
    def Iceberg(/** maximal size of order to send */ lotSize = constant(10.0),
                /** underlying orders to create */ proto = Limit()) : IOrderGenerator
    
    // defined at defs\order.sc: 38.5
    /** Factory creating fixed budget orders
     *
     *  Fixed budget order acts like a market order
     *  but the volume is implicitly given by a budget available for trades.
     *  Internally first it sends request.EvalVolumesForBudget
     *  to estimate volumes and prices of orders to sent and
     *  then sends a sequence of order.ImmediateOrCancel to be sure that
     *  cumulative price of trades to be done won't exceed the given budget.
     */
    @python.order.factory("order.meta.fixed_budget.Order_Impl")
    def FixedBudget(/** function defining side of orders to create */ side = side.Sell(),
                    /** function defining budget on which it may send orders at one time */ budget = constant(1000.0)) : IOrderGenerator
    
    // defined at <undefined filename>: <undefined position>
    /** Factory creating limit orders
     *
     *  Limit orders ask to buy or sell some asset at price better than some limit price.
     *  If a limit order is not competely fulfilled
     *  it remains in an order book waiting to be matched with another order.
     */
    @python.order.factory("order.limit.Order_Impl")
    def LimitSigned(/**signed volume*/ signedVolume : () => .Float = constant(1.0),
                    /** function defining price of orders to create */ price = constant(100.0)) : .IOrderGenerator
    
    // defined at defs\order.sc: 120.5
    /** Factory creating Peg orders
     *
     *  A peg order is a particular case of the floating price order
     *  with the price better at one tick than the best price of the order queue.
     *  It implies that if several peg orders are sent to the same order queue
     *  they start to race until being matched against the counterparty orders.
     */
    @python.order.factory("order.meta.peg.Factory_Impl")
    def Peg(proto = price.Limit()) : IOrderGenerator
    
}

@category = "Strategy"
package strategy
{
    @category = "Side function"
    package side
    {
        // defined at defs\strategies\parts\side.sc: 82.5
        /** Side function for pair trading strategy
         */
        def PairTrading(/** reference to order book for another asset used to evaluate fair price of our asset */ bookToDependOn = orderbook.OfTrader(),
                        /** multiplier to obtain fair asset price from the reference asset price */ factor = 1.0,
                        /** asset in question */ book = orderbook.OfTrader()) = observable.Side(FundamentalValue(orderbook.MidPrice(bookToDependOn)*factor,book))
        
        // defined at defs\strategies\parts\side.sc: 11.5
        /** Side function for signal strategy
         */
        @python.observable()
        def Signal(/** signal to be listened to */ signal = constant(0.0),
                   /** threshold when the trader starts to act */ threshold = 0.7) = if signal>threshold then side.Buy() else if signal<0-threshold then side.Sell() else side.Nothing()
        
        // defined at defs\strategies\parts\side.sc: 37.5
        /** Side function for crossing averages strategy
         */
        def CrossingAverages(/** parameter |alpha| for exponentially weighted moving average 1 */ alpha_1 = 0.15,
                             /** parameter |alpha| for exponentially weighted moving average 2 */ alpha_2 = 0.015,
                             /** threshold when the trader starts to act */ threshold = 0.0,
                             /** asset in question */ book = orderbook.OfTrader()) = Signal(math.EW.Avg(orderbook.MidPrice(book),alpha_1)-math.EW.Avg(orderbook.MidPrice(book),alpha_2),threshold)
        
        // defined at defs\strategies\parts\side.sc: 24.5
        /** Side function for trend follower strategy
         */
        def TrendFollower(/** parameter |alpha| for exponentially weighted moving average */ alpha = 0.15,
                          /** threshold when the trader starts to act */ threshold = 0.0,
                          /** asset in question */ book = orderbook.OfTrader()) = Signal(math.Derivative(math.EW.Avg(orderbook.MidPrice(book),alpha)),threshold)
        
        // defined at defs\strategies\parts\side.sc: 55.5
        /** Side function for fundamental value strategy
         */
        @python.observable()
        def FundamentalValue(/** observable fundamental value */ fv = constant(200.0),
                             /** asset in question */ book = orderbook.OfTrader()) = if orderbook.bid.Price(book)>fv then side.Sell() else if orderbook.ask.Price(book)<fv then side.Buy() else side.Nothing()
        
        // defined at defs\strategies\parts\side.sc: 69.5
        /** Side function for mean reversion strategy
         */
        def MeanReversion(/** parameter |alpha| for exponentially weighted moving average */ alpha = 0.015,
                          /** asset in question */ book = orderbook.OfTrader()) = FundamentalValue(math.EW.Avg(orderbook.MidPrice(book),alpha),book)
        
        // defined at defs\strategies\parts\side.sc: 4.5
        /** Side function for a noise trading strategy
         */
        def Noise(side_distribution = math.random.uniform(0.0,1.0)) = if side_distribution>0.5 then side.Sell() else side.Buy()
        
    }
    
    package weight
    {
        package array
        {
            // defined at <undefined filename>: <undefined position>
            /** Function returning an array of length *len(array)*
             *  having 1 at the index of the maximal element and 0 are at the rest
             */
            @python.curried("ChooseTheBest")
            def array_ChooseTheBest() : .Optional[.List[.Float]] => .List[.Float]
            
            // defined at <undefined filename>: <undefined position>
            /** Identity function for an array of floats
             */
            @python.curried("IdentityL")
            def array_IdentityL() : .Optional[.List[.Float]] => .List[.Float]
            
        }
        
        package trader
        {
            // defined at <undefined filename>: <undefined position>
            /** Returns traders eficiency. Under efficiency we understand trader balance if trader position was cleared
             */
            @python.curried("Efficiency")
            def trader_Efficiency() : .IAccount => .IFunction[.Float]
            
            // defined at <undefined filename>: <undefined position>
            /** Calculates how many times efficiency of trader went up and went down
             * Returns difference between them.
             *
             * TODO: should be UpScore(timeframe, Efficiency(trader)) - DownScore(timeframe, Efficiency(trader))
             */
            @python.curried("Score")
            def trader_Score() : .IAccount => .IFunction[.Float]
            
            // defined at <undefined filename>: <undefined position>
            /** Returns first derivative of a moving average of the trader efficiency
             */
            @python.curried("EfficiencyTrend")
            def trader_EfficiencyTrend(/** parameter alpha for the moving average */ alpha = 0.15) : .IAccount => .IFunction[.Float]
            
            // defined at <undefined filename>: <undefined position>
            /** Unit function. Used to simulate uniform random choice of a strategy
             */
            @python.curried("Unit")
            def trader_Unit() : .IAccount => .IFunction[.Float]
            
        }
        
        package f
        {
            // defined at <undefined filename>: <undefined position>
            /** scaling function = max(0, f(x)) + 1
             */
            @python.curried("Clamp0")
            def f_Clamp0() : .Optional[.IFunction[.Float]] => .IFunction[.Float]
            
            // defined at <undefined filename>: <undefined position>
            /** scaling function = atan(base^f(x))
             */
            @python.curried("AtanPow")
            def f_AtanPow(/** base for power function */ base = 1.002) : .Optional[.IFunction[.Float]] => .IFunction[.Float]
            
            // defined at <undefined filename>: <undefined position>
            /** identity scaling = f(x)
             */
            @python.curried("IdentityF")
            def f_IdentityF() : .Optional[.IFunction[.Float]] => .IFunction[.Float]
            
        }
        
        def efficiency = trader.trader_Efficiency
        
        // defined at defs\strategies\efficiency.sc: 126.5
        /** Function returning an array of length *len(array)*
         *  having 1 at the index of the maximal element and 0 are at the rest
         */
        @python.intrinsic("strategy.weight._ChooseTheBest_Impl")
        @curried("array")
        def ChooseTheBest(array : Optional[List[Float]] = []) : List[Float]
        
        def chooseTheBest = array.array_ChooseTheBest
        
        def score = trader.trader_Score
        
        def atanpow = f.f_AtanPow
        
        // defined at defs\strategies\efficiency.sc: 96.5
        /** Returns traders eficiency. Under efficiency we understand trader balance if trader position was cleared
         */
        @curried("trader")
        def Efficiency(/** account in question */ trader : IAccount = trader.SingleProxy()) : IFunction[Float] = trader.Efficiency(trader)
        
        def efficiencyTrend = trader.trader_EfficiencyTrend
        
        def clamp0 = f.f_Clamp0
        
        // defined at defs\strategies\efficiency.sc: 77.5
        /** Calculates how many times efficiency of trader went up and went down
         * Returns difference between them.
         *
         * TODO: should be UpScore(timeframe, Efficiency(trader)) - DownScore(timeframe, Efficiency(trader))
         */
        @python.intrinsic("strategy.weight._Score_Impl")
        @curried("trader")
        def Score(/** account in question */ trader : IAccount = trader.SingleProxy()) : IFunction[Float]
        
        // defined at defs\strategies\efficiency.sc: 63.5
        /** scaling function = max(0, f(x)) + 1
         */
        @curried("f")
        def Clamp0(/** function to scale */ f : Optional[IFunction[Float]] = constant()) : IFunction[Float] = math.Max(constant(0),f)+1
        
        // defined at defs\strategies\efficiency.sc: 105.5
        /** Returns first derivative of a moving average of the trader efficiency
         */
        @curried("trader")
        def EfficiencyTrend(/** account in question */ trader : IAccount = trader.SingleProxy(),
                            /** parameter alpha for the moving average */ alpha = 0.15) : IFunction[Float] = math.Derivative(math.EW.Avg(trader.Efficiency(trader),alpha))
        
        def unit = trader.trader_Unit
        
        // defined at defs\strategies\efficiency.sc: 87.5
        /** Unit function. Used to simulate uniform random choice of a strategy
         */
        @curried("trader")
        def Unit(/** account in question */ trader : IAccount = trader.SingleProxy()) : IFunction[Float] = constant(1.0)
        
        // defined at defs\strategies\efficiency.sc: 51.5
        /** scaling function = atan(base^f(x))
         */
        @curried("f")
        def AtanPow(/** function to scale */ f : Optional[IFunction[Float]] = constant(),
                    /** base for power function */ base = 1.002) : IFunction[Float] = math.Atan(math.Pow(constant(base),f))
        
        // defined at defs\strategies\efficiency.sc: 119.5
        /** Identity function for an array of floats
         */
        @python.intrinsic("strategy.weight._Identity_Impl")
        @curried("array")
        def IdentityL(array : Optional[List[Float]] = []) : List[Float]
        
        def identity_f = f.f_IdentityF
        
        // defined at defs\strategies\efficiency.sc: 72.5
        /** identity scaling = f(x)
         */
        @curried("f")
        def IdentityF(f : Optional[IFunction[Float]] = constant()) : IFunction[Float] = f
        
    }
    
    @category = "Price function"
    package price
    {
        // defined at defs\strategies\parts\price.sc: 4.5
        /** Price function for a liquidity provider strategy
         */
        def LiquidityProvider(/** side of orders to create */ side = .side.Sell(),
                              /** initial price which is taken if orderBook is empty */ initialValue = 100.0,
                              /** defines multipliers for current asset price when price of
                                *             order to create is calculated*/ priceDistr = math.random.lognormvariate(0.0,0.1),
                              /** asset in question */ book = orderbook.OfTrader()) = orderbook.SafeSidePrice(orderbook.Queue(book,side),constant(initialValue))*priceDistr
        
    }
    
    @category = "Volume function"
    package position
    {
        // defined at defs\strategies\parts\position.sc: 4.5
        /** Position function for desired position strategy
         */
        def DesiredPosition(/** observable desired position */ desiredPosition = const(),
                            /** trader in question */ trader = trader.SingleProxy()) = observable.Volume(desiredPosition-trader.Position(trader)-trader.PendingVolume(trader))
        
        // defined at defs\strategies\parts\position.sc: 15.5
        /** Position function for Bollinger bands strategy with linear scaling
         */
        def Bollinger_linear(/** alpha parameter for exponentially weighted moving everage and variance */ alpha = 0.15,
                             /** observable scaling function that maps relative deviation to desired position */ k = const(0.5),
                             /** trader in question */ trader = trader.SingleProxy()) = DesiredPosition(observable.OnEveryDt(1.0,math.EW.RelStdDev(orderbook.MidPrice(orderbook.OfTrader(trader)),alpha))*k,trader)
        
        // defined at defs\strategies\parts\position.sc: 34.5
        /** Position function for Relative Strength Index strategy with linear scaling
         */
        def RSI_linear(/** alpha parameter for exponentially moving averages of up movements and down movements */ alpha = 1.0/14.0,
                       /** observable scaling function that maps RSI deviation from 50 to the desired position */ k = const(-0.04),
                       /** lag for calculating up and down movements */ timeframe = 1.0,
                       /** trader in question */ trader = trader.SingleProxy()) = DesiredPosition(observable.OnEveryDt(1.0,50.0-math.RSI(orderbook.OfTrader(trader),timeframe,alpha))*k,trader)
        
    }
    
    package account
    {
        package inner
        {
            // defined at <undefined filename>: <undefined position>
            /** Associated with a strategy account that tracks
             *  how orders sent by the strategy have been actually traded
             */
            @python.curried("Real")
            def inner_Real() : .Optional[.ISingleAssetStrategy] => .IAccount
            
            // defined at <undefined filename>: <undefined position>
            /** Associated with a strategy account that evaluates for every order sent by the strategy
             *  how it would be traded by sending request.evalMarketOrder
             *  (note: orders sent by a strategy wrapped into an adaptive strategy may not come to the market
             *  but we want evaluate in any case would it be profitable or not)
             */
            @python.curried("VirtualMarket")
            def inner_VirtualMarket() : .Optional[.ISingleAssetStrategy] => .IAccount
            
        }
        
        // defined at defs\strategies\efficiency.sc: 3.5
        /** Associated with a strategy account that tracks
         *  how orders sent by the strategy have been actually traded
         */
        @python.intrinsic("strategy.account._Account_Impl")
        @curried("inner")
        def Real(/** strategy to track */ inner : Optional[ISingleAssetStrategy] = Noise()) : IAccount
        
        // defined at defs\strategies\efficiency.sc: 12.5
        /** Associated with a strategy account that evaluates for every order sent by the strategy
         *  how it would be traded by sending request.evalMarketOrder
         *  (note: orders sent by a strategy wrapped into an adaptive strategy may not come to the market
         *  but we want evaluate in any case would it be profitable or not)
         */
        @python.intrinsic("strategy.account._VirtualMarket_Impl")
        @curried("inner")
        def VirtualMarket(/** strategy to track */ inner : Optional[ISingleAssetStrategy] = Noise()) : IAccount
        
        def real = inner.inner_Real
        
        def virtualMarket = inner.inner_VirtualMarket
        
    }
    
    // defined at defs\strategies\common.sc: 14.5
    /** Creates a strategy combining two strategies
     *  Can be considered as a particular case of Array strategy
     */
    @python.intrinsic("strategy.combine._Combine_Impl")
    def Combine(A = Noise(),
                B = Noise()) : ISingleAssetStrategy
    
    // defined at defs\strategies\position.sc: 3.5
    /** Strategy believing that trader position should be proportional to 50 - RSI(asset)
     */
    def RSI_linear(/** order factory function */ orderFactory = order.signedVolume.MarketSigned(),
                   /** alpha parameter for exponentially moving averages of up movements and down movements */ alpha = 1.0/14,
                   /** observable scaling function that maps RSI deviation from 50 to the desired position */ k = const(-0.04),
                   /** lag for calculating up and down movements */ timeframe = 1.0) = Generic(orderFactory(position.RSI_linear(alpha,k,timeframe)))
    
    // defined at defs\strategies\side.sc: 115.5
    /** Dependent price strategy believes that the fair price of an asset *A*
     * is completely correlated with price of another asset *B* and the following relation
     * should be held: *PriceA* = *kPriceB*, where *k* is some factor.
     * It may be considered as a variety of a fundamental value strategy
     * with the exception that it is invoked every the time price of another
     * asset *B* changes.
     */
    def PairTrading(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
                    /** order factory function*/ orderFactory = order.side.Market(),
                    /** reference to order book for another asset used to evaluate fair price of our asset */ bookToDependOn = orderbook.OfTrader(),
                    /** multiplier to obtain fair asset price from the reference asset price */ factor = 1.0) = Generic(orderFactory(side.PairTrading(bookToDependOn,factor)),eventGen)
    
    // defined at defs\strategies\adaptive.sc: 49.5
    /** A composite strategy initialized with an array of strategies.
     * In some moments of time the most effective strategy
     * is chosen and made running; other strategies are suspended.
     * It can be considered as a particular case for MultiArmedBandit strategy with
     * *corrector* parameter set to *chooseTheBest*
     */
    @python.intrinsic("strategy.choose_the_best._ChooseTheBest_Impl")
    def ChooseTheBest(/** original strategies that can be suspended */ strategies = [Noise()],
                      /** function creating phantom strategy used for efficiency estimation */ account = account.inner.inner_VirtualMarket(),
                      /** function estimating is the strategy efficient or not */ performance = weight.trader.trader_EfficiencyTrend()) : ISingleAssetStrategy
    
    // defined at defs\strategies\side.sc: 16.5
    /** Signal strategy listens to some discrete signal
     * and when the signal becomes more than some threshold the strategy starts to buy.
     * When the signal gets lower than -threshold the strategy starts to sell.
     */
    def Signal(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
               /** order factory function*/ orderFactory = order.side.Market(),
               /** signal to be listened to */ signal = constant(0.0),
               /** threshold when the trader starts to act */ threshold = 0.7) = Generic(orderFactory(side.Signal(signal,threshold)),eventGen)
    
    // defined at defs\strategies\sideprice.sc: 28.5
    /** Liquidity provider for two sides
     */
    def LiquidityProvider(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
                          /** order factory function*/ orderFactory = order.side_price.Limit(),
                          /** initial price which is taken if orderBook is empty */ initialValue = 100.0,
                          /** defines multipliers for current asset price when price of
                            *                    order to create is calculated*/ priceDistr = math.random.lognormvariate(0.0,0.1)) = Array([LiquidityProviderSide(eventGen,orderFactory,side.Sell(),initialValue,priceDistr),LiquidityProviderSide(eventGen,orderFactory,side.Buy(),initialValue,priceDistr)])
    
    // defined at defs\strategies\side.sc: 57.5
    /** Two averages strategy compares two averages of price of the same asset but
     * with different parameters ('slow' and 'fast' averages) and when
     * the first is greater than the second one it buys,
     * when the first is lower than the second one it sells
     */
    def CrossingAverages(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
                         /** order factory function*/ orderFactory = order.side.Market(),
                         /** parameter |alpha| for exponentially weighted moving average 1 */ ewma_alpha_1 = 0.15,
                         /** parameter |alpha| for exponentially weighted moving average 2 */ ewma_alpha_2 = 0.015,
                         /** threshold when the trader starts to act */ threshold = 0.0) = Generic(orderFactory(side.CrossingAverages(ewma_alpha_1,ewma_alpha_2,threshold)),eventGen)
    
    // defined at defs\strategies\adaptive.sc: 3.5
    /** Strategy that wraps another strategy and passes its orders only if *predicate* is true
     */
    @python.intrinsic("strategy.suspendable._Suspendable_Impl")
    def Suspendable(/** wrapped strategy */ inner = Noise(),
                    /** predicate to evaluate */ predicate = true() : IFunction[Boolean]) : ISingleAssetStrategy
    
    // defined at defs\strategies\side.sc: 35.5
    /** Trend follower can be considered as a sort of a signal strategy
     * where the *signal* is a trend of the asset.
     * Under trend we understand the first derivative of some moving average of asset prices.
     * If the derivative is positive, the trader buys; if negative - it sells.
     * Since moving average is a continuously changing signal, we check its
     * derivative at moments of time given by *eventGen*.
     */
    def TrendFollower(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
                      /** order factory function*/ orderFactory = order.side.Market(),
                      /** parameter |alpha| for exponentially weighted moving average */ ewma_alpha = 0.15,
                      /** threshold when the trader starts to act */ threshold = 0.0) = Generic(orderFactory(side.TrendFollower(ewma_alpha,threshold)),eventGen)
    
    // defined at defs\strategies\side.sc: 79.5
    /** Fundamental value strategy believes that an asset should have some specific price
     * (*fundamental value*) and if the current asset price is lower than the fundamental value
     * it starts to buy the asset and if the price is higher it starts to sell the asset.
     */
    def FundamentalValue(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
                         /** order factory function*/ orderFactory = order.side.Market(),
                         /** defines fundamental value */ fundamentalValue = constant(100.0)) = Generic(orderFactory(side.FundamentalValue(fundamentalValue)),eventGen)
    
    // defined at defs\strategies\common.sc: 44.5
    /** Strategy for a multi asset trader.
     * It believes that these assets represent a single asset traded on different venues
     * Once an ask at one venue becomes lower than a bid at another venue
     * it sends market sell and buy orders in order to exploit this arbitrage possibility
     */
    @python.intrinsic("strategy.arbitrage._Arbitrage_Impl")
    def Arbitrage() : IMultiAssetStrategy
    
    // defined at defs\strategies\side.sc: 137.5
    /** Strategy that calculates Relative Strength Index of an asset
     *  and starts to buy when RSI is greater than 50 + *threshold*
     *  and sells when RSI is less than 50 - *thresold*
     */
    def RSIbis(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
               /** order factory function*/ orderFactory = order.side.Market(),
               /** parameter |alpha| for exponentially weighted moving average when calculating RSI */ alpha = 1.0/14,
               /** lag for calculating up and down movements for RSI */ timeframe = 1.0,
               /** strategy starts to act once RSI is out of [50-threshold, 50+threshold] */ threshold = 30.0) = Generic(orderFactory(side.Signal(50.0-math.RSI(orderbook.OfTrader(),timeframe,alpha),50.0-threshold)),eventGen)
    
    // defined at defs\strategies\adaptive.sc: 13.5
    /** Adaptive strategy that evaluates *inner* strategy efficiency and if it is considered as good, sends orders
     */
    def TradeIfProfitable(/** wrapped strategy */ inner = Noise(),
                          /** defines how strategy trades are booked: actually traded amount or virtual market orders are
                            * used in order to estimate how the strategy would have traded if all her orders appear at market */ account = account.inner.inner_VirtualMarket(),
                          /** given a trading account tells should it be considered as effective or not */ performance = weight.trader.trader_EfficiencyTrend()) = Suspendable(inner,performance(account(inner))>=0)
    
    // defined at defs\strategies\common.sc: 22.5
    /** Creates a strategy combining an array of strategies
     */
    @python.intrinsic("strategy.combine._Array_Impl")
    def Array(/** strategies to combine */ strategies = [Noise()]) : ISingleAssetStrategy
    
    // defined at defs\strategies\side.sc: 97.5
    /** Mean reversion strategy believes that asset price should return to its average value.
     * It estimates this average using some functional and
     * if the current asset price is lower than the average
     * it buys the asset and if the price is higher it sells the asset.
     */
    def MeanReversion(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
                      /** order factory function*/ orderFactory = order.side.Market(),
                      /** parameter |alpha| for exponentially weighted moving average */ ewma_alpha = 0.15) = Generic(orderFactory(side.MeanReversion(ewma_alpha)),eventGen)
    
    // defined at defs\strategies\common.sc: 38.5
    /** Empty strategy doing nothing
     */
    @python.intrinsic("strategy.basic._Empty_Impl")
    def Empty() : ISingleAssetStrategy
    
    // defined at defs\strategies\adaptive.sc: 27.5
    /** A composite strategy initialized with an array of strategies.
     * In some moments of time the efficiency of the strategies is evaluated
     * These efficiencies are mapped into weights using *weight* and *normilizer*
     * functions per every strategy and *corrector* for the whole collection of weights
     * These weights are used to choose randomly a strategy to run for the next quant of time.
     * All other strategies are suspended
     */
    @python.intrinsic("strategy.multiarmed_bandit._MultiarmedBandit2_Impl")
    def MultiArmedBandit(/** original strategies that can be suspended */ strategies = [Noise()],
                         /** function creating a virtual account used for estimate efficiency of the strategy itself */ account = account.inner.inner_VirtualMarket(),
                         /** function estimating is the strategy efficient or not */ weight = weight.trader.trader_EfficiencyTrend(),
                         /** function that maps trader efficiency to its weight that will be used for random choice */ normalizer = weight.f.f_AtanPow(),
                         /** given array of strategy weights corrects them.
                           * for example it may set to 0 all weights except the maximal one */ corrector = weight.array.array_IdentityL()) : ISingleAssetStrategy
    
    // defined at defs\strategies\sideprice.sc: 47.5
    /** A Strategy that allows to drive the asset price based on historical market data
     *  by creating large volume orders for the given price.
     *
     *  Every time step of 1 in the simulation corresponds to a 1 day in the market data.
     *
     *  At each time step the previous Limit Buy/Sell orders are cancelled and new ones
     *  are created based on the next price of the market data.
     */
    def MarketData(/** Ticker of the asset */ ticker = "^GSPC",
                   /** Start date in DD-MM-YYYY format */ start = "2001-1-1",
                   /** End date in DD-MM-YYYY format */ end = "2010-1-1",
                   /** Price difference between orders placed and underlying quotes */ delta = 1.0,
                   /** Volume of Buy/Sell orders. Should be large compared to the volumes of other traders. */ volume = 1000.0) = Combine(Generic(order.Iceberg(constant(volume),order.FloatingPrice(observable.BreaksAtChanges(observable.Quote(ticker,start,end)+delta),order.price.Limit(side.Sell(),constant(volume*1000)))),event.After(constant(0.0))),Generic(order.Iceberg(constant(volume),order.FloatingPrice(observable.BreaksAtChanges(observable.Quote(ticker,start,end)-delta),order.price.Limit(side.Buy(),constant(volume*1000)))),event.After(constant(0.0))))
    
    // defined at defs\strategies\common.sc: 29.5
    /** Strategy that listens to all orders sent by a trader to the market
     *  and in some moments of time it randomly chooses an order and cancels it
     *  Note: a similar effect can be obtained using order.WithExpiry meta orders
     */
    @python.intrinsic("strategy.canceller._Canceller_Impl")
    def Canceller(/** intervals between order cancellations */ cancellationIntervalDistr = math.random.expovariate(1.0)) : ISingleAssetStrategy
    
    // defined at defs\strategies\sideprice.sc: 3.5
    /** Liquidity provider for one side
     */
    def LiquidityProviderSide(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
                              /** order factory function*/ orderFactory = order.side_price.Limit(),
                              /** side of orders to create */ side = .side.Sell(),
                              /** initial price which is taken if orderBook is empty */ initialValue = 100.0,
                              /** defines multipliers for current asset price when price of
                                *                    order to create is calculated*/ priceDistr = math.random.lognormvariate(0.0,0.1)) = Generic(orderFactory(side,price.LiquidityProvider(side,initialValue,priceDistr)),eventGen)
    
    // defined at defs\strategies\common.sc: 4.5
    /** Generic strategy that wakes up on events given by *eventGen*,
     *  creates an order via *orderFactory* and sends the order to the market using its trader
     */
    @python.intrinsic("strategy.generic._Generic_Impl")
    def Generic(/** order factory function*/ orderFactory = order.Limit(),
                /** Event source making the strategy to wake up*/ eventGen = event.Every()) : ISingleAssetStrategy
    
    // defined at defs\strategies\sideprice.sc: 85.5
    def MarketMaker(delta = 1.0,
                    volume = 20.0) = Combine(Generic(order.Iceberg(constant(volume),order.FloatingPrice(observable.BreaksAtChanges(observable.OnEveryDt(0.9,orderbook.SafeSidePrice(orderbook.Asks(),constant(100+delta))/math.Exp(math.Atan(trader.Position())/1000))),order.price.Limit(side.Sell(),constant(volume*1000)))),event.After(constant(0.0))),Generic(order.Iceberg(constant(volume),order.FloatingPrice(observable.BreaksAtChanges(observable.OnEveryDt(0.9,orderbook.SafeSidePrice(orderbook.Bids(),constant(100-delta))/math.Exp(math.Atan(trader.Position())/1000))),order.price.Limit(side.Buy(),constant(volume*1000)))),event.After(constant(0.0))))
    
    // defined at defs\strategies\side.sc: 3.5
    /** Noise strategy is a quite dummy strategy that randomly chooses trade side and sends market orders
     */
    def Noise(/** Event source making the strategy to wake up*/ eventGen = event.Every(math.random.expovariate(1.0)),
              /** order factory function*/ orderFactory = order.side.Market()) = Generic(orderFactory(side.Noise()),eventGen)
    
    // defined at defs\strategies\position.sc: 19.5
    /** Strategy believing that trader position should be proportional to the relative standard deviation of its price
     */
    def Bollinger_linear(/** order factory function */ orderFactory = order.signedVolume.MarketSigned(),
                         /** alpha parameter for exponentially weighted moving everage and variance */ alpha = 0.15,
                         /** observable scaling function that maps relative deviation to desired position */ k = const(0.5)) = Generic(orderFactory(position.Bollinger_linear(alpha,k)))
    
}

@category = "Trader"
package trader
{
    // defined at defs\trader\properties.sc: 12.5
    /** Number of money owned by trader
     */
    @python.intrinsic("trader.props.Balance_Impl")
    def Balance(trader = SingleProxy() : IAccount) : IObservable[Price]
    
    // defined at defs\trader\properties.sc: 36.5
    /** Returns traders naive approximation of trader eficiency.
     *  It takes into account only the best price of the order queue
     */
    def RoughPnL(trader = SingleProxy() : IAccount) = observable.Float(Balance(trader)+orderbook.NaiveCumulativePrice(orderbook.OfTrader(trader),Position(trader)))
    
    // defined at defs\trader\properties.sc: 4.5
    /** Returns position of the trader
     *  It is negative if trader has sold more assets than has bought and
     *  positive otherwise
     */
    @python.intrinsic("trader.props.Position_Impl")
    def Position(trader = SingleProxy() : IAccount) : IObservable[Volume]
    
    // defined at defs\trader\properties.sc: 24.5
    /** Returns traders eficiency. Under efficiency we understand trader balance if trader position was cleared
     */
    def Efficiency(trader = SingleProxy() : IAccount) = observable.Float(Balance(trader)+orderbook.CumulativePrice(orderbook.OfTrader(trader),Position(trader)))
    
    // defined at defs\trader\classes.sc: 38.5
    /** Phantom trader that is used to refer to the current trader
     *  (normally it is used to define trader properties and strategies)
     */
    @python.intrinsic("trader.proxy._Single_Impl")
    @label = "N/A"
    def SingleProxy() : ISingleAssetTrader
    
    // defined at defs\trader\classes.sc: 21.5
    /** A trader that trades different assets
     *  It can be considered as a composition of single asset traders and multi asset strategies
     *  At the moment there is no way to instruct a multi asset strategy to trade only on subset of the assets
     */
    @python.intrinsic("trader.classes._MultiAsset_Impl")
    @label = "%(name)s"
    def MultiAsset(/** defines accounts for every asset to trade */ traders = [] : List[ISingleAssetTrader],
                   /** multi asset strategy run by the trader */ strategy = strategy.Arbitrage(),
                   name = "-trader-",
                   /** current trader balance (number of money units that it owns) */ PnL = 0.0,
                   /** defines what data should be gathered for the trader */ timeseries = [] : List[ITimeSerie]) : ITrader
    
    // defined at defs\trader\properties.sc: 49.5
    /** Returns first derivative of a moving average of the trader efficiency
     */
    def EfficiencyTrend(trader = SingleProxy() : IAccount,
                        alpha = 0.15) = math.Derivative(math.EW.Avg(Efficiency(trader),alpha))
    
    // defined at defs\trader\properties.sc: 18.5
    /** Cumulative volume of orders sent to the market but haven't matched yet
     */
    @python.intrinsic("trader.props.PendingVolume_Impl")
    def PendingVolume(trader = SingleProxy() : IAccount) : IObservable[Volume]
    
    // defined at defs\trader\classes.sc: 4.5
    /** A trader that trades a single asset on a single market
     */
    @python.intrinsic("trader.classes._SingleAsset_Impl")
    @label = "%(name)s"
    def SingleAsset(/** order book for the asset being traded */ orderBook : IOrderBook,
                    /** strategy run by the trader */ strategy = strategy.Noise(),
                    name = "-trader-",
                    /** current position of the trader (number of assets that it owns) */ amount = 0.0,
                    /** current trader balance (number of money units that it owns) */ PnL = 0.0,
                    /** defines what data should be gathered for the trader */ timeseries = [] : List[ITimeSerie]) : ISingleAssetTrader
    
}

@category = "Asset"
package orderbook
{
    @queue = "Ask_{%(book)s}"
    package ask
    {
        // defined at defs\orderbook\properties.sc: 152.9
        @label = "[{{queue}}]_{%(alpha)s}"
        def WeightedPrice(book = OfTrader(),
                          alpha = 0.15) = orderbook.WeightedPrice(_queue(book),alpha)
        
        // defined at defs\orderbook\properties.sc: 149.9
        @label = "LastTradeVolume({{queue}})"
        def LastTradeVolume(book = OfTrader()) = orderbook.LastTradeVolume(_queue(book))
        
        // defined at defs\orderbook\properties.sc: 140.9
        @label = "{{queue}}"
        def Price(book = OfTrader()) = BestPrice(_queue(book))
        
        // defined at defs\orderbook\properties.sc: 143.9
        @label = "Last({{queue}})"
        def LastPrice(book = OfTrader()) = orderbook.LastPrice(_queue(book))
        
        def _queue = Asks
        
        // defined at defs\orderbook\properties.sc: 146.9
        @label = "LastTrade({{queue}})"
        def LastTradePrice(book = OfTrader()) = orderbook.LastTradePrice(_queue(book))
        
    }
    
    @queue = "Bid^{%(book)s}"
    package bid
    {
        // defined at defs\orderbook\properties.sc: 152.9
        @label = "[{{queue}}]_{%(alpha)s}"
        def WeightedPrice(book = OfTrader(),
                          alpha = 0.15) = orderbook.WeightedPrice(_queue(book),alpha)
        
        // defined at defs\orderbook\properties.sc: 149.9
        @label = "LastTradeVolume({{queue}})"
        def LastTradeVolume(book = OfTrader()) = orderbook.LastTradeVolume(_queue(book))
        
        // defined at defs\orderbook\properties.sc: 140.9
        @label = "{{queue}}"
        def Price(book = OfTrader()) = BestPrice(_queue(book))
        
        // defined at defs\orderbook\properties.sc: 143.9
        @label = "Last({{queue}})"
        def LastPrice(book = OfTrader()) = orderbook.LastPrice(_queue(book))
        
        def _queue = Bids
        
        // defined at defs\orderbook\properties.sc: 146.9
        @label = "LastTrade({{queue}})"
        def LastTradePrice(book = OfTrader()) = orderbook.LastTradePrice(_queue(book))
        
    }
    
    // defined at defs\orderbook\classes.sc: 56.5
    /** Phantom orderbook that is used to refer to the current order book
     *
     *  May be used only in objects held by orderbooks (so it is normally used in orderbook properties)
     */
    @python.intrinsic("orderbook.of_trader._Proxy_Impl")
    @label = "N/A"
    def Proxy() : IOrderBook
    
    // defined at defs\orderbook\properties.sc: 50.5
    /** Returns best price if defined, otherwise last price
     *  and *defaultValue* if there haven't been any trades
     */
    @python.observable()
    def SafeSidePrice(queue = Asks(),
                      /** price to be used if there haven't been any trades */ defaultValue = constant(100.0)) = observable.Price(IfDefined(BestPrice(queue),IfDefined(LastPrice(queue),defaultValue)))
    
    // defined at defs\orderbook\properties.sc: 63.5
    /** Returns moving average of trade prices weighted by their volumes
     */
    @label = "Price_{%(alpha)s}^{%(queue)s}"
    def WeightedPrice(queue = Asks(),
                      /** parameter alpha for the moving average  */ alpha = 0.15) = math.EW.Avg(LastTradePrice(queue)*LastTradeVolume(queue),alpha)/math.EW.Avg(LastTradeVolume(queue),alpha)
    
    // defined at defs\orderbook\properties.sc: 74.5
    /** Returns tick size for the order *book*
     */
    @python.intrinsic("orderbook.props._TickSize_Impl")
    def TickSize(book = OfTrader()) : () => Price
    
    // defined at defs\orderbook\properties.sc: 88.5
    /** MidPrice of order *book*
     */
    def MidPrice(book = OfTrader()) = observable.Price((ask.Price(book)+bid.Price(book))/2.0)
    
    // defined at defs\orderbook\properties.sc: 10.5
    /** Returns sell side order queue for *book*
     */
    @python.intrinsic("orderbook.proxy._Asks_Impl")
    def Asks(book = OfTrader()) = Queue(book,side.Sell())
    
    // defined at defs\orderbook\properties.sc: 43.5
    /** Returns volume of the last trade at *queue*
     *  Returns None if there haven't been any trades
     */
    @python.intrinsic("orderbook.last_trade._LastTradeVolume_Impl")
    def LastTradeVolume(queue = Asks()) : IObservable[Volume]
    
    // defined at defs\orderbook\properties.sc: 16.5
    /** Returns buy side order queue for *book*
     */
    @python.intrinsic("orderbook.proxy._Bids_Impl")
    def Bids(book = OfTrader()) = Queue(book,side.Buy())
    
    // defined at defs\orderbook\properties.sc: 22.5
    /** Returns best order price of *queue*
     *  Returns None is *queue* is empty
     */
    @python.intrinsic("orderbook.props._BestPrice_Impl")
    def BestPrice(queue = Asks()) : IObservable[Price]
    
    // defined at defs\orderbook\classes.sc: 35.5
    /** Represents latency in information propagation between two agents
     * (normally between a trader and a market).
     * Ensures that sending packets via links preserves their order.
     * Holds two one-way links in opposite directions.
     */
    @python.intrinsic("orderbook.link._TwoWayLink_Impl")
    def TwoWayLink(/** Forward link (normally from a trader to a market)*/ up = Link(),
                   /** Backward link (normally from a market to a trader)*/ down = Link()) : ITwoWayLink
    
    // defined at defs\orderbook\properties.sc: 4.5
    /** Returns order queue of order *book* for trade *side*
     */
    @python.intrinsic("orderbook.proxy._Queue_Impl")
    def Queue(book = OfTrader(),
              side = side.Sell()) : IOrderQueue
    
    // defined at defs\orderbook\classes.sc: 47.5
    /** Phantom orderbook used to refer to the order book associated with a single asset trader
     *
     *  May be used only in objects that are held by traders (so it is used in trader properties and strategies)
     */
    @python.intrinsic("orderbook.of_trader._OfTrader_Impl")
    @label = "N/A"
    def OfTrader(Trader = trader.SingleProxy() : IAccount) : IOrderBook
    
    // defined at defs\orderbook\properties.sc: 96.5
    /** Returns price for best orders of total volume *depth*
     *
     *  In other words cumulative price corresponds to trader balance change
     *  if a market order of volume *depth* is completely matched
     *
     *  Negative *depth* correponds to will buy assets
     *  Positive *depth* correponds to will sell assets
     */
    @python.intrinsic("orderbook.cumulative_price.CumulativePrice_Impl")
    def CumulativePrice(book = OfTrader(),
                        depth = constant()) : IObservable[Price]
    
    // defined at defs\orderbook\properties.sc: 124.5
    /** Returns arrays of levels for given volumes [i*volumeDelta for i in range(0, volumeCount)]
     *  Level of volume V is a price at which cumulative volume of better orders is V
     */
    @python.intrinsic("orderbook.volume_levels.VolumeLevels_Impl")
    @label = "VolumeLevels(%(queue)s)"
    def VolumeLevels(queue = Asks(),
                     /** distance between two volumes */ volumeDelta = 30.0,
                     /** number of volume levels to track */ volumeCount = 10) : IObservable[IVolumeLevels]
    
    // defined at defs\orderbook\properties.sc: 29.5
    /** Returns last defined price at *queue*
     *  Returns None is *queue* has been always empty
     */
    @python.intrinsic("orderbook.last_price._LastPrice_Impl")
    def LastPrice(queue = Asks()) : IObservable[Price]
    
    // defined at defs\orderbook\classes.sc: 4.5
    /** Order book for a single asset in a market.
     * Maintains two order queues for orders of different sides
     */
    @python.intrinsic("orderbook.local._Local_Impl")
    @label = "%(name)s"
    def Local(tickSize = 0.01,
              _digitsToShow = 2,
              name = "-orderbook-",
              timeseries = [] : List[ITimeSerie]) : IOrderBook
    
    // defined at defs\orderbook\classes.sc: 15.5
    /** Represent an *orderbook* from point of view of a remote trader connected
     * to the market by means of a *link* that introduces some latency in information propagation
     */
    @python.intrinsic("orderbook.remote._Remote_Impl")
    @label = "%(orderbook)s.name^remote"
    def Remote(orderbook = Local(),
               link = TwoWayLink(),
               timeseries = [] : List[ITimeSerie]) : IOrderBook
    
    // defined at defs\orderbook\properties.sc: 109.5
    /** Returns naive approximation of price for best orders of total volume *depth*
     *  by taking into account prices only for the best order
     *
     *  Negative *depth* correponds to will buy assets
     *  Positive *depth* correponds to will sell assets
     */
    def NaiveCumulativePrice(book = OfTrader(),
                             depth = constant()) = observable.Price(if depth<0.0 then depth*ask.Price(book) else if depth>0.0 then depth*bid.Price(book) else 0.0)
    
    // defined at defs\orderbook\classes.sc: 25.5
    /** Represents latency in information propagation from one agent to another one
     * (normally between a trader and a market).
     * Ensures that sending packets via a link preserves their order.
     */
    @python.intrinsic("orderbook.link._Link_Impl")
    def Link(/** function called for each packet in order to determine
               * when it will appear at the end point*/ latency = const(0.001)) : ILink
    
    // defined at defs\orderbook\properties.sc: 80.5
    /** Spread of order *book*
     */
    def Spread(book = OfTrader()) = observable.Price(ask.Price(book)-bid.Price(book))
    
    // defined at defs\orderbook\properties.sc: 36.5
    /** Returns price of the last trade at *queue*
     *  Returns None if there haven't been any trades
     */
    @python.intrinsic("orderbook.last_trade._LastTradePrice_Impl")
    def LastTradePrice(queue = Asks()) : IObservable[Price]
    
}

@category = "Basic"
package observable
{
    // defined at defs\observable.sc: 4.5
    /** Discretizes function *x* at even time steps *dt*
     */
    @python.intrinsic("observable.on_every_dt._OnEveryDt_Impl")
    @label = "[%(x)s]_dt=%(dt)s"
    @observe_args = "no"
    def OnEveryDt(/** time discretization step */ dt = 1.0,
                  /** function to discretize */ x = constant()) : IObservable[Float]
    
    // defined at defs\observable.sc: 51.5
    /** Down casts function *x* to IObservable[Volume].
     * Needed since generic functions aren't implemented yet
     */
    @python.intrinsic("observable.on_every_dt._Observable_Impl")
    @label = "[%(x)s]"
    def Volume(x = const() : IFunction[Float]) : IObservable[Volume]
    
    // defined at defs\observable.sc: 59.5
    /** Down casts function *x* to IObservable[Side].
     * Needed since generic functions aren't implemented yet
     */
    @python.intrinsic("observable.on_every_dt._ObservableSide_Impl")
    @label = "[%(x)s]"
    def Side(x = side.Sell() : IFunction[Side]) : IObservable[Side]
    
    // defined at defs\observable.sc: 43.5
    /** Down casts function *x* to IObservable[Price].
     * Needed since generic functions aren't implemented yet
     */
    @python.intrinsic("observable.on_every_dt._Observable_Impl")
    @label = "[%(x)s]"
    def Price(x = const() : IFunction[Float]) : IObservable[Price]
    
    // defined at defs\observable.sc: 28.5
    /** Observable listening to *source*
     *  When *source* changes it inserts *undefined* value and then immidiately becomes equal to *source* value
     */
    @python.intrinsic("observable.breaks_at_changes._BreaksAtChanges_Impl")
    def BreaksAtChanges(source = constant(1.0)) : IObservable[Float]
    
    // defined at defs\observable.sc: 35.5
    /** Down casts function *x* to IObservable[Float].
     * Needed since generic functions aren't implemented yet
     */
    @python.intrinsic("observable.on_every_dt._Observable_Impl")
    @label = "[%(x)s]"
    def Float(x = const() : IFunction[Float]) : IObservable[Float]
    
    // defined at defs\observable.sc: 15.5
    /** Observable that downloads closing prices for every day from *start* to *end* for asset given by *ticker*
     *  and follows the price in scale 1 model unit of time = 1 real day
     */
    @python.intrinsic("observable.quote.Quote_Impl")
    @label = "%(ticker)s"
    def Quote(/** defines quotes to download */ ticker = "^GSPC",
              /** defines first day to download in form YYYY-MM-DD */ start = "2001-1-1",
              /** defines last day to download in form YYYY-MM-DD */ end = "2010-1-1") : IObservable[Price]
    
}

@python = "no"
package trash
{
    package types
    {
        type T1 = T
        
        type T
        
        type R : T
        
        type U : T, R
        
    }
    
    package in1
    {
        package in2
        {
            // defined at defs\trash.sc: 34.1
            def S1(y = "abc") = y
            
            // defined at defs\trash.sc: 42.1
            def F(x = IntFunc() : IFunction[Float]) = x
            
            // defined at defs\trash.sc: 32.1
            def A(x = constant(),
                  y = if 3>x+2 then x else x*2) : () => types.T
            
            // defined at defs\trash.sc: 44.1
            def IntObs() : IObservable[Int]
            
            // defined at defs\trash.sc: 40.1
            def IntFunc() : IFunction[Int]
            
            // defined at defs\trash.sc: 38.1
            def C(x : IFunction[CandleStick],
                  p = [12,23.2,0]) = p
            
            // defined at defs\trash.sc: 36.1
            def S2() : Optional[String] = S1()
            
            // defined at defs\trash.sc: 46.1
            def O(x = IntObs() : IObservable[Float]) = x
            
        }
        
        // defined at defs\trash.sc: 29.1
        def A(x : () => .trash.types.T1 = .trash.A()) : () => types.U
        
        // defined at defs\trash.sc: 23.27
        def toInject1() : () => Int
        
        // defined at defs\trash.sc: 24.27
        def toInject2() : () => Int
        
    }
    
    // defined at defs\trash.sc: 26.1
    def A(x = in1.in2.A()) : () => types.R
    
}

// defined at <undefined filename>: <undefined position>
/** Function always returning *x*
 */
@category = "Basic"
@label = "C=%(x)s"
def constant(x = 1.0) = const(x) : IFunction[Float]

// defined at <undefined filename>: <undefined position>
/** Trivial observable always returning *False*
 */
@category = "Basic"
@python.intrinsic.function("_constant._False_Impl")
@label = "False"
def false() : IObservable[Boolean]

type ITrader

type IGraph

type CandleStick

type Volume : Int

type Optional[T]

type IAccount

type Side

type Boolean

type Price : Float

// defined at <undefined filename>: <undefined position>
/** Trivial observable always returning *undefined* or *None* value
 */
@category = "Basic"
@python.intrinsic("_constant._Null_Impl")
def null() : () => Float

type IOrderQueue

// defined at <undefined filename>: <undefined position>
/** Time serie to store and render it after on a graph
 *  Used to specify what data should be collected about order books and traders
 */
@category = "Basic"
@python.intrinsic("timeserie._ToRecord_Impl")
@label = "%(source)s"
def TimeSerie(source = const(0.0) : IObservable[Any],
              graph = veusz.Graph(),
              _digitsToShow = 4,
              _smooth = 1) : ITimeSerie

type Float

type Int : Float

type ILink

type IOrderBook

type IEvent

type IMultiAssetStrategy

// defined at <undefined filename>: <undefined position>
/** Trivial observable always returning *x*
 */
@category = "Basic"
@python.intrinsic.function("_constant._Constant_Impl")
@label = "C=%(x)s"
def const(x = 1.0) : IObservable[Float]

type ITwoWayLink

type IObservable[U] : IFunction[U], IEvent

type IFunction[T] = () => T

type ISingleAssetStrategy

// defined at <undefined filename>: <undefined position>
/** Observable returning at the end of every *timeframe*
 * open/close/min/max price, its average and standard deviation
 */
@category = "Basic"
@python.intrinsic("observable.candlestick.CandleSticks_Impl")
@label = "Candles_{%(source)s}"
def CandleSticks(/** observable data source considered as asset price */ source = const(),
                 /** size of timeframe */ timeframe = 10.0) : IObservable[CandleStick]

type ISingleAssetTrader : IAccount, ITrader

// defined at <undefined filename>: <undefined position>
/** Trivial observable always returning *True*
 */
@category = "Basic"
@python.intrinsic.function("_constant._True_Impl")
@label = "True"
def true() : IObservable[Boolean]

type IVolumeLevels

type Order

type List[T]

type IDifferentiable : IFunction[Float]

// defined at <undefined filename>: <undefined position>
/** Returns *x* if defined and *elsePart* otherwise
 */
@category = "Basic"
@python.observable()
@label = "If def(%(x)s) else %(elsePart)s"
def IfDefined(x = constant(),
              /** function to take values from when *x* is undefined */ elsePart = constant()) = if x<>null() then x else elsePart

type ITimeSerie

type Any

// defined at <undefined filename>: <undefined position>
/** Time serie holding volume levels of an asset
 * Level of volume V is a price at which cumulative volume of better orders is V
 */
@category = "Basic"
@python.intrinsic("timeserie._VolumeLevels_Impl")
@label = "%(source)s"
def volumeLevels(source : IFunction[IVolumeLevels],
                 graph = veusz.Graph(),
                 _digitsToShow = 4,
                 _smooth = 1,
                 _volumes = [30.0],
                 _isBuy = 1) : ITimeSerie

type IOrderGenerator = IObservable[Order]

type String

