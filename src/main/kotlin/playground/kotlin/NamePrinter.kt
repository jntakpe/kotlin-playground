package playground.kotlin

class NamePrinter(private val firstName: String, private val lastName: String) {

    val fullname: String by lazy { "$firstName $lastName" }
    fun printName() {
        println(fullname)
    }
}