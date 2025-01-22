package agence;

public class Client {
	private String nom;
	private String prenom;
	private int numTel;
	private int IdClient;
	
	
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
	public int getNumTel() {
		return numTel;
	}
	public void setNumTel(int numTel) {
		this.numTel = numTel;
	}
	public int getIdClient() {
		return IdClient;
	}
	public void setIdClient(int idClient) {
		IdClient = idClient;
	}
	public Client(String nom, String prenom, int numTel, int idClient) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.numTel = numTel;
		IdClient = idClient;
	}
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", numTel=" + numTel + ", IdClient=" + IdClient + "]";
	}
	
}
