/*
representa un comentario en una publicacion o en otro comentario
 */
package proyectofinaled1;

public class Comentario {

    int id;
    int autorId;
    String contenido;
    long timestamp;

    public Comentario(int id, int autorId, String contenido, long timestamp) {
        this.id = id;
        this.autorId = autorId;
        this.contenido = contenido;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
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
}

