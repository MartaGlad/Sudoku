package com.kodilla.sudoku.game;

import com.kodilla.sudoku.structure.SudokuBoard;

public class SudokuPrinter {

    public void printTitle() {
        System.out.println("""
                 _____           _       _         \s
                /  ___|         | |     | |        \s
                \\ `--. _   _  __| | ___ | | ___   _\s
                 `--. \\ | | |/ _` |/ _ \\| |/ / | | |
                /\\__/ / |_| | (_| | (_) |   <| |_| |
                \\____/ \\__,_|\\__,_|\\___/|_|\\_\\\\__,_|
                """);
    }


    public void printInstructions() {
        System.out.println("Game commands:");
        System.out.println(">>>>  Insert a value: column,row,value (e.g. 1,2,4)");
        System.out.println(">>>>  Remove a value: column,row,0 (e.g. 1,2,0)");
        System.out.println(">>>>  Solve the board: SUDOKU");
        System.out.println(">>>>  Clear the board: CLEAR");
        System.out.println(">>>>  HELP");
        System.out.println(">>>>  Exit the game: EXIT");
    }


    public void printResult(boolean solved, SudokuBoard board) {
        if (solved) {
            printActualBoard(board);
        } else {
            System.out.println("This SUDOKU has no solution!");
        }
    }


    public void printActualBoard(SudokuBoard board) {
        System.out.println(board);
    }


    public void printPrompt() {
        System.out.print("Enter your command: ");
    }


    public void printMessage(String message) {
        System.out.println(message);
    }
}
