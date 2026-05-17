public class Principal {

    public static void main(String[] args) {

        UserManager usuarios = new UserManager();

        usuarios.registrarUsuarios("Santiago");
        usuarios.registrarUsuarios("Maria");

        Publicacion p1 =
            new Publicacion(1, "Hola mundo");

        Publicacion p2 =
            new Publicacion(2, "Aprendiendo Java");

        Publicacion p3 =
            new Publicacion(3, "Estructuras de Datos");

   
        PostTree arbol = new PostTree();

        arbol.insertar(p1);
        arbol.insertar(p2);
        arbol.insertar(p3);

        System.out.println("=== PUBLICACIONES ORDENADAS ===");

        arbol.mostrarInOrden();

  
        ActivityHistory historial = new ActivityHistory();

        historial.registrarActividad( "Santiago creó una publicación" );

        historial.registrarActividad("Maria comentó una publicación");

        historial.registrarActividad("Santiago dio like");

        System.out.println(" HISTORIAL ");

        historial.mostrarHistorial();

  
        System.out.println(" BUSQUEDA ");

        Publicacion encontrada = arbol.buscar(2);

        if (encontrada != null) {

            System.out.println( "Publicación encontrada: "+ encontrada.getContenido() );

        } else {

            System.out.println("No se encontró la publicación");
        }
    }
}
