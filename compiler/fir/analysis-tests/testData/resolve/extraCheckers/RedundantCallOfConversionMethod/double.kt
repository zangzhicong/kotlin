// RUN_PIPELINE_TILL: BACKEND
// WITH_STDLIB
val foo = 1.1.<!REDUNDANT_CALL_OF_CONVERSION_METHOD!>toDouble()<!>

/* GENERATED_FIR_TAGS: propertyDeclaration */
