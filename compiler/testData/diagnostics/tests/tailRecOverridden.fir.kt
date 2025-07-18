// RUN_PIPELINE_TILL: BACKEND
// See also KT-4285
open class A {
    open fun foo(x: Int = 0) {}

    open fun gav(y: Int = 1, z: Int = 2) {}
}

class B: A() {
    <!NO_TAIL_CALLS_FOUND!>tailrec<!> override fun foo(x: Int) {
        <!NON_TAIL_RECURSIVE_CALL!>foo<!>()
    }

    <!NO_TAIL_CALLS_FOUND!>tailrec<!> override fun gav(y: Int, z: Int) {
        <!NON_TAIL_RECURSIVE_CALL!>gav<!>(y)
    }

    tailrec fun bar(y: Double): Double = bar(y * 2.0)
}

class C: A() {
    tailrec override fun foo(x: Int) {
        foo(0)
    }

    tailrec override fun gav(y: Int, z: Int) {
        gav(y - 1, z - 1)
    }

    tailrec fun bar(y: Int = 1, z: Int = 2) {
        bar(z)
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, functionDeclaration, integerLiteral,
multiplicativeExpression, override, tailrec */
