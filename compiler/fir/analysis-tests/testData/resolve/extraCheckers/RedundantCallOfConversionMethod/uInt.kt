// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
fun test(i: UInt) {
    val <!UNUSED_VARIABLE!>foo<!> = i.<!REDUNDANT_CALL_OF_CONVERSION_METHOD!>toUInt()<!>
}

/* GENERATED_FIR_TAGS: functionDeclaration, localProperty, propertyDeclaration */
