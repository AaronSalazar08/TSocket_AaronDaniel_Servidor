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

import Modelo.Pedido;

public class Metodos implements ActionListener {

    ServerSocket servidor = null;
    Socket socketCliente = null;
    DataInputStream inputStream;
    DataOutputStream outputStream;
    int puerto = 5000;

    private VistaPrincipal vistaPrincipal;
    private LogIn logIn;
    private BuzonClientes buzonClientes;
    private Estado estado;
    private Noticias noticias;
    private Solicitudes solicitudes;
    private Pedidos pedidos;

    public Metodos(VistaPrincipal vistaPrincipal) {

        this.vistaPrincipal = vistaPrincipal;
        this.logIn = null;
        this.buzonClientes = null;
        this.estado = null;
        this.noticias = null;
        this.solicitudes = null;
        this.pedidos = null;
    }

    public Metodos(LogIn logIn) {

        this.logIn = logIn;
        this.vistaPrincipal = null;
        this.buzonClientes = null;
        this.estado = null;
        this.noticias = null;
        this.solicitudes = null;
        this.pedidos = null;
    }

    public Metodos(BuzonClientes buzonClientes) {

        this.buzonClientes = buzonClientes;
        this.vistaPrincipal = null;
        this.logIn = null;
        this.estado = null;
        this.noticias = null;
        this.solicitudes = null;
        this.pedidos = null;

    }

    public Metodos(Estado estado) {

        this.estado = estado;
        this.buzonClientes = null;
        this.vistaPrincipal = null;
        this.logIn = null;
        this.noticias = null;
        this.solicitudes = null;
        this.pedidos = null;

    }

    public Metodos(Noticias tarjetas) {

        this.noticias = tarjetas;
        this.estado = null;
        this.buzonClientes = null;
        this.vistaPrincipal = null;
        this.logIn = null;
        this.solicitudes = null;
        this.pedidos = null;

    }

    public Metodos(Solicitudes solicitudes) {

        this.solicitudes = solicitudes;
        this.noticias = null;
        this.estado = null;
        this.buzonClientes = null;
        this.vistaPrincipal = null;
        this.logIn = null;
        this.pedidos = null;

    }

    public Metodos(Pedidos pedidos) {

        this.pedidos = pedidos;
        this.solicitudes = null;
        this.noticias = null;
        this.estado = null;
        this.buzonClientes = null;
        this.vistaPrincipal = null;
        this.logIn = null;

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
                vistaPrincipal.usuarioLabel.setText(logIn.Usuario_txt.getText());
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

        if (vistaPrincipal != null && e.getSource() == vistaPrincipal.botonEstado) {

            Estado estado = new Estado();
            estado.setVisible(true);
            vistaPrincipal.dispose();

        }

        if (vistaPrincipal != null && e.getSource() == vistaPrincipal.botonNoticias) {

            Noticias noticias = new Noticias();
            noticias.setVisible(true);
            vistaPrincipal.dispose();

        }

        if (vistaPrincipal != null && e.getSource() == vistaPrincipal.botonSolicitudesTrabajos) {

            Solicitudes solicitudes = new Solicitudes();
            solicitudes.setVisible(true);
            vistaPrincipal.dispose();

        }

        if (vistaPrincipal != null && e.getSource() == vistaPrincipal.botonAtencionCliente) {

            BuzonClientes buzonClientes = new BuzonClientes();
            buzonClientes.setVisible(true);
            vistaPrincipal.dispose();

        }

        if (vistaPrincipal != null && e.getSource() == vistaPrincipal.botonCerrarServidor) {

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Deseas salir del Servidor?", "confirmacion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(null, "Saliendo del servidor...");
                vistaPrincipal.dispose();
            }

        }

        if (buzonClientes != null && e.getSource() == buzonClientes.botonVolver) {

            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.usuarioLabel.setText(logIn.Usuario_txt.getText());
            vistaPrincipal.setVisible(true);
            buzonClientes.dispose();

        }

