// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
sealed class A {
    class B:A()
    class<!SYNTAX!><!> :A()
    fun test(a : A) {
        <!NO_ELSE_IN_WHEN!>when<!>(a) {
        }
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, nestedClass, sealed, whenExpression, whenWithSubject */
