// RUN_PIPELINE_TILL: BACKEND
// FIR_IDENTICAL
//KT-1189 StackOverflow in ide
package kt1189
import java.util.concurrent.locks.ReentrantReadWriteLock

inline fun <T> ReentrantReadWriteLock.write(action: ()->T) : T {
    val rl = readLock()
    var readCount = 0
    val writeCount = getWriteHoldCount()
    if(writeCount == 0) {
        readCount = getReadHoldCount()
        if(readCount > 0)
            for(i in 1..readCount)
                rl.unlock()
    }

    val wl = writeLock()
    wl.lock()
    try {
        return action()
    }
    finally {
        if(readCount > 0) {
            for(j in 1..readCount) {
                rl.lock()
            }
        }
        wl.unlock()
    }
}

fun foo() {
    try {
        return
    }
    finally {
        for (i in 1..10) {}
    }
}

/* GENERATED_FIR_TAGS: assignment, comparisonExpression, equalityExpression, flexibleType, forLoop,
funWithExtensionReceiver, functionDeclaration, functionalType, ifExpression, inline, integerLiteral, javaFunction,
localProperty, nullableType, propertyDeclaration, rangeExpression, tryExpression, typeParameter */
