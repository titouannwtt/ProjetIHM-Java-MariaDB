//java -cp ".:/export/documents/mariadb-client.jar" Test

public class Test {

    public static void main(String[] args) {
		Bdd bdd = new Bdd();
		System.out.println("Nombre de Client:"+ bdd.getNumberOfClient());
		System.out.println("	Exemple Nom ID 1:"+ bdd.getNomClient(1));
		System.out.println("	Exemple Logement Depart ID 1:"+ bdd.getLogementDepart(1));
		System.out.println("	Exemple Logement Arrive ID 1:"+ bdd.getLogementArrivee(1));
		System.out.println(" ");
		System.out.println("Nombre de Camion:"+ bdd.getNumberOfCamion());
		System.out.println("	Exemple Heure Depart ID 1:"+ bdd.getHeureDepart(1));
		System.out.println("	Exemple Lieu Depart ID 1:"+ bdd.getLieuDepart(1));
		System.out.println("	Exemple Heure Arrive ID 1:"+ bdd.getHeureArrivee(1));
		System.out.println("	Exemple Lieu Arrive ID 1:"+ bdd.getLieuArrivee(1));
    }
}
