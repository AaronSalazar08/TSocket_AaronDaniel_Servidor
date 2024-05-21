package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import Controlador.Metodos;

public class Tarjetas extends JFrame{

    public JPanel panelTarjetas = new JPanel();
    public JTextArea datosTarjeta;
    public JRadioButton aprobada, denegada;
    public JButton botonVolver, botonRefrescar, botonEnviar;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);


    public Tarjetas (){

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Tarjetas de Clientes");
        setSize(500, 600);
        setContentPane(panelTarjetas);
        panelTarjetas.setBackground(new Color(26, 28, 37));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();


    }

    public void Elementos (){

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

        panelTarjetas.add(botonVolver);


    }

}
