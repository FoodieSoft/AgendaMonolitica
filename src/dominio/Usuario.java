package dominio;

import java.util.Vector;
import persistencia.Agente;

public class Usuario {

	private String ID;
	private String Password;

	public Usuario(String id, String password) {
		this.ID = id;
		this.Password = password;
	}

	public Usuario() {
		this.ID = null;
		this.Password = null;
	}

	// Seleccion de un usuario de la base de datos a partir del login y el password
	public static Usuario read(String id, String password) throws Exception {

		Usuario u = null;
		Vector<Object> aux = null;
		String SQL_Consulta = "SELECT id, password FROM Usuario WHERE id = '" + id + "' AND password = '" + password + "';";

		Agente a = Agente.getAgente();
		Vector<Object> res = a.select(SQL_Consulta);

		if (res.size() == 1) {
			aux = (Vector<Object>) res.elementAt(0);
			u = new Usuario((String) aux.elementAt(0), (String) aux.elementAt(1));
		}
		
		return u;
	}

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
}
