// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// LANGUAGE: +InnerClassInEnumEntryClass

enum class A {
    X {
        val x = 1
        fun foo() {}

        inner class Inner {
            val y = x
            fun bar() = foo()
        }
    }
}

/* GENERATED_FIR_TAGS: enumDeclaration, enumEntry */
