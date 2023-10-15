package org.example.backend.sintactico;

import org.example.backend.lexico.Token;
import org.example.backend.lexico.TokenEnum;
import org.example.backend.sintactico.report.ErrorSyntax;
import org.example.backend.sintactico.report.symbol.Sym;
import org.example.backend.sintactico.report.symbol.TypeSymbol;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Condicional {
    private final List<ErrorSyntax> errorSyntaxList;
    private List<Sym> symbols;

    public Condicional(List<ErrorSyntax> error) {
        this.errorSyntaxList = error;
        this.symbols = new ArrayList<>();
    }

    public boolean isValid(@NotNull List<Token> tk) {
        int estado = 0;
        int i = 1;
        while (i < tk.size()) {
            switch (estado) {
                case 0 -> {
                    if (tk.get(i).getLexema().equals("True") ||
                            tk.get(i).getLexema().equals("False")) {
                        estado = 3;
                    } else if (tk.get(i).getTipo() == TokenEnum.CONST ||
                            tk.get(i).getTipo() == TokenEnum.ID) {
                        estado = 1;
                    } else {
                        addError(tk.get(i), TokenEnum.CONST);
                        estado = -1;
                    }
                }
                case 1 -> {
                    if (tk.get(i).getLexema().equals(":")) {
                        //break;
                    } else if (tk.get(i).getTipo() == TokenEnum.COMPARISON) {
                        estado = 2;
                    } else {
                        addError(tk.get(i), TokenEnum.COMPARISON);
                        estado = -1;
                    }
                }
                case 2 -> {
                    if (tk.get(i).getTipo() == TokenEnum.CONST ||
                            tk.get(i).getTipo() == TokenEnum.ID ||
                            tk.get(i).getLexema().equals("True") ||
                            tk.get(i).getLexema().equals("False")) {
                        estado = 3;
                    } else {
                        addError(tk.get(i), TokenEnum.CONST);
                        estado = -1;
                    }
                }
                case 3 -> {
                    if (!tk.get(i).getLexema().equals(":")) {
                        estado = -1;
                    } else {
                        symbols.add(new Sym(new Token(TokenEnum.BOOLEAN, tk.get(i).getFila(), tk.get(i).getColumna()), TypeSymbol.CONDITION));
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

    private void addError(Token tk, @NotNull TokenEnum tokenEnum) {
        errorSyntaxList.add(new ErrorSyntax(tk.getLexema(), tk, tokenEnum.name()));
    }

    public List<ErrorSyntax> getErrorSyntaxList() {
        return errorSyntaxList;
    }

    public List<Sym> getSymbols() {
        return symbols;
    }

    public void setSymbols(List<Sym> symbols) {
        this.symbols = symbols;
    }
}
