package com.cine;

import java.util.ArrayList;

public class CineDatos {

    // Clase interna para Boleto
    public static class Boleto {
        public String cliente;
        public String peli;
        public String hora;
        public int numAsiento;
        public double costo;

        public Boleto(String cliente, String peli, String hora, int numAsiento, double costo) {
            this.cliente = cliente;
            this.peli = peli;
            this.hora = hora;
            this.numAsiento = numAsiento;
            this.costo = costo;
        }
    }

    // Clase interna para Funcion
    public static class Funcion {
        public String titulo;
        public String horario;
        public double precio;
        public boolean[] ocupados;
        public int vendidos;

        public Funcion(String titulo, String horario, double precio) {
            this.titulo = titulo;
            this.horario = horario;
            this.precio = precio;
            this.ocupados = new boolean[16]; 
            this.vendidos = 0;
        }
    }

    // Listas de datos
    public ArrayList<Funcion> listaFunciones = new ArrayList<>();
    public ArrayList<Boleto> listaVentas = new ArrayList<>();

    // Constructor: Inicializa las películas
    public CineDatos() {
        listaFunciones.add(new Funcion("El Teléfono Negro 2", "2:00 PM", 60.00));
        listaFunciones.add(new Funcion("Chainsaw Man: Reze", "5:00 PM", 75.00));
        listaFunciones.add(new Funcion("A pesar de ti", "8:00 PM", 60.00));
    }

    // Método de lógica pura: Generar el String del reporte
    public String generarReporte() {
        StringBuilder r = new StringBuilder();
        r.append("REPORTE GENERAL\n\n");
        
        double gananciaTotal = 0;
        int boletosTotal = 0;

        for (Boleto b : listaVentas) {
            r.append("Cliente: ").append(b.cliente)
             .append("   Película: ").append(b.peli)
             .append("   Asiento: ").append(b.numAsiento)
             .append("   $").append(b.costo).append("\n");
            gananciaTotal += b.costo;
            boletosTotal++;
        }
        r.append("\nTotal Boletos: ").append(boletosTotal).append("\n");
        r.append("Ganancia Total: $").append(gananciaTotal).append("\n\n");
        
        r.append("POR FUNCION\n");

        for (Funcion f : listaFunciones) {
            double gananciaPeli = f.vendidos * f.precio;
            r.append("Película: ").append(f.titulo).append(" (").append(f.horario).append(")\n");
            r.append("Vendidos: ").append(f.vendidos).append(" de 16\n");
            r.append("Ganancia: $").append(gananciaPeli).append("\n\n");
        }

        return r.toString();
    }
}