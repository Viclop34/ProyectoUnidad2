package procesocompra;
import java.util.Scanner;
import java.time.YearMonth;

public class MetodoPago {
    public void tipoDePago() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione el tipo de pago:");
        System.out.println("1. Tarjeta de Crédito");
        System.out.println("2. Tarjeta de Débito");
        System.out.println("3. Efectivo");

        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer de entrada

        switch (opcion) {
            case 1:
                System.out.println("Has seleccionado Tarjeta de Crédito.");
                String numeroCredito;
                do {
                    System.out.print("Introduce el número de la tarjeta de crédito (16 dígitos): ");
                    numeroCredito = scanner.nextLine();
                    if (numeroCredito.length() != 16 || !numeroCredito.matches("\\d+")) {
                        System.out.println("Número de tarjeta no válido. Debe tener 16 dígitos.");{

                        }
                    }
                } while (numeroCredito.length() != 16 || !numeroCredito.matches("\\d+"));

                System.out.print("Introduce el nombre del titular de la tarjeta: ");
                String nombreCredito = scanner.nextLine();

                String fechaExpiracion;
                do {
                    System.out.print("Introduce la fecha de expiración (MM/AA): ");
                    fechaExpiracion = scanner.nextLine();
                    if (!validarFechaExpiracion(fechaExpiracion)) {
                        System.out.println("Fecha de expiración no válida o la tarjeta ya está vencida.");
                    }
                } while (!validarFechaExpiracion(fechaExpiracion));

                String cvv;
                do {
                    System.out.print("Introduce el código CVV (3 o 4 dígitos): ");
                    cvv = scanner.nextLine();
                    if (cvv.length() < 3 || cvv.length() > 4 || !cvv.matches("\\d+")) {
                        System.out.println("CVV no válido. Debe tener 3 o 4 dígitos.");
                    }
                } while (cvv.length() < 3 || cvv.length() > 4 || !cvv.matches("\\d+"));

                System.out.println("Pago realizado con tarjeta de crédito.");
                break;

            case 2:
                System.out.println("Has seleccionado Tarjeta de Débito.");
                String numeroDebito;
                do {
                    System.out.print("Introduce el número de la tarjeta de débito (16 dígitos): ");
                    numeroDebito = scanner.nextLine();
                    if (numeroDebito.length() != 16 || !numeroDebito.matches("\\d+")) {
                        System.out.println("Número de tarjeta no válido. Debe tener 16 dígitos.");
                    }
                } while (numeroDebito.length() != 16 || !numeroDebito.matches("\\d+"));

                System.out.print("Introduce el nombre del titular de la tarjeta: ");
                String nombreDebito = scanner.nextLine();

                int intentos = 0;
                boolean pinValido = false;
                while (intentos < 3 && !pinValido) {
                    System.out.print("Introduce el PIN de la tarjeta (4 dígitos): ");
                    String pinDebito = scanner.nextLine();
                    if (pinDebito.length() == 4 && pinDebito.matches("\\d+")) {
                        System.out.println("PIN correcto.");
                        pinValido = true;
                    } else {
                        intentos++;
                        System.out.println("PIN incorrecto. Intentos restantes: " + (3 - intentos));
                    }
                }
                if (!pinValido) {
                    System.out.println("Tarjeta bloqueada por demasiados intentos fallidos.");
                } else {
                    System.out.println("Pago realizado con tarjeta de débito.");
                }
                break;

            case 3:
                System.out.println("Has seleccionado Efectivo.");
                double totalAPagar = 100.00;  // Este es el monto que se debe pagar, puede ser dinámico en una implementación real
                System.out.print("Introduce el monto entregado: ");
                double montoEfectivo = scanner.nextDouble();

                if (montoEfectivo < totalAPagar) {
                    System.out.println("Monto insuficiente. Por favor, ingrese una cantidad mayor.");
                } else {
                    double cambio = montoEfectivo - totalAPagar;
                    System.out.println("Pago realizado en efectivo. Cambio: " + cambio);
                }
                break;

            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
        }

    }

    public boolean validarFechaExpiracion(String fechaExpiracion) {
        String[] partes = fechaExpiracion.split("/");
        int mes = Integer.parseInt(partes[0]);
        int anio = Integer.parseInt("20" + partes[1]);  // Añadir "20" al año si es necesario

        YearMonth fechaActual = YearMonth.now();
        YearMonth fechaTarjeta = YearMonth.of(anio, mes);

        return fechaTarjeta.isAfter(fechaActual) || fechaTarjeta.equals(fechaActual);
    }

    public static void main(String[] args) {
        MetodoPago pago = new MetodoPago();
        pago.tipoDePago();
    }
}
