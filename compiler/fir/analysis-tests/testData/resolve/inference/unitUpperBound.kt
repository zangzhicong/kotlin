// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
// FULL_JDK

class A {
    fun foo(x: List<String>) {
        var w = 1
        x.ifEmpty {
            w += 2
        }
    }
}

/* GENERATED_FIR_TAGS: additiveExpression, assignment, classDeclaration, functionDeclaration, integerLiteral,
lambdaLiteral, localProperty, propertyDeclaration */
