// RUN_PIPELINE_TILL: FRONTEND
interface KtScope {
    fun getAllNames(): Set<String>
}

inline fun <E> buildSet(@<!OPT_IN_USAGE_ERROR!>BuilderInference<!> builderAction: MutableSet<E>.() -> Unit): Set<E> {
    return null!!
}

inline fun <R> withValidityAssertion(action: () -> R): R {
    return action()
}

class KtFirCompositeScope(val subScopes: List<KtScope>) {
    fun getAllNames(): Set<String> = withValidityAssertion {
        buildSet {
            subScopes.flatMapTo(this) { it.getAllNames() }
        }
    }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, functionalType, inline,
interfaceDeclaration, lambdaLiteral, nullableType, primaryConstructor, propertyDeclaration, thisExpression,
typeParameter, typeWithExtension */
