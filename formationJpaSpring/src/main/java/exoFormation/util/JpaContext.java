package exoFormation.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exoFormation.dao.DaoFormateur;
import exoFormation.dao.DaoFormateurJpaImpl;
import exoFormation.dao.DaoFormation;
import exoFormation.dao.DaoFormationJpaImpl;
import exoFormation.dao.DaoMateriel;
import exoFormation.dao.DaoMaterielJpaImpl;
import exoFormation.dao.DaoModule;
import exoFormation.dao.DaoModuleFormation;
import exoFormation.dao.DaoModuleFormationJpaImpl;
import exoFormation.dao.DaoModuleJpaImpl;
import exoFormation.dao.DaoParticipant;
import exoFormation.dao.DaoParticipantJpaImpl;

public class JpaContext {
	private static EntityManagerFactory factory=null;
	private static DaoFormateur daoFormateur;
	private static DaoParticipant daoParticipant;
	private static DaoFormation daoFormation;
	private static DaoMateriel daoMateriel;
	private static DaoModule daoModule;
	private static DaoModuleFormation daoModuleFormation;
	
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(factory==null) {
			factory=Persistence.createEntityManagerFactory("formation");
		}
		return factory;
	}
	
	public static void destroy() {
		if(factory!=null) {
			factory.close();
			factory=null;
		}
	}
	
	public static DaoFormateur getDaoFormateur() {
		if(daoFormateur==null) {
			daoFormateur=new DaoFormateurJpaImpl();
		}
		return daoFormateur;
	}
	
	public static DaoFormation getDaoFormation() {
		if(daoFormation==null) {
			daoFormation=new DaoFormationJpaImpl();
		}
		return daoFormation;
	}
	public static DaoParticipant getDaoParticipant() {
		if(daoParticipant==null) {
			daoParticipant=new DaoParticipantJpaImpl();
		}
		return daoParticipant;
	}
	
	public static DaoMateriel getDaoMateriel() {
		if(daoMateriel==null) {
			daoMateriel=new DaoMaterielJpaImpl();
		}
		return daoMateriel;
	}
	
	public static DaoModule getDaoModule() {
		if(daoModule==null) {
			daoModule=new DaoModuleJpaImpl();
		}
		return daoModule;
	}
	
	public static DaoModuleFormation getDaoModuleFormation() {
		if(daoModuleFormation==null) {
			daoModuleFormation=new DaoModuleFormationJpaImpl();
		}
		return daoModuleFormation;
	}
}

