package com.developpez.actions;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ili.jai.PersistanceAncien;
import ili.jai.PersistancePromotion;
import ili.jai.PersistancePromotionImp;
import ili.jai.ServicePersistance;
import ili.jai.ServicePersistanceImp;
import ili.jai.model.Promotion;

public class libelleAction extends ActionSupport {

	private ServicePersistance sp;
	ServletContext context = ServletActionContext.getServletContext();
	private PersistanceAncien spancien = (PersistanceAncien) context.getAttribute("spancien");
	private PersistancePromotion sppromo = (PersistancePromotion) context.getAttribute("sppromo");;

	private String libellepromo;
	private String idPromo;

	public String getLibellepromo() {
		return libellepromo;
	}

	public void setLibellepromo(String libellepromo) {
		this.libellepromo = libellepromo;
	}

	public String getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(String idPromo) {
		this.idPromo = idPromo;
	}

	public String execute() throws Exception {

		// Promotion p =sppromo.persiste(annee, libelle);

		ServletContext context = ServletActionContext.getServletContext();

		sp = new ServicePersistanceImp();
		sp = new ServicePersistanceImp();
		spancien = sp.servicePersistanceAncien();
		sppromo = new PersistancePromotionImp();
		System.out.println("###### "+idPromo);
		Promotion promo = sppromo.findById(Integer.parseInt(idPromo));
		System.out.println("####->"+promo.getNom());
		context.setAttribute("listAnciens", spancien.touteLaPromo(promo));

		return "success";

	}
}
