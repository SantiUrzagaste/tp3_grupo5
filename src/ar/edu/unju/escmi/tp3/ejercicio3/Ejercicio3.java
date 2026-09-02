package ar.edu.unju.escmi.tp3.ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Empleado empleado = null;
        int opcion;

        do {
            System.out.println("===== MENU EMPLEADO =====");
            System.out.println("1 - Crear empleado");
            System.out.println("2 - Aumentar Salario");
            System.out.println("3 - Mostrar los datos del empleado");
            System.out.println("4 - Salir");
            System.out.print("Ingrese una opcion: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del empleado: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Ingrese el legajo: ");
                    int legajo = Integer.parseInt(scanner.nextLine());

                    System.out.print("Ingrese el salario: ");
                    double salario = Double.parseDouble(scanner.nextLine());

                    empleado = new Empleado(nombre, legajo, salario);
                    System.out.println("Empleado creado correctamente.");
                    break;

                case 2:
                    if (empleado == null) {
                        System.out.println("Primero debe crear un empleado.");
                    } else {
                        System.out.print("Ingrese el legajo del empleado: ");
                        int legajoIngresado = Integer.parseInt(scanner.nextLine());

                        if (legajoIngresado == empleado.getLegajo()) {
                            empleado.aumentarSalario();
                            System.out.println("Salario aumentado correctamente.");
                        } else {
                            System.out.println("El legajo ingresado no coincide con ningun empleado.");
                        }
                    }
                    break;

                case 3:
                    if (empleado == null) {
                        System.out.println("Primero debe crear un empleado.");
                    } else {
                        empleado.mostrarDatos();
                    }
                    break;

                case 4:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }

            System.out.println();

        } while (opcion != 4);

        scanner.close();
    }
}