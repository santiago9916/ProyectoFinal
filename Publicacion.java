/*
representa una publicacion acha por un usuario
*/
package com.mycompany.proyectfinal;

public class Publicacion {
int id;
int autorld;
String contenido;
long timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAutorld() {
        return autorld;
    }

    public void setAutorld(int autorld) {
        this.autorld = autorld;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Publicacion(int id, int autorld, String contenido, long timestamp) {
        this.id = id;
        this.autorld = autorld;
        this.contenido = contenido;
        this.timestamp = timestamp;
    }

    int getid() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
