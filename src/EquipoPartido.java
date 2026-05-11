package src;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipoPartido {

    private int idTeam;
    private String name;
    private static int contadorIds = 1;
    private ArrayList<Partido> partidos = new ArrayList<>();
    private ArrayList<Jugador> jugadores = new ArrayList<>();

    public EquipoPartido(String name){
        this.idTeam = contadorIds;
        this.contadorIds++;
        this.name = name;
    }

    public void printJugadores(){
        System.out.println("Los jugadores del equipo : " + idTeam);
        for (Jugador j : jugadores){
            System.out.println(j);
        }
    }

    public String getName(){
        return this.name;
    }

    public int getId(){
        return this.idTeam;
    }

    public int cantJugadores(){
        return jugadores.size();
    }

    public void agregaPartido(Partido p){
        partidos.add(p);
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
