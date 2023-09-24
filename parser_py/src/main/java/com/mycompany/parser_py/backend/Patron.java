package com.mycompany.parser_py.backend;

public class Patron {
    private String cadena;

    public Patron(String cadena) {
        this.cadena = cadena;
    }

    public String getPatron(String str) {
        try {
            int d = Integer.parseInt(str);
            return "\\d";
        } catch (NumberFormatException e) {
        }
        switch (str) {
            case "and", "as", "assert", "break", "class", "continue", "def", "del", "elif", "else", "except",
                    "False", "finally", "for", "from", "global", "if", "import", "in", "is", "lambda", "None",
                    "nonlocal", "not", "or", "pass", "raise", "return", "True", "try", "while", "with", "yield" -> {
                return TokenEnum.KW.name();
            }
            case "(", ")", "{", "}", "[", "]", ",", ";", ":", "+", "-", "**", "/",
                    "//", "%", "*", "==", "!=", ">", "<", ">=", "<=", "=" -> {
                return str;
            }
            default -> {
                return "[A-z]+[\\d]*";
            }
        }
    }

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }
}
