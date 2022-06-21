package adv_kotlin.generics

class ReadOnlyRepoImpl<out T> : ReadOnlyRepo<T> {
    override fun getId(id: Int): T {
        TODO("Not yet implemented")
    }

    override fun getAll(): List<T> {
        TODO("Not yet implemented")
    }
}