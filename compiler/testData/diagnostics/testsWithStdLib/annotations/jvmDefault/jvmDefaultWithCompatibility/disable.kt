// RUN_PIPELINE_TILL: FRONTEND
// JVM_DEFAULT_MODE: disable

<!JVM_DEFAULT_WITH_COMPATIBILITY_IN_DECLARATION!>@JvmDefaultWithCompatibility<!>
interface A<T> {
    fun test(p: T) {}
}

<!JVM_DEFAULT_WITH_COMPATIBILITY_IN_DECLARATION!>@JvmDefaultWithCompatibility<!>
class B : A<String> {}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, interfaceDeclaration, nullableType, typeParameter */
