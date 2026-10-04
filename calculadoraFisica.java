import java.util.Scanner;

public class calculadoraFisica {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        menuMain();

    }

    static String leer(String mensaje) {
        System.out.print(mensaje);
        return scanner.next();
    }

    static void menuMain() {

        String opcionMenu = "0";
        while (!opcionMenu.equals("3")) {
            System.out.println("\033[H\033[2J");
            System.out.flush();

            System.out.println("""
                    Calculadora de Puntos en Sistemas de Coordenadas
                    Desarrollado por:
                    Hernández Morales Anahí
                    Ibarra Padilla Sebastián
                    Martínez Ruiz Josué Ignacio
                    Román Ruiz María Celeste

                    Todos los derechos reservados

                    Opciones:
                    1. Conversión de puntos
                    2. Cálculo de distancias entre dos puntos
                    3. Salir""");

            System.out.println("¿Qué gusta hacer? Seleccione un número.");
            opcionMenu = scanner.next();

            switch (opcionMenu) {
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    conversion();
                    break;

                case "2":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    distancias();
                    break;

                case "3":
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Gracias por usar nuestra calculadora!.");

                    break;

                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Opción " + opcionMenu + " no disponible (seleccione un número del 1 al 3):");
                    break;
            }

        }

    }

    static void conversion() { // Conversión de puntos

        String opcion = "0";

        while (!opcion.equals("9")) {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("""
                    Sistema para convertir puntos.
                    Seleccione una opción:
                    1. 2D (Cartesiano a Polar)
                    2. 2D (Polar a Cartesiano)
                    3. 3D (SCR a SCC)
                    4. 3D (SCR a SCE)
                    5. 3D (SCC a SCR)
                    6. 3D (SCC a SCE)
                    7. 3D (SCE a SCR)
                    8. 3D (SCE a SCC)
                    9. Volver al menú""");

            System.out.println("Seleccione un número.");
            opcion = scanner.next();
            switch (opcion) {
                case "1":
                    System.out.print("\033[H\033[2J");
                    System.out.flush(); // Conversión 2D cartesiano a polar
                    cartesianoToPolar();
                    break;

                case "2": // Conversión 2D polar a cartesiano
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    polarToCartesiano();
                    break;

                case "3": // Conversión 3D SCR a SCC
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    scrScc();
                    break;

                case "4": // Conversión 3D SCR a SCE
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    scrSce();
                    break;

                case "5": // Conversión 3D SCC a SCR
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    sccScr();
                    break;

                case "6": // Conversión 3D SCC a SCE
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    sccSce();
                    break;

                case "7": // Conversión 3D SCE a SCR
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    sceScr();
                    break;

                case "8": // Conversión 3D SCE a SCC
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    sceScc();
                    break;

                case "9": // Volver al menú
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    break;

                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Opción " + opcion + " no disponible (seleccione una opción del 1 al 9):");
                    break;
            }

        }

    }

    public static void cartesianoToPolar() { // Cartesiano a Polar

        String opc = "s";
        while (opc.equals("s")) {
            double valorX = 0;
            double valorY = 0;
            double valorR = 0;
            double angulo = 0;

            System.out.println("Conversión de Cartesiano a Polar (2D)");

            try {
                valorX = Double.parseDouble(leer("Introduzca el valor de X: "));

                valorY = Double.parseDouble(leer("Introduzca el valor de Y: "));

                valorR = Math.sqrt((Math.pow(valorX, 2) + (Math.pow(valorY, 2))));
                System.out.printf("%s %.2f", "El valor de R es: ", valorR);

                /*
                 * El método .toDegrees convierte de Radianes a Grados,
                 * El método .atan2 es como una versión mejorada de atan,
                 * que considera cuando la x vale 0 y se indefine y/x, solo que los ángulos te
                 * los da negativos.
                 */
                angulo = Math.toDegrees(Math.atan2(valorY, valorX));

                // Si el ángulo es negativo, le sumamos 360 para asegurarnos que sea positivo,
                // siempre se la suma 360 porque el método .atan2 los mide desde el eje x
                // positivo, solo que en sentido contrario.
                if (angulo < 0) {
                    angulo += 360;
                }

                System.out.printf("%s %.2f", "\nEl valor del ángulo es: ", angulo);
                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();

            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }

        }
    }

    public static void polarToCartesiano() { // Polar a Cartesiano

        String opc = "s";
        while (opc.equals("s")) {
            double valorX = 0;
            double valorY = 0;
            double valorR = 0;
            double angulo = 0;

            System.out.println("Conversión de Polar a Cartesiano (2D)");

            try {
                valorR = Double.parseDouble(leer("Introduzca el valor de R: "));
                angulo = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Theta en grados: "));
                angulo = Math.toRadians(angulo);

                valorX = valorR * Math.cos(angulo);
                System.out.printf("%s %.2f", "El valor de X es: ", valorX);

                valorY = valorR * Math.sin(angulo);
                System.out.printf("%s %.2f", "\nEl valor de Y es: ", valorY);

                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();

            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }

        }
    }

    public static void scrScc() { // SCR a SCC

        String opc = "s";
        while (opc.equals("s")) {
            double valorX = 0;
            double valorY = 0;
            double valorZ = 0;
            double valorR = 0;
            double angulo = 0;

            System.out.println("Conversión de SCR a SCC (3D)");
            try {
                valorX = Double.parseDouble(leer("Introduzca el lado en X: "));
                valorY = Double.parseDouble(leer("Introduzca el lado en Y: "));
                valorZ = Double.parseDouble(leer("Introduzca el lado en Z: "));

                valorR = Math.sqrt((Math.pow(valorX, 2) + (Math.pow(valorY, 2))));
                System.out.println("El valor de R es: " + valorR);

                angulo = Math.toDegrees(Math.atan2(valorY, valorX));
                if (angulo < 0) {
                    angulo += 360;
                }

                System.out.printf("%s %.2f", "El valor del ángulo Theta es:", angulo);

                System.out.println("\nEl valor de Z es " + valorZ);

                System.out.println("Otra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }

        }
    }

    public static void scrSce() { // SCR a SCE

        String opc = "s";
        while (opc.equals("s")) {
            double valorX = 0;
            double valorY = 0;
            double valorZ = 0;
            double valorRo = 0;
            double anguloTheta = 0;
            double anguloPhi = 0;

            System.out.println("Conversión de SCR a SCE");
            try {
                valorX = Double.parseDouble(leer("Introduzca el lado en X: "));
                valorY = Double.parseDouble(leer("Introduzca el lado en Y: "));
                valorZ = Double.parseDouble(leer("Introduzca el lado en Z: "));

                valorRo = Math.sqrt((Math.pow(valorX, 2) + (Math.pow(valorY, 2)) + (Math.pow(valorZ, 2))));

                System.out.printf("%s %.2f", "El valor de Rho es: ", valorRo);

                anguloTheta = Math.toDegrees(Math.atan2(valorY, valorX));
                if (anguloTheta < 0) {
                    anguloTheta += 360;
                }
                System.out.printf("%s %.2f", "\nEl valor del ángulo Theta es:", anguloTheta);

                anguloPhi = Math.toDegrees(Math.atan(Math.sqrt((valorX * valorX) + (valorY * valorY)) / valorZ));
                System.out.printf("%s %.2f", "\nEl valor del ángulo Phi es:", anguloPhi);

                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }

        }
    }

    public static void sccScr() { // SCC a SCR

        String opc = "s";
        while (opc.equals("s")) {
            double valorX = 0;
            double valorY = 0;
            double valorZ = 0;
            double valorR = 0;
            double angulo = 0;

            System.out.println("Conversión de SCC a SCR");
            try {
                valorR = Double.parseDouble(leer("Introduzca el valor de R: "));
                angulo = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Theta en grados: "));
                valorZ = Double.parseDouble(leer("Introduzca el valor en Z: "));
                angulo = Math.toRadians(angulo);

                valorX = valorR * Math.cos(angulo);
                System.out.printf("%s %.2f", "El valor de X es: ", valorX);

                valorY = valorR * Math.sin(angulo);
                System.out.printf("%s %.2f", "\nEl valor de Y es: ", valorY);

                System.out.println("\nEl valor de Z es " + valorZ);

                System.out.println("Otra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }

        }
    }

    public static void sccSce() { // SCC a SCE

        String opc = "s";
        while (opc.equals("s")) {
            double valorR = 0;
            double valorZ = 0;
            double valorRo = 0;
            double anguloTheta = 0;
            double anguloPhi = 0;

            System.out.println("Conversión de SCC a SCE");
            try {

                valorR = Double.parseDouble(leer("Introduzca el valor de R: "));
                anguloTheta = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Theta en grados: "));
                valorZ = Double.parseDouble(leer("Introduzca el valor de Z: "));

                valorRo = Math.sqrt((Math.pow(valorR, 2) + (Math.pow(valorZ, 2))));
                System.out.printf("%s %.2f", "El valor de Rho es: ", valorRo);

                System.out.println("\nEl valor del ángulo Theta es " + anguloTheta);

                anguloPhi = Math.toDegrees(Math.atan2(valorR, valorZ));
                if (anguloPhi < 0) {
                    anguloPhi += 360;
                }

                System.out.printf("%s %.2f", "El valor del ángulo Phi es: ", anguloPhi);

                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }
        }
    }

    public static void sceScr() { // SCE a SCR

        String opc = "s";
        while (opc.equals("s")) {
            double valorX = 0;
            double valorY = 0;
            double valorZ = 0;
            double valorRo = 0;
            double anguloTheta = 0;
            double anguloPhi = 0;

            System.out.println("Conversión de SCE a SCR");
            try {
                valorRo = Double.parseDouble(leer("Introduzca el valor de Rho: "));
                anguloTheta = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Theta en grados: "));
                anguloPhi = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Phi en grados: "));
                anguloTheta = Math.toRadians(anguloTheta);
                anguloPhi = Math.toRadians(anguloPhi);

                valorX = valorRo * Math.sin(anguloPhi) * Math.cos(anguloTheta);
                System.out.printf("%s %.2f", "El valor de X es: ", valorX);

                valorY = valorRo * Math.sin(anguloPhi) * Math.sin(anguloTheta);
                System.out.printf("%s %.2f", "\nEl valor de Y es: ", valorY);

                valorZ = valorRo * Math.cos(anguloPhi);
                System.out.printf("%s %.2f", "\nEl valor de Z es: ", valorZ);

                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }

        }
    }

    public static void sceScc() { // SCE a SCC

        String opc = "s";
        while (opc.equals("s")) {
            double valorR = 0;
            double valorZ = 0;
            double valorRo = 0;
            double anguloTheta = 0;
            double anguloPhi = 0;

            System.out.println("Conversión de SCE a SCC");
            try {
                valorRo = Double.parseDouble(leer("Introduzca el valor de Rho: "));
                anguloTheta = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Theta en grados: "));
                anguloPhi = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Phi en grados: "));
                anguloPhi = Math.toRadians(anguloPhi);

                valorR = valorRo * Math.sin(anguloPhi);
                System.out.printf("%s %.2f", "\nEl valor de R es:", valorR);

                System.out.println("\nEl valor del ángulo theta es: " + anguloTheta);

                valorZ = valorRo * Math.cos(anguloPhi);
                System.out.printf("%s %.2f", "El valor de Z es:", valorZ);

                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }

        }
    }

    // Aquí acaban las conversiones

    static void distancias() {
        String opcion = "0";

        while (!opcion.equals("6")) {
            System.out.println("\033[H\033[2J");
            System.out.flush();
            System.out.println("""
                    Sistema para obtener distancias.
                    Seleccione una opción:
                    1. 2D (Cartesiano)
                    2. 2D (Polares)
                    3. 3D (SCR)
                    4. 3D (SCC)
                    5. 3D (SCE)
                    6. Volver al menú""");

            System.out.println("Seleccione un número.");
            opcion = scanner.next();
            switch (opcion) {
                case "1": // Distancia en Cartesiano
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    distCart();
                    break;

                case "2": // Distancia en Polares
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    distPol();
                    break;

                case "3": // Distancia 3D SCR
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    distSCR();
                    break;

                case "4": // Distancia 3D SCC
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    distSCC();
                    break;

                case "5": // Distancia 3D SCE
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    distSCE();
                    break;

                case "6": // Menú
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    break;

                default:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Opción " + opcion + " no disponible (seleccione una opción del 1 al 9):");
                    break;
            }

        }
    }

    static void distCart() {
        String opc = "s";
        while (opc.equals("s")) {
            double x1, x2;
            double y1, y2;

            double distancia;
            System.out.println("Distancia entre dos puntos Cartesianos");
            try {
                x1 = Double.parseDouble(leer("Introduzca el valor de X1: "));
                y1 = Double.parseDouble(leer("Introduzca el valor de Y1: "));

                System.out.println();
                x2 = Double.parseDouble(leer("Introduzca el valor de X2: "));
                y2 = Double.parseDouble(leer("Introduzca el valor de Y2: "));

                distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

                System.out.printf("%s %.2f", "La distancia entre los puntos es: ", distancia);
                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }
        }
    }

    static void distSCR() {
        String opc = "s";
        while (opc.equals("s")) {
            double x1, x2;
            double y1, y2;
            double z1, z2;
            double distancia;
            System.out.println("Distancia entre dos puntos en SCR");
            try {
                x1 = Double.parseDouble(leer("Introduzca el valor de X1: "));
                y1 = Double.parseDouble(leer("Introduzca el valor de Y1: "));
                z1 = Double.parseDouble(leer("Introduzca el valor de Z1: "));

                System.out.println();
                x2 = Double.parseDouble(leer("Introduzca el valor de X2: "));
                y2 = Double.parseDouble(leer("Introduzca el valor de Y2: "));
                z2 = Double.parseDouble(leer("Introduzca el valor de Z2: "));

                distancia = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));

                System.out.printf("%s %.2f", "La distancia entre los puntos es: ", distancia);
                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }
        }
    }

    static void distPol() {

        String opc = "s";
        while (opc.equals("s")) {
            double r1, r2;
            double t1, t2;

            double distancia;
            System.out.println("Distancia entre dos puntos en Polares");
            try {
                r1 = Double.parseDouble(leer("Introduzca el valor de r1: "));
                t1 = Double.parseDouble(leer("Introduzca el valor del ángulo Theta1 en grados: "));

                System.out.println();
                r2 = Double.parseDouble(leer("Introduzca el valor de r2: "));
                t2 = Double.parseDouble(leer("Introduzca el valor del ángulo Theta2 en grados: "));

                t1 = Math.toRadians(t1);
                t2 = Math.toRadians(t2);

                distancia = Math.sqrt(Math.pow(r1, 2) + Math.pow(r2, 2) - (2 * r1 * r2 * Math.cos(t2 - t1)));
                System.out.printf("%s %.2f", "La distancia entre los puntos es: ", distancia);
                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }
        }
    }

    static void distSCC() {

        String opc = "s";
        while (opc.equals("s")) {
            double r1, r2;
            double t1, t2;
            double z1, z2;
            double distancia;
            System.out.println("Distancia entre dos puntos en SCC");
            try {
                r1 = Double.parseDouble(leer("Introduzca el valor de r1: "));
                t1 = Double.parseDouble(leer("Introduzca el valor del ángulo Theta1 en grados: "));
                z1 = Double.parseDouble(leer("Introduzca el valor de Z1: "));

                r2 = Double.parseDouble(leer("Introduzca el valor de r2: "));
                t2 = Double.parseDouble(leer("Introduzca el valor del ángulo Theta2 en grados: "));
                z2 = Double.parseDouble(leer("Introduzca el valor de Z2: "));

                t1 = Math.toRadians(t1);
                t2 = Math.toRadians(t2);

                distancia = Math
                        .sqrt(Math.pow(r1, 2) + Math.pow(r2, 2) - (2 * r1 * r2 * Math.cos(t2 - t1))
                                + Math.pow(z2 - z1, 2));
                System.out.printf("%s %.2f", "La distancia entre los puntos es: ", distancia);
                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }
        }
    }

    static void distSCE() {

        String opc = "s";
        while (opc.equals("s")) {
            double anguloTheta1 = 0, anguloTheta2 = 0;
            double anguloPhi1, anguloPhi2;
            double rho1, rho2;
            double distancia;
            System.out.println("Distancia entre dos puntos en SCE");
            try {
                System.out.println("Coordenadas del punto 1");
                rho1 = Double.parseDouble(leer("Introduzca el valor de Rho: "));
                anguloTheta1 = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Theta en grados: "));
                anguloPhi1 = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Phi en grados: "));

                anguloTheta1 = Math.toRadians(anguloTheta1);
                anguloPhi1 = Math.toRadians(anguloPhi1);

                System.out.println("\nCoordenadas del punto 2:");

                rho2 = Double.parseDouble(leer("Introduzca el valor de Rho: "));
                anguloTheta2 = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Theta en grados: "));
                anguloPhi2 = Double
                        .parseDouble(leer("Introduzca el valor del ángulo Phi en grados: "));
                anguloTheta2 = Math.toRadians(anguloTheta2);
                anguloPhi2 = Math.toRadians(anguloPhi2);

                distancia = Math.sqrt((Math.pow(rho2, 2) + Math.pow(rho1, 2))
                        - (2 * rho1 * rho2 * ((Math.cos(anguloPhi1) * Math.cos(anguloPhi2))
                                + (Math.sin(anguloPhi1) * Math.sin(anguloPhi2)
                                        * Math.cos(anguloTheta2 - anguloTheta1)))));
                System.out.printf("%s %.2f", "La distancia entre los puntos es: ", distancia);
                System.out.println("\nOtra vez s/n: ");
                opc = scanner.next();
            } catch (NumberFormatException e) {
                System.out.println("Error, debe introducir un número.\n");
            }
        }

    }

}