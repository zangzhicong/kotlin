// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// ISSUE: KT-58142
interface XTrackableLoading {
    val <X> Property<LoadingValue<X>>.liveLoaded: X
        get(): X = TODO()
}

interface LoadingValue<T>

interface Property<T>

interface AsyncModule {
    fun bar() {}
}
operator fun <T : AsyncModule, R> T.invoke(handler: T.() -> R): R = TODO()

fun XTrackableLoading.foo(fooBar: Property<LoadingValue<AsyncModule>>) {
    fooBar.liveLoaded {
        bar()
    }
}

/* GENERATED_FIR_TAGS: funWithExtensionReceiver, functionDeclaration, functionalType, getter, interfaceDeclaration,
lambdaLiteral, nullableType, operator, propertyDeclaration, propertyWithExtensionReceiver, typeConstraint, typeParameter,
typeWithExtension */
