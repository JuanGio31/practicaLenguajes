package com.mycompany.parser_py.backend;

/**
 * Clase que contiene toda la informacion sobre tokens
 *
 * @author giovanic
 */
public class Token {

    private TokenEnum tipo;
    private String lexema;
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

    public void setTipo(TokenEnum tipo) {
        this.tipo = tipo;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public String getPatron() {
        return patron;
    }

    public void setPatron(String patron) {
        this.patron = patron;
    }

}
