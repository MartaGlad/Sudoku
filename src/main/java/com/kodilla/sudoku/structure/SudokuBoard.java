package com.kodilla.sudoku.structure;

import java.util.ArrayList;
import java.util.List;

public class SudokuBoard {

    public static final int SIZE = 9;
    public static final int SUBSECTION_SIZE = 3;

    private final List<SudokuRow> rows =  new ArrayList<>();


    public SudokuBoard() {
        for (int i = 0; i < SIZE; i++) {
            rows.add(new SudokuRow());
        }
    }


    public SudokuElement getElement(int row, int col) {

        return rows.get(row).getElement(col);
    }


    public void setElement(int row, int col, int value) {

        rows.get(row).getElement(col).setValue(value);
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        sb.append("+-------+-------+-------+\n");

        for (int row = 0; row < SIZE; row++) {

            if (row == SUBSECTION_SIZE || row == 2 * SUBSECTION_SIZE) {
                sb.append("+-------+-------+-------+" + "\n");
            }
            sb.append("| ");

            for (int col = 0; col < SIZE; col++) {

                if (col == SUBSECTION_SIZE || col == 2 * SUBSECTION_SIZE) {
                    sb.append("| ");
                }
                SudokuElement element = getElement(row, col);
                sb.append(element.isEmpty() ? ". " : element.getValue() + " ");
            }
            sb.append("|"+"\n");
        }
        sb.append("+-------+-------+-------+\n");

        return sb.toString();
    }
}
