package dominio;

import persistencia.GestorUsuario;;

public class Usuario {

	private String id;
	private String password;
	private GestorUsuario gestorUsuario;

	public Usuario(String id, String password) {
		this.id = id;
		this.password = password;
		gestorUsuario = new GestorUsuario();
	}

	// Constructor vacio
	public Usuario() {
		this.id = null;
		this.password = null;
		gestorUsuario = new GestorUsuario();
	}

	public String getid() {
		return id;
	}

	public String getpassword() {
		return password;
	}

	// Seleccion de un usuario de la base de datos a partir del login y el
	// password
	public boolean autenticar() throws Exception {

		boolean autenticado = false;
		if (gestorUsuario.autenticar(id, password) != null) {
			autenticado = true;
		}
		return autenticado;

	}

}
