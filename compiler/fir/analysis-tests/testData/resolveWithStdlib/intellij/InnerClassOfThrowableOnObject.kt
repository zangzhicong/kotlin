// RUN_PIPELINE_TILL: FRONTEND
// See KT-49129

class Generic<T> {
    companion object {
        fun foo() {
            val x = object : Exception() {}
        }
    }
    class Nested {
        fun foo() {
            val x = object : Exception() {}
        }
    }
    inner class Inner {
        fun foo() {
            val x = <!INNER_CLASS_OF_GENERIC_THROWABLE_SUBCLASS!>object<!> : Exception() {}
        }
    }
}

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, companionObject, functionDeclaration, inner,
localProperty, nestedClass, nullableType, objectDeclaration, propertyDeclaration, typeParameter */
