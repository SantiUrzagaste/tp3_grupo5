package ar.edu.unju.escmi.tp3.ejercicio2;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<GatoSimple> gatos = new ArrayList<>();
        int opcion = 0;
        do {
            System.out.println("1 Crear gato simple.");
            System.out.println("2 Dar de comer a un gato simple.");
            System.out.println("3 Mostrar todos los gatos.");
            System.out.println("4 Crear gato contrincante para pelear con un gato simple.");
            System.out.println("5 Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1: {
                        System.out.print("Ingrese nombre: ");
                        String nombre = scanner.nextLine();

                        System.out.print("Ingrese color: ");
                        String color = scanner.nextLine();

                        System.out.print("Ingrese raza: ");
                        String raza = scanner.nextLine();

                        System.out.print("Ingrese edad: ");
                        int edad = Integer.parseInt(scanner.nextLine());

                        System.out.print("Ingrese peso: ");
                        double peso = Double.parseDouble(scanner.nextLine());

                        System.out.print("Ingrese sexo (macho/hembra): ");
                        String sexo = scanner.nextLine();

                        GatoSimple gato = new GatoSimple(nombre, color, raza, edad, peso, sexo);
                        gatos.add(gato);

                        System.out.println("Gato creado.");
                        break;
                    }

                    case 2: {
                        if (gatos.isEmpty()) {
                            System.out.println("No hay gatos creados.");
                        } else {
                            GatoSimple gato = gatos.get(gatos.size() - 1);
                            System.out.print("Ingrese la comida: ");
                            String comida = scanner.nextLine();
                            gato.comer(comida);
                        }
                        break;
                    }

                    case 3: {
                        if (gatos.isEmpty()) {
                            System.out.println("No hay gatos creados.");
                        } else {
                            for (int i = 0; i < gatos.size(); i++) {
                                GatoSimple gato = gatos.get(i);
                                System.out.println("Gato " + (i + 1));
                                System.out.println("Nombre: " + gato.getNombre());
                                System.out.println("Color: " + gato.getColor());
                                System.out.println("Raza: " + gato.getRaza());
                                System.out.println("Edad: " + gato.getEdad());
                                System.out.println("Peso: " + gato.getPeso());
                                System.out.println("Sexo: " + gato.getSexo());
                                System.out.println(gato.maullar());
                                System.out.println(gato.ronronear());
                            }
                        }
                        break;
                    }

                    case 4: {
                        if (gatos.isEmpty()) {
                            System.out.println("No hay gatos creados.");
                        } else {
                            GatoSimple gato = gatos.get(gatos.size() - 1);

                            System.out.print("Ingrese nombre del gato contrincante: ");
                            String nombre = scanner.nextLine();

                            System.out.print("Ingrese color: ");
                            String color = scanner.nextLine();

                            System.out.print("Ingrese raza: ");
                            String raza = scanner.nextLine();

                            System.out.print("Ingrese edad: ");
                            int edad = Integer.parseInt(scanner.nextLine());

                            System.out.print("Ingrese peso: ");
                            double peso = Double.parseDouble(scanner.nextLine());

                            System.out.print("Ingrese sexo (macho/hembra): ");
                            String sexo = scanner.nextLine();

                            GatoSimple gatoContrincante = new GatoSimple(nombre, color, raza, edad, peso, sexo);
                            gato.pelear(gatoContrincante);
                        }
                        break;
                    }

                    case 5: {
                        System.out.println("Programa finalizado.");
                        break;
                    }

                    default: {
                        System.out.println("Opcion incorrecta. Ingrese un número del 1 al 5.");
                        break;
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar un numero valido.");
            }
        } while (opcion != 5);
        scanner.close();
    }
}