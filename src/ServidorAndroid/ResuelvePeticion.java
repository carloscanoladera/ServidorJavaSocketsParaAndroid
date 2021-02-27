package ServidorAndroid;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.example.alumnosaplicacion2020fragment.accesoadatos.Centro;
import com.example.alumnosaplicacion2020fragment.accesoadatos.PeticionRespuesta;

import ServidorAndroid.datos.CentrosDAO;
import constantesservidor.ConstantesServidor;

public class ResuelvePeticion   {
	
	private HashMap<String,Centro> peticiones = null;
	private CentrosDAO centrosDao;
	
	public ResuelvePeticion(CentrosDAO centrosDao) {

	
		this.centrosDao= centrosDao;
	}
	
	
	
	public PeticionRespuesta resuelvePeticion(PeticionRespuesta peticion) {
		
		
		String codPeticion="";
		Centro centro =null;
		PeticionRespuesta respuesta = new PeticionRespuesta();
		
		Iterator<String> itPet= peticion.keySet().iterator();
		
		if (itPet.hasNext()) {
			
			codPeticion=itPet.next();
			centro=peticion.get(codPeticion);	
			
			switch (codPeticion) {
			
			case ConstantesServidor.BORRAR:
				
				if (centrosDao.borrarCentro(centro)==0) {
					
					respuesta.put(ConstantesServidor.RESPUESTA_OK, centro);
					
					return respuesta;
				};
				
				break;
				
			case ConstantesServidor.INSERTAR:
				
				if (centrosDao.InsertarCentro(centro)==0) {
					
					respuesta.put(ConstantesServidor.RESPUESTA_OK, centro);
					
				};
				
				break;
				
			case ConstantesServidor.LEER:
				
				centro = centrosDao.leerCentro((int)centro.getNumCentro());
			
				if (centro!= null) {
					
					respuesta.put(ConstantesServidor.RESPUESTA_OK, centro);
					
				}
				break;
				
			case ConstantesServidor.LISTADO:
				
				return centrosDao.listaCentros();
				
			
			
			}
					
		}
		
		
		
		 
		 return PeticionRespuesta.RESPUESTA_ERRONEA;
	}
	

}
