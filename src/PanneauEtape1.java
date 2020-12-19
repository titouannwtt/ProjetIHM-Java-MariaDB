import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanneauEtape1 extends JPanel {
    private String path;
    private Image imgFond;

    double estCoutChauff, estCoutCarb, estCoutPea, estCoutVehic;

    private JTextField idClient, tpsTransp, coutChauffeur, distTransport, coutCarburant, choixVehicule, amortVehicule, prixPeage;
    private JLabel estCoutChauffeur, estCoutCarburant, estCoutPeage, estCoutVehicule;

    private PanneauDevis panDevis;

    private BoutonEstimation boutonEst;

    private BoutonNext boutonNext;

    public PanneauEtape1(String path, PanneauDevis panDevis) {
        super(null);
        this.panDevis = panDevis;
        this.path = path;
        try {
            this.imgFond = ImageIO.read(new File(this.path));
        }catch(IOException e){
            System.err.println("An IOException was caught : "+e.getMessage());
        }

        idClient = new JTextField();
        idClient.setBounds(44,12, 278, 55);
        this.add(idClient);

        tpsTransp = new JTextField();
        tpsTransp.setBounds(44,152, 278,55);
        this.add(tpsTransp);

        coutChauffeur = new JTextField();
        coutChauffeur.setBounds(340, 152, 278,55);
        this.add(coutChauffeur);

        distTransport = new JTextField();
        distTransport.setBounds(638,152,278,55);
        this.add(distTransport);

        coutCarburant = new JTextField();
        coutCarburant.setBounds(935,152,278,55);
        this.add(coutCarburant);

        choixVehicule = new JTextField();
        choixVehicule.setBounds(44, 242,278,55);
        this.add(choixVehicule);

        amortVehicule = new JTextField();
        amortVehicule.setBounds(340,242,278,55);
        this.add(amortVehicule);

        prixPeage = new JTextField();
        prixPeage.setBounds(638,242,278,55);
        this.add(prixPeage);

        estCoutChauffeur = new JLabel();
        estCoutChauffeur.setBounds(239,375,81,31);
        this.add(estCoutChauffeur);

        estCoutCarburant = new JLabel();
        estCoutCarburant.setBounds(239, 413,81,31);
        this.add(estCoutCarburant);

        estCoutPeage = new JLabel();
        estCoutPeage.setBounds(239,449,81,31);
        this.add(estCoutPeage);

        estCoutVehicule = new JLabel();
        estCoutVehicule.setBounds(239,485,81,31);
        this.add(estCoutVehicule);

        boutonEst = new BoutonEstimation(this);
        boutonEst.setBounds(704,398,264,76);
        this.add(boutonEst);

        boutonNext = new BoutonNext(this);
        boutonNext.setBounds(1185,537,59,62);
        this.add(boutonNext);


    }

    public void estimate() throws NumberFormatException{

        this.setEstimations();

        if (this.isOk()) {
            estCoutChauffeur.setText(Double.toString(estCoutChauff));
            estCoutCarburant.setText(Double.toString(estCoutCarb));
            estCoutPeage.setText(Double.toString(estCoutPea));
            estCoutVehicule.setText(Double.toString(estCoutVehic));
        }
    }

    public void setEstimations() throws NumberFormatException{


        if (this.isOk()) {
            estCoutChauff = Double.parseDouble(this.coutChauffeur.getText()) * Double.parseDouble(this.tpsTransp.getText());
            estCoutCarb = Double.parseDouble(this.coutCarburant.getText()) * Double.parseDouble(this.distTransport.getText()) / 100;
            estCoutPea = Double.parseDouble(this.prixPeage.getText());
            estCoutVehic = Double.parseDouble(this.amortVehicule.getText());
        }
        else{
            JOptionPane.showMessageDialog(null, "Certains champs ne sont pas remplis !");
        }
    }

    public double getEstCoutCarb() {
        return estCoutCarb;
    }

    public double getEstCoutChauff() {
        return estCoutChauff;
    }

    public double getEstCoutPea() {
        return estCoutPea;
    }

    public double getEstCoutVehic() {
        return estCoutVehic;
    }

    private boolean isOk(){

        if (idClient.getText().equals("") || tpsTransp.getText().equals("") || coutChauffeur.getText().equals("") || coutCarburant.getText().equals("") || distTransport.getText().equals("") || choixVehicule.getText().equals("")|| amortVehicule.getText().equals("") || prixPeage.getText().equals("")){
            return false;
        }
        else{
            return true;
        }
    }

    public void goNext(){

        if (this.isOk()) {
            this.setEstimations();
            this.panDevis.goNext();
        }
        else{
            JOptionPane.showMessageDialog(null, "Certains champs ne sont pas remplis !");
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgFond,0,0,null);
    }
}
