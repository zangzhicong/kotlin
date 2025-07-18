// RUN_PIPELINE_TILL: FRONTEND
class C {
    private val x = object {
        fun foo() = 42
    }

    val y = x.foo()

    internal val z = object {
        fun foo() = 13
    }

    val w = z.<!UNRESOLVED_REFERENCE!>foo<!>() // ERROR!
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, functionDeclaration, integerLiteral,
propertyDeclaration */
