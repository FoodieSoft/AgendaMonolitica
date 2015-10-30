package persistencia;

import dominio.Usuario;

public class GestorUsuario {

	public static boolean autenticar(String login, String password) throws Exception{
		boolean autenticado = false;
		
		if(Usuario.read(login, password) != null)
			autenticado = true;
		
		return autenticado;
	}
}
