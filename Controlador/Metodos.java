package Controlador;

import Vista.LogIn;
import Vista.Pedidos;
import Vista.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class Metodos implements ActionListener {

    private VistaPrincipal vistaPrincipal;
    private LogIn logIn;

    public Metodos(VistaPrincipal vistaPrincipal) {

        this.vistaPrincipal = vistaPrincipal;
        this.logIn = null;
    }

    public Metodos(LogIn logIn) {

        this.logIn = logIn;
        this.vistaPrincipal = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       

        if (logIn != null && e.getSource() == logIn.botonContinuar) {

            String entradaUsuario = logIn.Usuario_txt.getText().trim();
            char[] entradaContrasena = logIn.contrasena_txt.getPassword();
            String contrasenaString = new String(entradaContrasena);
    
            Map<String, String> credencialesValidas = new HashMap<>();
            credencialesValidas.put("A", "1");

            if (entradaUsuario.isEmpty() || contrasenaString.isEmpty()) {

                JOptionPane.showMessageDialog(null, "Asegúrese de completar los espacios en blanco");
                return;
            }

            if (credencialesValidas.containsKey(entradaUsuario) &&
                    credencialesValidas.get(entradaUsuario).equals(contrasenaString)) {

                JOptionPane.showMessageDialog(null, "Bienvenido " + entradaUsuario);
                VistaPrincipal vistaPrincipal = new VistaPrincipal();
                vistaPrincipal.setVisible(true);
                logIn.dispose();

            } else {

                JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
            }

        }

        if (vistaPrincipal != null && e.getSource() == vistaPrincipal.botonPedidos) {

            Pedidos pedidos = new Pedidos();
            pedidos.setVisible(true);
            vistaPrincipal.dispose();
            
        }

        if (vistaPrincipal != null && e.getSource() == vistaPrincipal.botonCerrarServidor) {

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Deseas salir del programa?", "confirmacion",
                    JOptionPane.YES_NO_OPTION);

            if (true) {

                JOptionPane.showMessageDialog(null, "Saliendo del servidor...");
                vistaPrincipal.dispose();
            }

        }

    }

}
