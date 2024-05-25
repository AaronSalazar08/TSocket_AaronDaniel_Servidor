package Modelo;

import java.io.Serializable;

public class Aplicante extends Thread implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String cedula, nombre, correo, postulacion, provincia;
    protected int numero;

    public Aplicante(String cedula, String nombre, String correo, String postulacion, String provincia, int numero) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.correo = correo;
        this.postulacion = postulacion;
        this.provincia = provincia;
        this.numero = numero;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPostulacion() {
        return postulacion;
    }

    public void setPostulacion(String postulacion) {
        this.postulacion = postulacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

}
