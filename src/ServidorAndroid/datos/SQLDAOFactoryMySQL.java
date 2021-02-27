package ServidorAndroid.datos;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.DriverManager;
import java.sql.SQLException;

import constantesservidor.ConstantesServidor;

import java.sql.Connection;




	
	
	public class SQLDAOFactoryMySQL extends DAOFactory {

	    static Connection conexion = null;
	    static String DRIVER = "";
	    static String URLDB = "";
	    static String USUARIO = "centrosandroid";
	    static String CLAVE = "centrosandroid";

	     public SQLDAOFactoryMySQL(int BDSQL) {
	        if (BDSQL == ConstantesServidor.MYSQL) {
	            DRIVER = "com.mysql.cj.jdbc.Driver";
	            URLDB = "jdbc:mysql://34.89.142.36:3306/centrosandroid";
	            //System.out.println("mysql");
	        }
	        else {
	        	
	        	
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
			return new CentrosDAOMySQL();
		}

	}

