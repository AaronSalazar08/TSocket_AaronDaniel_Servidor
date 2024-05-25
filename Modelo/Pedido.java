package Modelo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Pedido extends Thread implements Serializable {

    private static final long serialVersionUID = 1L;

    private String promocion, direccion, nombreCliente, metodoPago, cantidadPromocion;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;

    public Pedido(String promocion, String direccion, String nombreCliente, String metodoPago, String cantidadPromocion,
            ObjectInputStream entrada, ObjectOutputStream salida) {
        this.promocion = promocion;
        this.direccion = direccion;
        this.nombreCliente = nombreCliente;
        this.metodoPago = metodoPago;
        this.cantidadPromocion = cantidadPromocion;
        this.entrada = entrada;
        this.salida = salida;
    }

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

    public ObjectInputStream getEntrada() {
        return entrada;
    }

    public void setEntrada(ObjectInputStream entrada) {
        this.entrada = entrada;
    }

    public ObjectOutputStream getSalida() {
        return salida;
    }

    public void setSalida(ObjectOutputStream salida) {
        this.salida = salida;
    }

    @Override
    public void run(){


    }

    @Override
    public String toString() {
        return "Pedido\n Promocion: " + promocion + "\nDireccion: " + direccion + "\nNombre: " + nombreCliente
                + "\nMetodoPago: " + metodoPago + "\nCantidad de Promocion: " + cantidadPromocion
                + "\n---------------------------------------------------------------------------------------------";
    }

}
