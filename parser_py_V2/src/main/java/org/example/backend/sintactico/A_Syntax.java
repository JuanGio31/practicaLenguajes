package org.example.backend.sintactico;

import org.example.backend.lexico.Token;
import org.example.backend.lexico.TokenEnum;
import org.example.backend.sintactico.report.symbol.Symbol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A_Syntax {
    private LinkedList<Token> values;
    private List<Symbol> symbols;

    public A_Syntax(List<Token> tokens) {
        this.values = new LinkedList<>();
        clearToken(tokens);
        symbols = new ArrayList<>();
    }

    public void validate() {
        List<Token> tmp = new ArrayList<>();
        while (!values.isEmpty()) {
            if (values.getFirst().getTipo() == TokenEnum.ID) {
                tmp.add(values.getFirst());


                while (!values.isEmpty()) {
                    values.removeFirst();
                    if (values.isEmpty()) {
                        break;
                    } else if (values.getFirst().getTipo() != TokenEnum.LINE_TERMINATOR) {
                        tmp.add(values.getFirst());
                    } else {
                        break;
                    }
                }
                Exp exp = new Exp();
                if (exp.isValid(tmp)) {
                    System.out.println("Valido");
                } else {
                    System.out.println("no valido");
                }
                tmp.clear();
            } else {
                break;
            }
        }
    }

    /**
     * Metodo que elimina los tokens innceseacios para el analisis sintactico
     *
     * @param tk el listado de tokens obtenido del analisis lexico
     */
    private void clearToken(List<Token> tk) {
        LinkedList<Token> tmp = new LinkedList<>();
        for (Token token : tk) {
            if (token.getTipo() != TokenEnum.COMMENT) {
                tmp.add(token);
            }
        }
        this.setValues(tmp);
    }

    public void setValues(LinkedList<Token> values) {
        this.values = values;
    }

    public void addSymbol(Token tk) {
        symbols.add(new Symbol(tk));
    }

    public List<Token> getValues() {
        return values;
    }


    public List<Symbol> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }
}
