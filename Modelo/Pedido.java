package Modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pedido implements Serializable {

    private static final long serialVersionUID = 8799656478674716632L;// Con esta creacion de la variable long, se
                                                                      // asegura la conexion serializable Cliente
                                                                      // Servidor para esta clase especifica

    // Atributos de Pedido
    private String promocion, direccion, nombreCliente, metodoPago, cantidadPromocion;

    // Contructor
    public Pedido(String promocion, String direccion, String nombreCliente, String metodoPago,
            String cantidadPromocion) {
        this.promocion = promocion;
        this.direccion = direccion;
        this.nombreCliente = nombreCliente;
        this.metodoPago = metodoPago;
        this.cantidadPromocion = cantidadPromocion;

    }

    // Getters y Setters para cada atributo
    public String getPromocion() {
        return promocion;
    }

    public void setPromocion(String promocion) {
        this.promocion = promocion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getCantidadPromocion() {
        return cantidadPromocion;
    }

    public void setCantidadPromocion(String cantidadPromocion) {
        this.cantidadPromocion = cantidadPromocion;
    }

    //Metodo para mostrar los atributos de Pedido
    @Override
    public String toString() {
        return "Pedido\n Promocion: " + promocion + "\nDireccion: " + direccion + "\nNombre: " + nombreCliente
                + "\nMetodoPago: " + metodoPago + "\nCantidad de Promocion: " + cantidadPromocion
                + "\n---------------------------------------------------------------------------------------------";
    }

}
