package org.example.frontend;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.example.backend.lexico.Token;
import org.example.backend.lexico.TokenEnum;

/**
 * @author giovanic
 */
public final class PanelToken extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    private List<Token> tokens;

    /**
     * Creates new form PanelToken
     *
     * @param tokens
     */
    public PanelToken(List<Token> tokens) {
        initComponents();
        this.tokens = tokens;
        loadTable();
        tablaTk.setEnabled(false);
    }

    public PanelToken(List<Token> tokens, int c) {
        initComponents();
        this.tokens = tokens;
        loadTable1();
        tablaTk.setEnabled(false);
    }

    public void loadTable() {
        String[] columnName = new String[]{"Token", "Patron", "Lexema", "Linea", "Columna"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnName);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Token token : tokens) {
            if (token.getTipo() != TokenEnum.ERROR && token.getTipo()
                    != TokenEnum.IDENT && token.getTipo()
                    != TokenEnum.LINE_TERMINATOR) {
                Object[] tmp = new Object[5];
                tmp[0] = token.getTipo();
                tmp[1] = token.getPatron();
                tmp[2] = token.getLexema();
                tmp[3] = token.getFila();
                tmp[4] = token.getColumna();
                modelo.addRow(tmp);
            }
        }
        tablaTk.setModel(modelo);
    }

    public void loadTable1() {
        String[] columnName = new String[]{"Token", "Linea", "Columna"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnName);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (Token token : tokens) {
            if (token.getTipo() == TokenEnum.ERROR) {
                Object[] tmp = new Object[3];
                tmp[0] = token.getTipo();
                tmp[1] = token.getFila();
                tmp[2] = token.getColumna();
                modelo.addRow(tmp);
            }
        }
        tablaTk.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTk = new javax.swing.JTable();

        tablaTk.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{{null, null, null, null}, {null, null, null, null}, {null, null, null, null}, {null, null, null, null}}, new String[]{"Title 1", "Title 2", "Title 3", "Title 4"}));
        jScrollPane1.setViewportView(tablaTk);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 596, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(0, 0, Short.MAX_VALUE)));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTk;
    // End of variables declaration//GEN-END:variables
}
