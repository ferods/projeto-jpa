package br.com.felipe.jpa.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
    
    public EntityManager getEntityManager() {
    	return emf.createEntityManager();
    }
    

}
