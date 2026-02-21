package com.kodilla.sudoku.game;

public class CommandParser {

    public int[] parseMove(String command) {

        int col, row, digitToInsert;
        int[] tabMove = new int[3];

        String[] values = command.trim().split(",");

        if (values.length != 3)
            throw new SudokuException("Wrong command! Try again.");

        try {
            col = Integer.parseInt(values[0].trim());
            row = Integer.parseInt(values[1].trim());
            digitToInsert = Integer.parseInt(values[2].trim());

        } catch (NumberFormatException e) {
           throw new SudokuException("Invalid number format in column, row or value to insert");
        }

        if (col < 1 || col > 9) throw new SudokuException("Invalid column number!");
        if (row < 1 || row > 9) throw new SudokuException("Invalid row number!");
        if (digitToInsert < 0 || digitToInsert > 9) throw new SudokuException("Invalid digit to insert!");

        tabMove[0] = row-1;
        tabMove[1] = col-1;
        tabMove[2] = digitToInsert;

        return tabMove;
    }
}
