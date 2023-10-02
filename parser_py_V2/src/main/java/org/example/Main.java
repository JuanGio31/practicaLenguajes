package org.example;

import com.formdev.flatlaf.FlatDarkLaf;
import org.example.backend.lexico.AnalizadorLexico;
import org.example.frontend.Visor;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        FlatDarkLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Visor().setVisible(true);
        });

    }

}

//        String cadena = "2015.2342340234";
//
//        FilesControl ctrl = new FilesControl();
//        cadena = ctrl.getContenido();
////        System.out.println(cadena);
//        AnalizadorLexico a = new AnalizadorLexico();
//        a.iniciar(cadena + "\n");
//        for (int i = 0; i < a.getTokens().size(); i++) {
//            System.out.println(a.getTokens().get(i).toString());
//        }
//
//        System.out.println(a.esNum(cadena + "\n"));
