package adv_kotlin.generics

class WriteRepoImpl<in T> : WriteRepo<T> {
    override fun save(obj: T) {
        TODO("Not yet implemented")
    }

    override fun saveAll(list: List<T>) {
        TODO("Not yet implemented")
    }
}