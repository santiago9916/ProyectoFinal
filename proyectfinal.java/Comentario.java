/*
representa un comentario en una publicacion o en otro comentario
*/
package com.mycompany.proyectfinal;

public class Comentario {
    int id;
    int autorld;
    String comentario;
    long timestamp;

    public Comentario(int id, int autorld, String comentario, long timestamp) {
        this.id = id;
        this.autorld = autorld;
        this.comentario = comentario;
        this.timestamp = timestamp;
    }

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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
    
    
}
