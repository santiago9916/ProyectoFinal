/*
nodo del arbol de publicaciones que puede contener una publicacion o comentario
*/
package com.mycompany.proyectofinal3;

import java.util.ArrayList;
import java.util.List;

public class NodoArbol {
    public Object data; // Contenido que puede ser publicacion o comentario /
    private List<NodoArbol> hijos; /* Lista de hijos */

    public NodoArbol(Object data, List<NodoArbol> hijos) {
        this.data = data;
        this.hijos = new ArrayList<>(); // Inicializacion de la lista de hijos /
    }

    NodoArbol(Publicacion p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    // Getters y setters del atributo data y del atributo hijos
        //data
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
        //-------
    
        //la lista de hijos
    public List<NodoArbol> getHijos() {
        return hijos;
    }
    public void setHijos(List<NodoArbol> hijos) {
        this.hijos = hijos;
    }
        //-------
  
    //_________________________________________________________
    
    //Agregará un hijo al nodo en el que este como comentario
    public void agregarHijo (NodoArbol hijo){ 
        this.hijos.add(hijo);
    }

    // obtiene el id del contenido ocn instanceof y returna el get.id
    public int getId() {
        switch (data) {
            case Publicacion publicacion -> {
                return publicacion.getId();
            }
            case Comentario comentario -> {
                return comentario.getId();
            }
            default -> {
            }
        }
        return -1;
    }  
}
