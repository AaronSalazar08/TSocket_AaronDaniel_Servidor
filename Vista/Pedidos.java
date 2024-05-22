package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controlador.Metodos;

public class Pedidos extends JFrame {

    public JPanel panelPedidos = new JPanel();
    public JTextArea pedidoCliente;
    public JScrollPane scroll = new JScrollPane(pedidoCliente);
    public JTextField respuestaPedido;
    public JButton botonRefrescar, botonEnviar, botonVolver;
    public JLabel indicacionCliente, respuestaLabel, division;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);

    public Pedidos() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pedidos");
        setSize(500, 500);
        setContentPane(panelPedidos);
        panelPedidos.setBackground(new Color(26, 28, 37));
        panelPedidos.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();

    }

    public void Elementos() {

        Metodos metodos = new Metodos(this);

        botonVolver = new JButton("");
        botonVolver.setBounds(40, 400, 50, 30);
        botonVolver.setBackground(new Color(111, 113, 121));
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
        botonRefrescar.setToolTipText("Refrescar los pedidos enviados por los clientes");
        ImageIcon iconoRefrescar = new ImageIcon("Vista/Imagenes/refrescar.png");
        Image imagenRefrescar = iconoRefrescar.getImage();
        Image imagenRefrescarAjustada = imagenRefrescar.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoRefrescarAjustada = new ImageIcon(imagenRefrescarAjustada);
        botonRefrescar.setIcon(iconoRefrescarAjustada);
        botonRefrescar.setBorderPainted(false);
        //botonRefrescar.addActionListener(metodos);

        botonEnviar = new JButton();
        botonEnviar.setBounds(350, 330, 50, 30);
        botonEnviar.setBackground(new Color(26, 28, 37));
        botonEnviar.setForeground(new Color(255, 255, 255));
        botonEnviar.setFont(fuente);
        botonEnviar.setToolTipText("Enviar respuesta al cliente sobre su pedido");
        ImageIcon iconoEnviar = new ImageIcon("Vista/Imagenes/enviar.png");
        Image imagenEnviar = iconoEnviar.getImage();
        Image imagenEnviarAjustada = imagenEnviar.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoEnviarAjustada = new ImageIcon(imagenEnviarAjustada);
        botonEnviar.setIcon(iconoEnviarAjustada);
        botonEnviar.setBorderPainted(false);



        division = new JLabel("-------------------------------------------------------------------------------------------------------------------------------------------------------");
        division.setBounds(0, 250, 600, 20);
        division.setForeground(new Color(255, 255, 255));
        division.setFont(fuente);

      
        indicacionCliente = new JLabel("Pedido del Cliente: ");
        indicacionCliente.setBounds(30, 40, 200, 30);
        indicacionCliente.setForeground(new Color(255, 255, 255));
        indicacionCliente.setFont(fuente);

        respuestaLabel = new JLabel("Tu respuesta:  ");
        respuestaLabel.setBounds(30, 290, 200, 30);
        respuestaLabel.setForeground(new Color(255, 255, 255));
        respuestaLabel.setFont(fuente);

        respuestaPedido = new JTextField();
        respuestaPedido.setBounds(30, 330, 300, 30);
        respuestaPedido.setFont(fuente);
        respuestaPedido.setToolTipText("Informa al cliente si su pedido está disponible o algún otro detalle que tenga que saber");

        pedidoCliente = new JTextArea();
        pedidoCliente.setEditable(false);

        scroll.setBounds(30, 80, 300, 150);
        scroll.setToolTipText("Aquí apareceran los pedidos solicitados por los clientes");

        panelPedidos.add(botonVolver);
        panelPedidos.add(botonRefrescar);
        panelPedidos.add(botonEnviar);
        panelPedidos.add(scroll);
        panelPedidos.add(indicacionCliente);
        panelPedidos.add(respuestaPedido);
        panelPedidos.add(respuestaLabel);
        panelPedidos.add(division);

    }
}