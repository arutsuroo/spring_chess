package com.wipro.chess_game.application;


import com.wipro.chess_game.chess.ChessException;
import com.wipro.chess_game.chess.ChessMatch;
import com.wipro.chess_game.chess.ChessPiece;
import com.wipro.chess_game.chess.ChessPosition;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        ChessMatch chessMatch = new ChessMatch();
        List<ChessPiece> captured = new ArrayList<>();

         while(!chessMatch.getCheckMate()) {

             try {
                 UI.clearScreen();
                 UI.printMatch(chessMatch, captured);
                 System.out.println();
                 System.out.print("Source: ");
                 ChessPosition source = UI.readChessPosition(scan);

                 boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                 UI.clearScreen();
                 UI.printBoard(chessMatch.getPieces(), possibleMoves);
                 System.out.println();
                 System.out.print("Target: ");
                 ChessPosition target = UI.readChessPosition(scan);

                 ChessPiece capturedPiece = chessMatch.performChessMove(source, target);

                 if (capturedPiece != null){
                     captured.add(capturedPiece);
                 }

                 if (chessMatch.getPromoted() != null){
                     System.out.print("Enter piece for promotion (B/N/R/Q): ");
                     String type = scan.nextLine();
                     chessMatch.replacePromotedPiece(type);
                 }

             }
             catch (ChessException e){
                 System.out.println(e.getMessage());
                 scan.nextLine();
             }
             catch (InputMismatchException e){
                 System.out.println(e.getMessage());
                 scan.nextLine();
             }
         }
         UI.clearScreen();
         UI.printMatch(chessMatch, captured);

    }

}
