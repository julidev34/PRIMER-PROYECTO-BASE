package src;

import java.util.ArrayList;


public class EstadisticaJugador {

    private int goals;
    private int partidos;
    private ArrayList<Float> puntuacionPartidos;
    private double puntuacionGeneral;

    public EstadisticaJugador(){
        this.goals = 0;
        this.partidos = 0;
        this.puntuacionPartidos = new ArrayList<>();
    }

    public int getGoles(){
        return this.goals;
    }

    public int getPartidos(){
        return this.partidos;
    }

    public ArrayList<Float> getPuntuacionPartidos(){
        return puntuacionPartidos;
    }

    public double getPuntuacionGeneral(){
        return puntuacionGeneral;
    }
    
    private void setEstadisticas(int cantGoles){
        this.goals += cantGoles;
        this.partidos++;
    }

    private void setPuntuacionPartidos(Float puntPartido){
        puntuacionPartidos.add(puntPartido);
    }

    private void setPuntuacionGeneral(){
        float totalPts = 0;
        for (Float pts : puntuacionPartidos){
            totalPts += pts;
        }
        puntuacionGeneral = totalPts / partidos;
    }

    // el jugador jugo un partido, queremos actualizar sus estadisticas 
    public void actualizarEst(int goles, float puntuacionP){
        setEstadisticas(goles);
        setPuntuacionPartidos(puntuacionP);
        setPuntuacionGeneral();
    }

}