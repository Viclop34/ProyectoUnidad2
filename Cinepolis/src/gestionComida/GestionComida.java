package gestionComida;

import java.util.ArrayList;
import java.util.Scanner;

public class GestionComida {
    public ArrayList<Comida> listaComida = new ArrayList<>();

    public void registrarComida(Comida comida) {
        listaComida.add(comida);
    }

    public void modificarComida(String nombreComida) {
        Scanner sc = new Scanner(System.in);
        for (Comida comida : listaComida) {
            if (comida.getNombreComida().equals(nombreComida)) {
                int opcion = 0;
                while (opcion != 3) {
                    System.out.println("Ingrese la opcion deseada: ");
                    System.out.println("1.Eliminar comida ");
                    System.out.println("2.Modificar precio ");
                    System.out.println("3.Salir ");
                    opcion = sc.nextInt();
                    switch (opcion) {
                        case 1:
                            System.out.println(" Haz elegido la opcion eliminar comida ");

                            for (Comida comida1 : listaComida) {
                                if (comida1.getNombreComida().equals(nombreComida)) {
                                    listaComida.remove(comida1);
                                }
                            }
                            System.out.println("La comida ha sido eliminada correctamente ");
                            break;
                        case 2:
                            System.out.println("Haz elegido la opcion modificar precio ");
                            System.out.println("Ingrese el nuevo precio: ");
                            Double precio = sc.nextDouble();
                            for(Comida comida1 : listaComida) {
                              if (comida1.getNombreComida().equals(nombreComida)) {
                                  comida1.setPrecioComida(precio);
                              }
                            }
                            System.out.println("La comida ha sido modificada correctamente ");
                            break;
                        case 3:
                            return;

                    }
                }
            }

        }
    }
}