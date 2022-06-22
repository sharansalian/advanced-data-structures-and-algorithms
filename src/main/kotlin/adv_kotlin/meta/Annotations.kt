package adv_kotlin.meta

@Table(name = "contacts")
data class Contact(val id: Int, @Field(name= "NAME") val name: String, val email: String)

@Target(AnnotationTarget.CLASS)
annotation class Table(val name: String)

@Target(AnnotationTarget.PROPERTY)
annotation class Field(val name: String)


fun main() {
    val annotation = Contact::class.annotations.find { it.annotationClass.simpleName == "Table" }

    println(annotation)
}