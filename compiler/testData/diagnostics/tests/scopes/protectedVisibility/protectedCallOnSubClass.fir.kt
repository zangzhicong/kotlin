// RUN_PIPELINE_TILL: FRONTEND
open class A {
    open protected fun foo() { }
    open protected fun foobaz() { }

    fun bar(x: B) {
        x.foo() // OK, foo declared in A
        x.<!INVISIBLE_REFERENCE!>baz<!>() // Declared in B
        x.<!INVISIBLE_REFERENCE!>foobaz<!>() // Declared in B
    }
}

class B : A() {
    protected fun baz() {}
    override fun foobaz() {}
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, override */
