package com.example

import com.example.models.TicTacToeGame
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.channels.consumeEach

fun Route.socket(game: TicTacToeGame) {
    route("/play") {
        webSocket {
            val player = game.connectPlayer(this)

            if(player == null) {
                close(CloseReason(CloseReason.Codes.CANNOT_ACCEPT, "2 players already connected"))
                return@webSocket
            }

            try {
                incoming.consumeEach { frame ->
                    if(frame is Frame.Text) {

                    }
                }
            } catch (e: Exception) {

            } finally {

            }
        }
    }
}