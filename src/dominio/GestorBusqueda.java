package dominio;

import java.sql.SQLException;

import persistencia.ContactoDAO;

public class GestorBusqueda {

	public Contacto buscar(Contacto contacto, Usuario usuario) throws SQLException, Exception{
		Contacto encontrado=null;
		ContactoDAO contactoDAO=new ContactoDAO();
		encontrado=contactoDAO.read(contacto, usuario);
		return encontrado;
	}
}
