package dominio;

public final class Contacto {

	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
	private String correoE;

	public Contacto(String nombre, String apellidos, String direccion, int telefono, String correoE) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.correoE = correoE;
	}

	public Contacto() {
		this.nombre = null;
		this.apellidos = null;
		this.direccion = null;
		this.telefono = 0;
		this.correoE = null;
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
				+ telefono + ", correoE=" + correoE + "]";
	}

}
