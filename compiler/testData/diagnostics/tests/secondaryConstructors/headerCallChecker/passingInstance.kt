// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// DIAGNOSTICS: -UNUSED_PARAMETER
fun foo(x: A) = 1

class A {
    constructor(x: Int)
    constructor(x: Int, y: Int, z: Int = x + foo(<!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this<!>) + foo(<!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this@A<!>)) :
        this(x + foo(<!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this<!>) + foo(<!INSTANCE_ACCESS_BEFORE_SUPER_CALL!>this@A<!>))
}

/* GENERATED_FIR_TAGS: additiveExpression, classDeclaration, functionDeclaration, integerLiteral, secondaryConstructor,
thisExpression */
