package src;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipoPartido {

    private int idTeam;
    private static int contadorIds = 1;
    private ArrayList<Partido> partidos = new ArrayList<>();
    private ArrayList<Jugador> jugadores = new ArrayList<>();

    public EquipoPartido(){
        this.idTeam = contadorIds;
        this.contadorIds++;
    }

    public void printJugadores(){
        System.out.println("Los jugadores del equipo : " + idTeam);
        for (Jugador j : jugadores){
            System.out.println(j);
        }
    }


    public int getId(){
        return this.idTeam;
    }

    public int cantJugadores(){
        return jugadores.size();
    }

    public void nuevoPartido(EquipoPartido eq2, int golesEq1, int golesEq2){
        Partido nuevo = new Partido(this, eq2, golesEq1, golesEq2);
        partidos.add(nuevo);
        eq2.partidos.add(nuevo);
        for (Jugador j : this.jugadores){
                
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese goles de " + j.getName());
            int golesJugador = sc.nextInt();
            
            System.out.println("Ingrese puntuacion de " + j.getName());
            int puntJugador = sc.nextInt();

            j.getEstadisticaJugador().actualizarEst(golesJugador, puntJugador);
        }
        for (Jugador j : eq2.jugadores){
                
            Scanner sc = new Scanner(System.in);
            System.out.println("Ingrese goles de " + j.getName());
            int golesJugador = sc.nextInt();
            
            System.out.println("Ingrese puntuacion de " + j.getName());
            int puntJugador = sc.nextInt();

            j.getEstadisticaJugador().actualizarEst(golesJugador, puntJugador);
        }
    }

    public void nuevoJugador(Jugador j){
        if (cantJugadores() < 5){
            jugadores.add(j);
            j.setEquipo(this);
        }
    }

    public int getPJ(){
        return partidos.size();
    }

    public int getPG(){
        int total = 0;
        for (Partido p : partidos){
            if (p.getEquipo1() == this.idTeam  && p.getGolesEq1() > p.getGolesEq2()){
                total += 1;
            } 
            else if (p.getEquipo2() == this.idTeam && p.getGolesEq1() < p.getGolesEq2()){
                total += 1;
            } 
        }
        return total;
    }

    public int getPP(){
        int total = 0;
        for (Partido p : partidos){
            if (p.getEquipo1() == this.idTeam && p.getGolesEq1() < p.getGolesEq2()){
                total += 1;
            } 
            else if (p.getEquipo2() == this.idTeam && p.getGolesEq1() > p.getGolesEq2()){
                total += 1;
            } 
        }
        return total;
    }

    public int getPE(){
        int total = 0;
        for (Partido p : partidos){
            if (p.getEquipo1() == this.idTeam && p.getGolesEq1() == p.getGolesEq2()){
                total += 1;
            } 
            else if (p.getEquipo2() == this.idTeam && p.getGolesEq1() == p.getGolesEq2()){
                total += 1;
            } 
        }
        return total;
    }

    public float promedioEdad(){
        int total = 0;
        for (Jugador j : jugadores){
            total += j.getAge();
        }
        return total / jugadores.size();
    }

    public int cantGoles(){
        int total = 0;
        for (Jugador j : jugadores){
            total += j.getEstadisticaJugador().getGoles();
        }
        return total;
    }
}
