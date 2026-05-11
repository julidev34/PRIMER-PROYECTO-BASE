package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        

        Scanner sc = new Scanner(System.in);
        Liga liga = new Liga();
        boolean sigue = true;
        while (sigue) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Crear Jugador");
            System.out.println("3. Agregar Jugador a Equipo");
            System.out.println("4. Jugar Partido");
            System.out.println("5. Mostrar Estadisticas");
            System.out.println("6. Salir");
            int op = sc.nextInt();
            sc.nextLine();
            if (op < 1 || op > 6){
                System.out.println("Fuera de rango de opciones");
                continue;
            }
            switch (op){
                case 1:
                    System.out.println("INGRESE NOMBRE DEL EQUIPO");
                    String e = sc.nextLine();
                    
                    liga.crearEquipo(e);
                    
                    break;

                case 2:
                    System.out.println("INGRESE NOMBRE");
                    String name = sc.nextLine();
                    System.out.println("INGRESE EDAD");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.println("INGRESE POSICION: DELANTERO, MEDIOCAMPISTA, DEFENSA O ARQUERO");
                    String pos = sc.nextLine();

                    liga.crearJugador(name, edad, pos);

                    break;
                    
                
                case 3:

                System.out.println("JUGADORES DISPONIBLES: ");
                liga.mostrarJugadores();

                System.out.println("JUGADOR ELEGIDO (ID): ");
                int idJ = sc.nextInt();
                sc.nextLine();
                Jugador j = liga.buscarJugadorPorId(idJ);
                
                if (j == null){
                    System.out.println("Ese ID no pertenece a ningun jugador");
                    continue;
                }

                System.out.println("EQUIPOS DISPONIBLES");
                liga.mostrarEquipos();

                System.out.println("EQUIPO ELEGIDO (ID): ");
                int idEq = sc.nextInt();
                sc.nextLine();
                EquipoPartido p = liga.buscarEquipoPorId(idEq);

                if (p == null){
                    System.out.println("Ese ID no pertenece a ningun equipo");
                    continue;
                }

                liga.agregarJugadorAEquipo(j, p);
                System.out.println(j.getName() + " fue agregado a " + p.getName());

                break;

                case 4:
                    System.out.println("EQUIPOS DISPONIBLES");
                    liga.mostrarEquipos();
                    
                    System.out.println("EQUIPO 1 (ID):");
                    int id1 = sc.nextInt();
                    sc.nextLine();
                    EquipoPartido eq1 = liga.buscarEquipoPorId(id1);

                    if (eq1 == null){
                        System.out.println("Ese ID no pertenece a ningun equipo");
                        continue;
                    }

                    System.out.println("GOLES EQUIPO 1 :");
                    int golesEq1 = sc.nextInt();
                    sc.nextLine();

                    
                    System.out.println("EQUIPO 2 (ID):");
                    int id2 = sc.nextInt();
                    sc.nextLine();
                    EquipoPartido eq2 = liga.buscarEquipoPorId(id2);

                    if (eq2 == null){
                        System.out.println("Ese ID no pertenece a ningun equipo");
                        continue;
                    }

                    System.out.println("GOLES EQUIPO 1 :");
                    int golesEq2 = sc.nextInt();
                    sc.nextLine();


                    if (id1 == id2){
                        System.out.println("ELEGISTE EL MISMO EQUIPO");
                        continue;
                    }

                    liga.crearPartido(eq1, eq2, golesEq1, golesEq2);
                    System.out.println("PARTIDO CREADO: ");
                    System.out.println(eq1.getName() + " " + golesEq1 + " - " + eq2.getName() + " " + golesEq2);

                    System.out.println("INGRESE ESTADISTICAS: ");

                    ArrayList<Jugador> jugadoresEq1 = eq1.getJugadores();
                    ArrayList<Jugador> jugadoresEq2 = eq2.getJugadores();
                    for (Jugador j1 : jugadoresEq1){
                        System.out.println(j1.getName());
                        
                        System.out.println("CUANTOS GOLES HIZO?");
                        int g = sc.nextInt();
                        sc.nextLine();

                        System.out.println("COMO PUNTUARIAS SU PARTIDO? (1-10) ");
                        int pts = sc.nextInt();
                        sc.nextLine();

                        j1.getEstadisticaJugador().actualizarEst(g, pts);

                    }
                    for (Jugador j2 : jugadoresEq2){
                        System.out.println(j2.getName());
                        
                        System.out.println("CUANTOS GOLES HIZO?");
                        int g = sc.nextInt();
                        sc.nextLine();

                        System.out.println("COMO PUNTUARIAS SU PARTIDO? (1-10) " );
                        int pts = sc.nextInt();
                        sc.nextLine();

                        j2.getEstadisticaJugador().actualizarEst(g, pts);

                    }

                    break;

                case 5:
                    System.out.println("TABLA DE POSICIONES : ");
                    liga.tablaDePosiciones();

                    System.out.println("EL GOLEADOR ES : ");
                    Jugador goleador = liga.goleador();
                    System.out.println(goleador.getName() + " con " + goleador.getEstadisticaJugador().getGoles());

                    break;
                
                case 6:
                    System.out.println("HASTA LUEGO");
                    sigue = false;
                    break;
            }


        }
    }

}
