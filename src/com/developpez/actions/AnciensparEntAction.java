package com.developpez.actions;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ili.jai.PersistanceAncien;
import ili.jai.PersistanceAncienImp;
import ili.jai.PersistanceEntreprise;
import ili.jai.PersistanceEntrepriseImp;
import ili.jai.ServicePersistance;
import ili.jai.ServicePersistanceImp;

public class AnciensparEntAction extends ActionSupport {

	private ServicePersistance sp;
	ServletContext context = ServletActionContext.getServletContext();

	// private PersistanceAncien spancien =(PersistanceAncien)
	// context.getAttribute("spancien");
	private PersistanceAncien spancien = new PersistanceAncienImp();
	private PersistanceEntreprise spentreprise = new PersistanceEntrepriseImp();
	private String nomentreprise;

	public String getNomentreprise() {
		return nomentreprise;
	}

	public void setNomentreprise(String nomentreprise) {
		this.nomentreprise = nomentreprise;
	}

	public String execute() throws Exception {

		// Promotion p =sppromo.persiste(annee, libelle);

		ServletContext context = ServletActionContext.getServletContext();

		sp = new ServicePersistanceImp();
		spentreprise = sp.servicePersistanceEntreprise();

		context.setAttribute("listAnciens", spancien.travaillentDans(spentreprise.findByName(nomentreprise)));
		//
		System.out.println("ent2");

		return "success";

	}
}
