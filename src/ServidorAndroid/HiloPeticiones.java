package ServidorAndroid;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import com.example.alumnosaplicacion2020fragment.accesoadatos.PeticionRespuesta;

import ServidorAndroid.datos.DAOFactory;
import constantesservidor.ConstantesServidor;

public class HiloPeticiones extends Thread {
	private Socket cliente = null;
	private DAOFactory dao = null;
	private ResuelvePeticion resPeticion=null;
	public HiloPeticiones(Socket cliente,DAOFactory dao) {
		
		
		this.cliente=cliente;
		this.dao=dao;
		this.resPeticion=new ResuelvePeticion(dao.getCentrosDAO());
		
		
		
	}
	
public void run() {
		
	
		
	
		ObjectInputStream streamLectura;
		try {
			streamLectura = new ObjectInputStream(cliente.getInputStream());
			PeticionRespuesta  pet = (PeticionRespuesta) streamLectura.readObject();
		
			
			
			  ObjectOutputStream streamEscritura = new ObjectOutputStream(
						cliente.getOutputStream()); 	
		   // Se prepara un objeto y se envía 
		  
			  streamEscritura.writeObject(resPeticion.resuelvePeticion(pet)); //enviando objeto
		   
		   
		   Thread.sleep(10000);
		   streamLectura.close();
		   streamEscritura.close();
		   cliente.close();
		   
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
