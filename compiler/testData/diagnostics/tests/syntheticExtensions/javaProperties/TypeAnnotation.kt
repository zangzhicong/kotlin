// RUN_PIPELINE_TILL: FRONTEND
// FIR_IDENTICAL
// FILE: KotlinFile.kt
fun foo(javaClass: JavaClass) {
    javaClass.getSomething()<!UNSAFE_CALL!>.<!>length
    javaClass.something<!UNSAFE_CALL!>.<!>length
}

// FILE: JavaClass.java
import org.jetbrains.annotations.*;

public class JavaClass {
    @Nullable
    public String getSomething() { return null; }
}

/* GENERATED_FIR_TAGS: functionDeclaration, javaFunction, javaProperty, javaType, nullableType */
