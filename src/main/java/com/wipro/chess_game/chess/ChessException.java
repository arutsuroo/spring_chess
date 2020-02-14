package com.wipro.chess_game.chess;

import com.wipro.chess_game.boardgame.BoardException;

public class ChessException extends BoardException {

    public ChessException(String msg){
        super(msg);
    }
}
