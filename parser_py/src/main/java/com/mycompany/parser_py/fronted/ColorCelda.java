package com.mycompany.parser_py.fronted;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author giovanic
 */
public class ColorCelda extends DefaultTableCellRenderer {

    private final String tipo;

    public ColorCelda(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table,
            Object value,
            boolean isSelected,
            boolean hasFocus,
            int row,
            int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        switch (tipo) {
            case "Identificador" -> {
                this.setOpaque(true);
                this.setBackground(Color.BLACK);
                this.setForeground(Color.WHITE);
            }
            case "Palabra Clave" -> {
                this.setOpaque(true);
                this.setBackground(Color.BLACK);
                this.setForeground(Color.MAGENTA);
            }
            case "Constantes" -> {
                this.setOpaque(true);
                this.setBackground(Color.BLACK);
                this.setForeground(Color.RED);
            }
            case "Operadores" -> {
                this.setOpaque(true);
                this.setBackground(Color.BLACK);
                this.setForeground(Color.CYAN);
            }
            case "Comentario" -> {
                this.setOpaque(true);
                this.setBackground(Color.BLACK);
                this.setForeground(Color.GRAY);
            }
            case "Otro" -> {
                this.setOpaque(true);
                this.setBackground(Color.BLACK);
                this.setForeground(Color.GREEN);
            }
            default ->
                throw new AssertionError();
        }
        return this;
    }
}
