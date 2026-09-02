package ar.edu.unju.escmi.tp3.ejercicio3;

import java.text.NumberFormat;
import java.util.Locale;

public class Empleado {

    private String nombre;
    private int legajo;
    private double salario;

    public static final double SALARIO_MINIMO = 600000.00;
    public static final double AUMENTO_MERITOS = 90000.00;

    public Empleado(String nombre, int legajo, double salario) {
        this.nombre = nombre;
        this.legajo = legajo;

        if (salario >= SALARIO_MINIMO) {
            this.salario = salario;
        } else {
            this.salario = SALARIO_MINIMO;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getLegajo() {
        return legajo;
    }

    public double getSalario() {
        return salario;
    }

    public void mostrarDatos() {
        NumberFormat formatoMoneda = NumberFormat.getNumberInstance(Locale.of("es", "AR"));
        formatoMoneda.setMinimumFractionDigits(2);
        formatoMoneda.setMaximumFractionDigits(2);

        System.out.println("Nombre del empleado: " + nombre);
        System.out.println("Legajo: " + legajo);
        System.out.println("Salario $: " + formatoMoneda.format(salario));
    }

    public void aumentarSalario() {
        this.salario += AUMENTO_MERITOS;
    }
}