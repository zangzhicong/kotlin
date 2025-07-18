// RUN_PIPELINE_TILL: BACKEND
// MODULE: m1
// FILE: a.kt
package p

public interface B {
    public fun foo(a: Int, b: String): B?
}

// MODULE: m2(m1)
// FILE: b.kt
package p

public interface C : B {
    override fun foo(a: Int, b: String): B?

}

// MODULE: m3
// FILE: b.kt
package p

public interface B {
    public fun foo(a: Int, b: String, c: Int = 0): B?
}

// MODULE: m4(m3, m2)
// FILE: c.kt
import p.*

fun test(b: B?) {
    if (b is C) {
        b<!UNNECESSARY_SAFE_CALL!>?.<!>foo(1, "")
    }
}

/* GENERATED_FIR_TAGS: functionDeclaration, ifExpression, integerLiteral, interfaceDeclaration, isExpression,
nullableType, override, safeCall, smartcast, stringLiteral */
