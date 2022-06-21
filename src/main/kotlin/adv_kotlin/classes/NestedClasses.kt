package adv_kotlin.classes

class DirectoryExplorer(val user: String = "") {

    fun listFolder(folder: String, user: String) {
        val permissionCheck = PermissionCheck()
        permissionCheck.validatePassword(user)
    }

    class PermissionCheck {
        fun validatePassword(user: String) {

        }
    }
}

fun main() {
    val directoryExplorer = DirectoryExplorer()

    val permissionCheck = DirectoryExplorer.PermissionCheck()
}