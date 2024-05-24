package Modelo;

import java.io.Serializable;

public class Pedido implements Serializable {
    private static final long serialVersionUID = -2396901459028578006L;

    public String promocion, direccion, nombreCliente, metodoPago, cantidadPromocion;

    public Pedido(String cantidadPromocion, String promocion,
            String direccion, String nombreCliente, String metodoPago) {

        this.cantidadPromocion = cantidadPromocion;
        this.promocion = promocion;
        this.direccion = direccion;
        this.nombreCliente = nombreCliente;
        this.metodoPago = metodoPago;
    }

    public String getCantidadPromocion() {
        return cantidadPromocion;
    }

    public void setCantidadPromocion(String cantidadPromocion) {
        this.cantidadPromocion = cantidadPromocion;
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

    @Override
    public String toString() {
        return "Pedido\n Promocion: " + promocion + "\nDireccion: " + direccion + "\nNombre: " + nombreCliente
                + "\nMetodoPago: " + metodoPago + "\nCantidad de Promocion: " + cantidadPromocion + "\n---------------------------------------------------------------------------------------------";
    }

  

    

}