        if (estado != null && e.getSource() == estado.botonVolver) {

            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.usuarioLabel.setText(logIn.Usuario_txt.getText().trim());
            vistaPrincipal.setVisible(true);
            estado.dispose();

        }

        if (noticias != null && e.getSource() == noticias.botonVolver) {

            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.usuarioLabel.setText(logIn.Usuario_txt.getText());
            vistaPrincipal.setVisible(true);
            noticias.dispose();

        }

        if (solicitudes != null && e.getSource() == solicitudes.botonVolver) {

            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.usuarioLabel.setText(logIn.Usuario_txt.getText());
            vistaPrincipal.setVisible(true);
            solicitudes.dispose();

        }

        if (pedidos != null && e.getSource() == pedidos.botonVolver) {

            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.usuarioLabel.setText(logIn.Usuario_txt.getText());
            vistaPrincipal.setVisible(true);
            pedidos.dispose();

        }

        if (pedidos != null && e.getSource() == pedidos.botonRefrescar) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // Inicia el servidor en el puerto especificado
                        ServerSocket servidor = new ServerSocket(puerto);
                        System.out.println("Servidor iniciado");

                        while (true) {
                            // Espera a que un cliente se conecte y acepta la conexión
                            Socket socketCliente = servidor.accept();

                            try (ObjectInputStream inputStream = new ObjectInputStream(
                                    socketCliente.getInputStream())) {
                                // Lee el objeto enviado por el cliente
                                Object objetoRecibido = inputStream.readObject();

                                if (objetoRecibido instanceof ArrayList<?>) {
                                    // Verifica que el objeto recibido sea una lista de pedidos
                                    @SuppressWarnings("unchecked")
                                    ArrayList<Pedido> listaPedidosRecibidos = (ArrayList<Pedido>) objetoRecibido;

                                    System.out.println("ArrayList recibido:");

                                    SwingUtilities.invokeLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            for (Pedido pedido : listaPedidosRecibidos) {
                                                pedidos.pedidoCliente.append(pedido.toString() + "\n");

                                            }
                                        }
                                    });
                                    try (ObjectOutputStream outputStream = new ObjectOutputStream(
                                            socketCliente.getOutputStream())) {
                                        outputStream.writeObject(listaPedidosRecibidos);
                                    } catch (IOException ex) {
                                        ex.printStackTrace();
                                    }

                                } else {
                                    System.err.println("El objeto recibido no es una lista de pedidos.");
                                }
                            } catch (ClassNotFoundException ex) {
                                // Error al intentar leer el objeto recibido
                                ex.printStackTrace();
                            }

                            // Cierra el socket del cliente
                            socketCliente.close();
                        }
                    } catch (IOException ex) {
                        // Error al intentar iniciar el servidor
                        ex.printStackTrace();
                    }
                }
            }).start();
        }

        if (vistaPrincipal != null && e.getSource() == vistaPrincipal.botonUsuario) {

            int confirmacion = JOptionPane.showConfirmDialog(null,
                    "¿Deseas cerrar sesión?", "confirmacion",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {

                JOptionPane.showMessageDialog(null, "Cerrando Sesión...");
                LogIn login = new LogIn();
                login.setVisible(true);
                vistaPrincipal.dispose();
            }

        }

    }

    public void RecibirListaPedidos() {
        Thread hilo = new Thread(() -> {
            try {

                Socket socketCliente = servidor.accept();

                ObjectInputStream inputStream = new ObjectInputStream(socketCliente.getInputStream());

                ArrayList<Pedidos> listaPedidosRecbidia = (ArrayList<Pedidos>) inputStream.readObject();

                System.out.println("ArrayList recibido: " + listaPedidosRecbidia);

                inputStream.close();
                socketCliente.close();

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();

            }
        });
        hilo.start();
    }

}
