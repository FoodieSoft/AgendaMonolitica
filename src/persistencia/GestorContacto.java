package persistencia;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Vector;

import dominio.Contacto;

public class GestorContacto {
	Agente agente;
	Contacto contacto;
	LinkedList<Contacto> listaContactos;

	public Vector<Object> leer(String nombre, String apellidos, String direccion, int telefono, String correoE)
			throws Exception {

		String sentencia = "SELECT * FROM CONTACTOS WHERE nombre='" + nombre + "' AND apellidos='" + apellidos
				+ "' AND telefono='" + telefono + "';";
		Vector<Object> contactos;
		contactos = Agente.getAgente().leerSentenciaContactos(sentencia);
		return contactos;
	}

	public int insert(Contacto persona) throws SQLException, Exception {
		int i;
		String sentencia = "";
		i = Agente.getAgente().update(sentencia);
		return i;
	}

	public int update(Contacto persona) throws SQLException, Exception {
		int i;
		String sentencia = "";
		i = Agente.getAgente().update(sentencia);
		return i;
	}

	public int delete(Contacto persona) throws SQLException, Exception {
		int i;
		String sentencia = "";
		i = Agente.getAgente().update(sentencia);
		return i;
	}

	public Vector<Object> readAll(Contacto persona) throws SQLException, Exception {

		String sentencia = "SELECT * FROM CONTACTOS ORDER BY nombre";
		Vector<Object> contactos;
		contactos = Agente.getAgente().leerSentenciaContactos(sentencia);
		return contactos;
	}

}