package ar.edu.unju.escmi.tp2.ejercicio5;

import java.util.Scanner;

public class Ejercicio5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Producto[] productos = new Producto[3];

        int cantidadProductos = 0;
        int opcion;

        do {

            System.out.println("===== MENU DE PRODUCTOS =====");
            System.out.println("1 - Crear producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Modificar precio de producto");
            System.out.println("4 - Mostrar los prodductos que superen un precio");
            System.out.println("5 - Salir");

            System.out.print("Ingrese una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {

                case 1:

                    if (cantidadProductos >= productos.length) {

                        System.out.println(
                                "No hay espacio para crear mas productos."
                        );

                    } else {

                        Producto producto = new Producto();

                        System.out.print("Ingrese el codigo: ");
                        producto.setCodigo(scanner.nextInt());
                        scanner.nextLine();

                        System.out.print("Ingrese la descripcion: ");
                        producto.setDescripcion(scanner.nextLine());

                        System.out.print("Ingrese el precio: ");
                        producto.setPrecio(scanner.nextDouble());
                        scanner.nextLine();

                        productos[cantidadProductos] = producto;

                        cantidadProductos++;

                        System.out.println(
                                "Producto creado correctamente."
                        );
                    }

                    break;

                case 2:

                    System.out.println("\n===== PRODUCTOS =====");

                    if (cantidadProductos == 0) {

                        System.out.println(
                                "No hay productos cargados."
                        );

                    } else {

                        for (int i = 0; i < cantidadProductos; i++) {

                            System.out.println(productos[i]);

                        }
                    }

                    break;

                case 3:

                    if (cantidadProductos == 0) {

                        System.out.println(
                                "No hay productos cargados."
                        );

                    } else {

                        System.out.print(
                                "Ingrese el codigo del producto: "
                        );

                        int codigoBuscado = scanner.nextInt();

                        boolean encontrado = false;

                        for (int i = 0; i < cantidadProductos; i++) {

                            if (productos[i].getCodigo() == codigoBuscado) {

                                System.out.print(
                                        "Ingrese el nuevo precio: "
                                );

                                double nuevoPrecio =
                                        scanner.nextDouble();

                                productos[i].setPrecio(nuevoPrecio);

                                encontrado = true;

                                System.out.println(
                                        "Precio modificado correctamente."
                                );

                                break;
                            }
                        }

                        if (!encontrado) {

                            System.out.println(
                                    "No se encontro un producto con ese codigo."
                            );
                        }
                    }

                    break;

                case 4:

                    if (cantidadProductos == 0) {

                        System.out.println(
                                "No hay productos cargados."
                        );

                    } else {

                        System.out.print(
                                "Ingrese el precio minimo: "
                        );

                        double precioBuscado =
                                scanner.nextDouble();

                        boolean encontrado = false;

                        System.out.println(
                                "\nProductos que superan "
                                + precioBuscado + ":"
                        );

                        for (int i = 0; i < cantidadProductos; i++) {

                            if (productos[i].getPrecio() > precioBuscado) {

                                System.out.println(productos[i]);

                                encontrado = true;
                            }
                        }

                        if (!encontrado) {

                            System.out.println(
                                    "No hay productos que superen ese precio."
                            );
                        }
                    }

                    break;

                case 5:

                    System.out.println(
                            "Programa finalizado."
                    );

                    break;

                default:

                    System.out.println(
                            "Opcion no valida."
                    );
            }

        } while (opcion != 5);

        scanner.close();
    }
}