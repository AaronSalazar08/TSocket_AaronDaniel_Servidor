package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import Controlador.Metodos;

public class Solicitudes extends JFrame {

    public JPanel panelSolicitudes = new JPanel();
    public JTextArea informacionAplicante;
    public JRadioButton contradato, rechazado;
    public JButton botonVolver, botonRefrescar, botonEnviar;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);


    public Solicitudes (){

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Solicitudes de aplicantes");
        setSize(500, 600);
        setContentPane(panelSolicitudes);
        panelSolicitudes.setBackground(new Color(26, 28, 37));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();

    }

    public void Elementos(){

        Metodos metodos = new Metodos(this);

        botonVolver = new JButton("");
        botonVolver.setBounds(40, 500, 50, 30);
        botonVolver.setBackground(new Color(111, 113, 121));
        botonVolver.setForeground(new Color(255, 255, 255));
        botonVolver.setFont(fuente);
        botonVolver.setToolTipText("Volver al menú principal");
        ImageIcon iconoVolver = new ImageIcon("Vista/Imagenes/volver.png");
        Image imagenVovler = iconoVolver.getImage();
        Image imagenVolverAjustada = imagenVovler.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoVolverAjustada = new ImageIcon(imagenVolverAjustada);
        botonVolver.setIcon(iconoVolverAjustada);
        botonVolver.addActionListener(metodos);
        botonVolver.setBorderPainted(false);

        panelSolicitudes.add(botonVolver);



    }

}
