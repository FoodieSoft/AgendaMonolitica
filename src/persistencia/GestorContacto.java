package persistencia;

import java.sql.SQLException;
import java.util.Vector;
import dominio.Contacto;
import dominio.Usuario;

public class GestorContacto {

	// Inserta un contacto en la base de datos
	public int insert(String nombre, String apellidos, String direccion, int telefono, String correoE, Usuario usuario)
			throws SQLException, Exception {
		int i;

		String sentencia = "INSERT INTO foodiesoft.CONTACTOS (nombre,apellidos,direccion,telefono,correo,codigo) VALUES('"
				+ nombre + "','" + apellidos + "','" + direccion + "'," + telefono + ",'" + correoE + "','"
				+ usuario.getid() + "');";

		i = Agente.getAgente().update(sentencia);
		return i;
	}

	// Actualiza los datos de un contacto
	public int update(String nombre, String apellidos, String direccion, int telefono, String correoE, Usuario usuario)
			throws SQLException, Exception {
		int i;
		String sentencia = "UPDATE foodiesoft.CONTACTOS SET direccion='" + direccion + "', telefono=" + telefono
				+ " , correo='" + correoE + "' WHERE nombre='" + nombre + "' AND apellidos='" + apellidos
				+ "' AND codigo='" + usuario.getid() + "';";
		i = Agente.getAgente().update(sentencia);
		return i;
	}

	// Elimina un contacto de la base de datos
	public int delete(String nombre, String apellidos, Usuario usuario) throws SQLException, Exception {
		int i;
		String sentencia = "DELETE FROM foodiesoft.contactos WHERE nombre='" + nombre + "' AND apellidos='" + apellidos
				+ "' AND codigo='" + usuario.getid() + "';";
		i = Agente.getAgente().update(sentencia);
		return i;
	}

	// Recupera un contacto de la base de datos
	public Vector<Contacto> read(String nombre, String apellidos, Usuario usuario) throws SQLException, Exception {

		String sentencia = "SELECT * FROM foodiesoft.contactos WHERE nombre='" + nombre + "' AND apellidos='"
				+ apellidos + "' AND codigo='" + usuario.getid() + "';";
		Vector<Contacto> contactos = Agente.getAgente().leerContactos(sentencia);
		return contactos;
	}

	// Recupera todos los contactos de la base de datos para un usuario
	public Vector<Contacto> readAll(Usuario usuario) throws SQLException, Exception {

		String sentencia = "SELECT * FROM foodiesoft.contactos WHERE codigo='" + usuario.getid()
				+ "' ORDER BY nombre, apellidos;";
		Vector<Contacto> contactos = Agente.getAgente().leerContactos(sentencia);
		return contactos;
	}

}