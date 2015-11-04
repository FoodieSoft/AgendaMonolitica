package persistencia;

import java.util.Vector;
import dominio.Usuario;

public class GestorUsuario {

	public GestorUsuario() {
	}

	public Usuario autenticar(String id, String password) throws Exception {

		Usuario usuario = null;
		String sentencia = "SELECT * FROM foodiesoft.usuarios WHERE id_usuario='" + id + "' AND password='" + password
				+ "';";

		Vector<Object> aux = Agente.getAgente().leerSentencia(sentencia);

		if (aux.size() != 0) {
			usuario = new Usuario(aux.elementAt(0).toString(), aux.elementAt(1).toString());
		}

		return usuario;
	}
}
