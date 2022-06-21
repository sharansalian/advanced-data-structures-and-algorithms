package adv_kotlin.classes

class PageResult(val result: String, val isError: Boolean) {

}

fun getPageResult(url: String): PageResult {
    //
    val wasValidCall = false

    if (wasValidCall) {
        return PageResult("contents", false)
    } else {
        return PageResult("error", true)
    }
}

fun getPageResponse(url: String): PageResponse {
    //
    val wasValidCall = false

    if (wasValidCall) {
        return PageResponse.Success("contents")
    } else {
        return PageResponse.Error("404", "Not Found")
    }
}


sealed class PageResponse {
    class Success(val content: String) : PageResponse()
    class Error(val errorCode: String, val errorMessage: String) : PageResponse()
}

fun main() {
    val pageResult = getPageResult("/")
    if (pageResult.isError) {

    }

    val pageResponse = getPageResponse("/")

    when(pageResponse){
        is PageResponse.Success -> println("Success: ${pageResponse.content}")
        is PageResponse.Error -> println("Error: ${pageResponse.errorCode}")
    }

}

