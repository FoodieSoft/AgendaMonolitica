package dominio;

public class Usuario {

	private String id;
	private String password;

	public Usuario(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public Usuario() {
		this.id = null;
		this.password = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", password=" + password + "]";
	}

}
