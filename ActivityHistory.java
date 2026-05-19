package proyectofinaled1;

/*
registra el historial de actividades de un usuario usando una Lista Doblemente enlazada
 */
import java.util.ArrayList;
import java.util.List;

public class ActivityHistory {

    private NodoDoble cabeza;
    private NodoDoble cola;

    /*
    Cada nodo guarda
    #descripcion
    #nodo siguiente
    #nodo anterior
     */
    public void registrarActividad(String desc) {
        NodoDoble nuevo = new NodoDoble(desc);
        if (cabeza == null) {
            cabeza = cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            nuevo.anterior = cola;
            cola = nuevo;
        }
    }

    /*
        List<>:DEVUELVE LAS ULTIMAS ACTIVIDADES
     */
    public List<String> obtenerUltimasActividades(int n) {
        /*
        List<>:LA LISTA GUARDA LOS RESULTADOS
         */
        List<String> actividades = new ArrayList<>();
        NodoDoble actual = cola;
        while (actual != null && actividades.size() < n) {
            actividades.add(actual.descripcion);
            actual = actual.anterior;
        }
        return actividades;
    }
}
