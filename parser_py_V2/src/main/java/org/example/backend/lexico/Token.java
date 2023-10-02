package org.example.backend.lexico;

/**
 * Clase que contiene toda la informacion sobre tokens
 *
 * @author giovanic
 */
public class Token {

    private final TokenEnum tipo;
    private final String lexema;
    private int fila;
    private int columna;
    private String patron;

    /**
     * Metodo constructor
     *
     * @param tipo    tipo de token
     * @param lexema  palabra formada
     * @param patron  patron del lexema
     * @param fila    fila donde se ubica el token
     * @param columna columna donde se ubica el token
     */
    public Token(TokenEnum tipo, String lexema, String patron, int fila, int columna) {
        this.tipo = tipo;
        this.lexema = lexema;
        this.patron = patron;
        this.fila = fila;
        this.columna = columna;
    }

    public Token(TokenEnum tipo, int fila, int columna) {
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
        this.lexema = "";
    }

    public Token() {
        this.tipo = TokenEnum.EOF;
        this.lexema = null;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tipo=" + tipo +
                ", lexema='" + lexema + '\'' +
                ", fila=" + fila +
                ", columna=" + columna +
                ", patron='" + patron + '\'' +
                '}';
    }

    public TokenEnum getTipo() {
        return tipo;
    }


    public String getLexema() {
        return lexema;
    }


    public int getFila() {
        return fila;
    }


    public int getColumna() {
        return columna;
    }

    public String getPatron() {
        return patron;
    }

}