// RUN_PIPELINE_TILL: FRONTEND
package a

fun foo() : Int {
    try {
        doSmth()
    }
    catch (e: Exception) {
        return <!RETURN_TYPE_MISMATCH!>""<!>
    }
    finally {
        return <!RETURN_TYPE_MISMATCH!>""<!>
    }
}

fun bar() : Int =
    <!RETURN_TYPE_MISMATCH!>try {
        doSmth()
    }
    catch (e: Exception) {
        ""
    }
    finally {
        ""
    }<!>


fun doSmth() {}

/* GENERATED_FIR_TAGS: functionDeclaration, localProperty, propertyDeclaration, stringLiteral, tryExpression */
