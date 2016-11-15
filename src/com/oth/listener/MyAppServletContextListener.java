package com.oth.listener;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.struts2.ServletActionContext;

import ili.jai.PersistanceAncien;
import ili.jai.PersistanceAncienImp;
import ili.jai.PersistanceEntreprise;
import ili.jai.PersistanceEntrepriseImp;
import ili.jai.PersistancePromotion;
import ili.jai.PersistancePromotionImp;
import ili.jai.ServicePersistance;
import ili.jai.ServicePersistanceImp;
import ili.jai.model.Entreprise;

public class MyAppServletContextListener 
               implements ServletContextListener{
	
	private ServicePersistance sp;
	private PersistancePromotion sppromo;
//	private ServletContext context = ServletActionContext.getServletContext(); 

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContextListener started");	
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sp= new ServicePersistanceImp();
		try {
			sp.creerTables();
			PersistanceEntreprise spentreprise = new PersistanceEntrepriseImp();
			PersistanceAncien spancien=new PersistanceAncienImp();
			PersistancePromotion sppromotion=new PersistancePromotionImp();
			
			spentreprise = sp.servicePersistanceEntreprise();
			spancien=sp.servicePersistanceAncien();
			sppromotion=sp.servicePersistancePromotion();
			
			sppromotion.persiste(2005,"Jupiter");
			sppromotion.persiste(2006,"Calisto");
			sppromotion.persiste(2007,"Europa");
			
			
			spentreprise.persiste("Nextoo","59100","Roubaix");
			spentreprise.persiste("GFI","59000","Lille");
			spentreprise.persiste("Excilys","75000","Paris");
		
		
			spancien.persiste("Lemaire", "Raphael",sppromotion.findById(2007),
					Entreprise.NONE, spentreprise.findByName("Excilys"));

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	sppromo =sp.servicePersistancePromotion();

		
	//	try {
	//System.out.println(sppromo.tous().size());
		//} catch (SQLException e) {
			//// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}

		
	}
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener destroyed");
		
	try {
		sp.effacerTables();
				} catch (SQLException e) {
		// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


        //Run this before web application is started

}
