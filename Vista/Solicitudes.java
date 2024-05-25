package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controlador.Metodos;

public class Solicitudes extends JFrame implements ActionListener {

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    private static final String RECHAZADO = "Rechazado";
    private static final String CONTRATADO = "Contratado";
    public JPanel panelSolicitudes = new JPanel();
    public JTextArea informacionAplicante;
    public JRadioButton contradato, rechazado;
    public JButton botonVolver, botonEnviar;

    public JLabel respuestaLabel, indicacionCliente;

    Font fuente = new Font("Times New Roman", Font.BOLD, 14);

    public JScrollPane scroll;

    public Solicitudes() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Solicitudes de aplicantes");
        setSize(700, 500);
        setContentPane(panelSolicitudes);
        panelSolicitudes.setBackground(new Color(26, 28, 37));
        panelSolicitudes.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);

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
        botonVolver.addActionListener(this);
        botonVolver.setBorderPainted(false);

        botonEnviar = new JButton();
        botonEnviar.setBounds(600, 400, 50, 30);
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
        contradato.setBounds(400, 400, 100, 30);
        contradato.setBackground(new Color(26, 28, 37));
        contradato.setToolTipText("Seleccionar si la tarjeta del cliente está aprobada para su uso en la plataforma");

        rechazado = new JRadioButton(RECHAZADO);
        rechazado.setForeground(new Color(255, 255, 255));
        rechazado.setBounds(500, 400, 100, 30);
        rechazado.setBackground(new Color(26, 28, 37));
        rechazado.setToolTipText("Seleccionar si la tarjeta del cliente está denegada para su uso en la plataforma");

        ButtonGroup grupoRadios = new ButtonGroup();
        grupoRadios.add(contradato);
        grupoRadios.add(rechazado);

        informacionAplicante = new JTextArea();
        informacionAplicante.setEditable(false);
        scroll = new JScrollPane(informacionAplicante);
        scroll.setBounds(30, 80, 400, 300);
        scroll.setBorder(
                BorderFactory.createCompoundBorder(scroll.getBorder(), BorderFactory.createLineBorder(Color.BLACK, 5)));
        scroll.setToolTipText(
                "Aquí apareceran los datos de los interesados en formar parte del equipo de trabajo de Pizza Roma");

        indicacionCliente = new JLabel("Aplicantes: ");
        indicacionCliente.setBounds(30, 40, 200, 30);
        indicacionCliente.setForeground(new Color(255, 255, 255));
        indicacionCliente.setFont(fuente);

        respuestaLabel = new JLabel("Tu respuesta:  ");
        respuestaLabel.setBounds(30, 275, 200, 30);
        respuestaLabel.setForeground(new Color(255, 255, 255));
        respuestaLabel.setFont(fuente);

        panelSolicitudes.add(botonVolver);
        panelSolicitudes.add(botonEnviar);
        panelSolicitudes.add(contradato);
        panelSolicitudes.add(rechazado);
        panelSolicitudes.add(scroll);
        // panelSolicitudes.add(informacionAplicante);
        panelSolicitudes.add(indicacionCliente);
        panelSolicitudes.add(respuestaLabel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botonVolver){

            metodos.solicitudesAprincipal();
        }
    }

}
