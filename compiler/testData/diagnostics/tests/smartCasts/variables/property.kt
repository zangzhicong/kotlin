// RUN_PIPELINE_TILL: FRONTEND
class MyClass(var p: String?)

fun bar(s: String): Int {
    return s.length
}

fun foo(m: MyClass): Int {
    m.p = "xyz"
    return bar(<!SMARTCAST_IMPOSSIBLE!>m.p<!>)
}

/* GENERATED_FIR_TAGS: assignment, classDeclaration, functionDeclaration, nullableType, primaryConstructor,
propertyDeclaration, stringLiteral */
