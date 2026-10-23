import java.util.Scanner;

public class Cajero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final String NOMBRE_BANCO = "INNBANK";
        final int MAX_INTENTOS = 3;

        // Arreglos
        String[] nombres = { "Ana", "Luis", "Sofia" };
        String[] pines = { "1234", "5678", "9012" };
        double[] saldos = { 1500.00, 320.50, 8000.00 };

        int numeroCliente;
        int indiceCliente = -1;
        int intentos = 0;
        int opcionMenu;
        boolean pinValido = false;

        System.out.println("==========================");
        System.out.println("  BIENVENIDO A " + NOMBRE_BANCO);
        System.out.println("==========================");

        // Buscar cliente por su número
        System.out.println("\n===== CLIENTES INNBANK =====");

        for (int i = 0; i < nombres.length; i++) {
            System.out.println(
                    "Cliente " + (i + 1) + ": " + nombres[i]);
        }

        System.out.println("\nIngresa tu número de cliente:");

        numeroCliente = sc.nextInt();
        sc.nextLine();

        // Los números son 1, 2 y 3; los índices son 0, 1 y 2.
        if (numeroCliente >= 1 && numeroCliente <= nombres.length) {
            indiceCliente = numeroCliente - 1;
        } else {
            System.out.println("Número de cliente inexistente.");
            sc.close();
            return;
        }

        // Validación del PIN del cliente seleccionado
        while (intentos < MAX_INTENTOS && !pinValido) {

            System.out.println("Ingresa tu PIN:");
            String pinCliente = sc.nextLine();

            if (pinCliente.equals(pines[indiceCliente])) {
                pinValido = true;
                System.out.println(
                        "\nPIN correcto. Acceso concedido.");
                System.out.println(
                        "Bienvenido(a), " + nombres[indiceCliente]);
            } else {

                intentos++;
                int intentosRestantes = MAX_INTENTOS - intentos;
                System.out.println("PIN incorrecto.");

                if (intentosRestantes > 0) {
                    System.out.println(
                            "Intentos restantes: " + intentosRestantes);
                } else {
                    System.out.println(
                            "Máximo de intentos alcanzado. Acceso denegado.");
                    sc.close();
                    return;
                }
            }
        }

        // Menu
        do {
            System.out.println("""

                    ==========================
                    |    MENÚ INNBANK        |
                    ==========================
                    | 1. Consultar saldo     |
                    | 2. Realizar depósito   |
                    | 3. Realizar retiro     |
                    | 4. Transferir dinero   |
                    | 5. Salir               |
                    ==========================
                    """);

            System.out.println("Elige una operación:");
            opcionMenu = sc.nextInt();

            switch (opcionMenu) {
                case 1 -> {
                    System.out.printf("Cliente: %s%n", nombres[indiceCliente]);

                    System.out.printf("Saldo disponible: $%.2f%n", saldos[indiceCliente]);
                }

                case 2 -> {
                    System.out.println("Monto a depositar:");
                    double montoDeposito = sc.nextDouble();

                    if (montoDeposito > 0) {

                        saldos[indiceCliente] += montoDeposito;

                        System.out.printf(
                                "Depósito exitoso. Saldo actual: $%.2f%n",
                                saldos[indiceCliente]);

                    } else {
                        System.out.println(
                                "El depósito debe ser mayor a cero.");
                    }
                }

                case 3 -> {
                    System.out.println("Monto a retirar:");
                    double montoRetiro = sc.nextDouble();

                    if (montoRetiro <= 0) {

                        System.out.println(
                                "El retiro debe ser mayor a cero.");

                    } else if (montoRetiro <= saldos[indiceCliente]) {

                        saldos[indiceCliente] -= montoRetiro;

                        System.out.printf(
                                "Retiro exitoso. Saldo actual: $%.2f%n",
                                saldos[indiceCliente]);

                    } else {

                        System.out.println(
                                "Saldo insuficiente.");
                    }
                }

                case 4 -> {

                    // Transferencias entre clientes
                    System.out.println(
                            "\n===== CLIENTES DISPONIBLES =====");

                    for (int i = 0; i < nombres.length; i++) {

                        if (i != indiceCliente) {
                            System.out.println(
                                    "Número: " + (i + 1)
                                            + " | Nombre: " + nombres[i]);
                        }
                    }

                    System.out.println(
                            "Ingresa el número del cliente destino:");

                    int numeroDestino = sc.nextInt();

                    // Validar que el número destino exista
                    if (numeroDestino < 1
                            || numeroDestino > nombres.length) {

                        System.out.println(
                                "Error: el cliente destino no existe.");

                    } else {

                        int indiceDestino = numeroDestino - 1;

                        // Evitar transferencias a la misma cuenta
                        if (indiceDestino == indiceCliente) {

                            System.out.println(
                                    "No puedes transferir a tu propia cuenta.");

                        } else {

                            System.out.println(
                                    "Destinatario: "
                                            + nombres[indiceDestino]);

                            System.out.println(
                                    "Monto a transferir:");

                            double montoTransferencia = sc.nextDouble();

                            if (montoTransferencia <= 0) {

                                System.out.println(
                                        "El monto debe ser mayor a cero.");

                            } else if (montoTransferencia > saldos[indiceCliente]) {

                                System.out.println(
                                        "Saldo insuficiente para transferir.");

                            } else {

                                // Actualizar ambas cuentas
                                saldos[indiceCliente] -= montoTransferencia;

                                saldos[indiceDestino] += montoTransferencia;

                                System.out.println(
                                        "\nTransferencia realizada con éxito.");

                                System.out.println(
                                        "Origen: "
                                                + nombres[indiceCliente]);

                                System.out.println(
                                        "Destino: "
                                                + nombres[indiceDestino]);

                                System.out.printf(
                                        "Importe: $%.2f%n",
                                        montoTransferencia);

                                System.out.printf(
                                        "Tu nuevo saldo: $%.2f%n",
                                        saldos[indiceCliente]);

                                System.out.printf(
                                        "Saldo de %s: $%.2f%n",
                                        nombres[indiceDestino],
                                        saldos[indiceDestino]);
                            }
                        }
                    }
                }

                case 5 -> System.out.println(
                        "Gracias por usar INNBANK. Vuelva pronto.");

                default -> System.out.println(
                        "Opción inválida. Elige una opción del 1 al 5.");
            }
        } while (opcionMenu != 5);
        sc.close();
    }
}