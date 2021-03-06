package object TypeInference
{
    def floatRank(e: Typed.Expr) = e.ty match {
        case x if x canCastTo Typed.topLevel.float_ => 0
        case x if x canCastTo Typed.topLevel.floatObservable => 10
        case x if x canCastTo Typed.topLevel.floatFunc => 1
        case t => -1
    }

    def isFloat(e : Typed.Expr) = floatRank(e) >= 0

    private def floatRankStrict(e: Typed.Expr) = floatRank(e) match {
        case -1 => throw new Exception(s"Expression $e is expected to have a numeric-like type")
        case x => x
    }

    private def unifyFloat(xs : Typed.Expr*) =
        (xs map floatRankStrict).sum match {
            case x if x >= 10 => Typed.topLevel.floatObservable
            case x if x >= 1 => Typed.topLevel.floatFunc
            case x if x >= 0 => Typed.topLevel.float_
        }

    trait Neg {
        self: Typed.Neg =>
        val ty = unifyFloat(x)
    }

    trait BinOp {
        self: Typed.BinOp =>
        val ty = unifyFloat(x,y)
    }

    trait IfThenElse {
        self: Typed.IfThenElse =>
        val ty = {
            if (isFloat(x) && isFloat(y))
                unifyFloat(x,y)
            else {
                if (x.ty canCastTo y.ty) y.ty else
                if (y.ty canCastTo x.ty) x.ty else
                    throw new Exception("Cannot unify if-then-else branches in expression " + self)
            }
        }
    }

    trait FloatLit {
        val ty =Typed.topLevel.float_
    }

    trait StringLit {
        val ty = Typed.topLevel.string_
    }

    trait IntLit {
        val ty = Typed.topLevel.int_
    }

    trait ParamRef {
        self: Typed.ParamRef =>
        val ty = p.ty match {
            case TypesBound.Optional(x) => x
            case x                      => x
        }
    }

    trait FunctionRef {
        self: Typed.FunctionRef =>
        val ty = f.ty
    }

    trait FunctionCall {
        self: Typed.FunctionCall =>
        val ty = target.ty.returnTypeIfFunction match {
            case Some(t) => t
            case None    => throw new Exception(s"${target.ty} should be castable to a function")
        }
    }

    trait List_ {
        self: Typed.List_ =>
        val ty =
            TypesBound.List_(
                xs.foldLeft[TypesBound.Base](TypesBound.Nothing) {
                    (acc, x) =>
                        if (acc canCastTo x.ty) x.ty else
                        if (x.ty canCastTo acc) acc  else
                            throw new Exception(s"Cannot unify $acc and ${x.ty} when typing expression $this")
            })
    }

    def checkBoolean(e : Typed.Expr) = {
        if (e.ty cannotCastTo Typed.topLevel.booleanFunc)
            throw new Exception(s"Expression $e is supposed to have () => Boolean type")
        e.ty
    }

    trait UnaryBoolean {
        val x : Typed.Expr
        val ty = checkBoolean(x)
    }

    trait BinaryBoolean extends UnaryBoolean {
        val y : Typed.Expr
        override val ty = checkBoolean(x); checkBoolean(y)
    }

    trait Condition {
        self: Typed.Condition =>
        val ty = {
            val t = unifyFloat(x,y)
            if ((t cannotCastTo  Typed.topLevel.float_) && (t cannotCastTo Typed.topLevel.floatFunc))
                throw new Exception(s"Arguments of boolean expression must be able to cast to () => Float or () => Int")
            Typed.topLevel.booleanFunc
        }
    }
}