// RUN_PIPELINE_TILL: FRONTEND
// LANGUAGE: -SoundSmartcastForEnumEntries
// DIAGNOSTICS: -UNUSED_VARIABLE
// SKIP_TXT

enum class Message(val text: String?) {
    HELLO("hello"),
    WORLD("world"),
    NOTHING(null)
}

fun printMessages() {
    Message.HELLO.text!!
    <!DEBUG_INFO_SMARTCAST!>Message.HELLO.text<!>.length

    <!DEBUG_INFO_SMARTCAST!>Message.NOTHING.text<!>.length

    Message.NOTHING.text<!UNNECESSARY_NOT_NULL_ASSERTION!>!!<!>
    <!DEBUG_INFO_SMARTCAST!>Message.NOTHING.text<!>.length
}

/* GENERATED_FIR_TAGS: checkNotNullCall, enumDeclaration, enumEntry, functionDeclaration, nullableType,
primaryConstructor, propertyDeclaration, smartcast */
