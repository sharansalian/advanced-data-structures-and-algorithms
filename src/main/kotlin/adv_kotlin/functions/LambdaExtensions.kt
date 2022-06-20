package adv_kotlin.functions

class Request(val method: String, val query: String, val contentType: String)
class Response(var contents: String, var status: Status) {
    operator fun invoke(status: Status.() -> Unit) {}
}

class Status(var code: Int, var description: String)

class RouteHandler(val request: Request, val response: Response) {
    var executeNext = false
    fun next() {
        executeNext = true
    }
}

fun routeHandler(path: String, f: RouteHandler.() -> Unit): RouteHandler.() -> Unit = f

/**
 * Clean Kotlin & Android projects & code write DSL
 */

fun main() {
    val request = Request("GET", "xx", "xxx")

    val routeHandler = routeHandler("/index.html") {
        if (request.query.isNotBlank()) {
            //process
        }
        response.contents
        response {
            code = 404
            description = "Not Found"
        }
    }

    val manager = Manager()
    manager.doSomething()
    manager("Hello")
}

class Manager {

    operator fun invoke(value: String) {

    }

    fun doSomething() {

    }

}