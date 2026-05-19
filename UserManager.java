/*
gestiona el registro y acceso de los usuarios
 */
package proyectofinaled1;

/*
importacion
 */
import java.util.HashMap;

public class UserManager {

    // HashMap de usuarios
    private HashMap<String, Usuario> usuarios;

    // Constructor
    public UserManager() {
        usuarios = new HashMap<>();
    }

    /*
    Verifica si el usuario ya existe
     */
    public void registrarUsuario(String username) {

        if (usuarios.containsKey(username)) {
            System.out.println("El usuario ya existe :( ");

        } else {

            Usuario nuevoUsuario = new Usuario(username);

            /*
            Guarda el usuario en el HashMap
             */
            usuarios.put(username, nuevoUsuario);

            System.out.println(
                    "El usuario fue registrado correctamente :)"
            );
        }
    }

    // Obtener usuario
    public Usuario obtenerUsuario(String username) {
        return usuarios.get(username);
    }
}
