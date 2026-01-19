package es.cide.programacio;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicArrowButton;

import java.awt.*;

public class ServerAdminPanel {
    public static void main(String[] args) {
        // cramos ventana
        JFrame finestra = new JFrame("Tauler d'administració - Nico Rueda");
        finestra.setSize(800, 600);
        // posicion
        finestra.setLocationRelativeTo(null);
        // empty border
        EmptyBorder emptyBorder = new EmptyBorder(10, 0, 0, 0);
        // creamos un grid. Añadimos los botones al grit
        JPanel grid = new JPanel(new GridLayout(2, 2, 15, 15));
        JPanel boxTopLeft = new JPanel(new GridLayout(1, 1));
        JPanel boxTopRight = new JPanel(new GridLayout(1, 1));
        JPanel boxBottomLeft = new JPanel(new GridLayout(1, 1));
        JPanel boxBottomRight = new JPanel(new GridLayout(1, 1));

        // linea decorativa
        Border empty = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        Border blackLine = BorderFactory.createLineBorder(Color.black);
        CompoundBorder line = new CompoundBorder(empty, blackLine);
        Border gridBorder = BorderFactory.createTitledBorder(line, "Titulo");
        grid.setBorder(gridBorder);

        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TitledBorder titol1 = new TitledBorder("Titol 1");

        // finestra.setLayout(new EmptyBorder(null));

        // creamos 4 botones
        JButton b1 = new JButton("TOP-LEFT");
        JButton b2 = new JButton("TOP-RIGHT");
        JButton b3 = new JButton("BOTTOM-TOP");
        JButton b4 = new JButton("BOTTOM-RIGHT");

        boxTopLeft.add(b1);
        boxTopRight.add(b2);
        boxBottomLeft.add(b3);
        boxBottomRight.add(b4);

        grid.add(boxTopLeft);
        grid.add(boxTopRight);
        grid.add(boxBottomLeft);
        grid.add(boxBottomRight);

        // borde a cada uno
        Border gridTitulo = BorderFactory.createTitledBorder(line, "Prueba");
        boxTopLeft.setBorder(gridTitulo);
        boxTopRight.setBorder(gridBorder);
        boxBottomLeft.setBorder(gridBorder);
        boxBottomRight.setBorder(gridBorder);

        // añadimos el grid al Jframe
        finestra.setLayout(new GridBagLayout());
        finestra.add(grid, new GridBagConstraints());

        // hacemos visible el jFRame
        finestra.setVisible(true);

        // importamos un tema
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(finestra);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}