package com.developpez.actions;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.glass.ui.TouchInputSupport;

import ili.jai.PersistancePromotion;
import ili.jai.PersistancePromotionImp;
import ili.jai.ServicePersistance;
import ili.jai.ServicePersistanceImp;
import ili.jai.model.Promotion;
import ili.jai.model.PromotionImpl;

public class PromoAction extends ActionSupport {
	/**
	 * 
	 */
	//private PersistancePromotion sppromo= new PersistancePromotionImp();
	private static final long serialVersionUID = 1L;
	ServletContext context = ServletActionContext.getServletContext();

	private PersistancePromotion sppromo =(PersistancePromotion) context.getAttribute("sppromo");
	private int annee;
	private String libelle;

	private ServicePersistance sp;

	
	
	
	
	
public void validate() {
	boolean missinglibelle = libelle.trim().isEmpty();
	
	boolean missingannee = annee == 0;
		
		
		
		if (missinglibelle && missingannee) {
		
		addActionError("Tous ces champs sont obligatoires");
		
		} else {
		
		if (missinglibelle) {
		
		addFieldError("libelle", "Vous devez fournir un libelle");
	
		}
	
		if (missingannee) {
	
		addFieldError("annee", "Vous devez fournir votre annee");
	
		} else {
	
		if (annee<2005||annee>2016) {
		
		addFieldError("annee", "Vous devez fournir annee entre 2005 et 2016");
		
		}
		
		}
	
		
		
		}
	}
	
	
	
	
	
public String execute() throws Exception {

	//Promotion p =sppromo.persiste(annee, libelle);
	System.out.println("promo1");
	ServletContext context = ServletActionContext.getServletContext();

	//sp=new ServicePersistanceImp();
	//sppromo =sp.servicePersistancePromotion();	
			context.setAttribute("listPromos", sppromo.tous());
		
			System.out.println("promo2");

		
		return "success";
		
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	



	public String enregistrer() throws SQLException {
		
		System.out.println("dans la méthode enregistrer()......");
		System.out.println("---------ss:------" +annee);


		ServletContext context = ServletActionContext.getServletContext();
	 



	//	try {
		///	int i = 0;
			//for(i=0;i<sppromo.tous().size();i++){
		//	System.out.println("--------------------"+sppromo.tous().get(i).getAnnee());
			//System.out.println("--------------------"+sppromo.tous().get(i).getNom());}

		sp=new ServicePersistanceImp();
		sppromo =sp.servicePersistancePromotion();	
		Promotion p	=sppromo.persiste(annee, libelle);

			context.setAttribute("listPromos", sppromo.tous());

		return "success";
		
		
		
	
		
		
		//listPromos.add(promo);
		
	//	if(this.libelle.equals("")) {
		//	addFieldError("libelle", "le libelle ne doit pas être vide");
			//return "input";
		//}
			//return "success";
		
	}
	
	public String lister(){
		System.out.println("dans la méthode lister().....");

		return "success";
	}


	
	
	
	
}
