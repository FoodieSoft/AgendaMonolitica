package dominio;

public class GestorUsuario {
	
	public boolean autenticar(Usuario usuario) throws Exception {
		boolean autenticado=false;
		GestorLoginUsuario gestorLoginUsuario= new GestorLoginUsuario();
		autenticado=gestorLoginUsuario.autenticar(usuario);
		return autenticado;
				
	}

}
