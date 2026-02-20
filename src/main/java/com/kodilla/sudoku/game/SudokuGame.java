package com.kodilla.sudoku.game;

import com.kodilla.sudoku.solver.SudokuSolver;
import com.kodilla.sudoku.structure.SudokuBoard;

import java.util.Scanner;

public class SudokuGame {

    private Scanner sc;
    private final SudokuBoard board;
    private final SudokuSolver solver;

    public SudokuGame(SudokuBoard board) {
        this.board = board;
        this.solver = new SudokuSolver(board);
    }


    public void showTitle() {
        //https://patorjk.com/software/taag/#p=display&f=Doom&t=Sudoku%0A&x=none&v=4&h=4&w=80&we=false
        System.out.println("""
                 _____           _       _         \s
                /  ___|         | |     | |        \s
                \\ `--. _   _  __| | ___ | | ___   _\s
                 `--. \\ | | |/ _` |/ _ \\| |/ / | | |
                /\\__/ / |_| | (_| | (_) |   <| |_| |
                \\____/ \\__,_|\\__,_|\\___/|_|\\_\\\\__,_|
                """);
    }


    private void createEmptyBoard() {}


    private void readUserData() {
        //and react on "SUDOKU"
    }


    private void showActualBoard() {

    }


    private void showResult() {

    }


    private boolean askAboutNextGame() {
        return false;
    }


    public boolean startGame() {

        return solver.solve();
    }

}
