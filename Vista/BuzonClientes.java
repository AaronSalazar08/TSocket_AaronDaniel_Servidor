package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controlador.Metodos;

public class BuzonClientes extends JFrame implements ActionListener {

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    public JPanel panelBuzonClientes = new JPanel();
    public JTextArea mensajeCliente, respuestaServidor;
    public JScrollPane scrollCliente;
    public JScrollPane scrollServidor;
    public JButton botonRefrescar, botonEnviar, botonVolver;
    public JLabel enviar, indicacionesCliente, division, respuestaLabel;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);

    public BuzonClientes() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Atención al Cliente");
        setSize(500, 600);
        setContentPane(panelBuzonClientes);
        panelBuzonClientes.setBackground(new Color(26, 28, 37));
        panelBuzonClientes.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);

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
        botonVolver.addActionListener(this);
        botonVolver.setBorderPainted(false);

        botonRefrescar = new JButton();
        botonRefrescar.setBounds(350, 80, 50, 30);
        botonRefrescar.setBackground(new Color(111, 113, 121));
        botonRefrescar.setToolTipText("Refrescar los mensajes enviados por los clientes");
        ImageIcon iconoRefrescar = new ImageIcon("Vista/Imagenes/volumen-apagado.png");
        Image imagenRefrescar = iconoRefrescar.getImage();
        Image imagenRefrescarAjustada = imagenRefrescar.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoRefrescarAjustada = new ImageIcon(imagenRefrescarAjustada);
        botonRefrescar.setIcon(iconoRefrescarAjustada);
        botonRefrescar.setBorderPainted(false);
        botonRefrescar.addActionListener(this);

        botonEnviar = new JButton();
        botonEnviar.setBounds(350, 380, 60, 30);
        botonEnviar.setBackground(new Color(26, 28, 37));
        botonEnviar.setForeground(new Color(255, 255, 255));
        botonEnviar.setFont(fuente);
        botonEnviar.setToolTipText("Enviar respuesta al cliente sobre su mensaje");
        ImageIcon iconoEnviar = new ImageIcon("Vista/Imagenes/enviar.png");
        Image imagenEnviar = iconoEnviar.getImage();
        Image imagenEnviarAjustada = imagenEnviar.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoEnviarAjustada = new ImageIcon(imagenEnviarAjustada);
        botonEnviar.setIcon(iconoEnviarAjustada);
        botonEnviar.setBorderPainted(false);
        botonEnviar.addActionListener(this);

        indicacionesCliente = new JLabel("Mensajes de Clientes: ");
        indicacionesCliente.setBounds(30, 20, 200, 30);
        indicacionesCliente.setForeground(new Color(255, 255, 255));
        indicacionesCliente.setFont(fuente);

        division = new JLabel(
                "-------------------------------------------------------------------------------------------------------------------------------------------------------");
        division.setBounds(0, 290, 600, 20);
        division.setForeground(new Color(255, 255, 255));
        division.setFont(fuente);

        respuestaLabel = new JLabel("Tu respuesta:  ");
        respuestaLabel.setBounds(30, 310, 200, 30);
        respuestaLabel.setForeground(new Color(255, 255, 255));
        respuestaLabel.setFont(fuente);

        mensajeCliente = new JTextArea();
        mensajeCliente.setEditable(false);
        scrollCliente = new JScrollPane(mensajeCliente);
        scrollCliente.setBounds(20, 60, 300, 200);
        scrollCliente.setBorder(BorderFactory.createCompoundBorder(scrollCliente.getBorder(),
                BorderFactory.createLineBorder(Color.BLACK, 5)));

        respuestaServidor = new JTextArea(" ");
        respuestaServidor.setEditable(true);

        scrollServidor = new JScrollPane(respuestaServidor);
        scrollServidor.setBorder(BorderFactory.createCompoundBorder(scrollServidor.getBorder(),
                BorderFactory.createLineBorder(Color.BLACK, 5)));
        scrollServidor.setBounds(20, 350, 300, 100);

        panelBuzonClientes.add(botonVolver);
        panelBuzonClientes.add(scrollCliente);
        panelBuzonClientes.add(scrollServidor);
        panelBuzonClientes.add(botonRefrescar);
        panelBuzonClientes.add(indicacionesCliente);
        panelBuzonClientes.add(division);
        panelBuzonClientes.add(respuestaLabel);
        panelBuzonClientes.add(botonEnviar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if(e.getSource() == botonVolver){

            metodos.buzonAprincipal();
            metodos.detenerServidor();
        }
        if(e.getSource() == botonEnviar){

            metodos.EnviarMensaje();
        }

        if(e.getSource() == botonRefrescar){

            
            metodos.RecibirMensaje();
        }

        
    }
}
