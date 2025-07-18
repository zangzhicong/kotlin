// RUN_PIPELINE_TILL: FRONTEND
interface List<out T : Any> {
    operator fun get(index: Int): T

    infix fun concat(other: List<<!TYPE_VARIANCE_CONFLICT_ERROR!>T<!>>): List<T>
}

typealias StringList = List<<!REDUNDANT_PROJECTION!>out<!> String>
typealias AnyList = List<*>

abstract class AbstractList<out T : Any> : List<T>

class SomeList : AbstractList<Int>() {
    override fun get(index: Int): Int = 42

    override fun concat(other: List<Int>): List<Int> = this
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, infix, integerLiteral, interfaceDeclaration, operator, out,
outProjection, override, starProjection, thisExpression, typeAliasDeclaration, typeConstraint, typeParameter */
