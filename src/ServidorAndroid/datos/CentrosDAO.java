package ServidorAndroid.datos;

import java.util.HashMap;
import java.util.List;

import com.example.alumnosaplicacion2020fragment.accesoadatos.Centro;
import com.example.alumnosaplicacion2020fragment.accesoadatos.PeticionRespuesta;

public interface CentrosDAO {
	
	

	
	public int InsertarCentro(Centro centro) ;
	
	
	public int borrarCentro(Centro centro);
	
	public Centro leerCentro(int Id);
	
	
	public int modificarCentro(Centro centro);
	
	public PeticionRespuesta listaCentros() ;
	


}
