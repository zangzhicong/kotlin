// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
// FILE: Bar.java
public class Bar implements Foo {
public interface I extends Boo {
}
}

// FILE: Baz.kt
public interface Foo {
    companion object {
        public val EMPTY: Foo = object : Foo{}
    }
}

interface Boo

public class Baz : Bar.I

/* GENERATED_FIR_TAGS: anonymousObjectExpression, classDeclaration, companionObject, interfaceDeclaration, javaType,
objectDeclaration, propertyDeclaration */
