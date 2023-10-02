package org.example.backend.lexico;

import org.example.Lexer;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class AnalizadorLexico {
    private List<Token> tokens;
    private List<Token> errors;

    public AnalizadorLexico() {
        this.tokens = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public void coincidencia(String str) throws IOException {
        Reader stringReader = new StringReader(str);
        Lexer lex = new Lexer(stringReader);
        Token tk = lex.yylex();
        while (tk.getTipo() != TokenEnum.EOF) {
            tokens.add(tk);
            tk = lex.yylex();
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public List<Token> getErrors() {
        return errors;
    }
}
