package org.iesch.a14_mapas_y_geo.model;

public class Restaurante {
    private String nombre;
    private double latitud;
    private double longitud;

    public Restaurante(String nombre, double latitud, double longitud) {
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
