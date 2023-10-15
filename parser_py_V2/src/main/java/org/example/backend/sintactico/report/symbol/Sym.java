package org.example.backend.sintactico.report.symbol;

import org.example.backend.lexico.Token;

public class Sym {
    private String value;
    private TypeSymbol type;
    private int row;
    private int column;

    public Sym(Token token, TypeSymbol type) {
        //simbolo, tipo, fila, columna
        this.value = token.getLexema();
        this.row = token.getFila();
        this.column = token.getColumna();
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TypeSymbol getType() {
        return type;
    }

    public void setType(TypeSymbol type) {
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