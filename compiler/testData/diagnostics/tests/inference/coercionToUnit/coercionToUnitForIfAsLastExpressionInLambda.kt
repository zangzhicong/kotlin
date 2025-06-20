// RUN_PIPELINE_TILL: FRONTEND

class Obj

fun foo(): String? {
    run {
        if (true) return@run

        if (true) Obj()
    }

    run {
        if (true) return@run

        if (true) return <!TYPE_MISMATCH!>Obj()<!> // correct error, type check against return type of function "foo"
    }

    run {
        if (true)
            return@run
        else
            if (true) 42
    }

    run {
        if (true)
            42
        else
            <!INVALID_IF_AS_EXPRESSION!>if<!> (true) 42
    }

    run {
        if (true) return@run

        if (true) {
            Obj()
        } else
            if (true) return null
    }

    return ""
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, ifExpression, integerLiteral, lambdaLiteral, nullableType,
stringLiteral */
