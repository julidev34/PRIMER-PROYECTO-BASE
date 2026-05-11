package src;

import java.util.ArrayList;

public class Partido {

    private ArrayList<EquipoPartido> equipos = new ArrayList<>();
    //equipos[0] es equipo 1, equipos[1] es equipo 2
    private int golesEq1;
    private int golesEq2;

    public Partido(EquipoPartido eq1, EquipoPartido eq2, int golesEq1, int golesEq2){        
        this.equipos.add(eq1);
        this.equipos.add(eq2);
        this.golesEq1 = golesEq1;
        this.golesEq2 = golesEq2;
    }

    public int getEquipo1(){
        return equipos.get(0).getId();
    }

    public int getEquipo2(){
        return equipos.get(1).getId();
    }

    public int getGolesEq1(){
        return this.golesEq1;
    }

    public int getGolesEq2(){
        return this.golesEq2;
    }

    public void printRes(){
        if (golesEq1 > golesEq2){
            System.out.println("Gano: " + equipos.get(0));
        } 
        else if (golesEq1 < golesEq2){
            System.out.println("Gano: " + equipos.get(1));
        } else {
            System.out.println("Empataron");
        }
    }

}
