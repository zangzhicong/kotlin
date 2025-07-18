// RUN_PIPELINE_TILL: FRONTEND
fun testRegularNavigation() {
    fun <OT> pcla(lambda: (TypeVariableOwner<OT>) -> Unit): OT = null!!

    val resultA = pcla { otvOwner ->
        otvOwner.constrain(ScopeOwner())
        // should fix OTv := ScopeOwner for scope navigation
        <!BUILDER_INFERENCE_STUB_RECEIVER, TYPE_MISMATCH("String?; ScopeOwner"), VAL_REASSIGNMENT!>otvOwner.instance<!> += ScopeOwner()
        // expected: Interloper </: ScopeOwner
        otvOwner.constrain(<!TYPE_MISMATCH("String?; Interloper")!>Interloper<!>)
    }
    // expected: ScopeOwner
    <!DEBUG_INFO_EXPRESSION_TYPE("BaseType")!>resultA<!>
}

fun testSafeNavigation() {
    fun <OT> pcla(lambda: (TypeVariableOwner<OT>?) -> Unit): OT = null!!

    val resultA = pcla { otvOwner ->
        otvOwner?.constrain(ScopeOwner())
        // should fix OTv := ScopeOwner for scope navigation
        <!BUILDER_INFERENCE_STUB_RECEIVER, TYPE_MISMATCH("String?; ScopeOwner"), VAL_REASSIGNMENT!>otvOwner?.instance<!> += ScopeOwner()
        // expected: Interloper </: ScopeOwner
        otvOwner?.constrain(<!TYPE_MISMATCH("String?; Interloper")!>Interloper<!>)
    }
    // expected: ScopeOwner
    <!DEBUG_INFO_EXPRESSION_TYPE("BaseType")!>resultA<!>
}


class TypeVariableOwner<T> {
    fun constrain(subtypeValue: T) {}
    val instance: T = null!!
}

interface BaseType

class ScopeOwner: BaseType {
    operator fun plusAssign(other: ScopeOwner) {}
}

object Interloper: BaseType

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, functionalType, interfaceDeclaration,
lambdaLiteral, localFunction, localProperty, nullableType, objectDeclaration, operator, propertyDeclaration, safeCall,
typeParameter */
