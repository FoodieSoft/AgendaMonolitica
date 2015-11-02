package persistencia;

import java.sql.ResultSet;
import java.util.Vector;

import dominio.Usuario;

public class GestorUsuario {

	public GestorUsuario() {
	}

	public Usuario autenticar(String id, String password) throws Exception {

		Usuario usuario = null;
		Agente agente = Agente.getAgente();
		String sentencia = "SELECT * FROM USUARIOS WHERE id_usuario='" + id + "' AND password='" + password + "';";
		ResultSet resultado = agente.leerSentencia(sentencia);
		Vector<Object> aux = null;

		while (resultado.next()) {
			aux.add(resultado.getObject("login"));
			aux.add(resultado.getObject("password"));
		}

		if (aux.size() != 0) {
			usuario = new Usuario(aux.elementAt(0).toString(), aux.elementAt(1).toString());
		}

		// podemos plantear devolver un 1 o un 0 en vez de un objeto para
		// simplificarlo mas
		return usuario;
	}
}
