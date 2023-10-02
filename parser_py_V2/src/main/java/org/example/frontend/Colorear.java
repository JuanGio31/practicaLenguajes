package org.example.frontend;

import org.example.backend.lexico.Token;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.util.List;

public class Colorear {

    public void colorearEditorTexto(JTextPane textPane, List<Token> tokens) {
        StyledDocument doc = textPane.getStyledDocument();
        String contenido;
        try {
            // Obtiene el texto completo del JTextPane
            contenido = doc.getText(0, doc.getLength());
        } catch (BadLocationException e) {
            return;
        }

        int indice = 0;
        for (Token token : tokens) {
            int startIndex = contenido.indexOf(token.getLexema(), indice); // Encuentra el inicio del token
            if (startIndex == -1) {
                continue; // Si no se encuentra, continúa con el siguiente token
            }

            int length = token.getLexema().length(); // La longitud del token

            Color color = getColor(token);

            StyleContext sc = StyleContext.getDefaultStyleContext();
            AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, color);

            doc.setCharacterAttributes(startIndex, length, aset, true);
            indice = startIndex + length; // Actualiza el índice para continuar buscando
        }
    }

    private static Color getColor(Token token) {
        return switch (token.getTipo()) {
            case KW -> Color.magenta;
            case ID -> Color.white;
            case CONST -> Color.red;
            case ARITHMETIC, ASSIGNMENT, LOGIC, COMPARISON -> Color.cyan;
            case COMMENT -> Color.LIGHT_GRAY;
            case OTHER -> Color.green;
            default -> Color.darkGray;
        };
    }
}
