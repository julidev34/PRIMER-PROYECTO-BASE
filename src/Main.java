package src;

public class Main {
    
    public static void main(String[] args){
        
        Jugador j1 = new Jugador("Messi",36, "delantero");
        Jugador j2 = new Jugador("Ronaldo", 40, "delantero");
        Jugador j3 = new Jugador("Andres Santos", 32, "defensa");
        j3.getId();



        EquipoPartido a = new EquipoPartido();
        EquipoPartido b = new EquipoPartido();
        a.nuevoJugador(j3);
        a.nuevoJugador(j1);
        b.nuevoJugador(j2);
        j1.printInfo();
        j2.printInfo();
        j3.printInfo();
        System.out.println("ID equipo a: " + a.getId());
        System.out.println("ID equipo b: " + b.getId());
        System.out.println("a tiene " + a.cantJugadores() + " jugadores");
        System.out.println("b tiene " + b.cantJugadores() + " jugadores");
        System.out.println("El promedio de edad del equipo a es: " + a.promedioEdad());
        System.out.println("El equipo a hizo " + a.cantGoles() + " en " + a.getPJ() + " partidos");

        //se podria crear una clase Organizador que haga el partido, para no hacerlo desde un equipo
        a.nuevoPartido(b, 3, 1);
        b.nuevoPartido(a, 5, 2);


        System.out.println("El equipo a hizo " + a.cantGoles() + " en " + a.getPJ() + " partidos");
        System.out.println("El equipo b hizo " + b.cantGoles() + " en " + b.getPJ() + " partidos");
        j1.printInfo();
        j2.printInfo();
        j3.printInfo();

        System.out.println(a.getPG());
    }

}
