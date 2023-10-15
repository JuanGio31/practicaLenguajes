package org.example.backend.sintactico.report;

import org.example.backend.lexico.Token;

public class ErrorSyntax {
    private String message;
    private String expectedVal;
    private int row;
    private int column;

    public ErrorSyntax(String message, Token tk, String ex) {
        this.message = message;
        row = tk.getFila();
        column = tk.getColumna();
        this.expectedVal = ex;
    }

    @Override
    public String toString() {
        return showMessage();
    }

    public String showMessage() {
        return "Syntax Error [" + row + ", " + column + "]->\t" + message + ":\n\t->se esperaba: " + expectedVal;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
