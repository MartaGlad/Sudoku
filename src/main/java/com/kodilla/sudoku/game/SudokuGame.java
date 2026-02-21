package com.kodilla.sudoku.game;

import com.kodilla.sudoku.solver.SudokuSolver;
import com.kodilla.sudoku.structure.SudokuBoard;
import com.kodilla.sudoku.structure.SudokuElement;

import java.util.Scanner;


public class SudokuGame {

    private SudokuBoard board;
    private final SudokuPrinter printer;
    private final Scanner scanner;
    private final CommandParser parser;


    public SudokuGame() {
        this.board = new SudokuBoard();
        this.printer = new SudokuPrinter();
        this.scanner = new Scanner(System.in);
        this.parser = new CommandParser();
    }


    public void createAndShowEmptyBoard() {
        board = new SudokuBoard();
        printer.printActualBoard(board);
    }


    private boolean askAboutNextGame() {
        printer.printMessage("If you want to play again press \"y\".");

        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }


    public void startGame() {
        printer.printTitle();
        printer.printInstructions();

        createAndShowEmptyBoard();

        while (true) {

            printer.printPrompt();

            String command = scanner.nextLine().trim().toUpperCase();

            switch (command) {

                case "SUDOKU" -> {
                    SudokuSolver solver = new SudokuSolver(board);
                    printer.printResult(solver.solve(), board);
                    if (askAboutNextGame()) {
                        createAndShowEmptyBoard();
                        continue;
                    }
                    else {
                        printer.printMessage("End of the game. Bye!");
                        return;
                    }
                }
                case "CLEAR" -> {
                    createAndShowEmptyBoard();
                    continue;
                }
                case "HELP" -> {
                    printer.printInstructions();
                    continue;
                }
                case "EXIT" -> {
                    printer.printMessage("End of the game. Bye!");
                    return;
                }
                default -> {
                    try {
                        int[] tabMove = parser.parseMove(command);

                        if (tabMove[2] == 0) {

                            if (!board.getElement(tabMove[0], tabMove[1]).isEmpty()) {

                                board.setElement(tabMove[0], tabMove[1], SudokuElement.EMPTY);
                                printer.printActualBoard(board);
                            } else {
                                printer.printMessage("This place is already empty!");
                            }
                            continue;
                        }

                        if (!canPlace(tabMove[0], tabMove[1], tabMove[2]))
                            throw new SudokuException("This field is not empty or conflicted!");

                        board.setElement(tabMove[0], tabMove[1], tabMove[2]);

                        printer.printActualBoard(board);

                    } catch (SudokuException e) {
                        printer.printMessage(e.getMessage());
                        continue;
                    }
                }
            }
        }
    }


    private boolean canPlace(int row, int col, int value) {
        if (!board.getElement(row, col).isEmpty())
            return false;

        return isRowValid(row, value)
                && isColumnValid(col, value)
                && isSubsectionValid(row, col, value);
    }


    private boolean isRowValid(int row, int value) {
        for (int c = 0; c < SudokuBoard.SIZE; c++) {
            if (board.getElement(row, c).getValue() == value)
                return false;
        }
        return true;
    }


    private boolean isColumnValid(int col, int value) {
        for (int r = 0; r < SudokuBoard.SIZE; r++) {
            if (board.getElement(r, col).getValue() == value)
                return false;
        }
        return true;
    }


    private boolean isSubsectionValid(int row, int col, int value) {
        int rowSubStart = (row / SudokuBoard.SUBSECTION_SIZE) * SudokuBoard.SUBSECTION_SIZE;
        int rowSubEnd = rowSubStart + SudokuBoard.SUBSECTION_SIZE;

        int colSubStart = (col / SudokuBoard.SUBSECTION_SIZE) * SudokuBoard.SUBSECTION_SIZE;
        int colSubEnd = colSubStart + SudokuBoard.SUBSECTION_SIZE;

        for (int r = rowSubStart; r < rowSubEnd; r++) {
            for (int c = colSubStart; c < colSubEnd; c++) {
                if (board.getElement(r, c).getValue() == value)
                    return false;
            }
        }
        return true;
    }
}

