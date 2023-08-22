package com.mycompany.parser_py;

import com.mycompany.parser_py.fronted.VisorFr;

/**
 *
 * @author giovanic
 */
public class Parser_py {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VisorFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisorFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisorFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisorFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            VisorFr ventana = new VisorFr();
            ventana.setTitle("Analizador Lexico");
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        });
    }
}

/*
analizador lexico
        solo separa los tokens ---> identificar tokens

analizador sintactico
        sujeto + predicado ---> sintactico,             no vee si la oracion tiene coherencia (logica), pero si que esten en su respectivo lugar (orden)
analizador semantico
        sentido logico (que el concepto signifique algo) ----> semantico
 */
