package org.example.frontend;

import java.util.List;
import javax.swing.table.DefaultTableModel;

import org.example.backend.sintactico.report.symbol.Sym;

/**
 * @author giovanic
 */
public final class PanelReport extends javax.swing.JPanel {

    private DefaultTableModel modelo;
    private List<Sym> syms;

    /**
     * Creates new form PanelReport
     */
    public PanelReport() {
        initComponents();
    }

    public void load(List<Sym> sym) {
        this.syms = sym;
        loadTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null},
                        {null, null, null, null}
                },
                new String[]{
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    public void loadTable() {
        String[] columnName = new String[]{"Simbolo", "Tipo", "Linea", "Columna"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columnName);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        if (syms != null) {
            for (int i = 0; i < syms.size(); i++) {
                Object[] tmp = new Object[4];
                tmp[0] = syms.get(i).getValue();
                tmp[1] = syms.get(i).getType();
                tmp[2] = syms.get(i).getRow();
                tmp[3] = syms.get(i).getColumn();
                modelo.addRow(tmp);
            }
            jTable1.setModel(modelo);
        }
    }
}
