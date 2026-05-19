/*
nodo de la lista doblemente enlazada para el historial de actividad
 */
package proyectofinaled1;

public class NodoDoble {

    String descripcion;
    NodoDoble siguiente;
    NodoDoble anterior; // Eliminé 'anterios'

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public NodoDoble(String descripcion, NodoDoble siguiente, NodoDoble anterior) {
        this.descripcion = descripcion;
        this.siguiente = siguiente;
        this.anterior = anterior;
    }

    public NodoDoble(String descripcion) {
        this.descripcion = descripcion;
    }
}
