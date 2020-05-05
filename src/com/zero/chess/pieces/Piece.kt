package com.zero.chess.pieces

import com.zero.chess.game.Player
import com.zero.chess.shared.Reference
import com.zero.chess.shared.Utility

import java.awt.*
import java.awt.image.ImageObserver

import com.zero.chess.shared.Reference.tileSize
import com.zero.chess.shared.Reference.turn

/**
 * The base piece class that all other pieces inherit from
 */
abstract class Piece(var boardX: Int, var boardY: Int, var player: Player, ID: Int) {
    var posX: Int = boardX * tileSize
    var posY: Int = boardY * tileSize
    private val icon: Image? = Reference.chessIcons?.getSubimage((5 - ID) * Reference.CHESS_ICON_W + 153, (if (player == Player.WHITE) 0 else 1) * (Reference.CHESS_ICON_H + 40) + 60, Reference.CHESS_ICON_W, Reference.CHESS_ICON_H)
    var isDragging: Boolean = false
    var moveOkay: Boolean = false

    fun resetToGrid() {
        if (this.posX != boardX * tileSize) posX = boardX * tileSize
        if (this.posY != boardY * tileSize) posY = boardY * tileSize
    }

    fun draw(g: Graphics, observer: ImageObserver) {
        g.drawImage(icon, posX, posY, tileSize, tileSize, observer)
    }

    open fun checkMove(boardX: Int, boardY: Int): Boolean {
        return (turn % 2 == 0 && player == Player.WHITE) || (turn % 2 == 1 && player == Player.BLACK)
    }
}
