package com.kodilla.sudoku.solver;

import com.kodilla.sudoku.structure.SudokuBoard;
import com.kodilla.sudoku.structure.SudokuElement;

import static com.kodilla.sudoku.structure.SudokuBoard.SUBSECTION_SIZE;


public class SudokuSolver {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    private final SudokuBoard board;


    public SudokuSolver(SudokuBoard board) {
        this.board = board;
    }


    public boolean solve() {
        for (int row = 0; row < SudokuBoard.SIZE; row++) {
            for (int col = 0; col < SudokuBoard.SIZE; col++) {

                if (board.getElement(row, col).isEmpty()) {

                    for (int v = MIN_VALUE; v <= MAX_VALUE; v++) {

                        board.setElement(row, col, v);

                        if (isValid(row, col) && solve()) {
                            return true;
                        }
                        board.setElement(row, col, SudokuElement.EMPTY);
                    }
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isValid (int row, int col) {
        return (isRowValid(row) && isColumnValid(col) && isSubsectionValid(row, col));
    }


    private boolean isRowValid(int row) {
        boolean[] usedNumbers = new boolean[SudokuBoard.SIZE];
        for (int col = 0; col < SudokuBoard.SIZE; col++) {
            if (!isAllowedAndMark(usedNumbers, row, col)) {
                return false;
            }
        }
        return true;
    }


    private boolean isColumnValid(int col) {
        boolean[] usedNumbers = new boolean[SudokuBoard.SIZE];
        for (int row = 0; row < SudokuBoard.SIZE; row++) {
            if (!isAllowedAndMark(usedNumbers, row, col)) {
                return false;
            }
        }
        return true;
    }


    private boolean isSubsectionValid(int row, int col) {
        boolean[] usedNumbers = new boolean[SudokuBoard.SIZE];
        int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

        int subsectionColStart = (col / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionColEnd = subsectionColStart + SUBSECTION_SIZE;

        for (int r =  subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c =  subsectionColStart; c < subsectionColEnd; c++) {
                if (!isAllowedAndMark(usedNumbers, r, c)) return false;
            }
        }
        return true;
    }


    private boolean isAllowedAndMark(boolean[] usedNumbers, int row, int col) {
        SudokuElement element = board.getElement(row, col);
        if (!element.isEmpty()) {
            int value = element.getValue();
            if (!usedNumbers[value - 1]) { // if checked value wasn't used so far
                usedNumbers[value - 1] = true; //mark as used
            }
            else  {
                return false;
            }
        }
        return true;
    }
}
