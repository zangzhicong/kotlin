// RUN_PIPELINE_TILL: BACKEND
// FULL_JDK
// FILE: Call.java

import org.jetbrains.annotations.NotNull;
import java.util.*;

public interface Call<D> {
    @NotNull
    Map<String, String> getArguments();
}

// FILE: test.kt

fun <D : Any> Call<D>.testForEach() {
    arguments.forEach { key, value ->
        key.length
        value.length
    }
    arguments.forEach {
        it.key.length
        it.value.length
    }
}

/* GENERATED_FIR_TAGS: flexibleType, funWithExtensionReceiver, functionDeclaration, inProjection, javaProperty, javaType,
lambdaLiteral, samConversion, typeConstraint, typeParameter */
