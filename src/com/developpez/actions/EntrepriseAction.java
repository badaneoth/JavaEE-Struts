package com.developpez.actions;

import java.sql.SQLException;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ili.jai.PersistanceEntreprise;
import ili.jai.ServicePersistance;
import ili.jai.ServicePersistanceImp;

public class EntrepriseAction extends ActionSupport {
	/**
	 * 
	 */
	
	
	
	ServletContext context = ServletActionContext.getServletContext();

	private PersistanceEntreprise spentreprise =(PersistanceEntreprise) context.getAttribute("spentreprise");
	private ServicePersistance sp;

	private static final long serialVersionUID = 1L;
	private String raisonSociale;
	private String cp;
	private String ville;
	
	//private static ArrayList<Entreprise> listEntreprises = new ArrayList<Entreprise>();

	
	public void validate() {
		boolean missingraisonSociale = raisonSociale.trim().isEmpty();
		boolean missingcp = cp.trim().isEmpty();
		boolean missingville = ville.trim().isEmpty();

		
			
			
			
			if (missingraisonSociale && missingcp && missingville) {
			
			addActionError("Tous ces champs sont obligatoires");
			
			} else {
			
			if (missingraisonSociale) {
			
			addFieldError("raisonSociale", "Vous devez fournir un raisonSocial");
		
			}
		
			if (missingcp) {
		
			addFieldError("cp", "Vous devez fournir le codepostale");
		
			} 

			if (missingville) {
		
			addFieldError("ville", "Vous devez fournir la ville");
		
			} 
		
			
			
			}
		}
		
	
	public String execute() throws Exception {

		//Promotion p =sppromo.persiste(annee, libelle);
		System.out.println("oth1 ");
		ServletContext context = ServletActionContext.getServletContext();

		//sp=new ServicePersistanceImp();
		//sppromo =sp.servicePersistancePromotion();	
				context.setAttribute("listEntreprises", spentreprise.tous());
			
				System.out.println("oth2 ");

			
			return "success";
			
		}
	
	
	
	public String getRaisonSociale() {
		return raisonSociale;
	}
	public void setRaisonSociale(String raisonSociale) {
		this.raisonSociale = raisonSociale;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
}



	public String enregistrer() throws SQLException {
		
		
		
		
		System.out.println("dans la méthode enregistrer().....oooooooooooooooooo.");
		//for(int i=0;i<spentreprise.tous().size();i++){
			//System.out.println("--------------------"+spentreprise.tous().get(i).getAnnee());
					//System.out.println("--------------------"+spentreprise.tous().get(1).getNom());//}
					//System.out.println("--------------------"+spentreprise.tous().get(0).getNom());//}

		ServletContext context = ServletActionContext.getServletContext();
	 



			

		sp=new ServicePersistanceImp();
		spentreprise =sp.servicePersistanceEntreprise();	
		 spentreprise.persiste(raisonSociale,cp,ville);

			context.setAttribute("listEntreprises", spentreprise.tous());

		return "success";
		
		
		//if(this.raisonSociale.equals("")) {
			//addFieldError("libelle", "le raisonSociale ne doit pas être vide");
			//return "input";
		//}
			//return "success";
		
	}
	
	public String lister(){
		System.out.println("dans la méthode lister().....");

		return "success";
	}



	
	

}
