package dominio;

import java.sql.SQLException;

import persistencia.ContactoDAO;

public class GestorInsercion {
	
	public boolean añadir(Contacto contacto, Usuario usuario) throws SQLException, Exception{
		boolean añadido=false;
		ContactoDAO contactoDAO=new ContactoDAO();
		añadido=contactoDAO.insert(contacto, usuario);
		return añadido;
	}

}
