package LaLiga;

public class Metodo {


    public static int[][] formarJornadas(String[] equipos) {
        int[][] jornadas = new int[98][3];//son 48 partidos de ida y 48 de vuelta
        boolean finLista = false;
        int jornada = 0, k = 0;
        //combinamos la primera mitad de la lista con la segunda mitad
        for (int i = 0; i < equipos.length / 2; i++) {
            jornada = 0;
            for (int j = equipos.length / 2; j < equipos.length; j++) {
                jornada++;
                jornadas[k][0] = jornada;//jornada
                jornadas[k][1] = i;//equipo local
                jornadas[k][2] = j;//equipo visitante
                k++;
            }
        }
        //hacemos la combinación contraria segunda mitad de la lista con la primera mitad
        for (int i = equipos.length / 2; i < equipos.length; i++) {
            jornada++;
            for (int j = 0; j < equipos.length / 2; j++) {
                jornadas[k][0] = jornada;//jornada
                jornadas[k][1] = i;//equipo local
                jornadas[k][2] = j;//equipo visitante
                k++;
            }
        }
        for (int i = 0; i < jornadas.length; i++) {
            System.out.print(
                    jornadas[i][0] + " ");
            System.out.print(jornadas[i][1] + " ");
            System.out.println(jornadas[i][2] + " ");

        }
        return jornadas;
    }

    public static Clasificacion[] pedirResultados(int[][] jornadas, String[] equipos) {
        Clasificacion[] clasificacion = new Clasificacion[14];
        boolean mismaJornada = true;
        int jornada = 1, i = 0;
        do {
            System.out.println("Introduza los resultados de la jornada " + jornada);
            do {
                System.out.println("Introduza los resultados del partido " + equipos[jornadas[i][1]] + "-"
                        + equipos[jornadas[i][2]]);
                i++;
                if (i < jornadas.length) {
                    if (jornada != jornadas[i][0]) {
                        mismaJornada = false;
                        jornada = jornadas[i][0];
                    }
                }
            } while (mismaJornada && i < jornadas.length);
        } while (i < jornadas.length);

        return clasificacion;
    }

    public static void ordenarJornadas(int[][] jornadas) {
        int minimo = 0;
        int[] aux = new int[3];
        for (int i = 0; i < jornadas.length - 1; i++) {
            minimo = i;
            for (int j = i + 1; j < jornadas.length; j++) {
                if (jornadas[j][0] < jornadas[minimo][0]) {
                    minimo = j;
                }
            }
            if (minimo != i) {
                aux[0] = jornadas[i][0];
                aux[1] = jornadas[i][1];
                aux[2] = jornadas[i][2];
                jornadas[i][0] = jornadas[minimo][0];
                jornadas[i][1] = jornadas[minimo][1];
                jornadas[i][2] = jornadas[minimo][2];
                jornadas[minimo][0] = aux[0];
                jornadas[minimo][1] = aux[1];
                jornadas[minimo][2] = aux[2];
            }
        }
    }
}
