package adv_kotlin.delegation

import adv_kotlin.classes.Customer

interface Repository {
    fun getById(id: Int): Customer
    fun getAll(): List<Customer>
}

interface Logger {
    fun logAll()
}

//delegate function of the repository to the instance that is passed in
class Controller(repository: Repository, logger: Logger) : Repository by repository, Logger by logger {
    fun index(): String {
        getAll()
//        getById()
        logAll()
        return ""
    }
}