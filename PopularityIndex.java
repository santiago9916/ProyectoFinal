/*
almacena la popularidad de una publicacion
 */
package proyectofinaled1;

import java.util.ArrayList;
import java.util.List;

public class PopularityIndex {

    private NodoAVL raiz; //raiz de tipo NodoAVL

    /**
     * Inserta o actualiza la popularidad de una publicación. Si ya existe, la
     * elimina y la reinserta con la nueva popularidad.
     *
     * @param pubId ID de la publicación.
     * @param pop Nuevo valor de popularidad.
     */
    public void actualizarPopularidad(int pubId, int pop) {
        // Primero, eliminar el nodo antiguo si existe (búsqueda por pubId)
        raiz = eliminarPorPublicacionId(raiz, pubId);
        // Luego insertar con la nueva popularidad
        raiz = insertar(raiz, pubId, pop);
    }

    // Inserta un nodo en el AVL balanceado (ordenado por popularidad)
    private NodoAVL insertar(NodoAVL nodo, int pubId, int pop) {
        if (nodo == null) {
            return new NodoAVL(pubId, pop);
        }

        if (pop < nodo.popularidad) {
            nodo.izquierdo = insertar(nodo.izquierdo, pubId, pop);
        } else if (pop > nodo.popularidad) {
            nodo.derecho = insertar(nodo.derecho, pubId, pop);
        } else {
            // Si la popularidad es igual, se decide por pubId para evitar duplicados
            if (pubId < nodo.publicacionId) {
                nodo.izquierdo = insertar(nodo.izquierdo, pubId, pop);
            } else if (pubId > nodo.publicacionId) {
                nodo.derecho = insertar(nodo.derecho, pubId, pop);
            } else {
                // Ya existe con misma popularidad y mismo ID -> no hacer nada
                return nodo;
            }
        }

        // Actualizar altura y balancear
        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        return balancear(nodo);
    }

    // Elimina un nodo buscándolo por publicacionId (sin importar popularidad)
    private NodoAVL eliminarPorPublicacionId(NodoAVL nodo, int pubId) {
        if (nodo == null) {
            return null;
        }

        // Buscar el nodo con el pubId (recorrido in-order)
        if (pubId < nodo.publicacionId) {
            nodo.izquierdo = eliminarPorPublicacionId(nodo.izquierdo, pubId);
        } else if (pubId > nodo.publicacionId) {
            nodo.derecho = eliminarPorPublicacionId(nodo.derecho, pubId);
        } else {
            // Nodo encontrado
            if (nodo.izquierdo == null || nodo.derecho == null) {
                NodoAVL temp = (nodo.izquierdo != null) ? nodo.izquierdo : nodo.derecho;
                if (temp == null) {
                    return null;
                } else {
                    return temp;
                }
            } else {
                NodoAVL sucesor = getMin(nodo.derecho);
                nodo.publicacionId = sucesor.publicacionId;
                nodo.popularidad = sucesor.popularidad;
                nodo.derecho = eliminarPorPublicacionId(nodo.derecho, sucesor.publicacionId);
            }
        }

        nodo.altura = 1 + Math.max(altura(nodo.izquierdo), altura(nodo.derecho));
        return balancear(nodo);
    }

    // Obtiene el nodo con la menor clave (popularidad más baja) - útil para sucesor
    private NodoAVL getMin(NodoAVL nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo;
    }

    // Altura de un nodo (maneja null)
    private int altura(NodoAVL n) {
        return (n == null) ? 0 : n.altura;
    }

    // Factor de balance
    private int balanceFactor(NodoAVL n) {
        return (n == null) ? 0 : altura(n.izquierdo) - altura(n.derecho);
    }

    // Balanceo AVL (rotaciones)
    private NodoAVL balancear(NodoAVL nodo) {
        int fb = balanceFactor(nodo);
        if (fb > 1) {
            if (balanceFactor(nodo.izquierdo) < 0) {
                nodo.izquierdo = rotacionIzquierda(nodo.izquierdo);
            }
            return rotacionDerecha(nodo);
        }
        if (fb < -1) {
            if (balanceFactor(nodo.derecho) > 0) {
                nodo.derecho = rotacionDerecha(nodo.derecho);
            }
            return rotacionIzquierda(nodo);
        }
        return nodo;
    }

    private NodoAVL rotacionDerecha(NodoAVL y) {
        NodoAVL x = y.izquierdo;
        NodoAVL T2 = x.derecho;
        x.derecho = y;
        y.izquierdo = T2;
        y.altura = 1 + Math.max(altura(y.izquierdo), altura(y.derecho));
        x.altura = 1 + Math.max(altura(x.izquierdo), altura(x.derecho));
        return x;
    }

    private NodoAVL rotacionIzquierda(NodoAVL x) {
        NodoAVL y = x.derecho;
        NodoAVL T2 = y.izquierdo;
        y.izquierdo = x;
        x.derecho = T2;
        x.altura = 1 + Math.max(altura(x.izquierdo), altura(x.derecho));
        y.altura = 1 + Math.max(altura(y.izquierdo), altura(y.derecho));
        return y;
    }

    /**
     * Retorna una lista con los IDs de las 'n' publicaciones más populares. Usa
     * un recorrido in-order inverso (derecha - raíz - izquierda).
     *
     * @param n Número de publicaciones a obtener.
     * @return Lista de IDs (máximo 'n' elementos).
     */
    public List<Integer> obtenerTopN(int n) {
        List<Integer> top = new ArrayList<>();
        obtenerTopNRecursivo(raiz, top, n);
        return top;
    }

    // Recorrido inverso: derecha -> raíz -> izquierda (orden descendente por popularidad)
    private void obtenerTopNRecursivo(NodoAVL nodo, List<Integer> lista, int n) {
        if (nodo == null || lista.size() >= n) {
            return;
        }
        obtenerTopNRecursivo(nodo.derecho, lista, n);
        if (lista.size() < n) {
            lista.add(nodo.publicacionId);
            obtenerTopNRecursivo(nodo.izquierdo, lista, n);
        }
    }
}
