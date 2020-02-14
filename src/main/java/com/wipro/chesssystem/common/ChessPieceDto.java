package com.wipro.chesssystem.common;

public class ChessPieceDto {

    private String pieceType;
    private ChessPositionDto chessPositionDto;
    private String color;

    public String getPieceType() {
        return pieceType;
    }

    public void setPieceType(String pieceType) {
        this.pieceType = pieceType;
    }

    public ChessPositionDto getChessPositionDto() {
        return chessPositionDto;
    }

    public void setChessPositionDto(ChessPositionDto chessPositionDto) {
        this.chessPositionDto = chessPositionDto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
