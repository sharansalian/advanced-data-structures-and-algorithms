package adv_kotlin.meta

import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties

fun getType(obj: KClass<*>) {
    println(obj.qualifiedName)
}

fun main() {
    /*  println(Transaction::class)

      val classInfo = Transaction::class

      classInfo.members.forEach {
          println("Property ${it.name} of type ${it.returnType}")
      }

      classInfo.constructors.forEach {
          println("Constructor ${it.name} - ${it.parameters}")
      }

      getType(Transaction::class)*/

    val constructor = ::Transaction

    println(constructor)

    val transaction = constructor.call(1, 200.0, "description")

    val validateFunc = Transaction::validate

    val idParam = constructor.parameters.first { it.name == "id" }

    val transaction2 = constructor.callBy(
        mapOf(idParam to 1, constructor.parameters[1] to 200.0, constructor.parameters[2] to "des")
    )

    val trans = Transaction(10, 20.0, "new value")

    //read the property value at run time
    val nameProperty = Transaction::class.memberProperties.find { it.name == "id" }

    val nameValue = nameProperty?.get(trans)

    println("Runtime value :$nameValue")

    println(transaction.description)
}