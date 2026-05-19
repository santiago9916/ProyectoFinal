package proyectofinaled1;

public class PostTree {

    public NodoArbol contenidoRaiz;

    /*Atributo contenidoraiz de tipo NodoArbol*/

    public PostTree(Publicacion p) { // constructor del atributo contenidoraiz
        this.contenidoRaiz = new NodoArbol(p);
    }

    //metodo para buscar un nodno por su id, llama al recursivo
    public NodoArbol buscarNodo(int id) {
        return buscarRecursivo(contenidoRaiz, id);
    }

    public NodoArbol buscarRecursivo(NodoArbol p, int id) {
        if (p == null) {
            return null;
        }
        if (p.getId() == id) {
            return p;
        }

        for (NodoArbol hijo : p.getHijos()) {
            NodoArbol encontrado = buscarRecursivo(hijo, id);
            if (encontrado != null) {
                return encontrado;
            }
        }
        return null;
    }
    //-----------------------------------------------------------

    public void agregarComentario(int idPadre, Comentario c) { //Agrega un comentario (hijo) a un nodo padre 
        NodoArbol padre = buscarNodo(idPadre);
        /*Busca un nodo con id padre*/

        if (padre != null) {
            /* Si lo encuentra*/
            NodoArbol nuevoComentario = new NodoArbol(c);
            padre.agregarHijo(nuevoComentario);
            System.out.println("Comentario agregado correctamente");
        } else {
            System.out.println("No se encontró el nodo padre con esa ID" + idPadre);
        }
    }

    void mostrarInOrden() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
