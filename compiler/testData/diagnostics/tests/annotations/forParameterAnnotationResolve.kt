// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
annotation class Ann(val x: Int)

data class A(val x: Int, val y: Int)

fun bar(): Array<A> = null!!

fun foo() {
    for (@Ann(1) i in 1..100) {}
    for (@Ann(2) i in 1..100) {}

    for (<!WRONG_ANNOTATION_TARGET!>@Ann(3)<!> (x, @Ann(4) y) in bar()) {}

    for (@<!UNRESOLVED_REFERENCE!>Err<!>() (x,y) in bar()) {}
}

/* GENERATED_FIR_TAGS: annotationDeclaration, checkNotNullCall, classDeclaration, data, forLoop, functionDeclaration,
integerLiteral, localProperty, primaryConstructor, propertyDeclaration, rangeExpression */
