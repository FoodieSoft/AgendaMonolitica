package persistencia;

import java.sql.*;
import java.util.Vector;
import dominio.Contacto;

public class Agente {

	// Instancia del agente
	protected static Agente mInstancia = null;

	// Conexion con la base de datos
	protected static Connection mBD;

	// Nombre del identificador de la base de datos (agendamonolitica)
	private static String url = "jdbc:mysql://localhost:3306/?user=root";

	// Driver para conectar con bases de datos MySQL
	private static String driver = "com.mysql.jdbc.Driver";

	// Constructor
	public Agente() throws Exception {
		conectar();
	}

	// Implementacion del patron singleton
	// http://es.wikipedia.org/wiki/Singleton
	public static Agente getAgente() throws Exception {
		if (mInstancia == null) {
			mInstancia = new Agente();
		}
		return mInstancia;
	}

	// Metodo para realizar la conexion a la base de datos
	private static void conectar() throws Exception {
		// Inicializacion de driver
		Class.forName("com.mysql.jdbc.Driver");

		// Conectamos a la BBDD con un usuario y una password
		mBD = DriverManager.getConnection(url + "&password=iso2");

	}

	// Metodo para desconectar de la base de datos
	public void desconectar() throws Exception {
		mBD.close();
	}

	// Metodo para leer un usuario de la base de datos
	public Vector<Object> leerUsuario(String SQL) throws SQLException, Exception {
		conectar();

		Statement select = mBD.createStatement();
		ResultSet s = select.executeQuery(SQL);
		Vector<Object> usuario = new Vector<Object>();

		while (s.next()) {
			usuario.add(s.getString(1));
			usuario.add(s.getString(2));
		}

		select.close();
		desconectar();
		return usuario;
	}

	// Metodo para leer los contactos de la base de datos
	public Vector<Contacto> leerContactos(String SQL) throws SQLException, Exception {
		conectar();

		Statement select = mBD.createStatement();
		ResultSet s = select.executeQuery(SQL);

		Vector<Contacto> contactos = new Vector<Contacto>();

		while (s.next()) {
			Contacto contacto = new Contacto(s.getString(1), s.getString(2), s.getString(3), s.getInt(4),
					s.getString(5));
			contactos.add(contacto);
		}
		select.close();
		desconectar();
		return contactos;
	}

	// Metodo para realizar una actualizacion en la base de datos
	public int update(String SQL) throws SQLException, Exception {
		conectar();
		PreparedStatement stmt = mBD.prepareStatement(SQL);
		int res = stmt.executeUpdate();
		stmt.close();
		desconectar();
		return res;
	}

}
