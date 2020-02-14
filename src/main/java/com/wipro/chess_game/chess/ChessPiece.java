package com.wipro.chess_game.chess;

import com.wipro.chess_game.boardgame.Board;
import com.wipro.chess_game.boardgame.Piece;
import com.wipro.chess_game.boardgame.Position;

public abstract class ChessPiece extends Piece {

    private Color color;
    private int moveCount;

    private static final String TYPE = "Default";


    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public void increaseMoveCount(){
        moveCount++;
    }

    public void decreaseMoveCount(){
        moveCount--;
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece)getBoard().piece(position);
        return p != null && p.getColor() != color;
    }

    public abstract String getTYPE();

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }
}
