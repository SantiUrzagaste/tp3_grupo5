package ar.edu.unju.escmi.tp3.ejercicio1;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
public class Ejercicio1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<Persona> personas = new ArrayList<>();
        int opcion = 0;
        do {
            System.out.println("1 Crear objeto con Constructor por defecto.");
            System.out.println("2 Crear objeto con Constructor parametrizado.");
            System.out.println("3 Crear objeto con Constructor (dni, nombre, fecha de nacimiento).");
            System.out.println("4 Mostrar personas.");
            System.out.println("5 Salir");
            System.out.print("Seleccione una opcion: ");
            try {
                opcion=Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1: {
                        Persona persona=new Persona();
                        System.out.print("Ingrese DNI: ");
                        persona.setDni(Integer.parseInt(scanner.nextLine()));
                        
                        System.out.print("Ingrese nombre: ");
                        persona.setNombre(scanner.nextLine());

                        System.out.print("Ingrese fecha de nacimiento (A-Mes-Dia): ");
                        persona.setFechaNacimiento(LocalDate.parse(scanner.nextLine()));

                        System.out.print("Ingrese domicilio: ");
                        persona.setDomicilio(scanner.nextLine());

                        System.out.print("Ingrese provincia: ");
                        persona.setProvincia(scanner.nextLine());

                        personas.add(persona);

                        System.out.println("Persona creada.");
                        break;
                    }

                    case 2: {
                        System.out.print("Ingrese DNI: ");
                        int dni=Integer.parseInt(scanner.nextLine());

                        System.out.print("Ingrese nombre: ");
                        String nombre=scanner.nextLine();

                        System.out.print("Ingrese fecha de nacimiento (A-Mes-Dia): ");
                        LocalDate fechaNacimiento=LocalDate.parse(scanner.nextLine());

                        System.out.print("Ingrese domicilio: ");
                        String domicilio=scanner.nextLine();

                        System.out.print("Ingrese provincia: ");
                        String provincia=scanner.nextLine();

                        Persona persona=new Persona(dni, nombre, fechaNacimiento, domicilio, provincia);
                        personas.add(persona);

                        System.out.println("Persona creada.");
                        break;
                    }

                    case 3: {
                        System.out.print("Ingrese DNI: ");
                        int dni=Integer.parseInt(scanner.nextLine());

                        System.out.print("Ingrese nombre: ");
                        String nombre=scanner.nextLine();

                        System.out.print("Ingrese fecha de nacimiento (A-Mes-Dia): ");
                        LocalDate fechaNacimiento=LocalDate.parse(scanner.nextLine());

                        Persona persona=new Persona(dni, nombre, fechaNacimiento);
                        personas.add(persona);

                        System.out.println("Persona creada.");
                        break;
                    }

                    case 4: {
                        if (personas.isEmpty()) {
                            System.out.println("No hay personas creadas.");
                        } else {
                            for (int i=0;i<personas.size();i++) {
                                System.out.println("Persona "+(i + 1));
                                personas.get(i).mostrarDatos();
                            }
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
                System.out.println("Debe ingresar un numero entero.");
            } catch (DateTimeParseException e) {
                System.out.println("Fecha incorrecta. Use aaaa-mm-dd, por ejemplo: 2005-03-15.");
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion!=5);
        scanner.close();
    }
}