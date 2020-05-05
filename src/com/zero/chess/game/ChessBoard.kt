package com.zero.chess.game

import com.zero.chess.pieces.*
import com.zero.chess.shared.Reference
import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.util.*

class ChessBoard {
    var pieces = LinkedList<Piece>()
        private set
    var size: Dimension

    private val white: Player
    private val black: Player

    init {

        size = Dimension(if (Reference.DEBUG) Reference.boardSize + Reference.boardSize / 4 else Reference.boardSize , Reference.boardSize)

        white = Player.WHITE
        black = Player.BLACK

        pieces.add(Rook(0, 0, white))
        pieces.add(Knight(1, 0, white))
        pieces.add(Bishop(2, 0, white))
        pieces.add(Queen(3, 0, white))
        pieces.add(King(4, 0, white))
        pieces.add(Bishop(5, 0, white))
        pieces.add(Knight(6, 0, white))
        pieces.add(Rook(7, 0, white))

        for (i in 0..7) {
            pieces.add(Pawn(i, 1, white))
        }

        for (i in 0..7) {
            pieces.add(Pawn(i, 6, black))
        }

        pieces.add(Rook(0, 7, black))
        pieces.add(Knight(1, 7, black))
        pieces.add(Bishop(2, 7, black))
        pieces.add(Queen(3, 7, black))
        pieces.add(King(4, 7, black))
        pieces.add(Bishop(5, 7, black))
        pieces.add(Knight(6, 7, black))
        pieces.add(Rook(7, 7, black))
    }

    fun draw(g: Graphics?) {
        g!!.color = Color(77, 49, 31)
        for (i in 0..6 step 2) {
            for (j in 0..6 step 2) {
                g.fillRect(i * Reference.tileSize, j * Reference.tileSize, Reference.tileSize, Reference.tileSize)
            }
        }

        for (i in 1..7 step 2) {
            for (j in 1..7 step 2) {
                g.fillRect(i * Reference.tileSize, j * Reference.tileSize, Reference.tileSize, Reference.tileSize)
            }
        }
        g.color = Color(217, 155, 114)
        for (i in 1..7 step 2) {
            for (j in 0..6 step 2) {
                g.fillRect(i * Reference.tileSize, j * Reference.tileSize, Reference.tileSize, Reference.tileSize)
            }
        }
        for (i in 0..6 step 2) {
            for (j in 1..7 step 2) {
                g.fillRect(i * Reference.tileSize, j * Reference.tileSize, Reference.tileSize, Reference.tileSize)
            }
        }
    }
}