/*
representa una publicacion acha por un usuario
 */
package proyectofinaled1;

public class Publicacion {

    int id;
    int autorId;
    String contenido;
    long timestamp;

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

    public Publicacion(int id, int autorId, String contenido, long timestamp) {
        this.id = id;
        this.autorId = autorId;
        this.contenido = contenido;
        this.timestamp = timestamp;
    }
}
