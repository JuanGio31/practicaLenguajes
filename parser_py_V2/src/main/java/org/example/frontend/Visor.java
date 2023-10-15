package org.example.frontend;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javaswingdev.drawer.Drawer;
import javaswingdev.drawer.DrawerController;

import javax.swing.*;

import org.example.backend.lexico.AnalizadorLexico;
import org.example.backend.sintactico.report.ErrorSyntax;
import org.example.backend.utilidades.FilesControl;
import org.example.backend.sintactico.*;

/**
 * @author giovanic
 */
public class Visor extends javax.swing.JFrame {

    private final FilesControl filesControl;
    private AnalizadorLexico lexico;
    public DrawerController drawer;

    public Visor() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("PYTHON-COMPILER");
        this.filesControl = new FilesControl();
        this.lexico = new AnalizadorLexico();
        this.panelTk = new PanelToken(lexico.getTokens());
        this.panelError = new PanelToken(lexico.getTokens(), 0);
        despintarBotonesMenu();
//        jTextPane1.setEditorKit(new NumberedEditorKit());
        jTextPane1.setCaretColor(Color.BLACK);
        objetoSeleccionado();
        this.drawer = Drawer.newDrawer(this)
                .leftDrawer(false)
                .drawerWidth(400)
                .drawerBackground(Color.LIGHT_GRAY)
                .header(new JLabel("Tokens"))
                .headerHeight(30)
                .addChild(panelTk)
                .addChild(new JLabel("Token Error"))
                .addChild(panelError)
                .build();

