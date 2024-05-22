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
    public JTextArea tarjetaCliente;
    public JScrollPane scroll = new JScrollPane(tarjetaCliente);
    public JButton botonVolver, botonRefrescar, botonEnviar;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);


    public Tarjetas (){

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Tarjetas de Clientes");
        setSize(500, 600);
        setContentPane(panelTarjetas);
        panelTarjetas.setBackground(new Color(26, 28, 37));
        panelTarjetas.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();


    }

    public void Elementos (){

        Metodos metodos = new Metodos(this);

        botonVolver = new JButton();
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

        botonRefrescar = new JButton();
        botonRefrescar.setBounds(350, 80, 40, 30);
        botonRefrescar.setBackground(new Color(111, 113, 121));
        botonRefrescar.setToolTipText("Refrescar los datos de las tarjetas enviadas por los clientes");
        ImageIcon iconoRefrescar = new ImageIcon("Vista/Imagenes/refrescar.png");
        Image imagenRefrescar = iconoRefrescar.getImage();
        Image imagenRefrescarAjustada = imagenRefrescar.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoRefrescarAjustada = new ImageIcon(imagenRefrescarAjustada);
        botonRefrescar.setIcon(iconoRefrescarAjustada);
        botonRefrescar.setBorderPainted(false);

        botonEnviar = new JButton();
        botonEnviar.setBounds(350, 330, 50, 30);
        botonEnviar.setBackground(new Color(26, 28, 37));
        botonEnviar.setForeground(new Color(255, 255, 255));
        botonEnviar.setFont(fuente);
        botonEnviar.setToolTipText("Enviar respuesta al cliente sobre su solicitud de aprobación para utilizar la tarjeta");
        ImageIcon iconoEnviar = new ImageIcon("Vista/Imagenes/enviar.png");
        Image imagenEnviar = iconoEnviar.getImage();
        Image imagenEnviarAjustada = imagenEnviar.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoEnviarAjustada = new ImageIcon(imagenEnviarAjustada);
        botonEnviar.setIcon(iconoEnviarAjustada);
        botonEnviar.setBorderPainted(false);

        scroll.setBounds(30, 80, 300, 150);
        scroll.setToolTipText("Aquí apareceran los datos de las tarjetas de los clientes esperando respuesta de aprobación");

        

        panelTarjetas.add(botonVolver);
        panelTarjetas.add(botonRefrescar);
        panelTarjetas.add(botonEnviar);
        panelTarjetas.add(scroll);


    }

}
