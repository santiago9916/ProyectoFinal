/*
almacena la popularidad de una publicacion
*/
package com.mycompany.proyectfinal;

public class NodoAVL {

    private int popularidad;
    private int publicacionId;
    private int altura;

    private NodoAVL izquierdo;
    private NodoAVL derecho;


    public NodoAVL(int publicacionId,
                   int popularidad) {

        this.publicacionId = publicacionId;
        this.popularidad = popularidad;
        this.altura = 1;
    }


    public NodoAVL(int popularidad,
                   int publicacionId,
                   int altura,
                   NodoAVL izquierdo,
                   NodoAVL derecho) {

        this.popularidad = popularidad;
        this.publicacionId = publicacionId;
        this.altura = altura;

        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }



    public int getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(int popularidad) {
        this.popularidad = popularidad;
    }

    public int getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(int publicacionId) {
        this.publicacionId = publicacionId;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public NodoAVL getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoAVL izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoAVL getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoAVL derecho) {
        this.derecho = derecho;
    }
}
