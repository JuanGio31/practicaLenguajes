package org.example.backend.lexico;

/**
 * Clase que contiene los tipos de tokens
 *
 * @author giovanic
 */
public enum TokenEnum {
    ID,
    KW,
    ARITHMETIC,
    COMPARISON,
    OTHER,
    LOGIC,
    ASSIGNMENT,
    CONST,
    COMMENT,
    ARRAY,
    PAR_A, PAR_C, //parentesis
    BRACES_A, BRACES_C, //llaves
    BR_A, BR_C, //corchetes
    IDENT,
    LINE_TERMINATOR,
    EOF, BOOLEAN, ERROR
}
