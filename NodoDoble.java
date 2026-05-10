/*
nodo de la lista doblemente enlazada para el historial de actividad
*/
package com.mycompany.proyectofinal3;

public class NodoDoble {
    String descripcion;
    NodoDoble siguiente;
    NodoDoble anterios;
    NodoDoble anterior;

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

    public NodoDoble getAnterios() {
        return anterios;
    }

    public void setAnterios(NodoDoble anterios) {
        this.anterios = anterios;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
    
    

    public NodoDoble(String descripcion, NodoDoble siguiente, NodoDoble anterios, NodoDoble anterior) {
        this.descripcion = descripcion;
        this.siguiente = siguiente;
        this.anterios = anterios;
        this.anterior = anterior;
    }
    
    
    public NodoDoble(String descripcion){
        this.descripcion = descripcion;
    }
}
