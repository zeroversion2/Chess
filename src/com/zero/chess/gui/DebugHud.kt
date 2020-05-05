package com.zero.chess.gui

import com.zero.chess.shared.Reference
import java.awt.*
import java.util.HashMap
import javax.swing.JPanel

class DebugHud {
    private var renderedText: String? = null
    private val content: MutableMap<String, Any>

    init {
        content = HashMap()
    }

    fun addLine(description: String, data: Any) {
        content[description] = data
        renderedText = ""
        for ((key, value) in content) {
            renderedText += key + ": " + value.toString() + "\n"
        }

    }

    fun removeLine(description: String) {
        content.remove(description)
        renderedText = ""
        for ((key, value) in content) {
            renderedText += key + ": " + value.toString() + "\n"
        }
    }

    fun draw(g: Graphics) {
        var i = 1
        val fontSize = 16
        g.font = Font(Font.SANS_SERIF, Font.BOLD, fontSize)
        for ((key, value) in content) {
            i++
            g.drawString(key + ": " + value.toString(), 10 + Reference.boardSize, fontSize * i)
        }
    }
}
