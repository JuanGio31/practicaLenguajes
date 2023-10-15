package org.example;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import org.example.frontend.Visor;

public class Main {

    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Visor().setVisible(true);
        });
    }
}
