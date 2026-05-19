/*
clase orquestadora que conecta todo el sistema de la red social
 */
package proyectofinaled1;

/*
importaciones
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SocialNetworkManager {

    // Atributos principales de la red
    private UserManager userManager;
    private HashMap<Integer, PostTree> posts;
    private PopularityIndex popularityIndex;
    private HashMap<Integer, ActivityHistory> userActivity;

    // Contadores internos para IDs automaticos
    private int contadorUsuarios = 1;
    private int contadorPublicaciones = 1;
    private int contadorComentarios = 1;

    // HashMap auxiliar para controlar los likes de las publicaciones
    private HashMap<Integer, Integer> likesPorPublicacion;

    // Constructor
    public SocialNetworkManager() {
        userManager = new UserManager();
        posts = new HashMap<>();
        popularityIndex = new PopularityIndex();
        userActivity = new HashMap<>();
        likesPorPublicacion = new HashMap<>();
    }

    //_________________________________________________________
    /*
    Crea un usuario en el sistema y le activa su historial
     */
    public void crearUsuario(String username) {
        userManager.registrarUsuario(username);

        Usuario u = userManager.obtenerUsuario(username);

        if (u != null) {
            u.setId(contadorUsuarios++);

            userActivity.put(u.getId(), new ActivityHistory());

            userActivity.get(u.getId()).registrarActividad("Usuario creado: " + username);
        }
    }

    //-------

    /*
    Crea una nueva publicacion en la red social
     */
    public int crearPublicacion(String username, String contenido) {
        Usuario u = userManager.obtenerUsuario(username);

        if (u == null) {
            return -1;
        }
        // ↑↑↑↑↑↑ Si el usuario no existe retorna -1

        int pubId = contadorPublicaciones++;
        long timestamp = System.currentTimeMillis();

        Publicacion p = new Publicacion(pubId, u.getId(), contenido, timestamp);

        PostTree arbolPublicacion = new PostTree(p);

        posts.put(pubId, arbolPublicacion);

        likesPorPublicacion.put(pubId, 0);

        popularityIndex.actualizarPopularidad(pubId, 0);

        userActivity.get(u.getId()).registrarActividad("Creó la publicación ID: " + pubId);

        return pubId;
    }

    //-------

    /*
    Agrega un comentario a una publicacion o a otro comentario
     */
    public void comentarPublication(String username, int pubId, int padId, String contenido) {
        Usuario u = userManager.obtenerUsuario(username);

        if (u == null) {
            return;
        }

        if (!posts.containsKey(pubId)) {
            return;
        }
        // ↑↑↑↑↑↑ Si la publicacion no existe finaliza el metodo

        int commentId = contadorComentarios++;
        long timestamp = System.currentTimeMillis();

        Comentario c = new Comentario(commentId, u.getId(), contenido, timestamp);

        PostTree arbol = posts.get(pubId);

        arbol.agregarComentario(padId, c);

        userActivity.get(u.getId()).registrarActividad("Comentó en la publicación ID: " + pubId);
    }

    //-------

    /*
    Incrementa los likes y actualiza la posicion en el AVL de popularidad
     */
    public void darLike(int publicacionId) {
        if (likesPorPublicacion.containsKey(publicacionId)) {

            int likesActuales = likesPorPublicacion.get(publicacionId);
            likesActuales++;

            likesPorPublicacion.put(publicacionId, likesActuales);

            popularityIndex.actualizarPopularidad(publicacionId, likesActuales);
        }
    }

    //-------

    /*
    Obtiene las N publicaciones mas populares del AVL
     */
    public List<Integer> getTopNPublicaciones(int n) {
        return popularityIndex.obtenerTopN(n);
    }

    //-------

    /*
    Devuelve las ultimas actividades registradas por el usuario
     */
    public List<String> getHistorialDeUsuario(String username, int n) {
        Usuario u = userManager.obtenerUsuario(username);

        if (u != null && userActivity.containsKey(u.getId())) {
            return userActivity.get(u.getId()).obtenerUltimasActividades(n);
        }

        return new ArrayList<>();
    }
}
