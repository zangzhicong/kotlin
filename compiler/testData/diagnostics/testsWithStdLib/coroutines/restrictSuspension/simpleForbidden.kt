// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
@kotlin.coroutines.RestrictsSuspension
class RestrictedController

suspend fun Any?.extFun() {}
suspend fun suspendFun() {}

fun generate(c: suspend RestrictedController.() -> Unit) {}

fun test() {
    generate {
        <!ILLEGAL_RESTRICTED_SUSPENDING_FUNCTION_CALL!>extFun<!>()
        <!ILLEGAL_RESTRICTED_SUSPENDING_FUNCTION_CALL!>suspendFun<!>()
    }
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, lambdaLiteral,
nullableType, suspend, typeWithExtension */
