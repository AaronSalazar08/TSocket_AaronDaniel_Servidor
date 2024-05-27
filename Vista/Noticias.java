package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controlador.Metodos;

public class Noticias extends JFrame implements ActionListener {

    //Metodo para la llamada de los metodos de las constantes mediante una instacia de la clase Metodos 

    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    private static final String TIMES_NEW_ROMAN = "Times New Roman";
    public JPanel panelNoticias = new JPanel();
    public JTextArea noticias;

    public JScrollPane scroll;
    public JButton botonVolver, botonEnviar;
    public JLabel indicacionCliente;
    Font fuente = new Font(TIMES_NEW_ROMAN, Font.BOLD, 14);

    //Metodo constructor 
    
    public Noticias() {

        //Inicializar JPanel

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Noticias Pizza Roma");
        setSize(500, 400);
        setContentPane(panelNoticias);
        panelNoticias.setBackground(new Color(26, 28, 37));
        panelNoticias.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);

        //Inicializar constantes

        //JButtton
        

        botonVolver = new JButton();
        botonVolver.setBounds(40, 310, 50, 30);
        botonVolver.setBackground(new Color(111, 113, 121));
        botonVolver.setForeground(new Color(255, 255, 255));
        botonVolver.setFont(fuente);
        botonVolver.setToolTipText("Volver al menú principal");
        ImageIcon iconoVolver = new ImageIcon("Vista/Imagenes/volver.png");
        Image imagenVovler = iconoVolver.getImage();
        Image imagenVolverAjustada = imagenVovler.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoVolverAjustada = new ImageIcon(imagenVolverAjustada);
        botonVolver.setIcon(iconoVolverAjustada);
        botonVolver.setBorderPainted(false);
        botonVolver.setOpaque(false);
        botonVolver.addActionListener(this);

        botonEnviar = new JButton();
        botonEnviar.setBounds(370, 310, 50, 30);
        botonEnviar.setBackground(new Color(26, 28, 37));
        botonEnviar.setForeground(new Color(255, 255, 255));
        botonEnviar.setFont(fuente);
        botonEnviar.setToolTipText(
                "Enviar noticias a los clientes sobre Pizza Roma");
        ImageIcon iconoEnviar = new ImageIcon("Vista/Imagenes/enviar.png");
        Image imagenEnviar = iconoEnviar.getImage();
        Image imagenEnviarAjustada = imagenEnviar.getScaledInstance(50, 30, Image.SCALE_SMOOTH);
        ImageIcon iconoEnviarAjustada = new ImageIcon(imagenEnviarAjustada);
        botonEnviar.setIcon(iconoEnviarAjustada);
        botonEnviar.setBorderPainted(false);

        //JTextrea

        noticias = new JTextArea(" ");
        noticias.setEditable(true);

        //JScrollPane

        scroll = new JScrollPane(noticias);

        scroll.setBounds(30, 80, 400, 200);
        scroll.setBorder(
                BorderFactory.createCompoundBorder(scroll.getBorder(), BorderFactory.createLineBorder(Color.BLACK, 5)));
        scroll.setToolTipText(
                "Agregar noticias destacas de Pizza Roma");

        //JLabel

        indicacionCliente = new JLabel("Noticias Pizza Roma ");
        indicacionCliente.setBounds(30, 40, 200, 30);
        indicacionCliente.setForeground(new Color(255, 255, 255));
        indicacionCliente.setFont(fuente);

        //Añadir constantes al JPanel

        panelNoticias.add(botonVolver);
        panelNoticias.add(botonEnviar);
        panelNoticias.add(scroll);
        panelNoticias.add(indicacionCliente);

    }

     //Metodo para la acción de los botones mediante una instancia de la clase de Metodos 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botonVolver){

            metodos.noticiasAprincipal();
        }
    }

}
