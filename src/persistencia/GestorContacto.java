package persistencia;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Vector;

import dominio.Contacto;
import dominio.Usuario;

public class GestorContacto {
	Agente agente;
	Contacto contacto;
	LinkedList<Contacto> listaContactos;

	// public Vector<Object> leer(String nombre, String apellidos, String
	// direccion, int telefono, String correoE)
	// throws Exception {
	//
	// String sentencia = "SELECT * FROM CONTACTOS WHERE nombre='" + nombre + "'
	// AND apellidos='" + apellidos
	// + "' AND telefono='" + telefono + "';";
	// Vector<Object> contactos;
	// contactos = Agente.getAgente().leerSentenciaContactos(sentencia);
	// return contactos;
	// }

	public int insert(String nombre,String apellidos,String direccion, int telefono,String correoE, Usuario usuario) throws SQLException, Exception {
		int i;
		if(direccion==""){
			direccion=null;
		}
//		if(telefono==' '){
//			telefono=00000;
//		}
		if(correoE==""){
			correoE=null;
		}
String sentencia = 
		"INSERT INTO foodiesoft.CONTACTOS(nombre,apellidos,direccion,telefono,correo,codigo) VALUES('"+nombre+"','"+apellidos+"','"+direccion+"',"+telefono+",'"+correoE+"','"+usuario.getid()+"');";
		
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

	public int search(Contacto persona) throws SQLException, Exception {
		int i;
		String sentencia = "";
		i = Agente.getAgente().update(sentencia);
		return i;

	}

	public Vector<Contacto> readAll() throws SQLException, Exception {

		String sentencia = "SELECT * FROM foodiesoft.contactos ORDER BY nombre, apellidos;";
		Vector<Contacto> contactos = Agente.getAgente().leerSentenciaContactos(sentencia);
		return contactos;
	}

}