package com.kodilla.sudoku.structure;

public class SudokuElement {

    private int value;
    public static final int EMPTY = -1;


    public SudokuElement() {
        this.value = EMPTY;
    }


    public boolean isEmpty() {
        return value == EMPTY;
    }


    public void setValue(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
