

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Bdd {

  private Connection co;

  public Bdd() {
  }

  public void connectSQL() {
    try {
      Class.forName("org.mariadb.jdbc.Driver");
    } catch (ClassNotFoundException e1){
      System.out.println(e1.getMessage());
    }
    try {
      Connection co = DriverManager.getConnection(
              "jdbc:mariadb://dwarves.iut-fbleau.fr/castrop",
              "castrop", "444719");
      this.co=co;
    } catch (SQLException e2){
      System.out.println(e2.getMessage());
    }
  }

  public void closeSQL() {
    try {
      this.co.close();
  	} catch (SQLException e3){ 
      System.out.println(e3.getMessage());		     
    }
  }


  //==========================================================
  //==========================================================
  //==========================================================

  public void createDevis(double coutChauffeur, double coutCarburant, double coutPeage, double coutVehicule, int serviceDemontage, int serviceEmballage, int serviceEtatLieuxSortie, int serviceEtatLieuxEntree, int serviceGroupage, int serviceDevisTardif, double manDepVolume, double manDepEtage, double manDepDistance, int manDepMonteMeuble, int manDepAscenseur, double manArrVolume, double manArrEtage, double manArrDistance, int manArrMonteMeuble, int manArrAscenseur) {
  	String query = "INSERT INTO Profil (id, coutChauffeur, coutCarburant, coutPeage, coutVehicule, serviceDemontage, serviceEmballage, serviceEtatLieuxSortie, serviceEtatLieuxEntree, serviceGroupage, serviceDevisTardif, manDepVolume, manDepEtage, manDepDistance, manDepMonteMeuble, manDepAscenseur, manArrVolume, manArrEtage, manArrDistance, manArrMonteMeuble, manArrAscenseur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  	try {
  		PreparedStatement requete = this.co.prepareStatement(query);

		int x = getNumberOfDevis();
		String id = String.valueOf(x); 
		requete.setString(1, id);
     	String t = String.valueOf(coutChauffeur); 
  		requete.setString(2, t);
     	t = String.valueOf(coutCarburant); 
		requete.setString(3, t);
     	t = String.valueOf(coutPeage); 
		requete.setString(4, t);
     	t = String.valueOf(coutVehicule); 
		requete.setString(5, t);
     	t = String.valueOf(serviceDemontage); 
		requete.setString(6, t);
     	t = String.valueOf(serviceEmballage); 
		requete.setString(7, t);
     	t = String.valueOf(serviceEtatLieuxSortie); 
		requete.setString(8, t);
     	t = String.valueOf(serviceEtatLieuxEntree); 
		requete.setString(9, t);
     	t = String.valueOf(serviceGroupage); 
		requete.setString(10, t);
     	t = String.valueOf(serviceDevisTardif); 
		requete.setString(11, t);
     	t = String.valueOf(manDepVolume); 
		requete.setString(12, t);
     	t = String.valueOf(manDepEtage); 
		requete.setString(13, t);
     	t = String.valueOf(manDepDistance); 
		requete.setString(14, t);
     	t = String.valueOf(manDepMonteMeuble); 
		requete.setString(15, t);
     	t = String.valueOf(manDepAscenseur); 
		requete.setString(16, t);
     	t = String.valueOf(manArrVolume); 
		requete.setString(17, t);
     	t = String.valueOf(manArrEtage); 
		requete.setString(18, t);
     	t = String.valueOf(manArrDistance); 
		requete.setString(19, t);
     	t = String.valueOf(manArrMonteMeuble); 
		requete.setString(20, t);
     	t = String.valueOf(manArrAscenseur); 
		requete.setString(8, t);
  		ResultSet res = requete.executeQuery();
  		requete.close();
  	} catch (SQLException e4){ 
      	System.out.println(e4.getMessage());		     
  	}
  }

  public int getNumberOfDevis() {
    int x = 0;
    try {
      PreparedStatement requete = this.co.prepareStatement("SELECT COUNT(*) FROM Devis");
      ResultSet res = requete.executeQuery();
      res.first();
      x=res.getInt(1);

      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return x;
  }

  //==========================================================
  //==========================================================
  //==========================================================


  public int getNumberOfClient() {
    int x = 0;
    try {
      PreparedStatement requete = this.co.prepareStatement("SELECT COUNT(*) FROM Profil");
      ResultSet res = requete.executeQuery();
      res.first();
      x=res.getInt(1);

      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return x;
  }

  public String getNomClient(int id) {
    String resultat = new String();
    String query = "SELECT Nom from Profil where Id=?";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      String t = String.valueOf(id); 
      requete.setString(1, t);
      ResultSet res = requete.executeQuery();
      res.first();
      resultat=res.getString(1);
      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return resultat;
  }
  public String getLogementDepart(int id) {
    String resultat = new String();
    String query = "SELECT LogementDep from Profil where Id=?";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      String t = String.valueOf(id); 
      requete.setString(1, t);
      ResultSet res = requete.executeQuery();
      res.first();
      resultat=res.getString(1);
      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return resultat;
  }
  public String getLogementArrivee(int id) {
    String resultat = new String();
    String query = "SELECT LogementArr from Profil where Id=?";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      String t = String.valueOf(id); 
      requete.setString(1, t);
      ResultSet res = requete.executeQuery();
      res.first();
      resultat=res.getString(1);
      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return resultat;
  }
  public String getMailClient(int id) {
    String resultat = new String();
    String query = "SELECT Mail from Profil where Id=?";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      String t = String.valueOf(id); 
      requete.setString(1, t);
      ResultSet res = requete.executeQuery();
      res.first();
      resultat=res.getString(1);
      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return resultat;
  }
  public String suppressClient(int id) {
    String resultat = new String();
    String query = "DELETE from Client where id=?";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      String t = String.valueOf(id); 
      requete.setString(1, t);
      ResultSet res = requete.executeQuery();
      res.first();
      resultat=res.getString(1);
      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return resultat;
  }

  //==========================================================
  //==========================================================
  //==========================================================

  public int getNumberOfCamion() {
    int x = 0;
    String query = "SELECT COUNT(*) FROM Camion;";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      ResultSet res = requete.executeQuery();
      res.first();
      x=res.getInt(1);

      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return x;
  }

  public String getHeureDepart(int id) {
    String resultat = new String();
    String query = "SELECT HeureDep from Camion where Numero=?";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      String t = String.valueOf(id); 
      requete.setString(1, t);
      ResultSet res = requete.executeQuery();
      res.first();
      resultat=res.getString(1);
      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return resultat;
  }

  public String getLieuDepart(int id) {
    String resultat = new String();
    String query = "SELECT LieuDep from Camion where Numero=?";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      String t = String.valueOf(id); 
      requete.setString(1, t);
      ResultSet res = requete.executeQuery();
      res.first();
      resultat=res.getString(1);
      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return resultat;
  }

  public String getHeureArrivee(int id) {
    String resultat = new String();
    String query = "SELECT HeureArr from Camion where Numero=?";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      String t = String.valueOf(id); 
      requete.setString(1, t);
      ResultSet res = requete.executeQuery();
      res.first();
      resultat=res.getString(1);
      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return resultat;
  }

  public String getLieuArrivee(int id) {
    String resultat = new String();
    String query = "SELECT LieuArr from Camion where Numero=?";
    try {
      PreparedStatement requete = this.co.prepareStatement(query);
      String t = String.valueOf(id); 
      requete.setString(1, t);
      ResultSet res = requete.executeQuery();
      res.first();
      resultat=res.getString(1);
      requete.close();
    } catch (SQLException e4){ 
        System.out.println(e4.getMessage());         
    }
    return resultat;
  }
  
  //==========================================================
  //==========================================================
  //==========================================================

  public void createClient(String nom, String logementDep, String logementArr, String mail) {
  	String query = "INSERT INTO Profil (Nom, LogementDep, LogementArr, DerniereModif, Id, Mail) VALUES (?, ?, ?, ?, ?, ?)";
  	try {
  		PreparedStatement requete = this.co.prepareStatement(query);
      //========== NOM ================
  		requete.setString(1, nom);
      //===== LOGEMENT DEPART =========
      requete.setString(2, logementDep);
      //===== LOGEMENT ARRIVE =========
      requete.setString(3, logementArr);
      //====== DERNIERE MODIF =========
      java.util.Date dt = new java.util.Date();
      java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String currentTime = sdf.format(dt);
      requete.setString(4, currentTime);
      //=========== ID ===============
      int x = getNumberOfClient();
      String id = String.valueOf(x); 
      requete.setString(5, id);
      //========== MAIL ==============
      requete.setString(6, mail);
      //=============================
  		ResultSet res = requete.executeQuery();
  		requete.close();
  	} catch (SQLException e4){ 
      	System.out.println(e4.getMessage());		     
  	}
  }
}