package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import Controlador.Metodos;

public class BuzonClientes extends JFrame {

    public JPanel panelBuzonClientes = new JPanel();
    public JTextArea mensajeCliente, respuestaServidor;
    public JScrollPane scrollCliente = new JScrollPane(mensajeCliente);
    public JScrollPane scrollServidor;
    public JButton botonRefrescar, botonEnviar, botonVolver;
    public JLabel refrescarQueja, enviar, indicacionesCliente, division, respuestaLabel, enviarRespuesta;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);

    public BuzonClientes() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Atención al Cliente");
        setSize(500, 600);
        setContentPane(panelBuzonClientes);
        panelBuzonClientes.setBackground(new Color(26, 28, 37));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();

    }

    public void Elementos() {

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

        botonRefrescar = new JButton();
        botonRefrescar.setBounds(370, 110, 80, 40);
        botonRefrescar.setBackground(new Color(111, 113, 121));
        botonRefrescar.setToolTipText("Refrescar los mensajes enviados por los clientes");
        ImageIcon iconoRefrescar = new ImageIcon("Vista/Imagenes/refrescar.png");
        Image imagenRefrescar = iconoRefrescar.getImage();
        Image imagenRefrescarAjustada = imagenRefrescar.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
        ImageIcon iconoRefrescarAjustada = new ImageIcon(imagenRefrescarAjustada);
        botonRefrescar.setIcon(iconoRefrescarAjustada);
        botonRefrescar.setBorderPainted(false);

        botonEnviar = new JButton();
        botonEnviar.setBounds(350, 380, 60, 30);
        botonEnviar.setBackground(new Color(26, 28, 37));
        botonEnviar.setForeground(new Color(255, 255, 255));
        botonEnviar.setFont(fuente);
        botonEnviar.setToolTipText("Enviar respuesta al cliente sobre su mensaje");
        ImageIcon iconoEnviar = new ImageIcon("Vista/Imagenes/enviar.png");
        Image imagenEnviar = iconoEnviar.getImage();
        Image imagenEnviarAjustada = imagenEnviar.getScaledInstance(60, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoEnviarAjustada = new ImageIcon(imagenEnviarAjustada);
        botonEnviar.setIcon(iconoEnviarAjustada);
        botonEnviar.setBorderPainted(false);


        refrescarQueja = new JLabel("Refrescar Mensajes");
        refrescarQueja.setBounds(360, 160, 200, 30);
        refrescarQueja.setForeground(new Color(255, 255, 255));
        refrescarQueja.setFont(fuente);

        indicacionesCliente = new JLabel("Mensajes de Clientes: ");
        indicacionesCliente.setBounds(30, 20, 200, 30);
        indicacionesCliente.setForeground(new Color(255, 255, 255));
        indicacionesCliente.setFont(fuente);

        division = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------");
        division.setBounds(0, 290, 600, 20);
        division.setForeground(new Color(255, 255, 255));
        division.setFont(fuente);

        respuestaLabel = new JLabel("Tu respuesta:  ");
        respuestaLabel.setBounds(30, 310, 200, 30);
        respuestaLabel.setForeground(new Color(255, 255, 255));
        respuestaLabel.setFont(fuente);

        enviarRespuesta = new JLabel("Enviar");
        enviarRespuesta.setBounds(360, 410, 150, 30);
        enviarRespuesta.setForeground(new Color(255, 255, 255));
        enviarRespuesta.setFont(fuente);


        mensajeCliente = new JTextArea();
        mensajeCliente.setEditable(false);
        scrollCliente.setBounds(20, 60, 300, 200);

        respuestaServidor = new JTextArea(" ");
        respuestaServidor.setEditable(true);

        scrollServidor = new JScrollPane(respuestaServidor);

        scrollServidor.setBounds(20, 350, 300, 100);
        
        panelBuzonClientes.add(botonVolver);
        panelBuzonClientes.add(scrollCliente);
        panelBuzonClientes.add(scrollServidor);
        panelBuzonClientes.add(botonRefrescar);
        panelBuzonClientes.add(refrescarQueja);
        panelBuzonClientes.add(indicacionesCliente);
        panelBuzonClientes.add(division);
        panelBuzonClientes.add(respuestaLabel);
        panelBuzonClientes.add(enviarRespuesta);
        panelBuzonClientes.add(botonEnviar);

    }
}
