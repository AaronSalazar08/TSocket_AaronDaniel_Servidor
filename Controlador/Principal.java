package Controlador;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import Vista.BuzonClientes;
import Vista.Estado;
import Vista.LogIn;
import Vista.Noticias;
import Vista.Pedidos;
import Vista.Solicitudes;
import Vista.VistaPrincipal;

public class Principal {

    public static void main(String[] args) {
        

        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        LogIn logIn = new LogIn();
        BuzonClientes buzonClientes = new BuzonClientes();
        Estado estado = new Estado();
        Noticias noticias = new Noticias();
        Solicitudes solicitudes = new Solicitudes();
        Pedidos pedidos = new Pedidos();

        Metodos metodos = new Metodos(vistaPrincipal, logIn, buzonClientes, estado, noticias, solicitudes, pedidos);

        
        

        vistaPrincipal.setMetodos(metodos);
        logIn.setMetodos(metodos);
        buzonClientes.setMetodos(metodos);
        estado.setMetodos(metodos);
        noticias.setMetodos(metodos);
        solicitudes.setMetodos(metodos);
        pedidos.setMetodos(metodos);


        logIn.setVisible(true);
       
    }

    

}
