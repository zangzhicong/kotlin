// RUN_PIPELINE_TILL: BACKEND
import kotlin.reflect.KProperty

class LazyDelegate<T>(val value: T) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): T = value
}

fun <T> lazy(block: () -> T): LazyDelegate<T> = LazyDelegate(block())

fun getAny(): Any? = null

fun <Q> materialize(): Q = null!!

class Test {
    val x: String by lazy {
        materialize()
    }
}

/* GENERATED_FIR_TAGS: checkNotNullCall, classDeclaration, functionDeclaration, functionalType, lambdaLiteral,
nullableType, operator, primaryConstructor, propertyDeclaration, propertyDelegate, starProjection, typeParameter */
