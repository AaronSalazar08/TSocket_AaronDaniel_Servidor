package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import Controlador.Metodos;

public class Pedidos extends JFrame implements ActionListener {
    //Metodo para la llamada de los metodos de las constantes mediante una instacia de la clase Metodos 

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    public JPanel panelPedidos = new JPanel();
    public JTextArea pedidoCliente;
    public JScrollPane scroll;
    public JButton botonRefrescar, botonEnviar, botonVolver;
    public JLabel indicacionCliente;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);

    //Metodo constructor 
    public Pedidos() {
        //Inicializando JPanel

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pedidos");
        setSize(370, 500);
        setContentPane(panelPedidos);
        panelPedidos.setBackground(new Color(26, 28, 37));
        panelPedidos.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);

        //Inicializando constantes 

        //JButton
       
        botonVolver = new JButton("");
        botonVolver.setBounds(40, 400, 50, 30);
        botonVolver.setBackground(new Color(111, 113, 121));
        botonVolver.setToolTipText("Volver al menú principal");
        ImageIcon iconoVolver = new ImageIcon("Vista/Imagenes/volver.png");
        Image imagenVovler = iconoVolver.getImage();
        Image imagenVolverAjustada = imagenVovler.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoVolverAjustada = new ImageIcon(imagenVolverAjustada);
        botonVolver.setIcon(iconoVolverAjustada);
        botonVolver.addActionListener(this);
        botonVolver.setBorderPainted(false);

        botonRefrescar = new JButton();
        botonRefrescar.setBounds(290, 40, 40, 30);
        botonRefrescar.setBackground(new Color(111, 113, 121));
        botonRefrescar.setToolTipText("Refrescar los pedidos enviados por los clientes");
        ImageIcon iconoRefrescar = new ImageIcon("Vista/Imagenes/refrescar.png");
        Image imagenRefrescar = iconoRefrescar.getImage();
        Image imagenRefrescarAjustada = imagenRefrescar.getScaledInstance(40, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoRefrescarAjustada = new ImageIcon(imagenRefrescarAjustada);
        botonRefrescar.setIcon(iconoRefrescarAjustada);
        botonRefrescar.setBorderPainted(false);
       

        botonEnviar = new JButton();
        botonEnviar.setBounds(290, 400, 50, 30);
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

        //JLabel

        indicacionCliente = new JLabel("Factura del Cliente: ");
        indicacionCliente.setBounds(30, 40, 200, 30);
        indicacionCliente.setForeground(new Color(255, 255, 255));
        indicacionCliente.setFont(fuente);
        pedidoCliente = new JTextArea();
        pedidoCliente.setEditable(false);

        //JTextArea

        pedidoCliente = new JTextArea();
        pedidoCliente.setEditable(false);


        //JScrollPane
        scroll = new JScrollPane(pedidoCliente);
        scroll.setBounds(30, 80, 300, 280);
        scroll.setBorder(
                BorderFactory.createCompoundBorder(scroll.getBorder(), BorderFactory.createLineBorder(Color.BLACK, 5)));
        scroll.setToolTipText("Aquí apareceran los pedidos solicitados por los clientes");

        //Añadir constantes al JPanel

        panelPedidos.add(botonVolver);
        panelPedidos.add(botonRefrescar);
        panelPedidos.add(botonEnviar);
        panelPedidos.add(scroll);
        panelPedidos.add(indicacionCliente);

    }

    //Metodo para la acción de los botones mediante una instancia de la clase de Metodos 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botonVolver){

            metodos.pedidosAprincipal();
           
        }

    }
}
