package persistencia;
import java.sql.SQLException;
import java.util.LinkedList;
import dominio.Contacto;

public class GestorContacto {
	Agente agente;
	Contacto contacto;
	LinkedList<Contacto> listaContactos;
	
	public int leer(String nombre, String apellidos, String direccion, int telefono, String correoE) throws Exception{
		int i;
		agente = Agente.getAgente();
		
		
		return i;
	}
	
	public int insert(Contacto persona) throws SQLException, Exception{
		int i;
		i= Agente.getAgente().insert("");
		return i;
	}
	
	public int update(Contacto persona) throws SQLException, Exception{
		int i;
		i= Agente.getAgente().update("");
		return i;
	}
	
	public int delete(Contacto persona) throws SQLException, Exception{
		int i;
		i= Agente.getAgente().delete("");
		return i;
	}

}