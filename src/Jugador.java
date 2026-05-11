package src;

public class Jugador {
    
    private String name;
    private int age;
    private int id;
    private static int contadorIds;
    private EstadisticaJugador estadistica;
    private String pos;
    private EquipoPartido equipo;

    public Jugador(String name, int age, String pos){
        this.name = name;
        this.age = age;
        this.id = contadorIds;
        this.contadorIds++;
        this.estadistica = new EstadisticaJugador();
        this.pos = pos;
    }
   
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public int getId(){
        return this.id;
    }

    public String getPos(){
        return this.pos;
    }

    public EstadisticaJugador getEstadisticaJugador(){
        return this.estadistica;
    }

    public void printInfo(){
        System.out.println("El " + this.pos + " " + this.name + " tiene estas estadisticas:");
        System.out.println(estadistica.getGoles() + " goles");
        System.out.println("En " + estadistica.getPartidos() + " partidos");
        System.out.println("Con una puntuacion general de " + estadistica.getPuntuacionGeneral() + "/10");
    }   

    public void setAge(int newAge){
        this.age = newAge;
    } 

    public void setPos(String newPos){
        this.pos = newPos;
    }    
    

    public EquipoPartido getEquipo(){
        return this.equipo;
    }

    public void setEquipo(EquipoPartido eq){
        if (this.getEquipo() == null){    
            this.equipo = eq;
        }
    }
    

}
