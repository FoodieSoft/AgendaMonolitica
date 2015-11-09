package dominio;

import java.sql.SQLException;
import java.util.Vector;

import persistencia.ContactoDAO;

public class GestorLectorContactos {

	public Vector<Contacto> leerTodos(Usuario usuario) throws SQLException, Exception{
		Vector<Contacto> contactos=null;
		ContactoDAO contactoDAO=new ContactoDAO();
		contactos=contactoDAO.readAll(usuario);
		return contactos;
	}
}
