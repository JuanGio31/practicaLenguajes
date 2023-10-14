package org.example.backend.sintactico;

import org.example.backend.lexico.Token;
import org.example.backend.lexico.TokenEnum;

import java.util.List;

public class Exp {
    public Exp() {
    }

    public boolean isValid(List<Token> tk) {
        int estado = 0;
        int i = 0;
        while (i < tk.size()) {
            switch (estado) {
                case 0 -> {
                    if (tk.get(i).getTipo() == TokenEnum.ID) {
                        estado = 1;
                    } else {
                        estado = -1;
                    }
                }
                case 1 -> {
                    if (tk.get(i).getLexema().equals(",")) {
                        estado = 0;
                    } else if (tk.get(i).getTipo() == TokenEnum.ASSIGNMENT) {
                        estado = 2;
                    } else {
                        estado = -1;
                    }
                }
                case 2 -> {
                    if (tk.get(i).getTipo() == TokenEnum.CONST) {
                        estado = 3;
                    } else {
                        estado = -1;
                    }
                }
                case 3 -> {
                    if (tk.get(i).getLexema().equals(",")) {
                        estado = 2;
                    } else if (tk.get(i).getTipo() == TokenEnum.CONST) {
                        return true;
                    } else {
                        estado = -1;
                    }
                }
                case -1 -> {
                    return false;
                }
            }
            i++;
        }
        return estado == 3;
    }
}
