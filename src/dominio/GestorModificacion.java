package dominio;

import java.sql.SQLException;

import persistencia.ContactoDAO;

public class GestorModificacion {

	public boolean modificar(Contacto contacto, Usuario usuario) throws SQLException, Exception{
		boolean modificado=false;
		ContactoDAO contactoDAO=new ContactoDAO();
		modificado=contactoDAO.update(contacto, usuario);
		return modificado;
	}
}
