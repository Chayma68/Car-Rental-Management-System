package agence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestionAgenceLocation {
    String user = "root";
    String pass = "";
    String url = "jdbc:mysql://localhost:3306/chdatabase";
    static Connection myConnection;

    public GestionAgenceLocation() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        myConnection = DriverManager.getConnection(url, user, pass);
        System.out.println("Connexion établie");
    }
    	//Gestion vehicule
	 public void ajouterVehicule(Vehicule vehicule)throws SQLException{
		 String requete= "INSERT INTO véhicule(idVehicule, marque, modele, année) VALUES(?,?,?,?)";
		 PreparedStatement pr= myConnection.prepareStatement(requete);
		 pr.setInt(1, vehicule.getIdVehicule());
		 pr.setString(2, vehicule.getMarque());
		 pr.setString(3, vehicule.getModele());
		 pr.setInt(4, vehicule.getAnnée());
		 
		 pr.executeUpdate();
		 System.out.println("vehicule ajoute avec succes!");
	 }
	 
	 public void supprimerVehicule(int id)throws SQLException {
		 String requete = "DELETE FROM véhicule WHERE idVehicule=?" ;
		 PreparedStatement pr= myConnection.prepareStatement(requete);
		 pr.setInt(1, id); 
		 pr.executeUpdate();
		 System.out.println("vehicule supprime avec succes! ");
	}
	 
	 public void modifierVehicule(Vehicule nouveauVehicule) throws SQLException {
		    String requeteVerification = "SELECT COUNT(*) FROM véhicule WHERE idVehicule=?";
		    PreparedStatement prVerification = myConnection.prepareStatement(requeteVerification);
		    prVerification.setInt(1, nouveauVehicule.getIdVehicule());
		    ResultSet resultatVerification = prVerification.executeQuery();
		    resultatVerification.next();
		    int count = resultatVerification.getInt(1);

		    if (count == 0) {
		        
		        return;
		    }
		    String requeteModification = "UPDATE véhicule SET marque=?, modele=?, annee=? WHERE idVehicule=?";
		    PreparedStatement prModification = myConnection.prepareStatement(requeteModification);
		    prModification.setString(1, nouveauVehicule.getMarque());
		    prModification.setString(2, nouveauVehicule.getModele());
		    prModification.setInt(3, nouveauVehicule.getAnnée());
		    prModification.setInt(4, nouveauVehicule.getIdVehicule());

		    int rowsAffected = prModification.executeUpdate();
		    
		    if (rowsAffected == 0) {
		        System.out.println("Le véhicule avec l'ID spécifié n'existe pas.");
		    } else {
		        System.out.println("Véhicule modifié avec succès !");
		    }
		    System.out.println("Véhicule modifié avec succès !");
		}
	 public void rechercherVehicule(String marque, String modele, int annee) throws SQLException {
		 String requete= "SELECT * FROM véhicule WHERE marque=? AND modele = ? AND année= ?";
		 PreparedStatement pr= myConnection .prepareStatement(requete);
		 
		 pr.setString(1, marque);
		 pr.setString(2, modele);
		 pr.setInt(3, annee);
		 
		 ResultSet r = pr.executeQuery();
		 
		 while(r.next()) {
			 Vehicule vehicule = new Vehicule(r.getInt("id"), r.getString("marque"), r.getString("modele"), r.getInt("annee"));
			 System.out.println(vehicule);
		 }
		 
	 }
	 public Vehicule getVehiculeParID(int id) throws SQLException {
		    String requete = "SELECT * FROM véhicule WHERE idVehicule = ?";
		    PreparedStatement pr = myConnection.prepareStatement(requete);
		    pr.setInt(1, id);
		    
		    ResultSet rs = pr.executeQuery();
		    if (rs.next()) {
		        String marque = rs.getString("marque");
		        String modele = rs.getString("modele");
		        int année = rs.getInt("année");
		        
		        return new Vehicule(id, marque, modele, année);
		    }
		    
		    return null; 
		}
	 
	 // Gestion Client  

	    public void ajouterClient(Client client) throws SQLException {
	        String requete = "INSERT INTO client(IdClient, nom, prenom, numTel) VALUES(?,?,?,?)";
	        PreparedStatement pr = myConnection.prepareStatement(requete);
	        pr.setInt(1, client.getIdClient());
	        pr.setString(2, client.getNom());
	        pr.setString(3, client.getPrenom());
	        pr.setInt(4, client.getNumTel());

	        pr.executeUpdate();
	        System.out.println("Client ajouté avec succès !");
	    }

	    public void supprimerClient(int id) throws SQLException {
	        String requete = "DELETE FROM client WHERE IdClient=?";
	        PreparedStatement pr = myConnection.prepareStatement(requete);
	        pr.setInt(1, id);
	        pr.executeUpdate();
	        System.out.println("Client supprimé avec succès !");
	    }

	    public void modifierClient(Client nouveauClient) throws SQLException {
	        String requeteVerification = "SELECT COUNT(*) FROM client WHERE IdClient=?";
	        PreparedStatement prVerification = myConnection.prepareStatement(requeteVerification);
	        prVerification.setInt(1, nouveauClient.getIdClient());
	        ResultSet resultatVerification = prVerification.executeQuery();
	        resultatVerification.next();
	        int count = resultatVerification.getInt(1);

	        if (count == 0) {
	            System.out.println("Le client avec l'ID spécifié n'existe pas.");
	            return;
	        }
	        String requeteModification = "UPDATE client SET nom=?, prenom=?, numTel=? WHERE IdClient=?";
	        PreparedStatement prModification = myConnection.prepareStatement(requeteModification);
	        prModification.setString(1, nouveauClient.getNom());
	        prModification.setString(2, nouveauClient.getPrenom());
	        prModification.setInt(3, nouveauClient.getNumTel());
	        prModification.setInt(4, nouveauClient.getIdClient());

	        prModification.executeUpdate();
	        System.out.println("Client modifié avec succès !");
	    }
	    
	    public void rechercherClient(String nom, String prenom) throws SQLException {
	        String requete = "SELECT * FROM client WHERE nom=? AND prenom=?";
	        PreparedStatement pr = myConnection.prepareStatement(requete);

	        pr.setString(1, nom);
	        pr.setString(2, prenom);

	        ResultSet r = pr.executeQuery();

	        while (r.next()) {
	            Client client = new Client(r.getString("nom"), r.getString("prenom"), r.getInt("numTel"), r.getInt("IdClient"));
	            System.out.println(client);
	        }
	    }
	    
	 // Gestion Location 

	    public static void enregistrerLocation(Location location) throws SQLException {
	        String requete = "INSERT INTO location(Idlocation, IdClient, IdVehicule, kilometrageRetour, etatVehiculeRetour, dateLocation, dateRetour) VALUES(?,?,?,?,?,?,?)";
	        PreparedStatement pr = myConnection.prepareStatement(requete);
	        pr.setInt(1, location.getIdlocation());
	        pr.setInt(2, location.getIdClient());
	        pr.setInt(3, location.getIdVehicule());
	        pr.setInt(4, location.getKilometrageRetour());
	        pr.setString(5, location.getEtatVehiculeRetour());
	        pr.setDate(6, new java.sql.Date(location.getDateLocation().getTime()));
	        pr.setDate(7, new java.sql.Date(location.getDateRetour().getTime()));

	        pr.executeUpdate();
	        System.out.println("Location enregistrée avec succès !");
	    }

	    public static void visualiserLocationsEnCours() throws SQLException {
	        String requete = "SELECT * FROM location";
	        PreparedStatement pr = myConnection.prepareStatement(requete);

	        ResultSet r = pr.executeQuery();

	        while (r.next()) {
	            Location location = new Location(
	                r.getInt("Idlocation"),
	                r.getInt("IdClient"),
	                r.getInt("IdVehicule"),
	                r.getInt("kilometrageRetour"),
	                r.getString("etatVehiculeRetour"),
	                r.getDate("dateLocation"),
	                r.getDate("dateRetour")
	            );
	            System.out.println(location);
	        }
	    }

	    public static void cloturerLocation(int idLocation, int kilometrageRetour, String etatVehiculeRetour) throws SQLException {
	        String requete = "UPDATE location SET kilometrageRetour=?, etatVehiculeRetour=? WHERE Idlocation=?";
	        PreparedStatement pr = myConnection.prepareStatement(requete);

	        pr.setInt(1, kilometrageRetour);
	        pr.setString(2, etatVehiculeRetour);
	        pr.setInt(3, idLocation);

	        pr.executeUpdate();
	        System.out.println("Location clôturée avec succès !");
	    }
}
