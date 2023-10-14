package org.example.backend.sintactico.report.symbol;

import org.example.backend.lexico.Token;

public class Symbol {
    private Token token;
    private String type;
    private int row;
    private int column;

    public Symbol(Token token) {
        //simbolo, tipo, fila, columna
        this.token = token;
        this.row = token.getFila();
        this.column = token.getColumna();
        this.type = ((Object) token.getLexema()).getClass().getSimpleName();
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
}