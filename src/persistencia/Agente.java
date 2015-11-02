package persistencia;
import java.sql.*;
import java.util.Vector;

public class Agente {

	//Instancia del agente
    protected static Agente mInstancia=null;
    
    //Conexion con la base de datos
    protected static Connection mBD;
    
    //Nombre del identificador de la base de datos (agendamonolitica)
    private static String url="jdbc:mysql://localhost/agendamonolitica"; 			
    
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
			
			//Inicializacion de driver
			Class.forName(driver);
			
		} catch (Exception e) {
			System.out.println("Error al inicializar el driver: " + e.toString());
		}
		try {
			
			//Conectamos a la BBDD con un usuario y una password
			mBD = DriverManager.getConnection(url,"root","658776775");
			
		} catch (Exception e) {
			System.out.println("No se ha podido establecer conexion con la base de datos");
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
	
	public Vector<Object> read(String SQL) throws SQLException, Exception{
		
		conectar();
		PreparedStatement select =	mBD.prepareStatement(SQL);
		ResultSet s = select.executeQuery();
		
	    Vector<Object> v=new Vector<Object>();
	    Vector<Object> aux;
				while (s.next()) {
					aux=new Vector<Object>();
					aux.add((String)s.getString("login"));
					aux.add((String)s.getString("password"));
					v.add(aux);
				}	
				
		desconectar();
    	return v;
	}

}
