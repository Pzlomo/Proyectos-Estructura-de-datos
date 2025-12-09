package com.mycompany.proyectocine; // <--- ESTA LÍNEA ES CRUCIAL

import java.util.ArrayList;

public class CineDatos {
    // Definimos qué es una Función (Película + Horario)
    public static class Funcion {
        public String titulo;
        public String horario;
        public double precio;
        public boolean[] ocupados = new boolean[16];
        public int vendidos = 0;

        public Funcion(String t, String h, double p) {
            this.titulo = t; this.horario = h; this.precio = p;
        }
    }
    
    // Definimos qué es un Boleto
    public static class Boleto {
        public String cliente, peli, hora;
        public int numAsiento;
        public double costo;
        public Boleto(String c, String p, String h, int n, double cost) {
            this.cliente = c; this.peli = p; this.hora = h; this.numAsiento = n; this.costo = cost;
        }
    }

    // Listas compartidas para todo el programa
    public static ArrayList<Funcion> listaFunciones = new ArrayList<>();
    public static ArrayList<Boleto> listaVentas = new ArrayList<>();

    // Creamos las 3 películas automáticamente
    static {
        listaFunciones.add(new Funcion("El Teléfono Negro 2", "2:00 PM", 60.00));
        listaFunciones.add(new Funcion("Chainsaw Man: Reze", "5:00 PM", 75.00));
        listaFunciones.add(new Funcion("A pesar de ti", "8:00 PM", 60.00));
    }
    
    public static String generarReporte() {
        String r = "";
        for(Boleto b : listaVentas) r += "Venta: " + b.peli + " - $" + b.costo + "\n";
        return r;
    }
}