package agence;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main{
	
    public static void main(String[] args) throws ParseException {
        GestionAgenceLocation gestionAgenceLocation;
        try {
            gestionAgenceLocation = new GestionAgenceLocation();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
			int choix = 0;

			while (choix != 12) {
			    System.out.println("****** MENU*******");
			    System.out.println("1/ Ajouter un véhicule");
			    System.out.println("2/ Supprimer un véhicule");
			    System.out.println("3/ Modifier un véhicule");
			    System.out.println("4/ Rechercher un véhicule");
			    System.out.println("5/ Ajouter un client");
			    System.out.println("6/ Supprimer un client");
			    System.out.println("7/ Modifier un client");
			    System.out.println("8/ Rechercher un client");
			    System.out.println("9/ Enregistrer une location");
			    System.out.println("10/ Visualiser les locations en cours");
			    System.out.println("11/ Clôturer une location");
			    System.out.println("12/ Quitter");
			    System.out.print("Choix : ");
			    choix = scanner.nextInt();

			    switch (choix) {
			    case 1:
			        // Ajouter un véhicule
			        System.out.println("******Ajouter un véhicule******");
			        System.out.print("ID du véhicule : ");
			        int idVehicule = scanner.nextInt();
			        System.out.print("Marque : ");
			        String marque = scanner.next();
			        System.out.print("Modèle : ");
			        String modele = scanner.next();
			        System.out.print("Année : ");
			        int annee = scanner.nextInt();
			        
			        
			        try {
						gestionAgenceLocation.ajouterVehicule(new Vehicule(annee,modele, marque,idVehicule));
					} catch (SQLException e) {
						e.printStackTrace();
					}
			        break;
			        
			    case 2:
			        // Supprimer un véhicule
			        System.out.println("******Supprimer un véhicule *******");
			        System.out.print("ID du véhicule à supprimer : ");
			        int idVehiculeASupprimer = scanner.nextInt();
			        
			        
			        try {
						gestionAgenceLocation.supprimerVehicule(idVehiculeASupprimer);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			        break;
			        
			    case 3:
			        // Modifier un véhicule
			        System.out.println("***** Modifier un véhicule *******");
			        System.out.print("ID du véhicule à modifier : ");
			        int idVehiculeAModifier = scanner.nextInt();
			        System.out.print("Nouvelle marque : ");
			        String nouvelleMarque = scanner.next();
			        System.out.print("Nouveau modèle : ");
			        String nouveauModele = scanner.next();
			        System.out.print("Nouvelle année : ");
			        int nouvelleAnnee = scanner.nextInt();

			        try {
			            String url = "jdbc:mysql://localhost:3306/chdatabase";
			            String user = "root";
			            String password = "";

			            try (Connection connection = DriverManager.getConnection(url, user, password)) {
			               
			                String requeteVerification = "SELECT COUNT(*) FROM véhicule WHERE idVehicule=?";
			                try (PreparedStatement prVerification = connection.prepareStatement(requeteVerification)) {
			                    prVerification.setInt(1, idVehiculeAModifier);
			                    try (ResultSet resultatVerification = prVerification.executeQuery()) {
			                        resultatVerification.next();
			                        int count = resultatVerification.getInt(1);

			                        if (count == 0) {
			                            System.out.println("Le véhicule avec l'ID spécifié n'existe pas.");
			                            break;
			                        }

			                       
			                        String requeteModification = "UPDATE véhicule SET marque=?, modele=?, année=? WHERE idVehicule=?";
			                        try (PreparedStatement prModification = connection.prepareStatement(requeteModification)) {
			                            prModification.setString(1, nouvelleMarque);
			                            prModification.setString(2, nouveauModele);
			                            prModification.setInt(3, nouvelleAnnee);
			                            prModification.setInt(4, idVehiculeAModifier);
			                            prModification.executeUpdate();
			                            System.out.println("Le véhicule a été modifié avec succès.");
			                        }
			                    }
			                }
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			        break;
			    case 4:
			        // Rechercher un véhicule
			        System.out.println("*******Rechercher un véhicule*****");
			        System.out.print("Marque : ");
			        String marqueRecherchee = scanner.next();
			        System.out.print("Modèle : ");
			        String modeleRecherche = scanner.next();
			        System.out.print("Année : ");
			        int anneeRecherchee = scanner.nextInt();
			        try {
						gestionAgenceLocation.rechercherVehicule(marqueRecherchee, modeleRecherche, anneeRecherchee);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			        break;
			        
			    case 5:
			        // Ajouter un client
			        System.out.println("****** Ajouter un client******");
			        System.out.print("ID du client : ");
			        int idClient = scanner.nextInt();
			        System.out.print("Nom : ");
			        String nomClient = scanner.next();
			        System.out.print("Prénom : ");
			        String prenomClient = scanner.next();
			        System.out.print("Numero de telephone du client : ");
			          int numTel = scanner.nextInt();
			        try {
						gestionAgenceLocation.ajouterClient(new Client(nomClient, prenomClient,numTel,idClient));
					} catch (SQLException e) {
						e.printStackTrace();
					}
			        break;
			        
			    case 6:
			        // Supprimer un client
			        System.out.println("******Supprimer un client ******");
			        System.out.print("ID du client à supprimer : ");
			        int idClientASupprimer = scanner.nextInt();
			        
			        try {
						gestionAgenceLocation.supprimerClient(idClientASupprimer);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			        break;
			        
			    case 7:
			        // Modifier un client
			        System.out.println("***** Modifier un client*******");
			        System.out.print("ID du client à modifier : ");
			        int idClientAModifier = scanner.nextInt();
			        System.out.print("Nouveau nom : ");
			        String nouveauNom = scanner.next();
			        System.out.print("Nouveau prénom : ");
			        String nouveauPrenom = scanner.next();
			        System.out.print("Nouveau numéro de téléphone : ");
			        int nouveauNumTel = scanner.nextInt();

			        try {
			            String url = "jdbc:mysql://localhost:3306/chdatabase";
			            String user = "root";
			            String password = "";

			            try (Connection connection = DriverManager.getConnection(url, user, password)) {
			                // Vérifier si le client existe déjà
			                String requeteVerification = "SELECT COUNT(*) FROM client WHERE IdClient=?";
			                try (PreparedStatement prVerification = connection.prepareStatement(requeteVerification)) {
			                    prVerification.setInt(1, idClientAModifier);
			                    try (ResultSet resultatVerification = prVerification.executeQuery()) {
			                        resultatVerification.next();
			                        int count = resultatVerification.getInt(1);

			                        if (count == 0) {
			                            System.out.println("Le client avec l'ID spécifié n'existe pas.");
			                            break;
			                        }
			                        String requeteModification = "UPDATE client SET Nom=?, Prenom=?, NumTel=? WHERE IdClient=?";
			                        try (PreparedStatement prModification = connection.prepareStatement(requeteModification)) {
			                            prModification.setString(1, nouveauNom);
			                            prModification.setString(2, nouveauPrenom);
			                            prModification.setInt(3, nouveauNumTel);
			                            prModification.setInt(4, idClientAModifier);
			                            prModification.executeUpdate();
			                            System.out.println("Le client a été modifié avec succès.");
			                        }
			                    }
			                }
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			        break;
			        
				case 8:
			        // Rechercher un client
			        System.out.println("***** Rechercher un client *****");
			        System.out.print("Nom : ");
			        String nomRecherche = scanner.next();
			        System.out.print("Prénom : ");
			        String prenomRecherche = scanner.next();
			       try {
						gestionAgenceLocation.rechercherClient(nomRecherche, prenomRecherche);
					} catch (SQLException e) {
						e.printStackTrace();
					}
			        break;
				case 9:
				    // Enregistrer une location
				    System.out.println("***** Enregistrer une location *******");
				    System.out.print("ID de la location : ");
				    int idlocation = scanner.nextInt();
				    System.out.print("ID du client : ");
				    int idClient1 = scanner.nextInt();
				    System.out.print("ID du véhicule : ");
				    int idVehicule1 = scanner.nextInt();
				    System.out.print("Kilométrage retour : ");
				    int kilometrageRetour = scanner.nextInt();
				    System.out.print("État du véhicule retour : ");
				    String etatVehiculeRetour = scanner.next();
				    System.out.print("Date de location (yyyy-MM-dd) : ");
				    String dateLocationStr = scanner.next();
				    System.out.print("Date de retour (yyyy-MM-dd) : ");
				    String dateRetourStr = scanner.next();

				    // Convertir les dates de type String en type java.util.Date
				    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				    Date dateLocation = dateFormat.parse(dateLocationStr);
				    Date dateRetour = dateFormat.parse(dateRetourStr);
				    Location location = new Location(idlocation, idClient1, idVehicule1, kilometrageRetour, etatVehiculeRetour, dateLocation, dateRetour);

				    try {
				        GestionAgenceLocation.enregistrerLocation(location);
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				    break; 
				    
				case 10:
				    // Visualiser les locations en cours
				    System.out.println("***** Locations en cours *******");
				    try {
				        GestionAgenceLocation.visualiserLocationsEnCours();
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				    break;
				case 11:
				    // Clôturer une location
				    System.out.println("***** Clôturer une location *******");
				    System.out.print("ID de la location : ");
				    int idLocation = scanner.nextInt();
				    System.out.print("Kilométrage retour : ");
				    int kilometrageRetour1 = scanner.nextInt();
				    System.out.print("État du véhicule retour : ");
				    String etatVehiculeRetour1 = scanner.next();

				    try {
				        GestionAgenceLocation.cloturerLocation(idLocation, kilometrageRetour1, etatVehiculeRetour1);
				    } catch (SQLException e) {
				        e.printStackTrace();
				    }
				    break;
				    
			    case 12:
			        // Quitter
			        System.out.println("Au revoir !");
			        break;
			        
			    default:
			        System.out.println("Choix invalide. Veuillez réessayer.");
			        break;
 }
   }
		}
    }}