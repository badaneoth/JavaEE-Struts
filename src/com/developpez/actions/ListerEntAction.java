package com.developpez.actions;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ili.jai.PersistanceAncien;
import ili.jai.PersistanceAncienImp;
import ili.jai.PersistanceEntreprise;
import ili.jai.PersistanceEntrepriseImp;
import ili.jai.PersistancePromotion;
import ili.jai.PersistancePromotionImp;
import ili.jai.ServicePersistance;
import ili.jai.ServicePersistanceImp;
import ili.jai.model.Entreprise;

public class ListerEntAction extends ActionSupport {
	private ServicePersistance sp;
	ServletContext context = ServletActionContext.getServletContext();

	private PersistanceEntreprise spentreprise =(PersistanceEntreprise) context.getAttribute("spentreprise");	

	private PersistanceAncien spancien =(PersistanceAncien) context.getAttribute("spancien");
	
	
	
	
	/////////////////
	
	String noment = (String) context.getAttribute("nom");


	
	private PersistancePromotion sppromo=	new PersistancePromotionImp();
	
	
	
	/////////////////////
	
	public String execute() throws Exception {

		//Promotion p =sppromo.persiste(annee, libelle);
		System.out.println("ent1");
		ServletContext context = ServletActionContext.getServletContext();

		sp=new ServicePersistanceImp();
		///////////////////
		
		//Entreprise sppp= (Entreprise) new PersistanceEntrepriseImp();
		/////////////////
		spentreprise =sp.servicePersistanceEntreprise();	
				context.setAttribute("listEntreprises", spentreprise.tous());
				//System.out.println("-------111-------->>>>>>>"+spentreprise.findByName("GFI"));
			//	System.out.println("-------222-------->>>>>>>"+spentreprise.findByName(noment));
			//	context.setAttribute("listAnciens", spancien.travaillentDans(spentreprise.findByName(sppp.getNom())));

				System.out.println("ent2");

			
			return "success";
			
		}
	
	
}
