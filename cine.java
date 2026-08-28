import java.util.Scanner;
import java.time.LocalDate;

public class cine {

    static int numeroFactura = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n================================");
            System.out.println("       CINE UNIVERSITARIO");
            System.out.println("================================");
            System.out.println("1. Consultar precios");
            System.out.println("2. Comprar entradas");
            System.out.println("3. Salir");
            System.out.print("Elige una opcion: ");

            opcion = scanner.nextInt();

            switch (opcion) {

                case 1:
                    System.out.println("\n========== PRECIOS ==========");
                    System.out.println("1. Formato 2D   -> $5.00");
                    System.out.println("2. Formato 3D   -> $7.50");
                    System.out.println("3. Formato IMAX -> $10.00");
                    break;

                case 2:
                    comprarEntradas(scanner);
                    break;

                case 3:
                    System.out.println("\nGracias por utilizar el Cine Universitario.");
                    break;

                default:
                    System.out.println("\nOpcion invalida.");

            }

        } while (opcion != 3);

        scanner.close();
    }


    public static void comprarEntradas(Scanner scanner) {

      

scanner.nextLine();

System.out.println("\n========== DATOS DEL CLIENTE ==========");


System.out.print("Nombre completo: ");
String nombre = scanner.nextLine();




String cedula;

while (true) {

    System.out.print("Cedula (10 digitos): ");
    cedula = scanner.nextLine();

    
    if (cedula.matches("\\d{10}")) {

        break;

    } else {

        System.out.println("ERROR: La cedula debe tener exactamente 10 digitos.");
        System.out.println("No se permiten letras ni menos/más de 10 digitos.");
    }
}



String correo;

while (true) {

    System.out.print("Correo electronico: ");
    correo = scanner.nextLine();

    // Verifica que tenga @ y un punto
    if (correo.contains("@") && correo.contains(".")) {

        break;

    } else {

        System.out.println("ERROR: El correo debe contener '@' y '.'.");
        System.out.println("Ejemplo: usuario@gmail.com");
    }
}


        

        int formato;
        int edad;
        int cantidad;
        int dia;
        char estudiante;

        double precio = 0;

        System.out.println("\n========== DATOS DE LA ENTRADA ==========");

        System.out.println("1. 2D  - $5.00");
        System.out.println("2. 3D  - $7.50");
        System.out.println("3. IMAX - $10.00");

        System.out.print("Seleccione el formato: ");
        formato = scanner.nextInt();

       
        if (formato == 1) {

            precio = 5.00;

        } else if (formato == 2) {

            precio = 7.50;

        } else if (formato == 3) {

            precio = 10.00;

        } else {

            System.out.println("Formato invalido.");
            return;
        }


        
        System.out.print("Ingrese la edad: ");
        edad = scanner.nextInt();

        if (edad < 0 || edad > 120) {

            System.out.println("Edad fuera del rango permitido.");
            return;
        }


        System.out.print("Cantidad de entradas: ");
        cantidad = scanner.nextInt();

        if (cantidad <= 0) {

            System.out.println("La cantidad debe ser mayor que 0.");
            return;
        }



        System.out.println("\nDias de la semana:");
        System.out.println("1. Lunes");
        System.out.println("2. Martes");
        System.out.println("3. Miercoles");
        System.out.println("4. Jueves");
        System.out.println("5. Viernes");
        System.out.println("6. Sabado");
        System.out.println("7. Domingo");

        System.out.print("Seleccione el dia: ");
        dia = scanner.nextInt();

        if (dia < 1 || dia > 7) {

            System.out.println("Dia invalido.");
            return;
        }


       
        System.out.print("Es estudiante? (S/N): ");
        estudiante = scanner.next().toUpperCase().charAt(0);


     

        double subtotal = precio * cantidad;
        double descuento = 0;
        double recargo = 0;


        

        // R3 - Edad >= 65
        if (edad >= 65) {

            descuento = subtotal * 0.30;

            System.out.println("\nR3 aplicada: 30% de descuento.");
        }

        
        else if (edad >= 11) {

            descuento = subtotal * 0.20;

            System.out.println("\nR4 aplicada: 20% de descuento.");
        }

        
        else if (estudiante == 'S' && dia >= 1 && dia <= 5) {

            descuento = subtotal * 0.15;

            System.out.println("\nR5 aplicada: 15% de descuento.");
        }

        else if (dia == 3) {

            descuento = subtotal * 0.10;

            System.out.println("\nR6 aplicada: 10% de descuento.");
        }

        
        else {

            descuento = 0;

            System.out.println("\nNo se aplica descuento.");
        }


      

        double totalDescuento = subtotal - descuento;


     

        if ((dia == 6 || dia == 7) && formato == 3) {

            recargo = totalDescuento * 0.10;

            System.out.println("R7 aplicada: 10% de recargo IMAX.");
        }


        double total = totalDescuento + recargo;


     
        boolean combo = false;

        if ((cantidad > 4 && estudiante == 'S') || edad < 11) {

            combo = true;

            System.out.println("R8 aplicada: Combo pequeno de cortesia.");
        }


     

        scanner.nextLine();

        int formaPago;

        System.out.println("\n========== FORMA DE PAGO ==========");
        System.out.println("1. Efectivo");
        System.out.println("2. Tarjeta de credito");

        System.out.print("Seleccione la forma de pago: ");
        formaPago = scanner.nextInt();


        double comision = 0;
        double dineroEntregado = 0;
        double vuelto = 0;
        double totalPagar = total;


      

        if (formaPago == 1) {

            System.out.println("\n========== PAGO EN EFECTIVO ==========");

            System.out.printf("Total a pagar: $%.2f%n", total);

            System.out.print("Dinero entregado por el cliente: $");
            dineroEntregado = scanner.nextDouble();

            if (dineroEntregado < total) {

                System.out.println("\nERROR: El dinero entregado no es suficiente.");
                System.out.printf("Faltan: $%.2f%n", total - dineroEntregado);

                return;
            }

            vuelto = dineroEntregado - total;

        }


       

        else if (formaPago == 2) {

            System.out.println("\n========== PAGO CON TARJETA ==========");

           
            comision = total * 0.05;

            totalPagar = total + comision;

            System.out.printf("Subtotal final: $%.2f%n", total);
            System.out.printf("Comision bancaria 5%%: $%.2f%n", comision);
            System.out.printf("Total con tarjeta: $%.2f%n", totalPagar);

            System.out.println("Pago realizado con tarjeta de credito.");

        }

        else {

            System.out.println("Forma de pago invalida.");
            return;
        }


      

        System.out.println("\n");
        System.out.println("==============================================");
        System.out.println("             CINE UNIVERSITARIO");
        System.out.println("                 FACTURA");
        System.out.println("==============================================");

        System.out.println("Factura N.: " + String.format("%05d", numeroFactura));
        System.out.println("Fecha: " + LocalDate.now());

        System.out.println("----------------------------------------------");

        System.out.println("CLIENTE");
        System.out.println("Nombre : " + nombre);
        System.out.println("Cedula : " + cedula);
        System.out.println("Correo : " + correo);

        System.out.println("----------------------------------------------");

        System.out.println("DETALLE DE LA COMPRA");

        String nombreFormato = "";

        if (formato == 1) {
            nombreFormato = "2D";
        } else if (formato == 2) {
            nombreFormato = "3D";
        } else {
            nombreFormato = "IMAX";
        }

        System.out.println("Formato        : " + nombreFormato);
        System.out.println("Cantidad       : " + cantidad);
        System.out.printf("Precio unitario: $%.2f%n", precio);

        System.out.println("----------------------------------------------");

        System.out.printf("Subtotal       : $%.2f%n", subtotal);
        System.out.printf("Descuento      : $%.2f%n", descuento);
        System.out.printf("Recargo        : $%.2f%n", recargo);

        if (combo) {
            System.out.println("Beneficio      : Combo pequeno de cortesia");
        }

        System.out.println("----------------------------------------------");

        System.out.printf("Total           : $%.2f%n", total);

        if (formaPago == 1) {

            System.out.println("Forma de pago   : EFECTIVO");
            System.out.printf("Entregado       : $%.2f%n", dineroEntregado);
            System.out.printf("Vuelto          : $%.2f%n", vuelto);

        } else {

            System.out.println("Forma de pago   : TARJETA DE CREDITO");
            System.out.printf("Comision 5%%     : $%.2f%n", comision);
            System.out.printf("Total cobrado   : $%.2f%n", totalPagar);
        }

        System.out.println("==============================================");
        System.out.println("       Gracias por su compra");
        System.out.println("==============================================");

        numeroFactura++;
    }
}
