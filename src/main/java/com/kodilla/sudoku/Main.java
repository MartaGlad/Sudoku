package com.kodilla.sudoku;

import com.kodilla.sudoku.game.SudokuGame;

public class Main {

    public static void main(String[] args) {

        boolean gameFinished = false;

        while (!gameFinished) {

            SudokuGame sudokuGame = new SudokuGame();
            gameFinished = sudokuGame.startGame();
        }

    }
}
