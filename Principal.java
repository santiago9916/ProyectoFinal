package proyectofinaled1;

public class Principal {

    public static void main(String[] args) {

        /*
        Se crea el administrador de usuarios
         */
        UserManager usuarios = new UserManager();

        /*
        Registro de usuarios
         */
        usuarios.registrarUsuario("Santiago");
        usuarios.registrarUsuario("Maria");

        /*
        Creacion de publicaciones
        id, autorId, contenido y fecha
         */
        Publicacion p1
                = new Publicacion(
                        1,
                        1,
                        "Hola mundo",
                        System.currentTimeMillis()
                );

        Publicacion p2
                = new Publicacion(
                        2,
                        1,
                        "Aprendiendo Java",
                        System.currentTimeMillis()
                );

        Publicacion p3
                = new Publicacion(
                        3,
                        2,
                        "Estructuras de Datos",
                        System.currentTimeMillis()
                );

        /*
        Se crea el arbol usando una publicacion raiz
         */
        PostTree arbol = new PostTree(p1);

        /*
        Historial de actividades
         */
        ActivityHistory historial = new ActivityHistory();

        /*
        Registro de actividades
         */
        historial.registrarActividad(
                "Santiago creó una publicación"
        );

        historial.registrarActividad(
                "Maria comentó una publicación"
        );

        historial.registrarActividad(
                "Santiago dio like"
        );

        /*
        Mostrar historial
         */
        System.out.println(" HISTORIAL ");

        System.out.println(
                historial.obtenerUltimasActividades(10)
        );

        /*
        Buscar una publicacion por id
         */
        System.out.println(" BUSQUEDA ");

        NodoArbol encontrado = arbol.buscarNodo(1);

        /*
        Si encuentra el nodo muestra el contenido
         */
        if (encontrado != null) {

            Publicacion pub
                    = (Publicacion) encontrado.getData();

            System.out.println(
                    "Publicación encontrada: "
                    + pub.getContenido()
            );

        } else {

            /*
            Mensaje si no encuentra la publicacion
             */
            System.out.println(
                    "No se encontró la publicación"
            );
        }
    }
}
