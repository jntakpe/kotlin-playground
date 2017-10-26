package playground.kotlin

import playground.java.DbConnection
import java.awt.Color
import java.awt.Frame
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths
import javax.swing.text.SimpleAttributeSet
import javax.swing.text.StyleConstants

fun scopingFct() {
    DbConnection.getConnection()?.let { connection ->
        //executed only if connection is not null
    }
    //connection not available here
}

fun applyClosure() = File("some/path").apply { mkdir() }
//see java equivalent

fun receiver() {
    val w = Frame()
    with(w) {
        setLocation(0, 0)
        setSize(10, 10)
        StyleConstants.setBackground(SimpleAttributeSet(), Color.BLUE)
    }
}

fun chain() {
    Frame().run {
        setLocation(0, 0)
        setSize(10, 10)
        StyleConstants.setBackground(SimpleAttributeSet(), Color.BLUE)
    }.run {
        receiver()
    }
}

fun tryWithResources() {
    Files.lines(Paths.get("some/path")).use { it.forEach { println(it) } }
}