package Controlador;

import Vista.BuzonClientes;
import Vista.Estado;
import Vista.LogIn;
import Vista.Pedidos;
import Vista.Solicitudes;
import Vista.Noticias;
import Vista.VistaPrincipal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import Modelo.Aplicante;
import Modelo.Pedido;

public class Metodos {

    public ServerSocket servidor;
    public Socket socket;

    private VistaPrincipal vistaPrincipal;
    private LogIn logIn;
    private BuzonClientes buzonClientes;
    private Estado estado;
    private Noticias noticias;
    private Solicitudes solicitudes;
    private Pedidos pedidos;

    public Metodos(VistaPrincipal vistaPrincipal, LogIn logIn, BuzonClientes buzonClientes, Estado estado,
            Noticias noticias, Solicitudes solicitudes, Pedidos pedidos) {
        this.vistaPrincipal = vistaPrincipal;
        this.logIn = logIn;
        this.buzonClientes = buzonClientes;
        this.estado = estado;
        this.noticias = noticias;
        this.solicitudes = solicitudes;
        this.pedidos = pedidos;
    }

    // Metodos para pasar de ventana JFrame a otra
    public void principalApedidos() {

        pedidos.setVisible(true);
        vistaPrincipal.setVisible(false);
    }

    public void pedidosAprincipal() {

        vistaPrincipal.setVisible(true);
        pedidos.setVisible(false);
    }

    public void principalAEstado() {

        vistaPrincipal.setVisible(false);
        estado.setVisible(true);
    }

    public void estadoAprincipal() {

        estado.setVisible(false);
        vistaPrincipal.setVisible(true);
    }

    public void principalAnoticias() {

        vistaPrincipal.setVisible(false);
        noticias.setVisible(true);
    }

    public void noticiasAprincipal() {

        noticias.setVisible(false);
        vistaPrincipal.setVisible(true);
    }

    public void principalAsolicitudes() {

        vistaPrincipal.setVisible(false);
        solicitudes.setVisible(true);
    }

    public void solicitudesAprincipal() {

        solicitudes.setVisible(false);
        vistaPrincipal.setVisible(true);
    }

    public void principalAbuzon() {

        vistaPrincipal.setVisible(false);
        buzonClientes.setVisible(true);
    }

    public void buzonAprincipal() {

        buzonClientes.setVisible(false);
        vistaPrincipal.setVisible(true);
    }

    // Metodo para preguntar al usuario si desea cerrar el servidor
    public void cerrarServidor() {

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Deseas salir del Servidor?", "confirmacion",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Saliendo del servidor...");
            vistaPrincipal.dispose();
        }
    }

    public void handleLogIn() {
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

            vistaPrincipal.usuarioLabel.setText(logIn.Usuario_txt.getText());
            vistaPrincipal.setVisible(true);
            logIn.setVisible(false);

            new Thread(() -> {
                try {
                    servidor = new ServerSocket(5000);
                    System.out.println("Servidor iniciado");

                    while (true) {
                        socket = servidor.accept();
                        RecibirListaPedidos();
                        RecibirAplicantes();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }).start();
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
        }
    }

    public void RecibirListaPedidos() {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {

            Object objetoPedidos = inputStream.readObject();

            if (objetoPedidos instanceof ArrayList<?>) {
                @SuppressWarnings("unchecked")
                ArrayList<Pedido> listaPedidosRecibidos = (ArrayList<Pedido>) objetoPedidos;

                System.out.println("ArrayList recibido:" + listaPedidosRecibidos);

                SwingUtilities.invokeLater(() -> {
                    for (Pedido pedido : listaPedidosRecibidos) {
                        pedidos.pedidoCliente.append(pedido.toString() + "\n");
                    }
                });

                
                outputStream.writeObject(listaPedidosRecibidos);
                outputStream.flush();
                
            } else {
                System.err.println("El objeto recibido no es una lista de pedidos.");
            }
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        } finally{
            // Cierra el socket después de completar la comunicación
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void RecibirAplicantes() {
        try (ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream())) {
    
            Object objetoAplicante = inputStream.readObject();
    
            if (objetoAplicante instanceof ArrayList<?>) {
                @SuppressWarnings("unchecked")
                ArrayList<Aplicante> aplicantes = (ArrayList<Aplicante>) objetoAplicante;
    
                System.out.println("ArrayList recibido:" + aplicantes);
    
                SwingUtilities.invokeLater(() -> {
                    for (Aplicante aplicante : aplicantes) {
                        // Asegúrate de que solicitudes.informacionAplicante sea del tipo correcto
                        solicitudes.informacionAplicante.append(aplicante.toString() + "\n");
                    }
                });
    
                // No cierres el socket aquí, espera hasta que hayas terminado de comunicarte con el cliente
    
                outputStream.writeObject(aplicantes);
                outputStream.flush();
            } else {
                System.err.println("El objeto recibido no es una lista de aplicantes.");
            }
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        } finally {
            // Cierra el socket después de completar la comunicación
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

    public void mandarNoticia() {

    }

}
