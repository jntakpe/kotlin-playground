package playground.kotlin

fun printName(userInfo: UserInfo?) {
    val name = userInfo?.name ?: throw IllegalStateException("User was null")
    println("Name $name")
}

fun runPrint(userInfo: UserInfo?) {
    if (userInfo != null) {
        println("Name ${userInfo.name}")
    }
    throw IllegalStateException("User was null")
    //or run server ....
    println("User has no name")
}