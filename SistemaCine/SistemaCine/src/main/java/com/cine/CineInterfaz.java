package com.cine;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class CineInterfaz extends JFrame {

    // Instancia de la clase de datos (conexión con el otro archivo)
    CineDatos datos = new CineDatos();

    JPanel panelPrincipal;
    CardLayout tarjetas;
    CineDatos.Funcion funcionActual; // Referencia a la función seleccionada
    JButton[] botonesAsientos = new JButton[16]; 
    JLabel labelTitulo, labelPrecio;
    JTextField campoNombre;
    JTextArea textoReporte;

    Color azulMarino = new Color(10, 25, 50);
    Color blanco = Color.WHITE;
    Color negro = Color.BLACK;

    public CineInterfaz() {
        setTitle("Sistema CineVi");
        setSize(900, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        tarjetas = new CardLayout();
        panelPrincipal = new JPanel(tarjetas);
        panelPrincipal.setBackground(azulMarino);

        // Agregamos los paneles
        panelPrincipal.add(panelMenu(), "MENU");
        panelPrincipal.add(panelSala(), "SALA");
        panelPrincipal.add(panelReporte(), "REPORTE");

        add(panelPrincipal);
    }

    public JPanel panelMenu() {
        JPanel p = new JPanel(new BorderLayout()); 
        p.setBackground(azulMarino);
        p.setBorder(new EmptyBorder(30, 30, 30, 30));

        JLabel titulo = new JLabel("CARTELERA SALA VIP", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        titulo.setForeground(blanco);
        p.add(titulo, BorderLayout.NORTH);

        JPanel gridPelis = new JPanel(new GridLayout(4, 1, 10, 10)); 
        gridPelis.setBackground(azulMarino);

        // Iteramos sobre la lista que está en CineDatos
        for (int i = 0; i < datos.listaFunciones.size(); i++) {
            CineDatos.Funcion f = datos.listaFunciones.get(i);
            JButton btn = new JButton("<html><center><b>" + f.titulo + "</b><br>" + f.horario + "</center></html>");
            btn.setBackground(blanco);
            btn.setForeground(negro);
            btn.setFocusPainted(false);
            
            btn.addActionListener(e -> cargarSala(f));
            gridPelis.add(btn);
        }

        JButton btnRep = new JButton("VER REPORTE DE VENTAS");
        btnRep.setBackground(blanco);
        btnRep.setForeground(negro);
        btnRep.addActionListener(e -> {
            mostrarReporte();
            tarjetas.show(panelPrincipal, "REPORTE");
        });
        
        JPanel abajo = new JPanel(new BorderLayout());
        abajo.setBackground(azulMarino);
        abajo.setBorder(new EmptyBorder(20,0,0,0));
        abajo.add(btnRep);

        p.add(gridPelis, BorderLayout.CENTER);
        p.add(abajo, BorderLayout.SOUTH);

        return p;
    }

    public JPanel panelSala() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(azulMarino);

        JPanel arriba = new JPanel(new GridLayout(2, 1));
        arriba.setBackground(azulMarino);
        labelTitulo = new JLabel("Título", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        labelTitulo.setForeground(blanco);
        
        labelPrecio = new JLabel("Precio", SwingConstants.CENTER);
        labelPrecio.setForeground(blanco);
        
        arriba.add(labelTitulo);
        arriba.add(labelPrecio);
        p.add(arriba, BorderLayout.NORTH);

        JPanel centro = new JPanel(new BorderLayout());
        centro.setBackground(azulMarino);
        centro.setBorder(new EmptyBorder(10, 50, 10, 50));

        JLabel pantalla = new JLabel("P A N T A L L A", SwingConstants.CENTER);
        pantalla.setForeground(Color.RED);
        pantalla.setFont(new Font("Arial", Font.BOLD, 18));
        pantalla.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, Color.RED));
        pantalla.setPreferredSize(new Dimension(100, 50));
        centro.add(pantalla, BorderLayout.NORTH);

        JPanel gridAsientos = new JPanel(new GridLayout(4, 4, 15, 15));
        gridAsientos.setBackground(azulMarino);

        for (int i = 0; i < 16; i++) {
            botonesAsientos[i] = new JButton(String.valueOf(i + 1)); 
            botonesAsientos[i].setBackground(blanco);
            botonesAsientos[i].setForeground(negro);
            botonesAsientos[i].setFont(new Font("Arial", Font.BOLD, 14));
            
            final int indice = i; 
            botonesAsientos[i].addActionListener(e -> clickAsiento(indice));
            
            gridAsientos.add(botonesAsientos[i]);
        }
        centro.add(gridAsientos, BorderLayout.CENTER);
        p.add(centro, BorderLayout.CENTER);

        JPanel abajo = new JPanel();
        abajo.setLayout(new BoxLayout(abajo, BoxLayout.Y_AXIS));
        abajo.setBackground(azulMarino);
        abajo.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel panelNom = new JPanel();
        panelNom.setBackground(azulMarino);
        JLabel lblN = new JLabel("Nombre Cliente (Opcional): ");
        lblN.setForeground(blanco);
        campoNombre = new JTextField(15);
        panelNom.add(lblN);
        panelNom.add(campoNombre);

        JPanel panelBtn = new JPanel();
        panelBtn.setBackground(azulMarino);
        JButton btnCancel = new JButton("Volver");
        btnCancel.setBackground(blanco);
        btnCancel.setForeground(negro);
        btnCancel.addActionListener(e -> tarjetas.show(panelPrincipal, "MENU"));

        JButton btnOk = new JButton("CONFIRMAR COMPRA");
        btnOk.setBackground(blanco);
        btnOk.setForeground(negro);
        btnOk.addActionListener(e -> hacerCompra());

        panelBtn.add(btnCancel);
        panelBtn.add(btnOk);

        abajo.add(panelNom);
        abajo.add(panelBtn);
        p.add(abajo, BorderLayout.SOUTH);

        return p;
    }

    public JPanel panelReporte() {
        JPanel p = new JPanel(new BorderLayout());
        p.setBackground(azulMarino);
        p.setBorder(new EmptyBorder(20,20,20,20));

        JLabel t = new JLabel("REPORTE DE VENTAS", SwingConstants.CENTER);
        t.setForeground(blanco);
        t.setFont(new Font("Arial", Font.BOLD, 22));
        p.add(t, BorderLayout.NORTH);

        textoReporte = new JTextArea();
        textoReporte.setEditable(false);
        p.add(new JScrollPane(textoReporte), BorderLayout.CENTER);

        JButton btnVolver = new JButton("REGRESAR");
        btnVolver.setBackground(blanco);
        btnVolver.setForeground(negro);
        btnVolver.addActionListener(e -> tarjetas.show(panelPrincipal, "MENU"));
        p.add(btnVolver, BorderLayout.SOUTH);
        return p;
    }

    public void cargarSala(CineDatos.Funcion f) {
        funcionActual = f;
        labelTitulo.setText(f.titulo);
        labelPrecio.setText("Hora: " + f.horario + "    Costo: $" + f.precio);
        campoNombre.setText("");

        for (int i = 0; i < 16; i++) {
            botonesAsientos[i].setText(String.valueOf(i + 1));
            botonesAsientos[i].setName("libre"); 

            if (funcionActual.ocupados[i]) {
                botonesAsientos[i].setBackground(Color.GRAY);
                botonesAsientos[i].setText("X");
                botonesAsientos[i].setEnabled(false);
            } else {
                botonesAsientos[i].setBackground(blanco);
                botonesAsientos[i].setEnabled(true);
            }
        }
        tarjetas.show(panelPrincipal, "SALA");
    }

    public void clickAsiento(int i) {
        JButton btn = botonesAsientos[i];
        
        if (btn.getBackground().equals(blanco)) {
            btn.setBackground(Color.CYAN); 
            btn.setName("seleccionado");
        } else {
            btn.setBackground(blanco);
            btn.setName("libre");
        }
    }

    public void hacerCompra() {
        String nombre = campoNombre.getText();
        if (nombre.isEmpty()) {
            nombre = "Anónimo"; 
        }

        double total = 0;
        String asientosStr = "";
        boolean comproAlgo = false;

        for (int i = 0; i < 16; i++) {
            if (botonesAsientos[i].getName() != null && botonesAsientos[i].getName().equals("seleccionado")) {
                funcionActual.ocupados[i] = true;
                funcionActual.vendidos++;

                // Crear boleto y agregarlo a la lista de datos
                CineDatos.Boleto b = new CineDatos.Boleto(nombre, funcionActual.titulo, funcionActual.horario, (i + 1), funcionActual.precio);
                datos.listaVentas.add(b);

                total += funcionActual.precio;
                asientosStr += (i + 1) + ", ";
                comproAlgo = true;
            }
        }

        if (comproAlgo) {
            JOptionPane.showMessageDialog(this, "¡Venta Lista!\nCliente: " + nombre + "\nAsientos: " + asientosStr + "\nTotal: $" + total);
            cargarSala(funcionActual); 
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione al menos un asiento.");
        }
    }

    public void mostrarReporte() {
        // Pedimos el texto a la clase de datos
        textoReporte.setText(datos.generarReporte());
    }

    public static void main(String[] args) {
        new CineInterfaz().setVisible(true);
    }
}