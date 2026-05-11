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

    public void agregarJugadorAEquipo(Jugador j, EquipoPartido e){
        e.nuevoJugador(j);
    }

    public void mostrarPartidosGanados(){
        for (EquipoPartido e : equipos){
            System.out.println(e + " (ID =" + e.getId() + ")" + " gano " + e.getPG() + " de " + e.getPJ() + " partidos jugados");
        }
    }

    public EquipoPartido campeon(){
        int max = 0;
        EquipoPartido c = null;
        for (EquipoPartido e : equipos){
            if (max < e.getPJ()){
                max = e.getPJ();
                c = e;
            }
        }
        return c; 
    }

    public Jugador goleador(){
        int max = 0;
        Jugador goleador = null;
        for (Jugador j : jugadores){
            int golesJ = j.getEstadisticaJugador().getGoles();
            if (golesJ > max){
                max = golesJ;
                goleador = j;
            }
        }
        return goleador;
    }

    public void mostrarEquipos(){
        for (EquipoPartido e : equipos){
            System.out.println(e.getName() + " " + e.getId());
        }
    }

    public void mostrarJugadores(){
        for (Jugador j : jugadores){
            System.out.println(j.getName() + " " + j.getId());
        }
    }  

    public void tablaDePosiciones(){
        ArrayList<EquipoPartido> tabla = equipos;
        tabla.sort((e1, e2) -> e2.getPG() - e1.getPG());
        
        int pos = 1;

        for(EquipoPartido e : equipos){
            
            System.out.println(pos + "° EQUIPO " + e.getId());

            System.out.println(
            "PJ: " + e.getPJ() +
            " | PG: " + e.getPG() +
            " | PE: " + e.getPE() +
            " | PP: " + e.getPP()
            );

            System.out.println("-------------------");

        pos++;
        }
    }

}
