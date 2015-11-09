package dominio;

import java.sql.SQLException;
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
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoE = correoE;
		this.gestorContacto = new GestorContacto();
	}

	public Contacto() {
		this.nombre = null;
		this.apellidos = null;
		this.direccion = null;
		this.telefono = 0;
		this.correoE = null;
		this.gestorContacto = new GestorContacto();
	}

	public boolean insertarContacto(String nombre, String apellidos, String direccion, int telefono, String correoE,
			Usuario usuario) throws SQLException, Exception {
		boolean insertado = false;
		if (gestorContacto.insert(nombre, apellidos, direccion, telefono, correoE, usuario) != 0) {
			insertado = true;
		}
		return insertado;
	}

	public boolean modificarContacto(String nombre, String apellidos, String direccion, int telefono, String correoE,
			Usuario usuario) throws SQLException, Exception {
		boolean modificado = false;
		if (gestorContacto.update(nombre, apellidos, direccion, telefono, correoE, usuario) != 0) {
			modificado = true;
		}
		return modificado;
	}

	public boolean eliminarContacto(String nombre, String apellidos, Usuario usuario) throws SQLException, Exception {
		boolean eliminado = false;
		if (gestorContacto.delete(nombre, apellidos, usuario) != 0) {
			eliminado = true;
		}
		return eliminado;
	}

	public Vector<Contacto> buscarContacto(String nombre, String apellidos, Usuario usuario)
			throws SQLException, Exception {
		Vector<Contacto> contacto = gestorContacto.read(nombre, apellidos, usuario);

		return contacto;
	}

	public Vector<Contacto> leerContactos(Usuario usuario) throws SQLException, Exception {
		Vector<Contacto> contactos = gestorContacto.readAll(usuario);

		return contactos;
	}

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

	public String toString() {
		return "Contacto [nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono="
				+ telefono + ", correoE=" + correoE + ", gestorContacto=" + gestorContacto + "]";
	}
}
