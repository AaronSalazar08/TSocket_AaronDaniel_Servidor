package Vista;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controlador.Metodos;

public class LogIn extends JFrame {

    public JPanel panelLogIn = new JPanel();
    public JLabel usuario, contrasena;
    public JTextField Usuario_txt;
    public JPasswordField contrasena_txt;
    public JButton botonContinuar;
    Font fuente = new Font("Times New Roman", Font.BOLD, 16);

    public LogIn() {

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setTitle("Inciar Sesión");
        setSize(300, 300);
        setContentPane(panelLogIn);
        panelLogIn.setBackground(new Color(26, 28, 37));
        setLocationRelativeTo(null);
        setLayout(null);
        Elementos();
    }

    public void Elementos() {

        Metodos metodos = new Metodos(this);

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

        Usuario_txt = new JTextField();
        Usuario_txt.setBounds(70, 60, 150, 30);
        Usuario_txt.setToolTipText("Ingrese su nombre de usuario");
        Usuario_txt.setFont(fuente);

        contrasena_txt = new JPasswordField();
        contrasena_txt.setBounds(70, 155, 150, 30);
        contrasena_txt.setToolTipText("Ingrese su contraseña de usuario");
        contrasena_txt.setFont(fuente);

        botonContinuar = new JButton("Continuar");
        botonContinuar.setBounds(100, 210, 100, 30);
        botonContinuar.setBackground(new Color(111, 113, 121));
        botonContinuar.setForeground(new Color(255, 255, 255));
        botonContinuar.addActionListener(metodos);

        panelLogIn.add(usuario);
        panelLogIn.add(contrasena);
        panelLogIn.add(Usuario_txt);
        panelLogIn.add(contrasena_txt);
        panelLogIn.add(botonContinuar);
    }
}
