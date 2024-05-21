package Vista;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogIn extends JFrame {


    public JPanel panelLogIn = new JPanel();
    public JLabel usuario, contrasena, bienvenida;
    public JTextField Usuario_txt;
    public JPasswordField contrasena_txt;
    public JButton botonContinuar, botonCerrarServidor;



    public LogIn (){

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Inciar Sesión");
        setSize(300, 300);
        setContentPane(panelLogIn);
        panelLogIn.setBackground(new Color(26, 28, 37));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();
    }

    public void Elementos (){

        bienvenida = new JLabel("Iniciar Sesión");
        bienvenida.setBounds(40, 20, 150, 40);

        usuario = new JLabel("Usuario");
        usuario.setBounds(100, 50, 150, 30);

        contrasena = new JLabel("Contraseña");
        contrasena.setBounds(100, 50, 200, 30);
        
        Usuario_txt = new JTextField();
        Usuario_txt.setBounds(100, 100, 150, 30);
        Usuario_txt.setToolTipText("Ingrese su nombre de usuario");

        contrasena_txt = new JPasswordField();
        contrasena_txt.setBounds(100, 230, 150, 30);
        contrasena_txt.setToolTipText("Ingrese su contraseña de usuario");



    }
}
