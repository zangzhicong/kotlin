// RUN_PIPELINE_TILL: FRONTEND
// DIAGNOSTICS: -UNUSED_PARAMETER -REDUNDANT_PROJECTION

class In<in T>() {
    fun f(t : T) {}
    fun f(t : Int) = t
}

fun test1(x: In<String>): Unit = x.f("1")
fun test2(x: In<in String>): Unit = x.f("1")
fun test3(x: In<<!CONFLICTING_PROJECTION!>out<!> String>): Unit = x.<!NONE_APPLICABLE!>f<!>("1")
fun test4(x: In<*>): Unit = x.<!NONE_APPLICABLE!>f<!>("1")

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, in, inProjection, nullableType, outProjection,
primaryConstructor, starProjection, stringLiteral, typeParameter */
