package ServidorAndroid.datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.example.alumnosaplicacion2020fragment.accesoadatos.Centro;
import com.example.alumnosaplicacion2020fragment.accesoadatos.PeticionRespuesta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CentrosDAOMySQL implements CentrosDAO{
	
    Connection conexion;
	
	public CentrosDAOMySQL() {
		
		
		 conexion = SQLDAOFactoryMySQL.crearConexion();
	}

	@Override
	public int InsertarCentro(Centro centro) {
		// TODO Auto-generated method stub
		
	    int valor = 0;
     
        //nombre, codpais, tasapago, sumaimpuestos, numerohabitantes
        String sql = "INSERT INTO centro "
                + "(id, nombrecentro, localidad, provincia,direccion,telefono) "
                + "VALUES ( ? , ?, ? ,? , ?,?)";

        PreparedStatement sentencia;
        try {
            sentencia = (PreparedStatement) conexion.prepareStatement(sql);
            sentencia.setLong(1, centro.getNumCentro());
            sentencia.setString(2, centro.getNombreCentro());
            sentencia.setString(3, centro.getLocalidad());
            sentencia.setString(4, centro.getProvincia());
            sentencia.setString(5, centro.getDireccion());
            sentencia.setString(6, centro.getTelefono());
      
            

            int filas = sentencia.executeUpdate();
            if (filas > 0) {
                valor = 0;
            }
            sentencia.close();

        } catch (SQLException e) {
            MensajeExcepcion(e);
            valor = -1;
        }
        return valor;
	
	}

	@Override
	public int borrarCentro(Centro centro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Centro leerCentro(int Id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int modificarCentro(Centro centro) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PeticionRespuesta listaCentros() {
		PeticionRespuesta lista = new PeticionRespuesta();
	        try {
	            Statement sentencia = (Statement) conexion.createStatement();
	            String sql = "SELECT * FROM centros";
	            ResultSet resul = sentencia.executeQuery(sql);

	            while (resul.next()) {
	                Centro centro = new Centro(
	                		 resul.getLong("id"),
	                        resul.getString("nombrecentro"),	                       
	                        resul.getString("localidad"),
	                        resul.getString("provincia"),	                       
	                        resul.getString("direccion"),	 	                                              
	                        resul.getString("telefono")
	                        );
	                
	                
	                lista.put(String.valueOf(centro.getNumCentro()), centro);
	                
	            }
	                
	            } catch (SQLException e) {
	                MensajeExcepcion(e);
	                return PeticionRespuesta.RESPUESTA_ERRONEA;
	                
	            }
	        
	       
	        return lista;
	}
	
	  private void MensajeExcepcion(SQLException e) {
	        System.out.printf("HA OCURRIDO UNA EXCEPCIÓN:%n");
	        System.out.printf("Mensaje   : %s %n", e.getMessage());
	        System.out.printf("SQL estado: %s %n", e.getSQLState());
	        System.out.printf("Cód error : %s %n", e.getErrorCode());
	    }

}
