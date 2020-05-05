package com.zero.chess.pieces

import com.zero.chess.game.Player
import com.zero.chess.shared.Reference.debugHud

/**
 * Created by iek2d on 4/14/2017.
 */
class Pawn(boardX: Int, boardY: Int, player: Player) : Piece(boardX, boardY, player, 0) {
    override fun checkMove(boardX: Int, boardY: Int): Boolean {
        debugHud.addLine("checked position", boardX.toString() + ", " + boardY)
        if(boardX == this.boardX && boardY == this.boardY + if (this.player == Player.WHITE) 1 else -1){
            return super.checkMove(boardX, boardY)
        }
        return false
    }
}
