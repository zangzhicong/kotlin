// RUN_PIPELINE_TILL: FRONTEND
// CHECK_TYPE
// DIAGNOSTICS: -UNUSED_PARAMETER, -UNUSED_VARIABLE

object TestClass {
    inline operator fun <T> invoke(task: () -> T) = task()
}

fun test(s: String): String {
    val a = TestClass { TestClass { TestClass } }
    a checkType { _<TestClass>() }

    <!UNREACHABLE_CODE!>val b =<!> TestClass { return s }
    <!UNREACHABLE_CODE!>b checkType { _<Nothing>() }<!>
}

/* GENERATED_FIR_TAGS: classDeclaration, funWithExtensionReceiver, functionDeclaration, functionalType, infix, inline,
lambdaLiteral, localProperty, nullableType, objectDeclaration, operator, propertyDeclaration, typeParameter,
typeWithExtension */
