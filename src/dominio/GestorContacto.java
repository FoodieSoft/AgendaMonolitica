package dominio;

import java.sql.SQLException;
import java.util.Vector;

public class GestorContacto {

	public boolean a�adir(Contacto contacto, Usuario usuario) throws SQLException, Exception{
		boolean a�adido=false;
		GestorInsercion gestorInsercion=new GestorInsercion();
		a�adido=gestorInsercion.a�adir(contacto, usuario);		
		return a�adido;
	}
	
	public boolean modificar(Contacto contacto, Usuario usuario) throws SQLException, Exception{
		boolean modificado=false;
		GestorModificacion gestorModificacion=new GestorModificacion();
		modificado=gestorModificacion.modificar(contacto,usuario);
		return modificado;
	}
	
	public boolean eliminar(Contacto contacto, Usuario usuario) throws SQLException, Exception{
		boolean eliminado=false;
		GestorEliminacion gestorEliminacion=new GestorEliminacion();
		eliminado=gestorEliminacion.eliminar(contacto,usuario);
		return eliminado;
	}
	
	public Contacto buscar(Contacto contacto, Usuario usuario) throws SQLException, Exception{
		Contacto contactoEncontrado=null;
		GestorBusqueda gestorBusqueda=new GestorBusqueda();
		contactoEncontrado=gestorBusqueda.buscar(contacto, usuario);
		return contactoEncontrado;
	}
	
	public Vector<Contacto> leerContactos(Usuario usuario) throws SQLException, Exception{
		Vector<Contacto> contactos=null;
		GestorLectorContacto gestorLector=new GestorLectorContacto();
		contactos=gestorLector.leerTodos(usuario);
		return contactos;
	}
	
	
}
