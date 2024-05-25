package Controlador;

import Vista.BuzonClientes;
import Vista.Estado;
import Vista.LogIn;
import Vista.Pedidos;
import Vista.Solicitudes;
import Vista.Noticias;
import Vista.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
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
    private Pedidos enlacepedidos;

    public Metodos(VistaPrincipal vistaPrincipal, LogIn logIn, BuzonClientes buzonClientes, Estado estado,
            Noticias noticias, Solicitudes solicitudes, Pedidos enlacepedidos) {
        this.vistaPrincipal = vistaPrincipal;
        this.logIn = logIn;
        this.buzonClientes = buzonClientes;
        this.estado = estado;
        this.noticias = noticias;
        this.solicitudes = solicitudes;
        this.enlacepedidos = enlacepedidos;
    }

    //Metodos para pasar de ventana JFrame a otra 
    public void principalApedidos (){

        enlacepedidos.setVisible(true);
        vistaPrincipal.setVisible(false);
    }

    public void pedidosAprincipal (){

        vistaPrincipal.setVisible(true);
        enlacepedidos.setVisible(false);
    }

    public void principalAEstado (){

        vistaPrincipal.setVisible(false);
        estado.setVisible(true);
    }

    public void estadoAprincipal (){

        estado.setVisible(false);
        vistaPrincipal.setVisible(true);
    }

    public void principalAnoticias (){

        vistaPrincipal.setVisible(false);
        noticias.setVisible(true);
    }

    public void noticiasAprincipal (){

        noticias.setVisible(false);
        vistaPrincipal.setVisible(true);
    }

    public void principalAsolicitudes (){

        vistaPrincipal.setVisible(false);
        solicitudes.setVisible(true);
    }

    public void solicitudesAprincipal (){

        solicitudes.setVisible(false);
        vistaPrincipal.setVisible(true);
    }

    public void principalAbuzon (){

        vistaPrincipal.setVisible(false);
        buzonClientes.setVisible(true);
    }

    public void buzonAprincipal (){

        buzonClientes.setVisible(false);
        vistaPrincipal.setVisible(true);
    }
    

   public void cerrarServidor() {
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Deseas salir del Servidor?", "confirmacion",
                JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Saliendo del servidor...");
            vistaPrincipal.dispose();
            try {
                if (servidor != null && !servidor.isClosed()) {
                    servidor.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
        } else if (credencialesValidas.containsKey(entradaUsuario) && credencialesValidas.get(entradaUsuario).equals(contrasenaString)) {
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
                        try (ObjectInputStream entrada = new ObjectInputStream(socket.getInputStream());
                                ObjectOutputStream salida = new ObjectOutputStream(socket.getOutputStream())) {
                            RecibirListaPedidos(entrada, salida);
                            RecibirAplicantes(entrada, salida);
                        }
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        if (servidor != null && !servidor.isClosed()) {
                            servidor.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
           
        } else {
            JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
        }
    }

    public void RecibirListaPedidos(ObjectInputStream entrada, ObjectOutputStream salida) {
        try {

            Object objetoPedidos = entrada.readObject();

            if (objetoPedidos instanceof ArrayList<?>) {
                @SuppressWarnings("unchecked")
                ArrayList<Pedido> listaPedidosRecibidos = (ArrayList<Pedido>) objetoPedidos;
                System.out.println("ArrayList recibido:" + listaPedidosRecibidos);
                SwingUtilities.invokeLater(() -> {
                    for (Pedido pedido : listaPedidosRecibidos) {
                        enlacepedidos.pedidoCliente.append(pedido.toString() + "\n");
                    }
                });
                salida.writeObject(listaPedidosRecibidos);
                salida.flush();
            } else {
                System.err.println("El objeto recibido no es una lista de pedidos.");
            }
        } catch (ClassNotFoundException | IOException ex) {
            ex.printStackTrace();
        }
    }

   public void RecibirAplicantes(ObjectInputStream entrada, ObjectOutputStream salida) {
    try {
        Object objetoAplicante = entrada.readObject();
        if (objetoAplicante instanceof ArrayList<?>) {
            @SuppressWarnings("unchecked")
            ArrayList<Aplicante> aplicantes = (ArrayList<Aplicante>) objetoAplicante;
            System.out.println("ArrayList recibido:" + aplicantes.toString());
            SwingUtilities.invokeLater(() -> {
                for (Aplicante aplicante : aplicantes) {
                    solicitudes.informacionAplicante.append(aplicante.toString() + "\n");
                }
            });
            salida.writeObject(aplicantes);
            salida.flush();
        } else {
            System.err.println("El objeto recibido no es una lista de aplicantes.");
        }
    } catch (EOFException e) {
        // Manejar EOFException (se ha alcanzado el final del flujo de entrada)
        // Por ejemplo, cerrar el socket y liberar recursos
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } catch (ClassNotFoundException | IOException ex) {
        ex.printStackTrace();
    } 
}

   
    
    
}

