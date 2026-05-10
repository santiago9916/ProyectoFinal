/*
nodo del arbol de publicaciones que puede contener una publicacion o comentario
*/
package com.mycompany.proyectofinal3;

import java.util.List;

public class NodoArbol {
    public object data;
    public List<NodoArbol> hijos;

    public NodoArbol(object data, List hijos) {
        this.data = data;
        this.hijos = hijos;
    }

    public object getData() {
        return data;
    }

    public void setData(object data) {
        this.data = data;
    }

    public List getHijos() {
        return hijos;
    }

    public void setHijos(List hijos) {
        this.hijos = hijos;
    }
    
    public void agregarhijo (NodoArbol hijo){
        this.hijos.add(hijo);
    }
    
    
    
}
