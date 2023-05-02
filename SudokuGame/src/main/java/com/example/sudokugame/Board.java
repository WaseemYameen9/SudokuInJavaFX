package com.example.sudokugame;


// Main Board Class having 81 Cells as it contains a 2D array of Cell type
public class Board {
    // Cells in the main Sudoku game board
    private Cell[][] BoardCells;


    // Constructor that initializes the Board Cells
    public Board()
    {
        BoardCells = new Cell[9][9];
        SETBoardCellsRowsandColumns();
    }

    // Initilaize the Cell values with default value -1 and set their rows and columns
    public void SETBoardCellsRowsandColumns()
    {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                BoardCells[row][col] = new Cell(row, col, -1);
            }
        }
    }

    // This function will get the textbox name and value on that textbox
    // and set the cell value and return the rows and columns in which the value added
    public int[] setCellValue(String textBoxName, int value) {
        // Get the row and column from the text box name
        //(3,4) where 3 is the starting index and 4 is ending index of the string
        int row = Integer.parseInt(textBoxName.substring(3, 4)) - 1;
        int col = Integer.parseInt(textBoxName.substring(4, 5)) - 1;

        // Set the value of the corresponding Cell object
        BoardCells[row][col].setValue(value);
        return new int[]{row, col};
    }

    //  Row Condition Check : It will check that the value in given row and column  does not exist in that row
    // If the value is repeating in row it will return false
    public boolean CheckRows(int row, int column) {
        int value = BoardCells[row][column].getValue();
        for (int i = 0; i < 9; i++) {
            if (column != i && BoardCells[row][i].getValue() == value) {
                return false;
            }
        }
        return true;
    }

    // Column Condition Check : Same as row condition but it checks the columns values
    public boolean CheckColumns(int row, int column) {
        int value = BoardCells[row][column].getValue();
        for (int i = 0; i < 9; i++) {
            if (row != i && BoardCells[i][column].getValue() == value) {
                return false;
            }
        }
        return true;
    }

    // Sub Grid Condition Check : This function checks
    // that the value in given row and column is not repeating in sub-grid
    public boolean ChecksubGrid(int row, int column) {
        int value = BoardCells[row][column].getValue();

        // Think the 9-by-9 sudoku grid as 3-by-3 grid which further has 3-by-3 grid each
        int subGridRowNumber = row / 3;     // sub-grid rowNumber
        int subGridColumnNumber = column / 3;   // sub-grid ColumnNumber

        // Iterations to check wether the value exists in it's 3-by-3 subgrid
        for (int i = subGridRowNumber * 3; i < subGridRowNumber * 3 + 3; i++) {
            for (int j = subGridColumnNumber * 3; j < subGridColumnNumber * 3 + 3; j++) {
                if (i != row && j != column && BoardCells[i][j].getValue() == value) {
                    return false;
                }
            }
        }
        return true;
    }
    // Winning Condition Check : As we initialize the cells with -1 value. We check that if there is no -1
    // Value is left it means the user has completed the game and won
    public boolean checkWinningCondition()
    {
        for(int i=0;i<9;i++)
        {
            for(int j = 0; j<9 ; j++)
            {
                if(BoardCells[i][j].getValue() == -1)
                {
                    return false;
                }
            }

        }
        return true;
    }



}
