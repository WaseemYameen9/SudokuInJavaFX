package com.example.sudokugame;


// Cell class: There are 81 cells in a board and it is a single cell class
public class Cell {
    private int row;
    private int column;
    private int value;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    // Constructor
    public Cell(int row, int col, int val)
    {
        this.row=row;
        this.column=col;
        this.value=val;
    }

}
