package LaLiga;
//este programa partirá de 14 equipos por lo que la liga va a tener 7 encuentros por jornada de liga
//generará para cada jornada de liga una combinación diferente de partidos que será el "producto cartesiano" de la
//mitad de los equipos con la otra mitad
public class Main {
//estos son los 14 equipos que forman mi liga
    public static String [] equipos={"Sevilla", "Betis", "Cádiz","Málaga", "Valencia","Bilbao", "Madrid","Barcelona",
    "Celta", "Murcia", "Coruña", "Granada", "Córdoba", "Jaén"};
    public static int[][] jornadas;
    public static Clasificacion[] clasificacion =new Clasificacion[14];

    public static void main(String[] args) {
    jornadas=Metodo.formarJornadas(equipos);
    Metodo.ordenarJornadas(jornadas);//ordenamos la tabla anterior por número de jornada
    clasificacion=Metodo.pedirResultados(jornadas,equipos);

    }

}
