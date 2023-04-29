package com.example.sudokugame;

public class Board {
    private Cell[][] BoardCells;

    public Board()
    {
        BoardCells = new Cell[9][9];
        SETBoardCellsRowsandColumns();
    }

    public void SETBoardCellsRowsandColumns()
    {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                BoardCells[row][col] = new Cell(row, col, 0);
            }
        }
    }

    public int[] setCellValue(String textBoxName, int value) {
        // Get the row and column from the text box name
        //(3,4) where 3 is the starting index and 4 is ending index of the string
        int row = Integer.parseInt(textBoxName.substring(3, 4)) - 1;
        int col = Integer.parseInt(textBoxName.substring(4, 5)) - 1;

        // Set the value of the corresponding Cell object
        BoardCells[row][col].setValue(value);
        return new int[]{row, col};
    }

    public boolean CheckRows(int row,int column)
    {
        int value = BoardCells[row][column].getValue();
        for (int i=0;i<9;i++)
        {
            if(column == i)
            {
                continue;
            }
            else
            {
                if(BoardCells[row][i].getValue() == value)
                {
                    return false;
                }
            }
        }
        return true;

    }
    public boolean CheckColumns(int row, int column)
    {
        int value = BoardCells[row][column].getValue();
        for (int i=0;i<9;i++)
        {
            if(row == i)
            {
                continue;
            }
            else
            {
                if(BoardCells[i][column].getValue() == value)
                {
                    return false;
                }
            }
        }
        return true;

    }

    public void ChecksubGrid()
    {

    }



}
