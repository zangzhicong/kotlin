// RUN_PIPELINE_TILL: BACKEND
// DUMP_CFG
fun test_1() {
    when {}
}

fun test_2(x: Int) {
    when (x) {}
}

fun test_3(x: Int) {
    when (val y = x) {}
}

/* GENERATED_FIR_TAGS: functionDeclaration, localProperty, propertyDeclaration, whenExpression, whenWithSubject */
