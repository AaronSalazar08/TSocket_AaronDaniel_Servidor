package Vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlador.Metodos;



public class LogIn extends JFrame implements ActionListener {
     //Metodo para la llamada de los metodos de las constantes mediante una instacia de la clase Metodos 


    public void setMetodos(Metodos metodos) {
        this.metodos = metodos;
    }

    public static Metodos metodos;

    public JPanel panelLogIn = new JPanel();
    public JLabel usuario, contrasena;
    public  JTextField Usuario_txt;
    public JPasswordField contrasena_txt;
    public JButton botonContinuar;
    Font fuente = new Font("Times New Roman", Font.BOLD, 16);

    //Metodo constructor 

    public LogIn() {
        //Inicializando JPanel

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inciar Sesión");
        setSize(300, 300);
        setContentPane(panelLogIn);
        panelLogIn.setBackground(new Color(26, 28, 37));
        panelLogIn.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255), 4));
        setLocationRelativeTo(null);
        setLayout(null);

        //Inicializando constantes

        //JLabel

        usuario = new JLabel("Usuario");
        usuario.setBounds(110, 25, 150, 30);
        usuario.setBackground(new Color(255, 255, 255));
        usuario.setForeground(new Color(255, 255, 255));
        usuario.setFont(fuente);


        contrasena = new JLabel("Contraseña");
        contrasena.setBounds(100, 120, 150, 30);
        contrasena.setBackground(new Color(255, 255, 255));
        contrasena.setForeground(new Color(255, 255, 255));
        contrasena.setFont(fuente);

        //JTexfield

        Usuario_txt = new JTextField();
        Usuario_txt.setBounds(70, 60, 150, 30);
        Usuario_txt.setToolTipText("Ingrese su nombre de usuario");
        Usuario_txt.setFont(fuente);

        //JPasswordfield

        contrasena_txt = new JPasswordField();
        contrasena_txt.setBounds(70, 155, 150, 30);
        contrasena_txt.setToolTipText("Ingrese su contraseña de usuario");
        contrasena_txt.setFont(fuente);

        //JButton

        botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(100, 210, 100, 30);
        botonContinuar.setBackground(new Color(111, 113, 121));
        botonContinuar.setForeground(new Color(255, 255, 255));
       botonContinuar.addActionListener(this);

       //Añadir constantes al JPanel

        panelLogIn.add(usuario);
        panelLogIn.add(contrasena);
        panelLogIn.add(Usuario_txt);
        panelLogIn.add(contrasena_txt);
        panelLogIn.add(botonContinuar);
       
    }

     //Metodo para la acción de los botones mediante una instancia de la clase de Metodos 
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == botonContinuar){
            
            if(metodos != null ){
                metodos.handleLogIn();

            }else {

                JOptionPane.showMessageDialog(null, "Metodos is null");
            }

            
           

        }
    }

    

        

       
    
}
