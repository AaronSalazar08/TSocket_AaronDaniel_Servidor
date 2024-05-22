package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.*;

import Controlador.Metodos;

public class Estado extends JFrame {

    public JPanel panelEstado = new JPanel();
    public JLabel pedidoCliente_label, indicacionCliente;
    public JTextArea pedidoCliente;
    public JScrollPane scroll = new JScrollPane(pedidoCliente);
    public JButton botonRefrescar, botonEnviarEstado, botonVolver;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);

    public Estado() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Estado de Pedidos");
        setSize(500, 450);
        setContentPane(panelEstado);
        panelEstado.setBackground(new Color(26, 28, 37));

        panelEstado.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();

    }

    public void Elementos() {

        Metodos metodos = new Metodos(this);

        botonVolver = new JButton("");
        botonVolver.setBounds(40, 350, 50, 30);
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

        botonEnviarEstado = new JButton();
        botonEnviarEstado.setBounds(350, 290, 50, 30);
        botonEnviarEstado.setBackground(new Color(26, 28, 37));
        botonEnviarEstado.setForeground(new Color(255, 255, 255));
        botonEnviarEstado.setFont(fuente);
        botonEnviarEstado.setToolTipText("Enviar respuesta al cliente sobre su estado de duración del pedido");
        ImageIcon iconoEnviar = new ImageIcon("Vista/Imagenes/enviar.png");
        Image imagenEnviar = iconoEnviar.getImage();
        Image imagenEnviarAjustada = imagenEnviar.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoEnviarAjustada = new ImageIcon(imagenEnviarAjustada);
        botonEnviarEstado.setIcon(iconoEnviarAjustada);
        botonEnviarEstado.setBorderPainted(false);

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

        scroll.setBounds(30, 80, 300, 200);
        scroll.setBorder(BorderFactory.createCompoundBorder(scroll.getBorder(), BorderFactory.createLineBorder(Color.BLACK, 5)));
        scroll.setToolTipText("Aquí apareceran los pedidos realizados por los clientes");

        indicacionCliente = new JLabel("Pedido del Cliente: ");
        indicacionCliente.setBounds(30, 40, 200, 30);
        indicacionCliente.setForeground(new Color(255, 255, 255));
        indicacionCliente.setFont(fuente);

        panelEstado.add(botonVolver);
        panelEstado.add(botonEnviarEstado);
        panelEstado.add(botonRefrescar);
        panelEstado.add(scroll);
        panelEstado.add(indicacionCliente);

    }
}
