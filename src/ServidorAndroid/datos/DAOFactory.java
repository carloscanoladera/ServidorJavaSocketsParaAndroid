package ServidorAndroid.datos;

import constantesservidor.ConstantesServidor;

public abstract class DAOFactory {
    // Bases de datos soportadas



    public abstract CentrosDAO getCentrosDAO();
 

    public static DAOFactory getDAOFactory(int bd) {
        switch (bd) {
            case ConstantesServidor.MYSQL:
                return new SQLDAOFactoryMySQL(ConstantesServidor.MYSQL);
           
            case ConstantesServidor.ORACLE:               
                return new SQLDAOFactoryOracle(ConstantesServidor.ORACLE);                 
            default:
                return null;
        }
    }
}

