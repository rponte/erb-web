package br.com.triadworks.erp.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("erp");

    public EntityManager getEntityManager() {
        return factory.createEntityManager();
    }
	
}
