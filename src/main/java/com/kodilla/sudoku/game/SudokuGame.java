package com.kodilla.sudoku.game;

import com.kodilla.sudoku.solver.SudokuSolver;
import com.kodilla.sudoku.structure.SudokuBoard;

public class SudokuGame {

    private SudokuBoard board;
    private SudokuSolver solver;

    public void showTitle() {
        //https://patorjk.com/software/taag/#p=display&f=Doom&t=Sudoku%0A&x=none&v=4&h=4&w=80&we=false
        System.out.println(" _____           _       _          \n" +
                "/  ___|         | |     | |         \n" +
                "\\ `--. _   _  __| | ___ | | ___   _ \n" +
                " `--. \\ | | |/ _` |/ _ \\| |/ / | | |\n" +
                "/\\__/ / |_| | (_| | (_) |   <| |_| |\n" +
                "\\____/ \\__,_|\\__,_|\\___/|_|\\_\\\\__,_|\n");
    }


    public boolean startGame() {
        /* true if user wants to play again, false if doesn't */
        return false;
    }

}
