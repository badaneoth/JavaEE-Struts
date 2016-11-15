package com.developpez.actions;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ili.jai.PersistancePromotion;
import ili.jai.ServicePersistance;
import ili.jai.ServicePersistanceImp;


public class ListerAction extends ActionSupport {

	private ServicePersistance sp;
	ServletContext context = ServletActionContext.getServletContext();

	private PersistancePromotion sppromo =(PersistancePromotion) context.getAttribute("sppromo");
	
	public String execute() throws Exception {

		//Promotion p =sppromo.persiste(annee, libelle);
		System.out.println("promo1");
		ServletContext context = ServletActionContext.getServletContext();

		sp=new ServicePersistanceImp();
		sppromo =sp.servicePersistancePromotion();	
				context.setAttribute("listPromos", sppromo.tous());
			
				System.out.println("promo2");

			
			return "success";
			
		}
}
