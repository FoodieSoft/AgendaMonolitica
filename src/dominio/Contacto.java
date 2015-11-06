package dominio;

import java.util.Vector;

import persistencia.GestorContacto;

public class Contacto {

	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	private String correoE;
	private GestorContacto gestorContacto;

	public Contacto(String nombre, String apellidos, String direccion, int telefono, String correoE) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoE = correoE;
	}

	public Vector<Object> leerContacto() throws Exception {
		Vector<Object> persona=gestorContacto.leer(nombre, apellidos, direccion, telefono, correoE);
		return persona;
	}

//	public int borrarContacto() {
//		int i=gestorContacto.delete(persona)
//
//	}
//
//	public int modificarContacto() {
//
//	}
//
//	public int eliminarContacto() {
//
//	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getCorreoE() {
		return correoE;
	}

	public void setCorreoE(String correoE) {
		this.correoE = correoE;
	}

}
