package dominio;

import java.util.Vector;
import persistencia.GestorUsuario;;

public class Usuario {

	private String ID;
	private String Password;
	private GestorUsuario gestor;
	
	public Usuario(String id, String password) {
		this.ID = id;
		this.Password = password;
		gestor = new GestorUsuario();
	}
	

	public Usuario() {
		this.ID = null;
		this.Password = null;
		gestor=new GestorUsuario();
	}

	// Seleccion de un usuario de la base de datos a partir del login y el password
	

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}
	public void actualizar(){
		gestor.
	}
}
