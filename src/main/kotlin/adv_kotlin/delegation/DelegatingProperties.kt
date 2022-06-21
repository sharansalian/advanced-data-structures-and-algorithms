package adv_kotlin.delegation

import kotlin.reflect.KProperty

class Service {
    var someProperty: String by ExternalFunctionality()
}

class ExternalFunctionality {

    var backingField = "Default"

    operator fun getValue(service: Service, property: KProperty<*>): String {
        return backingField
    }

    operator fun setValue(service: Service, property: KProperty<*>, value: String) {
        backingField = value
    }
}

fun main() {
    val service = Service()

    println(service.someProperty)
    service.someProperty = "Hello World!"
    println(service.someProperty)
}