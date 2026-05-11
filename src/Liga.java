package src;

import java.util.ArrayList;

public class Liga {
    private ArrayList<EquipoPartido> equipos;
    private ArrayList<Jugador> jugadores;
    private ArrayList<Partido> partidos;
    
    public Liga(){
        this.equipos = new ArrayList<>();
        this.jugadores = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void crearJugador(String name, int age, String pos){
        Jugador j = new Jugador(name, age, pos); 
        jugadores.add(j);
    }

    public void crearEquipo(String name){
        EquipoPartido e = new EquipoPartido(name);
        equipos.add(e);
    }

    public void crearPartido(EquipoPartido eq1, EquipoPartido eq2, int golesEq1, int golesEq2){
        Partido p = new Partido(eq1, eq2, golesEq1, golesEq2);
        partidos.add(p);
        eq1.agregaPartido(p);
        eq2.agregaPartido(p);
    }

    public Jugador buscarJugadorPorId(int id){
        for (Jugador j : jugadores){
            if (j.getId() == id){
                System.out.println("El jugador con ID = " + id + " es " + j.getName());
                return j;
            }
        }
        System.out.println("No existe un jugador con ese ID");
        return null;
    }

    public EquipoPartido buscarEquipoPorId(int id){
        for (EquipoPartido e : equipos){
            if (e.getId() == id){
                System.out.println("El equipo con ID = " + id + " es " + e.getName());
                return e;
            }
        }
        System.out.println("No existe un equipo con ese ID");
        return null;
    }


}
