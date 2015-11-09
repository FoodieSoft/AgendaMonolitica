package persistencia;

import java.util.Vector;
import dominio.Usuario;

public class UsuarioDAO {

	public UsuarioDAO() {
	}

	public boolean autenticar(Usuario usuario) throws Exception {
		boolean autenticado = false;

		String sentencia = "SELECT * FROM foodiesoft.usuarios WHERE id_usuario='" + usuario.getId() + "' AND password='"
				+ usuario.getPassword() + "';";

		Vector<Object> aux = Agente.getAgente().leerUsuario(sentencia);

		if (aux.size() != 0) {
			autenticado = true;
		}

		return autenticado;
	}
}
