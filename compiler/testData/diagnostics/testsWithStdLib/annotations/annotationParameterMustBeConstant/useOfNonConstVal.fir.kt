// RUN_PIPELINE_TILL: FRONTEND
val nonConst = 1

const val constConst = <!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>nonConst * nonConst + 2<!>

annotation class Ann(val x: Int, val y: String)

@Ann(<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>nonConst<!>, <!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>"${nonConst}"<!>)
fun foo1() {}

@Ann(<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>nonConst + constConst<!>, <!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>"${constConst}"<!>)
fun foo2() {}

annotation class ArrayAnn(val x: IntArray)

@ArrayAnn(<!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>intArrayOf(1, <!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>constConst<!>, <!NON_CONST_VAL_USED_IN_CONSTANT_EXPRESSION!>nonConst<!>)<!>)
fun foo3() {}

/* GENERATED_FIR_TAGS: additiveExpression, annotationDeclaration, collectionLiteral, const, functionDeclaration,
integerLiteral, multiplicativeExpression, primaryConstructor, propertyDeclaration */
