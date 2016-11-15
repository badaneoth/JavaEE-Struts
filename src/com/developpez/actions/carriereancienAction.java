package com.developpez.actions;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ili.jai.PersistanceAncien;
import ili.jai.PersistanceAncienImp;
import ili.jai.PersistanceEntreprise;
import ili.jai.PersistanceEntrepriseImp;
import ili.jai.ServicePersistance;
import ili.jai.ServicePersistanceImp;
import ili.jai.model.Ancien;
import ili.jai.model.AncienImp;
import ili.jai.model.Entreprise;

public class carriereancienAction extends ActionSupport {

	private ServicePersistance sp;
	ServletContext context = ServletActionContext.getServletContext();

	// private PersistanceAncien spancien =(PersistanceAncien)
	// context.getAttribute("spancien");
	private PersistanceAncien spancien = new PersistanceAncienImp();
	private PersistanceEntreprise spentreprise = new PersistanceEntrepriseImp();
	private String nouvelleEntreprise;
	private String idAncien;
	private String majCarriere;

	public String getMajCarriere() {
		return majCarriere;
	}

	public void setMajCarriere(String majCarriere) {
		this.majCarriere = majCarriere;
	}

	public String getIdAncien() {
		return idAncien;
	}

	public void setIdAncien(String idAncien) {
		this.idAncien = idAncien;
	}

	public String getNouvelleEntreprise() {
		return nouvelleEntreprise;
	}

	public void setNouvelleEntreprise(String nouvelleEntreprise) {
		this.nouvelleEntreprise = nouvelleEntreprise;
	}

	public String execute() throws Exception {

		// Promotion p =sppromo.persiste(annee, libelle);

		ServletContext context = ServletActionContext.getServletContext();

		sp = new ServicePersistanceImp();
		spentreprise = sp.servicePersistanceEntreprise();
		////////////
		if (majCarriere != null) {
			try {
				System.out.println("##########################################################################");
				System.out.println("############" + nouvelleEntreprise);
				System.out.println("############" + idAncien);
				Ancien anc = spancien.findById(Integer.parseInt(idAncien));
				Entreprise entreprise = spentreprise.findByName(nouvelleEntreprise);
				Ancien nouveauAncien = new AncienImp(anc.getId(), anc.getNom(), anc.getPrenom(), anc.getPromotion(),
						entreprise, entreprise);

				spancien.maj(nouveauAncien);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("##########################################################################");

		}
		///////
		System.out.println("ent2");

		return "success";

	}
}
