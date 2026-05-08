package com.mycompany.proyectfinal;

public class PostTree {

    public NodoArbol contenidoRaiz;

    public PostTree(Publicacion p) {

        contenidoRaiz = new NodoArbol(p.getId(), p);
    }

    public NodoArbol buscarNodo(int id) {

        return buscarRecursivo(contenidoRaiz, id);
    }

    public NodoArbol buscarRecursivo(NodoArbol p, int id) {

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

    public void agregarComentario(int idPadre, Comentario c) {

        NodoArbol padre = buscarNodo(idPadre);

        if (padre != null) {

            NodoArbol nuevoComentario = new NodoArbol(c.getId(), c);

            padre.agregarHijo(nuevoComentario);

            System.out.println("Comentario agregado correctamente");

        } else {

            System.out.println("No se encontró el nodo padre");
        }
    }
}

/*
MAL!!!!!!!!!!!!!!!!!!!!!!
*/