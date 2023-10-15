package org.example.backend.sintactico;

import org.example.backend.lexico.Token;
import org.example.backend.lexico.TokenEnum;
import org.example.backend.sintactico.report.ErrorSyntax;
import org.example.backend.sintactico.report.symbol.Sym;
import org.example.backend.sintactico.report.symbol.TypeSymbol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class A_Syntax {

    private LinkedList<Token> values;
    private List<Sym> symbols;
    private List<ErrorSyntax> errors;

    public A_Syntax(List<Token> tokens) {
        this.values = new LinkedList<>();
        clearToken(tokens);
        symbols = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public void validate() {
        List<Token> tmp = new ArrayList<>();
        while (!values.isEmpty()) {
            if (values.getFirst().getTipo() == TokenEnum.ID) {
                int row = values.getFirst().getFila();
                tmp.add(values.getFirst());

                while (!values.isEmpty()) {
                    values.removeFirst();
                    if (values.isEmpty()) {
                        break;
                    } else if (row == values.getFirst().getFila()) {
                        tmp.add(values.getFirst());
                    } else {
                        break;
                    }
                }
                Exp exp = new Exp(errors);
                if (exp.isValid(tmp)) {
                    symbols.addAll(exp.getSymbols());
                }
                tmp.clear();
            } else {
                values.removeFirst();
                tmp.clear();
            }
        }
        System.out.println(symbols.size());
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

    public void addSymbol(Token tk, TypeSymbol typeSymbol) {
        symbols.add(new Sym(tk, typeSymbol));
    }

    public LinkedList<Token> getValues() {
        return values;
    }

    public void setValues(LinkedList<Token> values) {
        this.values = values;
    }

    public List<Sym> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Sym> symbols) {
        this.symbols = symbols;
    }

    public List<ErrorSyntax> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorSyntax> errors) {
        this.errors = errors;
    }

}
