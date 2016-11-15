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
import ili.jai.model.EntrepriseImp;
import ili.jai.model.Promotion;
import ili.jai.model.PromotionImpl;




public class ListerAncAction extends ActionSupport {
	
	
	
	private ServletContext context = ServletActionContext.getServletContext();
	
	private PersistancePromotion sppromo=	new PersistancePromotionImp();
	private PersistanceEntreprise spentreprise=new PersistanceEntrepriseImp();
	private ServicePersistance sp = new ServicePersistanceImp();
	private PersistanceAncien spancien = new PersistanceAncienImp();

	
	public String execute() throws Exception {
		System.out.println("-11111111111111111----tous anciens----------");

		System.out.println("=======>" + spancien.tous().get(0).getPromotion().getNom());
		Entreprise e =spancien.tous().get(0).getEntrepriseStageM2();
		System.out.println("==>"+e.getNom());
		context.setAttribute("listAnciens", spancien.tous());
		
		return "success";

	}
}
