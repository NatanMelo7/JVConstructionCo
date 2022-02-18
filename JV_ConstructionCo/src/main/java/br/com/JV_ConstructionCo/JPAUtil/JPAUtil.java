package br.com.JV_ConstructionCo.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("JV_ConstructionCo");
	
	public static EntityManager callEntity() {
		return FACTORY.createEntityManager();
	}
}
