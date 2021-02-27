package ServidorAndroid;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ForkJoinPool;

import ServidorAndroid.datos.DAOFactory;
import ServidorAndroid.datos.SQLDAOFactoryMySQL;
import constantesservidor.ConstantesServidor;

public class ServidorCentros extends Thread{
	
	private static boolean servidorParar=false;
	private ServerSocket servidor;
	private Socket cliente;
	
	private DAOFactory dao;
	
	public void run() {
		
		
		 dao = new SQLDAOFactoryMySQL(ConstantesServidor.MYSQL);
		 ForkJoinPool pool = ForkJoinPool.commonPool();
		 
		 
		 
		
		try {
			 servidor = new ServerSocket(ConstantesServidor.PUERTO_SERVIDOR);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while(!servidorParar) {
			
			
			
			
			try {
				cliente =servidor.accept();
				
				pool.submit(new HiloPeticiones(cliente, dao));
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}
		
		
		
		
	}
	
	
	public static void pararServidor() {
		
		servidorParar=true;
		
	}
	

}
