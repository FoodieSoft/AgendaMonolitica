package persistencia;

import java.util.Collection;



import dominio.Usuario;
	
public class GestorUsuario {
	private Collection listaUsuarios;
	private Usuario usuario;
	public GestorUsuario(){
		listaUsuarios= new Collection();
	}
	
	public Collection GetLista(){
		return listaUsuarios;
	}
	public void SetLista(Collection lista){
		listaUsuarios=lista;
	}
	public int actualizar(Usuario usuario) throws Exception{
		Agente magente=Agente.getAgente();
		magente.update("");
		
		return 0;
	}
}
