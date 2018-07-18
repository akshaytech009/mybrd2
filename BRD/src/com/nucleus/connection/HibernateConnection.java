package com.nucleus.connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateConnection {
	private static SessionFactory factory = null;
	private HibernateConnection(){}
	
	public SessionFactory getSessionFactory(){
		
		try{
			factory = new AnnotationConfiguration().configure().buildSessionFactory();
		
		return factory;
		}
		finally{
			if(factory!=null)
				factory.close();
		}
		
	}
}
