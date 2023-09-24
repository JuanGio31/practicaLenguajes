package com.mycompany.parser_py.backend.utilidades;

import com.mycompany.parser_py.Parser_py;
import com.mycompany.parser_py.backend.Patron;
import com.mycompany.parser_py.backend.Token;
import com.mycompany.parser_py.backend.TokenEnum;

public class Automata {
    private String cadena;
    private Patron patern;
    private int row;
    private int column;

    public Automata() {
    }

    public Automata(String cadena, Patron patern, int row, int column) {
        this.cadena = cadena;
        this.patern = patern;
        this.row = row;
        this.column = column;
    }

    public Token identificador() {
        int estado = 0;

        int i = 0;
        while (i < cadena.length()) {
            switch (estado) {
                case 0 -> {
                    if (Character.isLowerCase(cadena.charAt(i)) || cadena.charAt(i) == '_') {
                        estado = 1;
                        column++;
                    } else {
                        estado = -1;
                    }
                }
                case 1 -> {
                    if (Character.isLetterOrDigit(cadena.charAt(i)) || cadena.charAt(i) == '_') {
                        estado = 1;
                        column++;
                    } else {
                        estado = -1;
                    }
                }
                case -1 -> {
                    column = cadena.length() - 1;
                    break;
                }
            }
            i++;
        }

        if (cadena.charAt(cadena.length() - 1) == '_' || estado == -1) {
            return null;
        }
        return new Token(TokenEnum.ID, cadena, patern.getPatron(cadena), row, column);
    }

    public static void main(String[] args) {
        String cadena = "_myID";
        Patron pt = new Patron(cadena);
        Automata au = new Automata(cadena, pt, 0, 0);
        Token tk = au.identificador();
        if (tk != null) {
            System.out.println(tk.toString());
        } else {
            System.out.println("Token invalido");
        }
    }
}