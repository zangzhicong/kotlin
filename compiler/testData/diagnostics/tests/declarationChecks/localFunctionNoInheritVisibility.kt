// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
package d

class T {
    fun baz() = 1
}

<!WRONG_MODIFIER_TARGET!>override<!> fun zzz() {}

fun foo(t: T) {
    <!WRONG_MODIFIER_TARGET!>override<!> fun T.<!EXTENSION_SHADOWED_BY_MEMBER!>baz<!>() = 2

    // was "Visibility is unknown yet exception"
    t.baz()

    zzz()
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, integerLiteral, localFunction,
override */
