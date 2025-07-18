// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-41939

// FILE: Ann.java

public @interface Ann {
    String value();
}

// FILE: main.kt

fun test(ann: Ann) {
    ann.value
    ann.<!FUNCTION_EXPECTED!>value<!>() // should be an error
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaProperty, javaType */
