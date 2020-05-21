package com.wipro.chesssystem.service;

import com.wipro.chess_game.chess.ChessException;
import com.wipro.chess_game.chess.ChessMatch;
import com.wipro.chess_game.chess.ChessPiece;
import com.wipro.chess_game.chess.ChessPosition;
import com.wipro.chesssystem.common.ChessMapper;
import com.wipro.chesssystem.common.ChessMatchDto;
import com.wipro.chesssystem.common.ChessPieceDto;
import com.wipro.chesssystem.common.ChessPositionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChessService {

    @Autowired
    private ChessMapper chessMapper;

    public static ChessMatch match = new ChessMatch();

    public static ChessMatch getChessMatch() {
        return match;
    }

    public void reset(){
        match = new ChessMatch();
    }


    public boolean move(List<ChessPosition> chessPositions){
        boolean moveOK = true;
        try {
            getChessMatch().performChessMove(chessPositions.get(0), chessPositions.get(1));
        }
        catch (ChessException e){
            moveOK = false;
        }
            return moveOK;
    }

    public List<ChessPieceDto> listBoard() {
        List<ChessPieceDto> pieces = new ArrayList<>();
        ChessPiece[][] list = getChessMatch().getPieces();
        List<ChessPiece[]> invertedList = new ArrayList<>();
        for (int i = 0; i < list.length; i ++){
            invertedList.add(0, list[i]);
        }

        for (int i = 0; i < invertedList.size(); i++){
            ChessPiece[] row = invertedList.get(i);
            for (int j = 0; j < row.length; j++){
                if (row[j] != null){
                    ChessPieceDto piece = chessMapper.chessPieceDto(row[j], i, j);
                    pieces.add(piece);
                }
            }
        }
        return pieces;
    }

    public List<ChessPositionDto> listPossibleMoves(ChessPositionDto chessPositionDto) {

        List<ChessPositionDto> positions = new ArrayList<>();
        boolean[][] list = getChessMatch().possibleMoves(chessMapper.fromDto(chessPositionDto));
        for (int i = 0; i < list.length; i++){
            for (int j= 0; j < list[i].length; j++){
                if (list[i][j]){
                    positions.add(chessMapper.indexToChessPositionDto(7 - i, j));
                }
            }
        }
        return positions;
    }

    public ChessMatchDto getMatch(){
        ChessMatch match = getChessMatch();
        ChessMatchDto chessMatchDto = new ChessMatchDto();
        chessMatchDto.setTurn(match.getTurn());
        chessMatchDto.setCurrentPlayer(match.getCurrentPlayer().name());
        chessMatchDto.setCheck(match.getCheck());
        chessMatchDto.setCheckMate(match.getCheckMate());
        chessMatchDto.setChesslist(listBoard());
        return chessMatchDto;
    }
}
