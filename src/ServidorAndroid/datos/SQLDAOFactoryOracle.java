package ServidorAndroid.datos;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.DriverManager;
import java.sql.SQLException;

import constantesservidor.ConstantesServidor;

import java.sql.Connection;



	
	
	public class SQLDAOFactoryOracle extends DAOFactory {

	    static Connection conexion = null;
	    static String DRIVER = "";
	    static String URLDB = "";
	    static String USUARIO = "centros";
	    static String CLAVE = "centros";

	     SQLDAOFactoryOracle(int BDSQL) {
	  
	        
	        if (BDSQL == ConstantesServidor.ORACLE) {
	            DRIVER = "oracle.jdbc.driver.OracleDriver";
	            URLDB = "jdbc:oracle:thin:@localhost:1521:XE";
	            //System.out.println("oracle");
	        } else {
	        	
	        	
	        	//Arrojariamos una excepción
	        }

	    }//constructor

	    // crear la conexion
	    public static  Connection crearConexion() {
	        if (conexion == null) {
	            try {
	                Class.forName(DRIVER); // Cargar el driver
	            } catch (ClassNotFoundException ex) {
	                //Logger.getLogger(SQLDAOFactory.class.getName()).log(Level.SEVERE, null, ex);
	            	
	            	System.out.printf("HA OCURRIDO UNA EXCEPCIÓN:%n");
	            }
	            try {
	                conexion = (Connection) DriverManager.getConnection(URLDB, USUARIO, CLAVE);
	            } catch (SQLException ex) {
	                System.out.printf("HA OCURRIDO UNA EXCEPCIÓN:%n");
	                System.out.printf("Mensaje   : %s %n", ex.getMessage());
	                System.out.printf("SQL estado: %s %n", ex.getSQLState());
	                System.out.printf("Cód error : %s %n", ex.getErrorCode());
	            }
	        }
	        return conexion;
	    }

		@Override
		public CentrosDAO getCentrosDAO() {
			// TODO Auto-generated method stub
			return new centrosDAOOracle();
		}

	}

