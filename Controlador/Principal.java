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
        

        //Se crea una instancia de las respectivas clases que han sido heredadas con JFrame implementando la 
        //libreria javax.swing.*;
        VistaPrincipal vistaPrincipal = new VistaPrincipal();
        LogIn logIn = new LogIn();
        BuzonClientes buzonClientes = new BuzonClientes();
        Estado estado = new Estado();
        Noticias noticias = new Noticias();
        Solicitudes solicitudes = new Solicitudes();
        Pedidos pedidos = new Pedidos();

        //Se crea una instancia de la Clase Metdos en donde se le pasan como paramatreos las instancias de las clases anteriormente mencioandas
        Metodos metodos = new Metodos(vistaPrincipal, logIn, buzonClientes, estado, noticias, solicitudes, pedidos);

        
        
        //Para cada instancia se le incova el metodo se "setMetodos, el cual es un metodo constructor para poder trabajar con la clase metodos en todas las clases instanciadas anteriormente"
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
