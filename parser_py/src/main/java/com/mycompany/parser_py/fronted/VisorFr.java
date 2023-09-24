package com.mycompany.parser_py.fronted;

import com.mycompany.parser_py.backend.Analizador;
import com.mycompany.parser_py.backend.TokenEnum;
import com.mycompany.parser_py.backend.utilidades.FilesControl;
import com.mycompany.parser_py.backend.utilidades.Grafico;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.*;

/**
 * Clase que contiene toda la informacion del apartado grafico de la app
 *
 * @author giovanic
 */
public class VisorFr extends javax.swing.JFrame {

    private final FilesControl control;
    private DefaultTableModel modelo;
    private final Analizador analizador;
    private Grafico graph;

    /**
     * Creates new form VisorFr
     */
    public VisorFr() {
        initComponents();
        btnCargar.setToolTipText("Cargar Archivo");
        btnAnalizar.setToolTipText("Realizar Analisis");

        control = new FilesControl();
        analizador = new Analizador();
        graph = new Grafico();
        loadTable();
        objetoSeleccionado();
        areaTexto.setEditorKit(new NumberedEditorKit());

        reporteTab.setEnabled(false);

        areaTexto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_ENTER
//                        || e.getKeyCode() == KeyEvent.VK_SPACE
//                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
//                    analizador.getListError().clear();
//                    hacerAnalisis();
//                }
//                erLabel.setText("Errores: " + analizador.getListError().size());

//                if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
//                    analizador.getListError().clear();
//                    hacerAnalisis();
//                    for (int i = 0; i < analizador.getListError().size(); i++) {
//                        System.out.println(analizador.getListError().get(i).toString());
//                    }
//                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER
                        || e.getKeyCode() == KeyEvent.VK_SPACE
                        || e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    analizador.getListError().clear();
                    hacerAnalisis();
                }
                erLabel.setText("Errores: " + analizador.getListError().size());
            }
        });
    }

    private void loadTable() {
        String[] nombreColumnas = new String[]{"Token", "Patron", "Lexema", "Linea", "Columna"};
        modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(nombreColumnas);
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        for (int i = 0; i < analizador.getTokens().size(); i++) {
            Object[] tmp = new Object[5];
            tmp[0] = analizador.getTokens().get(i).getTipo();
            tmp[1] = analizador.getTokens().get(i).getPatron();
            tmp[2] = analizador.getTokens().get(i).getLexema();
            tmp[3] = analizador.getTokens().get(i).getFila();
            tmp[4] = analizador.getTokens().get(i).getColumna();
            modelo.addRow(tmp);
        }

        reporteTab.setModel(modelo);
    }

    private void colorear(String entrada) throws BadLocationException {
        char[] matrix = entrada.trim().toCharArray();
        String buffer = "";
        areaTexto.setText("");

        SimpleAttributeSet sm = new SimpleAttributeSet();
        for (int i = 0; i < matrix.length; i++) {
            buffer += matrix[i];
            boolean acept = false;

            for (int j = 0; j < analizador.getTokens().size(); j++) {
                TokenEnum tk = TokenEnum.ERROR;
                if (buffer.equals(analizador.getTokens().get(j).getLexema())) {
                    tk = analizador.getTokens().get(j).getTipo();
                }
                switch (tk) {
                    case KW -> {
                        textoColor(sm, areaTexto, buffer + " ", new Color(166, 96, 206));
                        acept = true;
                        buffer = "";
                    }
                    case ARITHMETIC, COMPARISON, LOGIC, ASSIGNMENT -> {
                        textoColor(sm, areaTexto, buffer + " ", Color.CYAN);
                        acept = true;
                        buffer = "";
                    }
                    case OTHER -> {
                        textoColor(sm, areaTexto, buffer + " ", Color.green);
                        acept = true;
                        buffer = "";
                    }
                    case ID -> {
                        textoColor(sm, areaTexto, buffer + " ", Color.black);
                        acept = true;
                        buffer = "";
                    }
                    case COMMENT -> {
                        textoColor(sm, areaTexto, buffer + " ", Color.gray);
                        acept = true;
                        buffer = "";
                    }
                    default -> {
                        acept = false;
                        buffer += matrix[i];
                    }
                }
            }

//            if (!acept) {
//                textoColor(sm, areaTexto, buffer, Color.ORANGE);
//            }
            if (matrix[i] == '\n') {
                areaTexto.getStyledDocument().insertString(
                        areaTexto.getStyledDocument().getLength(),
                        System.getProperty("line.separator"), null);
            }
        }
    }

    private void textoColor(SimpleAttributeSet attrs, JTextPane text, String string, Color color) {
        StyleConstants.setForeground(attrs, color);
        try {
            text.getStyledDocument().insertString(
                    text.getStyledDocument().getLength(), string, attrs);
        } catch (BadLocationException ex) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        inicioLbl = new javax.swing.JLabel();
        graficoLbl = new javax.swing.JLabel();
        sel0Label = new javax.swing.JLabel();
        sel1Label = new javax.swing.JLabel();
        ayudaLbl = new javax.swing.JLabel();
        sel2Label = new javax.swing.JLabel();
        tabbed = new javax.swing.JTabbedPane();
        inicio = new javax.swing.JPanel();
        btnCargar = new javax.swing.JButton();
        btnAnalizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reporteTab = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTexto = new javax.swing.JTextPane();
        erLabel = new javax.swing.JLabel();
        graficoPanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnId = new javax.swing.JLabel();
        btnArit = new javax.swing.JLabel();
        btnComp = new javax.swing.JLabel();
        btnAsig = new javax.swing.JLabel();
        btnKw = new javax.swing.JLabel();
        listTk = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        textIcon = new javax.swing.JTextPane();
        jButton3 = new javax.swing.JButton();
        acercaPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMenu.setBackground(new java.awt.Color(0, 29, 53));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        inicioLbl.setBackground(new java.awt.Color(0, 29, 53));
        inicioLbl.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        inicioLbl.setForeground(new java.awt.Color(255, 255, 255));
        inicioLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        inicioLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hogar.png"))); // NOI18N
        inicioLbl.setText("       Inicio");
        inicioLbl.setOpaque(true);
        inicioLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inicioLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inicioLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inicioLblMouseExited(evt);
            }
        });

        graficoLbl.setBackground(new java.awt.Color(0, 29, 53));
        graficoLbl.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        graficoLbl.setForeground(new java.awt.Color(255, 255, 255));
        graficoLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        graficoLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen.png"))); // NOI18N
        graficoLbl.setText("    Grafico");
        graficoLbl.setOpaque(true);
        graficoLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                graficoLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                graficoLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                graficoLblMouseExited(evt);
            }
        });

        sel0Label.setBackground(new java.awt.Color(204, 0, 0));
        sel0Label.setMaximumSize(new java.awt.Dimension(5, 32));
        sel0Label.setMinimumSize(new java.awt.Dimension(5, 32));
        sel0Label.setOpaque(true);
        sel0Label.setPreferredSize(new java.awt.Dimension(5, 45));

        sel1Label.setBackground(new java.awt.Color(204, 0, 0));
        sel1Label.setMaximumSize(new java.awt.Dimension(5, 32));
        sel1Label.setMinimumSize(new java.awt.Dimension(5, 32));
        sel1Label.setOpaque(true);
        sel1Label.setPreferredSize(new java.awt.Dimension(5, 45));

        ayudaLbl.setBackground(new java.awt.Color(0, 29, 53));
        ayudaLbl.setFont(new java.awt.Font("Georgia", 1, 18)); // NOI18N
        ayudaLbl.setForeground(new java.awt.Color(255, 255, 255));
        ayudaLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ayudaLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajustes.png"))); // NOI18N
        ayudaLbl.setText("     Ayuda");
        ayudaLbl.setOpaque(true);
        ayudaLbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ayudaLblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ayudaLblMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ayudaLblMouseExited(evt);
            }
        });

        sel2Label.setBackground(new java.awt.Color(204, 0, 0));
        sel2Label.setMaximumSize(new java.awt.Dimension(5, 32));
        sel2Label.setMinimumSize(new java.awt.Dimension(5, 32));
        sel2Label.setOpaque(true);
        sel2Label.setPreferredSize(new java.awt.Dimension(5, 45));

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(sel2Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ayudaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenuLayout.createSequentialGroup()
                        .addComponent(sel1Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(graficoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenuLayout.createSequentialGroup()
                        .addComponent(sel0Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(inicioLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(648, 648, 648))
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(logo)
                .addGap(82, 82, 82)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inicioLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sel0Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graficoLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sel1Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ayudaLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sel2Label, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(269, Short.MAX_VALUE))
        );

        getContentPane().add(panelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-4, -4, 210, 720));

        tabbed.setBackground(new java.awt.Color(255, 255, 255));
        tabbed.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        btnCargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/abrir.png"))); // NOI18N
        btnCargar.setMaximumSize(new java.awt.Dimension(40, 40));
        btnCargar.setMinimumSize(new java.awt.Dimension(40, 40));
        btnCargar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });

        btnAnalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        btnAnalizar.setMaximumSize(new java.awt.Dimension(40, 40));
        btnAnalizar.setMinimumSize(new java.awt.Dimension(40, 40));
        btnAnalizar.setPreferredSize(new java.awt.Dimension(40, 40));
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });

        reporteTab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(reporteTab);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("  ");

        areaTexto.setBackground(new java.awt.Color(51, 51, 51));
        areaTexto.setCaretColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(areaTexto);

        erLabel.setForeground(new java.awt.Color(204, 0, 0));
        erLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                erLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout inicioLayout = new javax.swing.GroupLayout(inicio);
        inicio.setLayout(inicioLayout);
        inicioLayout.setHorizontalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inicioLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, inicioLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(inicioLayout.createSequentialGroup()
                        .addComponent(btnCargar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(erLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCargar, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addGroup(inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(btnAnalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(erLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        tabbed.addTab("", inicio);

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnId.setBackground(new java.awt.Color(0, 51, 51));
        btnId.setFont(new java.awt.Font("Georgia", 1, 13)); // NOI18N
        btnId.setForeground(new java.awt.Color(51, 255, 255));
        btnId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnId.setText("Identificadores");
        btnId.setOpaque(true);
        btnId.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel2MouseExited(evt);
            }
        });
        jPanel1.add(btnId, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 140, 40));

        btnArit.setBackground(new java.awt.Color(0, 51, 51));
        btnArit.setFont(new java.awt.Font("Georgia", 1, 13)); // NOI18N
        btnArit.setForeground(new java.awt.Color(51, 255, 255));
        btnArit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnArit.setText("Aritmeticos");
        btnArit.setOpaque(true);
        btnArit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAritMouseClicked1(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAritMouseEntered1(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAritMouseExited1(evt);
            }
        });
        jPanel1.add(btnArit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 140, 40));

        btnComp.setBackground(new java.awt.Color(0, 51, 51));
        btnComp.setFont(new java.awt.Font("Georgia", 1, 13)); // NOI18N
        btnComp.setForeground(new java.awt.Color(51, 255, 255));
        btnComp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnComp.setText("Comparacion");
        btnComp.setOpaque(true);
        btnComp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCompMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCompMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCompMouseExited(evt);
            }
        });
        jPanel1.add(btnComp, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 140, 40));

        btnAsig.setBackground(new java.awt.Color(0, 51, 51));
        btnAsig.setFont(new java.awt.Font("Georgia", 1, 13)); // NOI18N
        btnAsig.setForeground(new java.awt.Color(51, 255, 255));
        btnAsig.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAsig.setText("Asignacion");
        btnAsig.setOpaque(true);
        btnAsig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAsigClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAsigEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAsigExited(evt);
            }
        });
        jPanel1.add(btnAsig, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 140, 40));

        btnKw.setBackground(new java.awt.Color(0, 51, 51));
        btnKw.setFont(new java.awt.Font("Georgia", 1, 13)); // NOI18N
        btnKw.setForeground(new java.awt.Color(51, 255, 255));
        btnKw.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnKw.setText("Palabra Clave");
        btnKw.setOpaque(true);
        btnKw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnKWClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnKWEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnKwExited(evt);
            }
        });
        jPanel1.add(btnKw, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 10, 140, 40));

        listTk.setBackground(new java.awt.Color(0, 51, 51));
        listTk.setForeground(new java.awt.Color(255, 255, 255));
        listTk.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        listTk.setMaximumSize(new java.awt.Dimension(32767, 34));
        listTk.setMinimumSize(new java.awt.Dimension(76, 34));
        listTk.setOpaque(true);
        listTk.setPreferredSize(new java.awt.Dimension(76, 34));
        jPanel1.add(listTk, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 140, -1));

        jButton1.setBackground(new java.awt.Color(0, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/crear.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setOpaque(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ver.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 40, -1));

        jButton4.setText("jButton4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 50, -1, -1));

        jLabel7.setFont(new java.awt.Font("Lato", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("TIPO DE TOKEN");

        textIcon.setEditable(false);
        jScrollPane3.setViewportView(textIcon);

        jButton3.setText("Limpiar Registros");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout graficoPanelLayout = new javax.swing.GroupLayout(graficoPanel);
        graficoPanel.setLayout(graficoPanelLayout);
        graficoPanelLayout.setHorizontalGroup(
            graficoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graficoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(graficoPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graficoPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(26, 26, 26))
        );
        graficoPanelLayout.setVerticalGroup(
            graficoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graficoPanelLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(graficoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        tabbed.addTab("", graficoPanel);

        javax.swing.GroupLayout acercaPanelLayout = new javax.swing.GroupLayout(acercaPanel);
        acercaPanel.setLayout(acercaPanelLayout);
        acercaPanelLayout.setHorizontalGroup(
            acercaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 835, Short.MAX_VALUE)
        );
        acercaPanelLayout.setVerticalGroup(
            acercaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );

        tabbed.addTab("", acercaPanel);

        getContentPane().add(tabbed, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 860, 710));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hacerAnalisis() {
        analizador.getTokens().clear();
        //analizador.escanear(areaTexto.getText() + "\n");
        try {
            analizador.scan(areaTexto.getText() + "\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("error ->");
        }
        loadTable();
    }

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        areaTexto.setText(control.getContenido());
    }//GEN-LAST:event_btnCargarActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
        hacerAnalisis();
    }//GEN-LAST:event_btnAnalizarActionPerformed

    private void inicioLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioLblMouseEntered
        inicioLbl.setBackground(new java.awt.Color(153, 153, 204));
        inicioLbl.setForeground(new java.awt.Color(60, 0, 100));

    }//GEN-LAST:event_inicioLblMouseEntered

    private void inicioLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioLblMouseExited
        inicioLbl.setBackground(new java.awt.Color(0, 29, 53));
        inicioLbl.setForeground(Color.WHITE);
    }//GEN-LAST:event_inicioLblMouseExited

    private void graficoLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graficoLblMouseEntered
        graficoLbl.setBackground(new java.awt.Color(153, 153, 204));
        graficoLbl.setForeground(new java.awt.Color(60, 0, 100));
    }//GEN-LAST:event_graficoLblMouseEntered

    private void graficoLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graficoLblMouseExited
        graficoLbl.setBackground(new java.awt.Color(0, 29, 53));
        graficoLbl.setForeground(Color.WHITE);
    }//GEN-LAST:event_graficoLblMouseExited

    private void inicioLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inicioLblMouseClicked
        tabbed.setSelectedIndex(0);
        objetoSeleccionado();
    }//GEN-LAST:event_inicioLblMouseClicked

    private void graficoLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_graficoLblMouseClicked
        tabbed.setSelectedIndex(1);
        objetoSeleccionado();
    }//GEN-LAST:event_graficoLblMouseClicked

    private void ayudaLblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaLblMouseClicked
        tabbed.setSelectedIndex(2);
        objetoSeleccionado();
    }//GEN-LAST:event_ayudaLblMouseClicked

    private void ayudaLblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaLblMouseEntered
        ayudaLbl.setBackground(new java.awt.Color(153, 153, 204));
        ayudaLbl.setForeground(new java.awt.Color(60, 0, 100));
    }//GEN-LAST:event_ayudaLblMouseEntered

    private void ayudaLblMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ayudaLblMouseExited
        ayudaLbl.setBackground(new java.awt.Color(0, 29, 53));
        ayudaLbl.setForeground(Color.WHITE);
    }//GEN-LAST:event_ayudaLblMouseExited

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (listTk.getSelectedIndex() != -1) {
            String name = listTk.getItemAt(listTk.getSelectedIndex());
            jLabel7.setText(name);
            System.out.println("--->" + name);
            control.eliminarArchivo("example/graph.png");
            if (name != null) {
                graph.writerDot(name);
                try {
                    graph.entrada(name);
                } catch (IOException ex) {
                    Logger.getLogger(VisorFr.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        btnId.setForeground(Color.red);
        llenarComboBox(TokenEnum.ID);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        btnId.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseExited
        btnId.setForeground(new java.awt.Color(51, 255, 255));
    }//GEN-LAST:event_jLabel2MouseExited

    private void btnAritMouseClicked1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAritMouseClicked1
        btnArit.setForeground(Color.red);
        llenarComboBox(TokenEnum.ARITHMETIC);
    }//GEN-LAST:event_btnAritMouseClicked1

    private void btnAritMouseEntered1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAritMouseEntered1
        btnArit.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnAritMouseEntered1

    private void btnAritMouseExited1(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAritMouseExited1
        btnArit.setForeground(new java.awt.Color(51, 255, 255));
    }//GEN-LAST:event_btnAritMouseExited1

    private void btnCompMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompMouseClicked
        btnComp.setForeground(Color.red);
        llenarComboBox(TokenEnum.COMPARISON);
    }//GEN-LAST:event_btnCompMouseClicked

    private void btnCompMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompMouseEntered
        btnComp.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnCompMouseEntered

    private void btnCompMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCompMouseExited
        btnComp.setForeground(new java.awt.Color(51, 255, 255));
    }//GEN-LAST:event_btnCompMouseExited

    private void btnAsigClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsigClicked
        btnAsig.setForeground(Color.red);
        llenarComboBox(TokenEnum.ASSIGNMENT);
    }//GEN-LAST:event_btnAsigClicked

    private void btnAsigEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsigEntered
        btnAsig.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnAsigEntered

    private void btnAsigExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAsigExited
        btnAsig.setForeground(new java.awt.Color(51, 255, 255));
    }//GEN-LAST:event_btnAsigExited

    private void btnKWClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKWClicked
        btnKw.setForeground(Color.red);
        llenarComboBox(TokenEnum.KW);
    }//GEN-LAST:event_btnKWClicked

    private void btnKWEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKWEntered
        btnKw.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_btnKWEntered

    private void btnKwExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKwExited
        btnKw.setForeground(new java.awt.Color(51, 255, 255));
    }//GEN-LAST:event_btnKwExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (listTk.getSelectedIndex() != -1) {
            insertIcon(listTk.getItemAt(listTk.getSelectedIndex()));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        control.eliminarPorExtension("example/", "dot");
        control.eliminarPorExtension("example/", "png");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void erLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_erLabelMouseClicked
        ErrorDialog error = new ErrorDialog(this, analizador.getListError());
        error.setLocationRelativeTo(null);
        error.setVisible(true);
    }//GEN-LAST:event_erLabelMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void llenarComboBox(TokenEnum tk) {
        listTk.removeAllItems();
        for (int i = 0; i < analizador.getTokens().size(); i++) {
            if (analizador.getTokens().get(i).getTipo() == tk) {
                listTk.addItem(analizador.getTokens().get(i).getLexema());
            }
        }
    }

    private void objetoSeleccionado() {
        switch (tabbed.getSelectedIndex()) {
            case 0 -> {
                sel0Label.setBackground(new java.awt.Color(153, 153, 204));
                sel1Label.setBackground(new java.awt.Color(0, 29, 53));
                sel2Label.setBackground(new java.awt.Color(0, 29, 53));
            }
            case 1 -> {
                sel1Label.setBackground(new java.awt.Color(153, 153, 204));
                sel0Label.setBackground(new java.awt.Color(0, 29, 53));
                sel2Label.setBackground(new java.awt.Color(0, 29, 53));
            }
            case 2 -> {
                sel2Label.setBackground(new java.awt.Color(153, 153, 204));
                sel1Label.setBackground(new java.awt.Color(0, 29, 53));
                sel0Label.setBackground(new java.awt.Color(0, 29, 53));
            }
        }
    }

    /**
     * INSERTAR UN ICONO --
     *
     * El método para ello es insertIcon().Este método reemplaza lo que hay
     * seleccioado en el JTextPane por el icono. Si sólo queremos insertarlo al
     * final, debemos cambiar la selección del texto al final, sin seleccionar
     * nada. Eso se hace con el método setCaretPosition(). Después generamos el
     * icono desde la imagen y lo añadimos con insertIcon
     *
     * @param nameFile nombre del archivo de imagen
     */
    public void insertIcon(String nameFile) {
        try {
            textIcon.setText("");
            textIcon.setCaretPosition(textIcon.getStyledDocument().getLength());
            ImageIcon icono = new ImageIcon("example/" + nameFile + ".png");
            textIcon.insertIcon(icono);
            //nuevaLinea(textIcon);
        } catch (NullPointerException e) {
        }
    }

    /**
     * Metodo para cambiar de línea
     *
     * @param text elemento donde se desea escribir (JTextPane)
     */
    private void nuevaLinea(JTextPane text) {
        try {
            text.getStyledDocument().insertString(
                    text.getStyledDocument().getLength(),
                    System.getProperty("line.separator"), null);

        } catch (BadLocationException ex) {
            Logger.getLogger(VisorFr.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel acercaPanel;
    private javax.swing.JTextPane areaTexto;
    private javax.swing.JLabel ayudaLbl;
    private javax.swing.JButton btnAnalizar;
    private javax.swing.JLabel btnArit;
    private javax.swing.JLabel btnAsig;
    private javax.swing.JButton btnCargar;
    private javax.swing.JLabel btnComp;
    private javax.swing.JLabel btnId;
    private javax.swing.JLabel btnKw;
    private javax.swing.JLabel erLabel;
    private javax.swing.JLabel graficoLbl;
    private javax.swing.JPanel graficoPanel;
    private javax.swing.JPanel inicio;
    private javax.swing.JLabel inicioLbl;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> listTk;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JTable reporteTab;
    private javax.swing.JLabel sel0Label;
    private javax.swing.JLabel sel1Label;
    private javax.swing.JLabel sel2Label;
    private javax.swing.JTabbedPane tabbed;
    private javax.swing.JTextPane textIcon;
    // End of variables declaration//GEN-END:variables
}
