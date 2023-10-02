package org.example.backend.sintactico;

import org.example.backend.lexico.Token;
import org.example.backend.lexico.TokenEnum;

import java.util.List;

public class Produccion {
    private List<Token> tokens;
    private boolean state;
    private int contador;

    public Produccion(List<Token> tokens) {
        this.tokens = tokens;
        contador = 0;
        state = false;
    }

    public void init() {
        if (!tokens.isEmpty()) {
            if (tokens.get(contador).getLexema().equals("var")) {
                contador++;
                if (tokens.get(contador).getTipo() == TokenEnum.ID) {
                    contador++;
                    if (tokens.get(contador).getTipo() == TokenEnum.ASSIGNMENT) {
                        contador++;
                        if (tokens.get(contador).getTipo() == TokenEnum.CONST) {
                            state = true;
                        }
                    }
                }
            }
        }
    }

    private void recognition() {
        int i = 0;
        while (i < tokens.size()) {
            switch (tokens.get(i).getTipo()) {
                case ID -> {

                }
                case KW -> {
                }
            }
        }
    }

    public boolean isVarDeclarative() {
        boolean isOk = false;
        if (tokens.isEmpty()) {
            return false;
        } else {
            if (tokens.get(contador).getTipo() != TokenEnum.ID) {
                return false;
            }
            if (tokens.get(contador).getTipo() != TokenEnum.ASSIGNMENT) {
                return false;
            }
            if (tokens.get(contador).getTipo() != TokenEnum.CONST) {
                return false;
            }
        }
        return true;
    }

    public boolean isState() {
        return state;
    }
}