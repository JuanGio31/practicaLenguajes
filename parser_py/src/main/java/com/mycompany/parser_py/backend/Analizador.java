package com.mycompany.parser_py.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author giovanic
 */
public class Analizador {

    private final char SPACE = ' ';
    private ArrayList<Token> tokens;
    private Map<String, TokenEnum> diccionario;

    public Analizador() {
        this.tokens = new ArrayList<>();
        diccionario = new HashMap<>();
        this.getDic();
    }

    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public Map<String, TokenEnum> getDiccionario() {
        return diccionario;
    }

    /**
     * Metodo para eliminar los deliminatodes exceptuando el saldo de linea
     *
     * @param cadena La cadena de entrada a limpiar
     * @return el texto limpio de algunos delimitadores
     */
    private String limpiarTexto(String cadena) {
        String textoLimpio = "";

        //Limpiar cadena de caracteres especiales
        for (int i = 0; i < cadena.length(); i++) {
            switch (cadena.charAt(i)) {
                case '\r', '\t', '\b', '\f' -> {
                }
                default -> {
                    textoLimpio += cadena.charAt(i);
                }
            }
        }
        return textoLimpio;
    }

    public void escanear(String entrada) {
        char[] entradaChar = limpiarTexto(entrada).toCharArray();
        String lexemaTemp = "";
        int row = 1;
        int col = -1;

        boolean[] acept = new boolean[]{false, false, false, false, false, false, false};
        for (int i = 0; i < entradaChar.length; i++) {
            col++;
            if (entradaChar[i] == SPACE) {
                if (this.diccionario.containsKey(lexemaTemp.trim())) {
                    tokens.add(
                            new Token(
                                    this.diccionario.get(
                                            lexemaTemp.trim()),
                                    lexemaTemp,
                                    definirPatron(
                                            lexemaTemp.trim()),
                                    row,
                                    col));
                }
                lexemaTemp = "";

            }
            lexemaTemp += entradaChar[i];
            if (charApertura(entradaChar[i], acept)) {
                tokens.add(new Token(TokenEnum.OTHER, entradaChar[i] + "", definirPatron(entradaChar[i] + ""), row, col));
                lexemaTemp = "";
            }

            switch (lexemaTemp) {
                case "<=", ">=", "==", "!=", "//" -> {
                    tokens.add(
                            new Token(
                                    this.diccionario.get(
                                            lexemaTemp),
                                    lexemaTemp,
                                    definirPatron(
                                            lexemaTemp),
                                    row,
                                    col));
                    lexemaTemp = "";
                }
            }

            if (entradaChar[i] == '\n') {
                if (this.diccionario.containsKey(lexemaTemp.trim())) {
                    tokens.add(
                            new Token(
                                    this.diccionario.get(
                                            lexemaTemp.trim()),
                                    lexemaTemp,
                                    definirPatron(
                                            lexemaTemp.trim()),
                                    row,
                                    col));
                }
                lexemaTemp = "";
                col = -1;
                row++;
            }
        }
    }

    private boolean charApertura(char c, boolean[] acept) {
        boolean tmp = false;
        switch (c) {
            case '(' -> {
                tmp = acept[0] = true;
            }
            case ')' -> {
                tmp = acept[1] = true;
            }
            case '{' -> {
                tmp = acept[2] = true;
            }
            case '}' -> {
                tmp = acept[3] = true;
            }
            case '[' -> {
                tmp = acept[4] = true;
            }
            case ']' -> {
                tmp = acept[5] = true;
            }
        }
        return tmp;
    }

    private String definirPatron(String str) {
        try {
            int d = Integer.parseInt(str);
            return "\\d";
        } catch (NumberFormatException e) {
        }

        switch (str) {
            case "and", "as", "assert", "break", "class", "continue", "def", "del", "elif", "else", "except", "False", "finally", "for", "from", "global", "if", "import", "in", "is", "lambda", "None", "nonlocal", "not", "or", "pass", "raise", "return", "True", "try", "while", "with", "yield" -> {
                return TokenEnum.KW.name();
            }
            case "(", ")", "{", "}", "[", "]", ",", ";", ":", "+", "-", "**", "/", "//", "%", "*", "==", "!=", ">", "<", ">=", "<=", "=" -> {
                return str;
            }
            default -> {
                return "[_|A-z]+[\\d]*";
            }
        }
    }

    private void getDic() {
        //diccionario = new HashMap<>();

        //operadores aritmeticos
        diccionario.put("+", TokenEnum.ARITHMETIC);
        diccionario.put("-", TokenEnum.ARITHMETIC);
        diccionario.put("**", TokenEnum.ARITHMETIC);
        diccionario.put("/", TokenEnum.ARITHMETIC);
        diccionario.put("//", TokenEnum.ARITHMETIC);
        diccionario.put("%", TokenEnum.ARITHMETIC);
        diccionario.put("*", TokenEnum.ARITHMETIC);

        //comparacion
        diccionario.put("==", TokenEnum.COMPARISON);
        diccionario.put("!=", TokenEnum.COMPARISON);
        diccionario.put(">", TokenEnum.COMPARISON);
        diccionario.put("<", TokenEnum.COMPARISON);
        diccionario.put(">=", TokenEnum.COMPARISON);
        diccionario.put("<=", TokenEnum.COMPARISON);

        //logicos
        diccionario.put("and", TokenEnum.LOGIC);
        diccionario.put("or", TokenEnum.LOGIC);
        diccionario.put("not", TokenEnum.LOGIC);

        //asignacion
        diccionario.put("=", TokenEnum.ASSIGNMENT);

        //palabras clave
        diccionario.put("as", TokenEnum.KW);
        diccionario.put("assert", TokenEnum.KW);
        diccionario.put("break", TokenEnum.KW);
        diccionario.put("class", TokenEnum.KW);
        diccionario.put("continue", TokenEnum.KW);
        diccionario.put("def", TokenEnum.KW);
        diccionario.put("del", TokenEnum.KW);
        diccionario.put("elif", TokenEnum.KW);
        diccionario.put("else", TokenEnum.KW);
        diccionario.put("finally", TokenEnum.KW);
        diccionario.put("for", TokenEnum.KW);
        diccionario.put("from", TokenEnum.KW);
        diccionario.put("global", TokenEnum.KW);
        diccionario.put("if", TokenEnum.KW);
        diccionario.put("import", TokenEnum.KW);
        diccionario.put("in", TokenEnum.KW);
        diccionario.put("is", TokenEnum.KW);
        diccionario.put("lambda", TokenEnum.KW);
        diccionario.put("None", TokenEnum.KW);
        diccionario.put("nonlocal", TokenEnum.KW);
        diccionario.put("pass", TokenEnum.KW);
        diccionario.put("raise", TokenEnum.KW);
        diccionario.put("return", TokenEnum.KW);
        diccionario.put("try", TokenEnum.KW);
        diccionario.put("while", TokenEnum.KW);
        diccionario.put("yield", TokenEnum.KW);

        //constante
        diccionario.put("True", TokenEnum.CONST);
        diccionario.put("False", TokenEnum.CONST);

        //otros
        diccionario.put("(", TokenEnum.OTHER);
        diccionario.put(")", TokenEnum.OTHER);
        diccionario.put("{", TokenEnum.OTHER);
        diccionario.put("}", TokenEnum.OTHER);
        diccionario.put("[", TokenEnum.OTHER);
        diccionario.put("]", TokenEnum.OTHER);
        diccionario.put(",", TokenEnum.OTHER);
        diccionario.put(";", TokenEnum.OTHER);
        diccionario.put(":", TokenEnum.OTHER);
    }
}
