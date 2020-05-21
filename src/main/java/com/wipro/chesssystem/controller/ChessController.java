package com.wipro.chesssystem.controller;

import com.wipro.chess_game.chess.ChessPosition;
import com.wipro.chesssystem.common.ChessMapper;
import com.wipro.chesssystem.common.ChessMatchDto;
import com.wipro.chesssystem.common.ChessPositionDto;
import com.wipro.chesssystem.service.ChessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/chess")
public class ChessController {

    @Autowired
    private ChessService service;

    @Autowired
    private ChessMapper chessMapper;

    @PostMapping("/move")
    public boolean performMove(@RequestBody List<ChessPositionDto> move){
        List<ChessPosition> chessPositions = new ArrayList<>();
        for (ChessPositionDto dto : move){
            chessPositions.add(chessMapper.fromDto(dto));
        }
       return service.move(chessPositions);
    }

    @PostMapping("/list-options")
    public List<ChessPositionDto> listPossibleMoves(@RequestBody ChessPositionDto chessPositionDto){
        return service.listPossibleMoves(chessPositionDto);
    }

    @GetMapping("/match")
    public ChessMatchDto getMatch(){
        return service.getMatch();
    }


}
