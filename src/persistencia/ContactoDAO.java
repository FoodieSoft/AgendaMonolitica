package persistencia;

import java.sql.SQLException;
import java.util.Vector;
import dominio.Contacto;
import dominio.Usuario;

public class ContactoDAO {

	// Inserta un contacto en la base de datos
	public boolean insert(Contacto contacto, Usuario usuario) throws SQLException, Exception {

		boolean insertado = false;
		int i;
		String sentencia = "INSERT INTO foodiesoft.CONTACTOS (nombre,apellidos,direccion,telefono,correo,codigo) VALUES('"
				+ contacto.getNombre() + "','" + contacto.getApellidos() + "','" + contacto.getDireccion() + "',"
				+ contacto.getTelefono() + ",'" + contacto.getCorreoE() + "','" + usuario.getId() + "');";

		i = Agente.getAgente().update(sentencia);

		if (i != 0) {
			insertado = true;
		}
		return insertado;
	}

	// Actualiza los datos de un contacto
	public boolean update(Contacto contacto, Usuario usuario) throws SQLException, Exception {
		boolean modificado = false;
		int i;
		String sentencia = "UPDATE foodiesoft.CONTACTOS SET direccion='" + contacto.getDireccion() + "', telefono="
				+ contacto.getTelefono() + " , correo='" + contacto.getCorreoE() + "' WHERE nombre='"
				+ contacto.getNombre() + "' AND apellidos='" + contacto.getApellidos() + "' AND codigo='"
				+ usuario.getId() + "';";
		i = Agente.getAgente().update(sentencia);
		if (i != 0) {
			modificado = true;
		}
		return modificado;
	}

	// Elimina un contacto de la base de datos
	public boolean delete(Contacto contacto, Usuario usuario) throws SQLException, Exception {
		boolean eliminado=false;
		int i;
		String sentencia = "DELETE FROM foodiesoft.contactos WHERE nombre='" + contacto.getNombre() + "' AND apellidos='" + contacto.getApellidos()
				+ "' AND codigo='" + usuario.getId() + "';";
		i = Agente.getAgente().update(sentencia);
		
		if(i!=0){
			eliminado=true;
		}
		return eliminado;
	}

	// Recupera un contacto de la base de datos
	public Contacto read(Contacto contacto, Usuario usuario) throws SQLException, Exception {

		String sentencia = "SELECT * FROM foodiesoft.contactos WHERE nombre='" + contacto.getNombre() + "' AND apellidos='"
				+ contacto.getApellidos() + "' AND codigo='" + usuario.getId() + "';";
		Vector<Contacto> buscado = Agente.getAgente().leerContactos(sentencia);
		Contacto contactoEncontrado=buscado.elementAt(0);
		return contactoEncontrado;
	}

	// Recupera todos los contactos de la base de datos para un usuario
	public Vector<Contacto> readAll(Usuario usuario) throws SQLException, Exception {

		String sentencia = "SELECT * FROM foodiesoft.contactos WHERE codigo='" + usuario.getId()
				+ "' ORDER BY nombre, apellidos;";
		Vector<Contacto> contactos = Agente.getAgente().leerContactos(sentencia);
		return contactos;
	}

}