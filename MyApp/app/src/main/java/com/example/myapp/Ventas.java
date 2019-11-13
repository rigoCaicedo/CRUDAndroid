package com.example.myapp;

public class Ventas {
    private String fecha_venta;

    private String venta_golosinas;

    private String venta_aseo;

    private double venta_escolares;



    public String get_fecha_venta() {
        return fecha_venta;
    }

    public void set_fecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String get_venta_golosinas() {
        return venta_golosinas;
    }

    public void set_venta_golosinas(String venta_golosinas) {
        this.venta_golosinas = venta_golosinas;
    }

    public String get_venta_aseo() {
        return venta_aseo;
    }

    public void set_venta_aseo(String venta_aseo) {
        this.venta_aseo = venta_aseo;
    }

    public double get_venta_escolares() {
        return venta_escolares;
    }

    public void set_venta_escolares(double venta_escolares) {
        this.venta_escolares = venta_escolares;
    }

}
