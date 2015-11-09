package dominio;

import java.sql.SQLException;

import persistencia.ContactoDAO;

public class GestorEliminacion {
	
	public boolean eliminar(Contacto contacto, Usuario usuario) throws SQLException, Exception{
		boolean eliminado=false;
		ContactoDAO contactoDAO=new ContactoDAO();
		eliminado=contactoDAO.delete(contacto, usuario);
		return eliminado;
	}

}
