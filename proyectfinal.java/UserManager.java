/*
gestiona el registro y acceso de los usuarios
*/
package com.mycompany.proyectfinal;
import java.util.HashMap;
public class UserManager {
    
    public HashMap<String, Usuario> usuario;

    public UserManager() {

        usuario = new HashMap<>();
    }

    public void registrarUsuarios(String username){
        if (usuario.containsKey(username)){
            System.out.println("El usuario ya existe :( ");
  } else {

            Usuario nuevousuario = new Usuario(username);

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
