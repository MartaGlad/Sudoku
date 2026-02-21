package com.kodilla.sudoku.structure;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {

    private final List<SudokuElement> elements = new ArrayList<>();


    public SudokuRow() {
        for (int i = 0; i < SudokuBoard.SIZE; i++) {
            elements.add(new SudokuElement());
        }
    }


    public SudokuElement getElement(int col) {
        return elements.get(col);
    }
}
