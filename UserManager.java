/*
gestiona el registro y acceso de los usuarios
*/
package com.mycompany.proyectfinal;
/*
importacion
*/
import java.util.HashMap;

/*
 crea el HashMap:en Java sirve para guardar datos usando una clave y un valor.
#Funciona como una especie de diccionario o tabla
*/
public class UserManager {
    
    public HashMap<String, Usuario> usuario;

    public UserManager() {

        usuario = new HashMap<>();
    }
/*
    con el f verifica si existe el username
    */
    public void registrarUsuarios(String username){
        if (usuario.containsKey(username)){
            System.out.println("El usuario ya existe :( ");
  } else {

            Usuario nuevousuario = new Usuario(username);
/*
            el (usuario.put guarda el usuario en el HashMap)
            */
            usuario.put(username, nuevousuario);

            System.out.println("El usuario fue registrado correctamente :)");
        }
    }
        public Usuario obtenerUsuario(String username){
        return usuario.get(username);
        }   
}

/*
REVISAR!!!!!!!!!!!!!
*/
