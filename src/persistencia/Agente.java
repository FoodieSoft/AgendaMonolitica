package persistencia;

import java.sql.*;

public class Agente {

	// Instancia del agente
	protected static Agente mInstancia = null;

	// Conexion con la base de datos
	protected static Connection mBD;

	// Nombre del identificador de la base de datos (agendamonolitica)
	private static String url = "jdbc:mysql://localhost/agendamonolitica";

	// Driver para conectar con bases de datos MySQL
	private static String driver = "com.mysql.jdbc.Driver";

	// Constructor
	private Agente() throws Exception {
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
		try {

			// Inicializacion de driver
			Class.forName("com.mysql.jdbc.Driver");

		} catch (Exception e) {
			System.out.println("Error al inicializar el driver: " + e.toString());
		}
		try {

			// Conectamos a la BBDD con un usuario y una password
			mBD = DriverManager.getConnection(url, "root", "iso2");

		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
			System.out.println("Causa: " + ex.getCause());
		}
	}

	// Metodo para desconectar de la base de datos
	public void desconectar() throws Exception {
		mBD.close();
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

	// Metodo para retomar datos de la base de datos
	public ResultSet leerSentencia(String SQL) throws SQLException, Exception {
		conectar();
		Statement select = mBD.createStatement();
		ResultSet s = select.executeQuery(SQL);
		select.close();
		desconectar();
		return s;

	}

}
