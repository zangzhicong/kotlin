// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -UnitConversionsOnArbitraryExpressions
// DIAGNOSTICS: -UNUSED_PARAMETER -UNUSED_EXPRESSION

fun foo(f: () -> Unit) {}

fun bar(): Int = 0

abstract class SubInt : () -> Int

fun <T> T.freeze(): T = TODO()

fun test(f: () -> String, g: () -> Nothing, h: () -> Nothing?, s: SubInt) {
    foo { "lambda" }
    foo(::bar)
    foo({ TODO() }.freeze())
    foo(g)

    foo(<!ARGUMENT_TYPE_MISMATCH!>h<!>)

    foo(<!ARGUMENT_TYPE_MISMATCH!>f<!>)
    foo(<!ARGUMENT_TYPE_MISMATCH!>s<!>)
}

/* GENERATED_FIR_TAGS: callableReference, classDeclaration, funWithExtensionReceiver, functionDeclaration,
functionalType, integerLiteral, lambdaLiteral, nullableType, stringLiteral, typeParameter */
