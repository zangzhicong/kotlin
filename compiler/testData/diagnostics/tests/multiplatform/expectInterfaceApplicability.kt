// IGNORE_FIR_DIAGNOSTICS
// RUN_PIPELINE_TILL: FIR2IR
// MODULE: m1-common
// FILE: common.kt
// TODO: .fir.kt version is just a stub.
expect interface My {
    open fun openFunPositive()
    open fun openFunNegative()
    abstract fun abstractFun()

    open val openValPositive: Int
    open val openValNegative: Int
    abstract val abstractVal: Int
}

// MODULE: m1-jvm()()(m1-common)
// FILE: jvm.kt
actual interface My {
    actual fun openFunPositive() = Unit
    actual fun <!ACTUAL_WITHOUT_EXPECT!>openFunNegative<!>()
    actual fun abstractFun()

    actual val openValPositive: Int get() = 0
    actual val <!ACTUAL_WITHOUT_EXPECT!>openValNegative<!>: Int
    actual val abstractVal: Int
}

/* GENERATED_FIR_TAGS: actual, expect, functionDeclaration, getter, integerLiteral, interfaceDeclaration,
propertyDeclaration */
