// RUN_PIPELINE_TILL: FRONTEND
// ISSUE: KT-71210
// RENDER_DIAGNOSTICS_FULL_TEXT
// FIR_DUMP

class C<T> {
    companion object {
        operator fun <T> invoke(name: String) = C<T>()
    }
}

fun main() {
    C.Companion.<!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>invoke<!>("")
    <!FUNCTION_CALL_EXPECTED!>C<Int><!>.<!NESTED_CLASS_ACCESSED_VIA_INSTANCE_REFERENCE!>Companion<!>.<!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>invoke<!>("")
    <!FUNCTION_CALL_EXPECTED!>C<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!><!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>Companion<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>invoke<!>("")

    C.<!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>invoke<!>("")
    <!FUNCTION_CALL_EXPECTED!>C<Int><!>.<!UNRESOLVED_REFERENCE!>invoke<!>("")
    <!FUNCTION_CALL_EXPECTED!>C<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!><!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>invoke<!>("")

    C.Companion.invoke<Int>("")
    <!FUNCTION_CALL_EXPECTED!>C<Int><!>.<!NESTED_CLASS_ACCESSED_VIA_INSTANCE_REFERENCE!>Companion<!>.invoke<Int>("")
    <!FUNCTION_CALL_EXPECTED!>C<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!><!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>Companion<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>invoke<!><Int>("")

    C.invoke<Int>("")
    <!FUNCTION_CALL_EXPECTED!>C<Int><!>.<!UNRESOLVED_REFERENCE!>invoke<!><Int>("")
    <!FUNCTION_CALL_EXPECTED!>C<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!><!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>invoke<!><Int>("")

    <!NEW_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>C<!>("")
    C<Int>("")
    <!WRONG_NUMBER_OF_TYPE_ARGUMENTS!>C<!><Int, Int, Int>("")

    C.Companion.invoke<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!>("")
    <!FUNCTION_CALL_EXPECTED!>C<Int><!>.<!NESTED_CLASS_ACCESSED_VIA_INSTANCE_REFERENCE!>Companion<!>.invoke<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!>("")
    <!FUNCTION_CALL_EXPECTED!>C<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!><!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>Companion<!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>invoke<!><Int, Int>("")

    C.invoke<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!>("")
    <!FUNCTION_CALL_EXPECTED!>C<Int><!>.<!UNRESOLVED_REFERENCE!>invoke<!><Int, Int, Int>("")
    <!FUNCTION_CALL_EXPECTED!>C<!WRONG_NUMBER_OF_TYPE_ARGUMENTS!><Int, Int, Int><!><!>.<!DEBUG_INFO_MISSING_UNRESOLVED!>invoke<!><Int, Int>("")
}

/* GENERATED_FIR_TAGS: classDeclaration, companionObject, functionDeclaration, nullableType, objectDeclaration, operator,
stringLiteral, typeParameter */
