package proyectofinaled1;

public class NodoAVL {

    public int popularidad;
    public int publicacionId;
    public int altura;

    public NodoAVL izquierdo;
    public NodoAVL derecho;

    //Constructor
    public NodoAVL(int publicacionId, int popularidad) {
        this.publicacionId = publicacionId;
        this.popularidad = popularidad;
        this.altura = 1;
    }
}

