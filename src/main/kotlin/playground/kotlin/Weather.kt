package playground.kotlin

import playground.java.Color

class Weather {

    fun smartCast(x: Any) = when (x) {
        is Int -> print(x + 1)
        is String -> print(x.length + 1)
        is IntArray -> println(x.sum())
        else -> println(0)
    }

    fun createUserInfo() {
        UserInfo(name = "SuperUser", isAdmin = true)
        UserInfo(uuid = "123456", name = "User", notes = "Standard user")
    }

    fun updateWeather(degrees: Int) {
        val description: String
        val color: Color
        if (degrees < 5) {
            description = "cold"
            color = Color.BLUE
        } else if (degrees < 25) {
            description = "mild"
            color = Color.ORANGE
        } else {
            description = "hot"
            color = Color.RED
        }
        println("playground.java.playground.kotlin.Weather is $description with color : $color")
    }

    fun betterUpdate(degrees: Int) {
        val (description: String, color: Color) = if (degrees < 5) {
            Pair("color", Color.BLUE)
        } else if (degrees < 25) {
            Pair("mild", Color.ORANGE)
        } else {
            Pair("hot", Color.RED)
        }
        println("playground.java.playground.kotlin.Weather is $description with color : $color")
    }

    fun betterAgain(degrees: Int) {
        val (description, color) = if (degrees < 5) {
            Pair("color", Color.BLUE)
        } else if (degrees < 25) {
            Pair("mild", Color.ORANGE)
        } else {
            Pair("hot", Color.RED)
        }
        println("playground.java.playground.kotlin.Weather is $description with color : $color")
    }

    fun betterOnceAgain(degrees: Int) {
        val (description, color) = when {
            degrees < 5 -> Pair("color", Color.BLUE)
            degrees < 25 -> Pair("mild", Color.ORANGE)
            else -> Pair("hot", Color.RED)
        }
        println("playground.java.playground.kotlin.Weather is $description with color : $color")
    }

    fun wow(degrees: Int) {
        val (description, color) = when {
            degrees < 5 -> "color" to Color.BLUE
            degrees < 25 -> "mild" to Color.ORANGE
            else -> "hot" to Color.RED
        }
        println("playground.java.playground.kotlin.Weather is $description with color : $color")
    }
}