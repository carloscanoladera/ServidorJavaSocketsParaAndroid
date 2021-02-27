package ServidorAndroid.datos;





import java.sql.Connection;

import com.example.alumnosaplicacion2020fragment.accesoadatos.Centro;
import com.example.alumnosaplicacion2020fragment.accesoadatos.PeticionRespuesta;

import constantesservidor.ConstantesServidor;

public class PruebaConexion {
	
	
	public static void main(String[] args) {
		
		DAOFactory dao = new SQLDAOFactoryMySQL(ConstantesServidor.MYSQL);
		Connection conexion = SQLDAOFactoryMySQL.crearConexion();
		
		
		PeticionRespuesta peticion = dao.getCentrosDAO().listaCentros();
		
		
		
	}

}