        home.setBackground(Color.WHITE);
        jTextArea1.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuPanel1 = new org.example.frontend.MenuPanel();
        logo = new javax.swing.JLabel();
        homeBtn = new javax.swing.JButton();
        reportBtn = new javax.swing.JButton();
        ayudaBtn = new javax.swing.JButton();
        sel1 = new javax.swing.JLabel();
        sel2 = new javax.swing.JLabel();
        sel3 = new javax.swing.JLabel();
        tabbed = new javax.swing.JTabbedPane();
        home = new javax.swing.JPanel();
        cargarBtn = new javax.swing.JButton();
        analizarBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        tokensTbn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        reportPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pReport = new org.example.frontend.PanelReport();
        help = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menuPanel1.setBackground(new java.awt.Color(153, 204, 255));
        menuPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logo.png"))); // NOI18N
        menuPanel1.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 150, 140));

        homeBtn.setBackground(new java.awt.Color(153, 0, 51));
        homeBtn.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        homeBtn.setForeground(new java.awt.Color(255, 255, 255));
        homeBtn.setText("HOME");
        homeBtn.setBorderPainted(false);
        homeBtn.setFocusPainted(false);
        homeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeBtnMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                homeBtnMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                homeBtnMouseExited(evt);
            }
        });
        menuPanel1.add(homeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 230, 40));

        reportBtn.setBackground(new java.awt.Color(153, 0, 51));
        reportBtn.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        reportBtn.setForeground(new java.awt.Color(255, 255, 255));
        reportBtn.setText("REPORTES");
        reportBtn.setBorderPainted(false);
        reportBtn.setFocusPainted(false);
        reportBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportBtnMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                reportBtnMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                reportBtnMouseExited(evt);
            }
        });
        menuPanel1.add(reportBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 230, 40));

        ayudaBtn.setBackground(new java.awt.Color(153, 0, 51));
        ayudaBtn.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        ayudaBtn.setForeground(new java.awt.Color(255, 255, 255));
        ayudaBtn.setText("AYUDA");
        ayudaBtn.setBorderPainted(false);
        ayudaBtn.setFocusPainted(false);
        ayudaBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ayudaBtnMouseClicked(evt);
            }

            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ayudaBtnMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                ayudaBtnMouseExited(evt);
            }
        });
        menuPanel1.add(ayudaBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 230, 40));

        sel1.setBackground(new java.awt.Color(0, 0, 0));
        sel1.setForeground(new java.awt.Color(0, 0, 0));
        sel1.setMaximumSize(new java.awt.Dimension(210, 4));
        sel1.setMinimumSize(new java.awt.Dimension(210, 4));
        sel1.setOpaque(true);
        sel1.setPreferredSize(new java.awt.Dimension(210, 4));
        menuPanel1.add(sel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 93, 210, 4));

        sel2.setBackground(new java.awt.Color(0, 0, 0));
        sel2.setForeground(new java.awt.Color(0, 0, 0));
        sel2.setMaximumSize(new java.awt.Dimension(210, 4));
        sel2.setMinimumSize(new java.awt.Dimension(210, 4));
        sel2.setOpaque(true);
        sel2.setPreferredSize(new java.awt.Dimension(210, 4));
        menuPanel1.add(sel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 153, 210, 4));

        sel3.setBackground(new java.awt.Color(0, 0, 0));
        sel3.setForeground(new java.awt.Color(0, 0, 0));
        sel3.setMaximumSize(new java.awt.Dimension(210, 4));
        sel3.setMinimumSize(new java.awt.Dimension(210, 4));
        sel3.setOpaque(true);
        sel3.setPreferredSize(new java.awt.Dimension(210, 4));
        menuPanel1.add(sel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 213, 210, 4));

        getContentPane().add(menuPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 800));

        tabbed.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        home.setBackground(new java.awt.Color(102, 102, 102));
        home.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        cargarBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        cargarBtn.setText("Cargar Archivo");
        cargarBtn.setContentAreaFilled(false);
        cargarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cargarBtnMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                cargarBtnMouseExited(evt);
            }
        });
        cargarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarBtnActionPerformed(evt);
            }
        });

        analizarBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        analizarBtn.setText("Analizar");
        analizarBtn.setContentAreaFilled(false);
        analizarBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                analizarBtnMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                analizarBtnMouseExited(evt);
            }
        });
        analizarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                analizarBtnActionPerformed(evt);
            }
        });

        clearBtn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        clearBtn.setText("Limpiar");
        clearBtn.setContentAreaFilled(false);
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                clearBtnMouseEntered(evt);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                clearBtnMouseExited(evt);
            }
        });
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        tokensTbn.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        tokensTbn.setText("Tokens");
        tokensTbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokensTbnActionPerformed(evt);
            }
        });

        jTextPane1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jTextPane1);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(255, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
                homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(homeLayout.createSequentialGroup()
                                                .addComponent(cargarBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(analizarBtn)
                                                .addGap(18, 18, 18)
                                                .addComponent(clearBtn)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tokensTbn)
                                                .addContainerGap())
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1149, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        homeLayout.setVerticalGroup(
                homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(homeLayout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cargarBtn)
                                        .addComponent(analizarBtn)
                                        .addComponent(clearBtn)
                                        .addComponent(tokensTbn))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        tabbed.addTab("", home);

        reportPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setText("TABLA DE SIMBOLOS");

        javax.swing.GroupLayout reportPanelLayout = new javax.swing.GroupLayout(reportPanel);
        reportPanel.setLayout(reportPanelLayout);
        reportPanelLayout.setHorizontalGroup(
                reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(reportPanelLayout.createSequentialGroup()
                                .addGroup(reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(reportPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabel1))
                                        .addGroup(reportPanelLayout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(pReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(752, Short.MAX_VALUE))
        );
        reportPanelLayout.setVerticalGroup(
                reportPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(reportPanelLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(pReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(247, Short.MAX_VALUE))
        );

        tabbed.addTab("", reportPanel);

        help.setBackground(new java.awt.Color(255, 255, 255));

        jTextArea2.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea2.setRows(5);
        jTextArea2.setText("INFORMACION IMPORTANTE.\nEste proyecto del compilador se está realizando por fases. como parte practica del curso\nde Lenguajes Formales y de Programacion.\nLas fases son:\n\tFase 1: Analizador Léxico.\n\tFase 2: Analizador Sintáctico.\n\tFace 3: Analizador Semántico.\n\nAlgunas definiciones.\n\nAnalizador Léxico:\nUn analizador léxico, también conocido como analizador lexicográfico,\nscanner o tokenizer, es la primera fase de un compilador. Consiste en un programa \nquerecibe como entrada el código fuente de otro programa (secuencia de caracteres) y\nproduce una salida compuesta de tokens (componentes léxicos) o símbolos. Estos tokens\nsirven para una posterior etapa del proceso de traducción, siendo la entrada para el \nanalizador sintáctico. La especificación de un lenguaje de programación a menudo \nincluye un conjunto de reglas que definen el léxico.\n\nAnalizador Sintáctico:\nUn analizador sintáctico, también conocido como parser, es una herramienta que \nforma parte de un compilador de código. Su función principal es revisar que \ntodo el código esté escrito correctamente, traduciéndolo y asegurándose de que \nel código sea ejecutable.\n\nEste proceso se realiza con la ayuda de los lexers o analizadores léxicos, que \ndescomponen el código en fichas y componentes individuales, facilitando así el \nanálisis del código. Los lexers crean un árbol de sintaxis o árbol de análisis \nque ayuda a analizar la sintaxis y la gramática del código.");
        jTextArea2.setFocusable(false);
        jScrollPane3.setViewportView(jTextArea2);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("COMPILADOR SIMPLE BASADO EN PYTHON");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("JUAN CASIA");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("RA: 201930457");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("FASE 2: ÁNALISIS SINTÁCTICO");

        javax.swing.GroupLayout helpLayout = new javax.swing.GroupLayout(help);
        help.setLayout(helpLayout);
        helpLayout.setHorizontalGroup(
                helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(helpLayout.createSequentialGroup()
                                .addGroup(helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(helpLayout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)))
                                        .addGroup(helpLayout.createSequentialGroup()
                                                .addGap(92, 92, 92)
                                                .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
        );
        helpLayout.setVerticalGroup(
                helpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(helpLayout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(helpLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(174, 174, 174))
        );

        tabbed.addTab("", help);

        getContentPane().add(tabbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1200, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseEntered
        pintarBoton(homeBtn, c1);
    }//GEN-LAST:event_homeBtnMouseEntered

    private void homeBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseExited
        despintarBotonesMenu();
    }//GEN-LAST:event_homeBtnMouseExited

    private void ayudaBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaBtnMouseEntered
        pintarBoton(ayudaBtn, c1);
    }//GEN-LAST:event_ayudaBtnMouseEntered

    private void ayudaBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaBtnMouseExited
        despintarBotonesMenu();
    }//GEN-LAST:event_ayudaBtnMouseExited

    private void reportBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportBtnMouseEntered
        pintarBoton(reportBtn, c1);
    }//GEN-LAST:event_reportBtnMouseEntered

    private void reportBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportBtnMouseExited
        despintarBotonesMenu();
    }//GEN-LAST:event_reportBtnMouseExited

    private void cargarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarBtnActionPerformed
        String cadena = filesControl.getContenido();
        jTextPane1.setText(cadena);
    }//GEN-LAST:event_cargarBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        jTextPane1.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

    private void analizarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_analizarBtnActionPerformed
        jTextArea1.setText("");
        lexico.getTokens().clear();
        lexico.getErrors().clear();
        try {
            lexico.coincidencia(jTextPane1.getText());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        A_Syntax syntax = new A_Syntax(lexico.getTokens());
        syntax.validate();
        pReport.load(syntax.getSymbols());
        Colorear colorear = new Colorear();
        colorear.colorearEditorTexto(jTextPane1, lexico.getTokens());
        panelTk.loadTable();
        panelError.loadTable1();
        imprimirErrores(syntax.getErrors());
    }//GEN-LAST:event_analizarBtnActionPerformed

    private void imprimirErrores(List<ErrorSyntax> errorList) {
        for (ErrorSyntax errorSyntax : errorList) {
            jTextArea1.append(errorSyntax.toString() + "\n\n");
        }
    }

    private void cargarBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarBtnMouseEntered
        pintarBoton(cargarBtn, c2);
    }//GEN-LAST:event_cargarBtnMouseEntered

    private void cargarBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cargarBtnMouseExited
        despintarBoton(cargarBtn);
    }//GEN-LAST:event_cargarBtnMouseExited

    private void analizarBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analizarBtnMouseEntered
        pintarBoton(analizarBtn, c2);
    }//GEN-LAST:event_analizarBtnMouseEntered

    private void analizarBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_analizarBtnMouseExited
        despintarBoton(analizarBtn);
    }//GEN-LAST:event_analizarBtnMouseExited

    private void clearBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseExited
        despintarBoton(clearBtn);
    }//GEN-LAST:event_clearBtnMouseExited

    private void clearBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseEntered
        pintarBoton(clearBtn, c2);
    }//GEN-LAST:event_clearBtnMouseEntered

    private void tokensTbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tokensTbnActionPerformed
        if (drawer.isShow()) {
            drawer.hide();
        } else {
            drawer.show();
        }
    }//GEN-LAST:event_tokensTbnActionPerformed

    private void homeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeBtnMouseClicked
        tabbed.setSelectedIndex(0);
        objetoSeleccionado();
    }//GEN-LAST:event_homeBtnMouseClicked

    private void reportBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportBtnMouseClicked
        tabbed.setSelectedIndex(1);
        objetoSeleccionado();
    }//GEN-LAST:event_reportBtnMouseClicked

    private void ayudaBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaBtnMouseClicked
        tabbed.setSelectedIndex(2);
        objetoSeleccionado();
    }//GEN-LAST:event_ayudaBtnMouseClicked

    private void despintarBotonesMenu() {
        homeBtn.setContentAreaFilled(false);
        ayudaBtn.setContentAreaFilled(false);
        reportBtn.setContentAreaFilled(false);
    }

    private void despintarBoton(JButton boton) {
        boton.setContentAreaFilled(false);
    }

    private void pintarBoton(JButton boton, Color c) {
        boton.setContentAreaFilled(true);
        boton.setBackground(c);
    }

    private void objetoSeleccionado() {
        switch (tabbed.getSelectedIndex()) {
            case 0 -> {
                sel1.setOpaque(true);
                sel1.repaint();
                sel2.setOpaque(false);
                sel2.repaint();
                sel3.setOpaque(false);
                sel3.repaint();
            }
            case 1 -> {
                sel1.setOpaque(false);
                sel1.repaint();
                sel2.setOpaque(true);
                sel2.repaint();
                sel3.setOpaque(false);
                sel3.repaint();
            }
            case 2 -> {
                sel1.setOpaque(false);
                sel1.repaint();
                sel2.setOpaque(false);
                sel2.repaint();
                sel3.setOpaque(true);
                sel3.repaint();
            }
        }
    }

    // Variables propias
    private PanelToken panelTk;
    private PanelToken panelError;
    private final Color c1 = new Color(164, 31, 82, 255);
    private final Color c2 = new Color(248, 8, 132, 255);
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton analizarBtn;
    private javax.swing.JButton ayudaBtn;
    private javax.swing.JButton cargarBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JPanel help;
    private javax.swing.JPanel home;
    private javax.swing.JButton homeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel logo;
    private org.example.frontend.MenuPanel menuPanel1;
    private org.example.frontend.PanelReport pReport;
    private javax.swing.JButton reportBtn;
    private javax.swing.JPanel reportPanel;
    private javax.swing.JLabel sel1;
    private javax.swing.JLabel sel2;
    private javax.swing.JLabel sel3;
    private javax.swing.JTabbedPane tabbed;
    private javax.swing.JButton tokensTbn;
    // End of variables declaration//GEN-END:variables
}
