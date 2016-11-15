package com.developpez.actions;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ili.jai.PersistanceAncien;
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


public class AncienAction extends ActionSupport {
	/**
	 * 
	 */
	ServletContext context = ServletActionContext.getServletContext();

	private PersistanceAncien spancien =(PersistanceAncien) context.getAttribute("spancien");
	private PersistancePromotion sppromo;
	private ServicePersistance sp;
	private PersistanceEntreprise spentreprise;
	private static final long serialVersionUID = 1L;
	private String nom;
	private String prenom;
	private int promo;
	private int annee;
	private int id;
	private String m1;
	private String m2;
	
	private String nomm;private String codepostale;private String ville;

Promotion pro =new PromotionImpl(annee, nom);
Entreprise ent =new EntrepriseImp(id, nomm, codepostale, ville);
	/*
	public Entreprise getEnt() {
	return ent;
}
public void setEnt(Entreprise ent) {
	this.ent = ent;
}
	public Promotion getPro() {
	return pro;
}
public void setPro(Promotion pro) {
	this.pro = pro;
}
*/

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	// il faut creer un objet promo
	public int getPromo() {
		return promo;
	}
	public void setPromo(int promo) {
		this.promo = promo;
	}



	
	public String getM1() {
		return m1;
	}

	public void setM1(String m1) {
		this.m1 = m1;
	}

	public String getM2() {
		return m2;
	}

	public void setM2(String m2) {
		this.m2 = m2;
	}

	public void validate() {
		boolean missingnom = nom.trim().isEmpty();
		boolean missingprenom = prenom.trim().isEmpty();
		boolean missingpromo =promo== -1 ;
			
			if (missingnom && missingprenom && missingpromo) {
			
			addActionError("Tous ces champs sont obligatoires");
			
			} else {
			
			if (missingnom) {
			
			addFieldError("nom", "Vous devez fournir un nom");
		
			}
		
			if (missingprenom) {
		
			addFieldError("prenom", "Vous devez fournir un prenom");
		
			} 

			if (missingpromo) {
		
			addFieldError("pro", "Vous devez fournir la promo");
		
			} 
		
			
			
			}
		}
	
	

	public String enregistrer() throws SQLException {
		
		System.out.println("dans la méthode enregistrer()......");
		//System.out.println("---------ss:------" +annee);

		ServletContext context = ServletActionContext.getServletContext();
	 

		sp=new ServicePersistanceImp();
		spancien =sp.servicePersistanceAncien();	
		//sp=new ServicePersistanceImp();
		//spentreprise =sp.servicePersistanceEntreprise();
		for (int i = 0; i < spancien.tous().size(); i++) {
			
			
			System.out.println("--------promo-----"+spancien.tous().get(i).getPromotion().getAnnee());
			}
		
		sppromo=	new PersistancePromotionImp();
		spentreprise=new PersistanceEntrepriseImp();
		//sppromo.findById(promo);
		System.out.println("-------------promoannee----------"+promo);
		System.out.println("##################################################");
		System.out.println("--"+m1);
		System.out.println("--"+m2);
		System.out.println("##################################################");
		
		Entreprise mm1;
		Entreprise mm2;
		
		if(this.m1.equals("-1")){
			System.out.println();
			mm1=Entreprise.NONE;
		}
		else{
			mm1=spentreprise.findByName(m1);
		}
		if(this.m2.equals("-1")){
			mm2=Entreprise.NONE;
		}
		else{
			mm2=spentreprise.findByName(m2);
		}
		spancien.persiste(nom, prenom,sppromo.findById(promo),mm1,mm2);

		
			context.setAttribute("listAnciens", spancien.tous());
		return "success";
		
		}
	
		public String lister(){
			System.out.println("dans la méthode lister().....");

			return "success";
			}

		}
