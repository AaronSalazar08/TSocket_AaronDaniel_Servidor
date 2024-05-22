package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import Controlador.Metodos;

public class Solicitudes extends JFrame {

    private static final String RECHAZADO = "Rechazado";
    private static final String CONTRATADO = "Contratado";
    public JPanel panelSolicitudes = new JPanel();
    public JTextArea informacionAplicante;
    public JRadioButton contradato, rechazado;
    public JButton botonVolver, botonRefrescar, botonEnviar;
    public JTextArea tarjetaCliente;
    public JScrollPane scroll = new JScrollPane(tarjetaCliente);
    public JLabel division, respuestaLabel, indicacionCliente;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);

    public Solicitudes() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Solicitudes de aplicantes");
        setSize(500, 500);
        setContentPane(panelSolicitudes);
        panelSolicitudes.setBackground(new Color(26, 28, 37));
        panelSolicitudes.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();

    }

    public void Elementos() {

        Metodos metodos = new Metodos(this);

        botonVolver = new JButton("");
        botonVolver.setBounds(40, 400, 50, 30);
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
        botonRefrescar.setToolTipText("Refrescar los datos de los interesados en trabajar en Pizza Roma");
        ImageIcon iconoRefrescar = new ImageIcon("Vista/Imagenes/refrescar.png");
        Image imagenRefrescar = iconoRefrescar.getImage();
        Image imagenRefrescarAjustada = imagenRefrescar.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoRefrescarAjustada = new ImageIcon(imagenRefrescarAjustada);
        botonRefrescar.setIcon(iconoRefrescarAjustada);
        botonRefrescar.setBorderPainted(false);

        botonEnviar = new JButton();
        botonEnviar.setBounds(280, 330, 50, 30);
        botonEnviar.setBackground(new Color(26, 28, 37));
        botonEnviar.setForeground(new Color(255, 255, 255));
        botonEnviar.setFont(fuente);
        botonEnviar.setToolTipText(
                "Enviar respuesta al aplicante obre su solicitud para trabajar en Pizza Roma");
        ImageIcon iconoEnviar = new ImageIcon("Vista/Imagenes/enviar.png");
        Image imagenEnviar = iconoEnviar.getImage();
        Image imagenEnviarAjustada = imagenEnviar.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoEnviarAjustada = new ImageIcon(imagenEnviarAjustada);
        botonEnviar.setIcon(iconoEnviarAjustada);
        botonEnviar.setBorderPainted(false);

        contradato = new JRadioButton(CONTRATADO);
        contradato.setForeground(new Color(255, 255, 255));
        contradato.setBounds(40, 330, 100, 30);
        contradato.setBackground(new Color(26, 28, 37));
        contradato.setToolTipText("Seleccionar si la tarjeta del cliente está aprobada para su uso en la plataforma");

        rechazado = new JRadioButton(RECHAZADO);
        rechazado.setForeground(new Color(255, 255, 255));
        rechazado.setBounds(140, 330, 100, 30);
        rechazado.setBackground(new Color(26, 28, 37));
        rechazado.setToolTipText("Seleccionar si la tarjeta del cliente está denegada para su uso en la plataforma");

        ButtonGroup grupoRadios = new ButtonGroup();
        grupoRadios.add(contradato);
        grupoRadios.add(rechazado);

        scroll.setBounds(30, 80, 300, 150);
        scroll.setBorder(BorderFactory.createCompoundBorder(scroll.getBorder(), BorderFactory.createLineBorder(Color.BLACK, 5)));
        scroll.setToolTipText(
                "Aquí apareceran los datos de los interesados en formar parte del equipo de trabajo de Pizza Roma");

        division = new JLabel(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------");
        division.setBounds(0, 250, 600, 20);
        division.setForeground(new Color(255, 255, 255));
        division.setFont(fuente);

        indicacionCliente = new JLabel("Aplicantes: ");
        indicacionCliente.setBounds(30, 40, 200, 30);
        indicacionCliente.setForeground(new Color(255, 255, 255));
        indicacionCliente.setFont(fuente);

        respuestaLabel = new JLabel("Tu respuesta:  ");
        respuestaLabel.setBounds(30, 275, 200, 30);
        respuestaLabel.setForeground(new Color(255, 255, 255));
        respuestaLabel.setFont(fuente);

        panelSolicitudes.add(botonVolver);
        panelSolicitudes.add(botonRefrescar);
        panelSolicitudes.add(botonEnviar);
        panelSolicitudes.add(contradato);
        panelSolicitudes.add(rechazado);
        panelSolicitudes.add(scroll);
        panelSolicitudes.add(division);
        panelSolicitudes.add(indicacionCliente);
        panelSolicitudes.add(respuestaLabel);

    }

}
