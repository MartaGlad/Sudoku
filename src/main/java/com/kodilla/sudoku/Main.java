package com.kodilla.sudoku;

import com.kodilla.sudoku.game.SudokuGame;
import com.kodilla.sudoku.structure.SudokuBoard;

public class Main {

    public static void main(String[] args) {

        int[][] tab = {
                {8, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 3, 6, 0, 0, 0, 0, 0},
                {0, 7, 0, 0, 9, 0, 2, 0, 0},
                {0, 5, 0, 0, 0, 7, 0, 0, 0},
                {0, 0, 0, 0, 4, 5, 7, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 3, 0},
                {0, 0, 1, 0, 0, 0, 0, 6, 8},
                {0, 0, 8, 5, 0, 0, 0, 1, 0},
                {0, 9, 0, 0, 0, 0, 4, 0, 0}
        };


        SudokuBoard sudokuBoard = new SudokuBoard(tab);

        SudokuGame sudokuGame = new SudokuGame(sudokuBoard);
        sudokuGame.showTitle();

        System.out.println("Example table: \n" + sudokuBoard);

        sudokuGame.startGame();

        System.out.println("Result: \n" + sudokuBoard);


       /* boolean gameFinished = false;

        while (!gameFinished) {

            SudokuGame sudokuGame = new SudokuGame();
            gameFinished = sudokuGame.startGame();
        } */

    }
}

