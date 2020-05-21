package com.wipro.chesssystem.common;

import java.util.List;

public class ChessMatchDto {

    private List<ChessPieceDto> chesslist;
    private int turn;
    private String currentPlayer;
    private int blackCapturedPieces;
    private int whiteCapturedPieces;
    private boolean check;
    private boolean checkMate;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isCheckMate() {
        return checkMate;
    }

    public void setCheckMate(boolean checkMate) {
        this.checkMate = checkMate;
    }

    public List<ChessPieceDto> getChesslist() {
        return chesslist;
    }

    public void setChesslist(List<ChessPieceDto> chesslist) {
        this.chesslist = chesslist;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getBlackCapturedPieces() {
        return blackCapturedPieces;
    }

    public void setBlackCapturedPieces(int blackCapturedPieces) {
        this.blackCapturedPieces = blackCapturedPieces;
    }

    public int getWhiteCapturedPieces() {
        return whiteCapturedPieces;
    }

    public void setWhiteCapturedPieces(int whiteCapturedPieces) {
        this.whiteCapturedPieces = whiteCapturedPieces;
    }
}
