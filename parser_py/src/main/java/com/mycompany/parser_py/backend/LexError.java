package com.mycompany.parser_py.backend;

/**
 *
 * @author giovanic
 */
public class LexError {

    private String cadenaError;
    private int row;
    private int col;

    public LexError(String cadenaError, int row, int col) {
        this.cadenaError = cadenaError;
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "LexError{" + "cadenaError=" + cadenaError + ", row=" + row + ", col=" + col + '}';
    }

    public String getCadenaError() {
        return cadenaError;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
