package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear Equipo");
            System.out.println("2. Crear Jugador");
            System.out.println("3. Agregar Jugador a Equipo");
            System.out.println("4. Jugar Partido");
            System.out.println("5. Mostrar Estadisticas");
            System.out.println("6. Salir");
            int op = sc.nextInt();
            if (op < 1 || op > 5){
                System.out.println("Fuera de rango de opciones");
                break;
            }
            switch (op){
                case 1:
                    EquipoPartido equipo = new EquipoPartido();
                    ArrayList<EquipoPartido> equipos = new ArrayList<>();
                    equipos.add(equipo);
                    System.out.println("El equipo fue creado, el ID del equipo es " + equipo.getId());

                    break;

                case 2:
                    System.out.println("INGRESE NOMBRE");
                    String name = sc.nextLine();
                    System.out.println("INGRESE EDAD");
                    int edad = sc.nextInt();
                    System.out.println("INGRESE POSICION: DELANTERO, MEDIOCAMPISTA, DEFENSA O ARQUERO");
                    String pos = sc.nextLine();

                    Jugador jugador = new Jugador(name, edad, pos);
                    ArrayList<EquipoPartido> jugadores = new ArrayList<>();
                    System.out.println("El jugador fue creado con ID " + jugador.getId());
                    break;
                
                case 3:


            }


        }
    }

}
