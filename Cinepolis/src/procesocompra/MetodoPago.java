package procesocompra;

import java.util.Scanner;
import java.time.YearMonth;

public class MetodoPago {
    private Scanner scanner = new Scanner(System.in);

    public void tipoDePago() {
        System.out.println("Seleccione el tipo de pago:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. Tarjeta de Débito");
        System.out.println("3. Efectivo");

        int opcion = obtenerOpcionPago();

        switch (opcion) {
            case 1:
                procesarPagoConTarjeta("crédito");
                break;

            case 2:
                procesarPagoConTarjeta("débito");
                break;

            case 3:
                procesarPagoEnEfectivo(200.00);
                break;

            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }
    }

    private int obtenerOpcionPago() {
        int opcion = -1;
        while (opcion < 1 || opcion > 3) {
            try {
                opcion = Integer.parseInt(scanner.nextLine());
                if (opcion < 1 || opcion > 3) {
                    System.out.println("Por favor, seleccione una opción válida (1-3):");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Inténtelo de nuevo:");
            }
        }
        return opcion;
    }

    private void procesarPagoConTarjeta(String tipo) {
        System.out.println("Has seleccionado Tarjeta de " + capitalize(tipo) + ".");

        String numeroTarjeta;
        do {
            System.out.print("Introduce el número de la tarjeta (" + (tipo.equals("crédito") ? "16" : "16") + " dígitos): ");
            numeroTarjeta = scanner.nextLine();
        } while (!validarNumeroTarjeta(numeroTarjeta));

        System.out.print("Introduce el nombre del titular de la tarjeta: ");
        String nombreTitular = scanner.nextLine();

        String fechaExpiracion;
        do {
            System.out.print("Introduce la fecha de expiración (MM/AA): ");
            fechaExpiracion = scanner.nextLine();
        } while (!validarFechaExpiracion(fechaExpiracion));

        if (tipo.equals("débito")) {
            procesarPagoConPin();
        }

        System.out.println("Pago realizado con tarjeta de " + capitalize(tipo) + ".");
    }

    private void procesarPagoConPin() {
        int intentos = 0;
        boolean pinValido = false;
        while (intentos < 3 && !pinValido) {
            System.out.print("Introduce el PIN de la tarjeta (4 dígitos): ");
            String pin = scanner.nextLine();
            if (validarPin(pin)) {
                System.out.println("PIN correcto.");
                pinValido = true;
            } else {
                intentos++;
                System.out.println("PIN incorrecto. Intentos restantes: " + (3 - intentos));
            }
        }
        if (!pinValido) {
            System.out.println("Tarjeta bloqueada por demasiados intentos fallidos.");
        }
    }

    private void procesarPagoEnEfectivo(double totalAPagar) {
        System.out.println("Has seleccionado Efectivo.");
        System.out.print("Introduce el monto entregado: ");
        double montoEfectivo = obtenerMontoEfectivo();

        if (montoEfectivo < totalAPagar) {
            System.out.println("Monto insuficiente. Por favor, ingrese una cantidad mayor.");
        } else {
            double cambio = montoEfectivo - totalAPagar;
            System.out.println("Pago realizado en efectivo. Cambio: " + cambio);
        }
    }

    private double obtenerMontoEfectivo() {
        double montoEfectivo = -1;
        while (montoEfectivo < 0) {
            try {
                montoEfectivo = Double.parseDouble(scanner.nextLine());
                if (montoEfectivo < 0) {
                    System.out.println("El monto no puede ser negativo. Inténtelo de nuevo:");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada no válida. Inténtelo de nuevo:");
            }
        }
        return montoEfectivo;
    }

    private boolean validarNumeroTarjeta(String numero) {
        if (numero.length() != 16 || !numero.matches("\\d+")) {
            System.out.println("Número de tarjeta no válido. Debe tener 16 dígitos.");
            return false;
        }
        return true;
    }

    private boolean validarPin(String pin) {
        return pin.length() == 4 && pin.matches("\\d+");
    }

    public boolean validarFechaExpiracion(String fechaExpiracion) {
        String[] partes = fechaExpiracion.split("/");
        if (partes.length != 2) {
            System.out.println("Formato de fecha no válido.");
            return false;
        }

        try {
            int mes = Integer.parseInt(partes[0]);
            int anio = Integer.parseInt("20" + partes[1]);

            YearMonth fechaActual = YearMonth.now();
            YearMonth fechaTarjeta = YearMonth.of(anio, mes);

            return fechaTarjeta.isAfter(fechaActual) || fechaTarjeta.equals(fechaActual);
        } catch (NumberFormatException e) {
            System.out.println("Formato de fecha no válido.");
            return false;
        }
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public static void main(String[] args) {
        MetodoPago pago = new MetodoPago();
        pago.tipoDePago();
    }
}