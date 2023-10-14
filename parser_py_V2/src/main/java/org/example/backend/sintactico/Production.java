package org.example.backend.sintactico;

import org.example.backend.lexico.Token;
import org.example.backend.lexico.TokenEnum;

import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.util.List;

public class Production {
    private int count = 0;
    private List<Token> tokens;
    private boolean state;


    public Production(List<Token> tokens) {
        this.tokens = tokens;
        state = false;
    }

    public void init() {
        if (!tokens.isEmpty()) {
            state = isVarDeclarative();
            count = 0;
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
        if (tokens.get(count).getTipo() == TokenEnum.ID) {
            count++;
            if (tokens.get(count).getTipo() == TokenEnum.ASSIGNMENT) {
                count++;
                return tokens.get(count).getTipo() == TokenEnum.CONST;
            }
        }
        return false;
    }


    public boolean isState() {
        return state;
    }
}
