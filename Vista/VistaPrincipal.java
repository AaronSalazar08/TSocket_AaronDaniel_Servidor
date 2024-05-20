package Vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class VistaPrincipal extends JFrame{

    private JButton botonPedidos, botonEstado, botonBilletera, botonSolicitudesTrabajos, botonAtencionCliente;
    private JLabel Bienvenida;
    private JPanel panelVistaPrincipal = new JPanel();
   
    

    public VistaPrincipal (){

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Menú Servidor");
        setSize(500, 600);
        setContentPane(panelVistaPrincipal);
        panelVistaPrincipal.setBackground(new Color( 4, 7, 25));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();
       
    }

    public void Elementos (){

       botonPedidos = new JButton("Ver Pedidos");
       botonPedidos.setBounds(165, 150, 150, 30);


       //Agregar elementos al JPanel
       panelVistaPrincipal.add(botonPedidos);

    }

    
}
