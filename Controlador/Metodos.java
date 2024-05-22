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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

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

            Noticias tarjeta = new Noticias();
            tarjeta.setVisible(true);
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
            vistaPrincipal.setVisible(true);
            buzonClientes.dispose();

        }

        if (estado != null && e.getSource() == estado.botonVolver) {

            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.setVisible(true);
            estado.dispose();

        }

        if (noticias != null && e.getSource() == noticias.botonVolver) {

            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.setVisible(true);
            noticias.dispose();

        }

        if (solicitudes != null && e.getSource() == solicitudes.botonVolver) {

            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.setVisible(true);
            solicitudes.dispose();

        }

        if (pedidos != null && e.getSource() == pedidos.botonVolver) {

            VistaPrincipal vistaPrincipal = new VistaPrincipal();
            vistaPrincipal.setVisible(true);
            pedidos.dispose();

        }

        if (pedidos != null && e.getSource() == pedidos.botonRefrescar) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        servidor = new ServerSocket(puerto);
                        System.out.println("Servidor iniciado");

                        while (true) {
                            socketCliente = servidor.accept();

                            inputStream = new DataInputStream(socketCliente.getInputStream());
                            outputStream = new DataOutputStream(socketCliente.getOutputStream());

                            String mensaje = inputStream.readUTF();

                            
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    pedidos.pedidoCliente.append(mensaje);
                                    System.out.println(mensaje);
                                }
                            });

                            outputStream.writeUTF("Hola Daniel");

                            socketCliente.close();
                        }

                    } catch (IOException ex) {
                        Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }).start();
        }

    }

}
