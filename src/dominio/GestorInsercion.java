package dominio;

import java.sql.SQLException;

import persistencia.ContactoDAO;

public class GestorInsercion {
	
	public boolean a�adir(Contacto contacto, Usuario usuario) throws SQLException, Exception{
		boolean a�adido=false;
		ContactoDAO contactoDAO=new ContactoDAO();
		a�adido=contactoDAO.insert(contacto, usuario);
		return a�adido;
	}

}
