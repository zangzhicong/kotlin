// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
interface Inter {
    fun foo(x: Int = <!UNINITIALIZED_PARAMETER!>y<!>, y: Int = x)
}

abstract class Abst {
    abstract fun foo(x: Int = <!UNINITIALIZED_PARAMETER!>y<!>, y: Int = x)
}

<!NON_MEMBER_FUNCTION_NO_BODY!>fun extraDiagnostics(x: Int = <!UNINITIALIZED_PARAMETER!>y<!>, y: Int)<!>

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration */
