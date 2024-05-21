package Vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Pedidos extends JFrame{

    public JPanel panelPedidos = new JPanel();
    public JTextArea pedidoCliente;
    public JTextField respuestaPedido;
    public JButton botonRefrescar, botonEnviar, botonVolver;

    public Pedidos (){

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Pedidos");
        setSize(500, 600);
        setContentPane(panelPedidos);
        panelPedidos.setBackground(new Color(26, 28, 37));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();

    }

    public void Elementos(){
        

    }
}
