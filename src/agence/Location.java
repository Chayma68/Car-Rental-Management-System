package agence;

import java.util.Date;

public class Location {
	private int Idlocation;
	private int IdClient;
	private int IdVehicule;
	private int kilometrageRetour;
	private String etatVehiculeRetour;
	private Date dateLocation;
	private Date dateRetour;
	
	
	public Location(int idlocation, int idClient, int idVehicule, int kilometrageRetour, String etatVehiculeRetour,
			Date dateLocation, Date dateRetour) {
		super();
		Idlocation = idlocation;
		IdClient = idClient;
		IdVehicule = idVehicule;
		this.kilometrageRetour = kilometrageRetour;
		this.etatVehiculeRetour = etatVehiculeRetour;
		this.dateLocation = dateLocation;
		this.dateRetour = dateRetour;
	}
	public int getIdlocation() {
		return Idlocation;
	}
	public void setIdlocation(int idlocation) {
		Idlocation = idlocation;
	}
	public int getIdClient() {
		return IdClient;
	}
	public void setIdClient(int idClient) {
		IdClient = idClient;
	}
	public int getIdVehicule() {
		return IdVehicule;
	}
	public void setIdVehicule(int idVehicule) {
		IdVehicule = idVehicule;
	}
	public int getKilometrageRetour() {
		return kilometrageRetour;
	}
	public void setKilometrageRetour(int kilometrageRetour) {
		this.kilometrageRetour = kilometrageRetour;
	}
	public String getEtatVehiculeRetour() {
		return etatVehiculeRetour;
	}
	public void setEtatVehiculeRetour(String etatVehiculeRetour) {
		this.etatVehiculeRetour = etatVehiculeRetour;
	}
	public Date getDateLocation() {
		return dateLocation;
	}
	public void setDateLocation(Date dateLocation) {
		this.dateLocation = dateLocation;
	}
	public Date getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(Date dateRetour) {
		this.dateRetour = dateRetour;
	}
	@Override
	public String toString() {
		return "Location [Idlocation=" + Idlocation + ", IdClient=" + IdClient + ", IdVehicule=" + IdVehicule
				+ ", kilometrageRetour=" + kilometrageRetour + ", etatVehiculeRetour=" + etatVehiculeRetour
				+ ", dateLocation=" + dateLocation + ", dateRetour=" + dateRetour + "]";
	}
	
	
}
