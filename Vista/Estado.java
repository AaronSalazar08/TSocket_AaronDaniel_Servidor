package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Controlador.Metodos;

public class Estado extends JFrame implements ActionListener {
    //Metodo para la llamada de los metodos de las constantes mediante una instacia de la clase Metodos 


    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    public JPanel panelEstado = new JPanel();
    public JLabel pedidoCliente_label, indicacionCliente;

    public JButton botonEnviarEstado, botonVolver;
    Font fuente = new Font("Times New Roman", Font.BOLD, 14);

    private String[] cabecera = { "Factura", "Promoción", "Cantidad", "Precio" };// Titulos a llevar el JTable

    DefaultTableModel modeloTabla = new DefaultTableModel(cabecera, 1000000) {

        //Metodo para no permitir poder editar la tabla
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    JTable tablaPedidos = new JTable(modeloTabla);
    JScrollPane scroll = new JScrollPane(tablaPedidos);

    //Metodo Constructor 

    public Estado() {

        //Inicializando JPanel
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Estado de Pedidos");
        setSize(500, 450);
        setContentPane(panelEstado);
        panelEstado.setBackground(new Color(26, 28, 37));

        panelEstado.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);
       

        //Inicializando constantes

        //JButton
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
        botonVolver.addActionListener(this);
        botonVolver.setBorderPainted(false);

        botonEnviarEstado = new JButton();
        botonEnviarEstado.setBounds(380, 350, 50, 30);
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

        //JScrollPane

        scroll.setBounds(30, 80, 400, 200);
        scroll.setBorder(
                BorderFactory.createCompoundBorder(scroll.getBorder(), BorderFactory.createLineBorder(Color.BLACK, 5)));
        scroll.setToolTipText("Aquí apareceran los pedidos realizados por los clientes");

        //JLabel

        indicacionCliente = new JLabel("Pedidos Clientes: ");
        indicacionCliente.setBounds(30, 40, 200, 30);
        indicacionCliente.setForeground(new Color(255, 255, 255));
        indicacionCliente.setFont(fuente);

        //Añadir costantes al JPanel

        panelEstado.add(botonVolver);
        panelEstado.add(botonEnviarEstado);
        panelEstado.add(scroll);
        panelEstado.add(indicacionCliente);

    }

     //Metodo para la acción de los botones mediante una instancia de la clase de Metodos 
    @Override
    public void actionPerformed(ActionEvent e) {
        

        if(e.getSource() == botonVolver){

            metodos.estadoAprincipal();
        }
    }
}
