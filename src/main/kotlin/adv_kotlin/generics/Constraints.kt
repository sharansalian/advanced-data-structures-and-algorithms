package adv_kotlin.generics

import java.io.Serializable

open class Entity(val id: Int)

//Upper bound entity anything that inherits Entity
class Repository<T : Entity> {
    fun save(entity: T) {
        if (entity.id != 0) {
            //...
        }
    }
}

//multiple restrictions
class MultipleExample<T> where T : Entity, T : Serializable {

}

class CustomerEntity : Entity(id = -1), Serializable {

}

// Functional generic constraint, this T has to be Serializable
fun <T: Serializable> streamObject(obj: T){

}

fun main() {
    val repository = MultipleExample<CustomerEntity>()
}