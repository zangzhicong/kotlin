// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
fun test() {
    val p: Array<String> = arrayOf("a")
    foo(*p)
}

fun foo(vararg a: String?) = a

/* GENERATED_FIR_TAGS: functionDeclaration, localProperty, nullableType, outProjection, propertyDeclaration,
stringLiteral, vararg */
