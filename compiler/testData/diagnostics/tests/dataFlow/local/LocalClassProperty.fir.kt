// RUN_PIPELINE_TILL: BACKEND
fun test(x: Any?) {
  if (x !is String) return

  class C {
    val v = x.length

    val vGet: Int
      get() = x.length

    val s: String = x
  }
}

/* GENERATED_FIR_TAGS: classDeclaration, functionDeclaration, getter, ifExpression, isExpression, localClass,
nullableType, propertyDeclaration, smartcast */
