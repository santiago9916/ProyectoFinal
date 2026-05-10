/*
registra el historial de actividades de un usuario usando una Lista Doblemente enlazada
*/

import java.util.ArrayList;
import java.util.List;

public class ActivityHistory {
    private NodoDoble cabeza;
    private NodoDoble cola;

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

    public List<String> obtenerUltimasActividades(int n) {
        List<String> actividades = new ArrayList<>();
        NodoDoble actual = cola;
        while (actual != null && actividades.size() < n) {
            actividades.add(actual.descripcion);
            actual = actual.anterior;
        }
        return actividades;
    }
}
