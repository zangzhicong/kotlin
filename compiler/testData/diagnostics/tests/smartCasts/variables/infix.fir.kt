// RUN_PIPELINE_TILL: BACKEND
// See KT-774
fun box() : Int {
    var a : Any = 1
    var d = 1

    if (a is Int) {
        return a + d
    } else {
        return 2
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, functionDeclaration, ifExpression, integerLiteral, isExpression,
localProperty, propertyDeclaration, smartcast */
