package agence;
//import java.sql.PreparedStatement;

public class Vehicule {
	private String marque;
	private String modele;
	private int année;
	private int idVehicule;
	
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public int getAnnée() {
		return année;
	}
	public void setAnnée(int année) {
		this.année = année;
	}
	public int getIdVehicule() {
		return idVehicule;
	}
	public void setIdVehicule(int idVehicule) {
		this.idVehicule = idVehicule;
	}
	@Override
	public String toString() {
		return "Vehicule [marque=" + marque + ", modele=" + modele + ", année=" + année + ", idVehicule=" + idVehicule
				+ "]";
	}
	public Vehicule(int année, String modele, String marque, int idVehicule) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.année = année;
		this.idVehicule = idVehicule;
	}
	

}
