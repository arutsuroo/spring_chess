package com.wipro.chesssystem.common;


import com.wipro.chess_game.chess.ChessPiece;
import com.wipro.chess_game.chess.ChessPosition;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChessMapper {

    ChessPositionDto toChessPosition(ChessPosition chessPosition);
    ChessPosition fromDto(ChessPositionDto chessPosition);

    default ChessPieceDto chessPieceDto(ChessPiece chessPiece, int i, int j) {
        char column = (char)('a' + j);
        ChessPosition position = new ChessPosition(column, i + 1);
        ChessPieceDto piece = new ChessPieceDto();
        piece.setChessPositionDto(toChessPosition(position));
        piece.setPieceType(chessPiece.getTYPE());
        piece.setColor(chessPiece.getColor().name());
        return piece;
    }

    default ChessPositionDto indexToChessPositionDto(int i , int j){
        char column = (char)('a' + j);
        ChessPositionDto position = new ChessPositionDto();
        position.setRow(i + 1);
        position.setColumn(column);
        return position;
    }
}
