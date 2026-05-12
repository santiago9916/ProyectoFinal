import java.util.ArrayList;
import java.util.List;

public class NodoArbol {
    private Object data;
    private List<NodoArbol> hijos;

    public NodoArbol(Object data) {
        this.data = data;
        this.hijos = new ArrayList<>();
    }

    public void addHijo(NodoArbol hijo) {
        hijos.add(hijo);
    }

    public Object getData() { return data; }
    public List<NodoArbol> getHijos() { return hijos; }

    public void mostrar(String prefijo) {
        System.out.println(prefijo + data.toString());
        for (NodoArbol hijo : hijos) {
            hijo.mostrar(prefijo + "   ");
        }
    }
}
