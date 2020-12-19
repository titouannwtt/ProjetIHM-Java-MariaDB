import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanneauEtape2 extends JPanel {
    private String path;
    private Image imgFond;

    private double estCoutCarb, estCoutChauff, estCoutPea, estCoutVehic;

    private JCheckBox demonteMeuble, emballageMeuble, etatLieuSortie, etatLieuEntree, reductionGroupage, devisTardif, monteMeubleDepart, ascenseurDepart, monteMeubleArrivee, ascenseurArrivee;

    private JTextField volumeDepart, etageDepart, distanceDepart, volumeArrivee, etageArrivee, distanceArrivee;

    private BoutonPrev boutonPrev;

    private BoutonValider boutonValider;

    private PanneauDevis panDevis;

    private Bdd base;

    public PanneauEtape2(String path, PanneauDevis panDevis, Bdd base, double estCoutCarb, double estCoutChauff, double estCoutPea, double estCoutVehic) {
        super(null);

        this.panDevis = panDevis;
        this.path = path;
        this.estCoutCarb = estCoutCarb;
        this.estCoutChauff = estCoutChauff;
        this.estCoutPea = estCoutPea;
        this.estCoutVehic = estCoutVehic;

        try {
            this.imgFond = ImageIO.read(new File(this.path));
        } catch (IOException e) {
            System.err.println("An IOException was caught : " + e.getMessage());
        }

        this.demonteMeuble = new JCheckBox();
        this.demonteMeuble.setBounds(46,64,30,30);
        demonteMeuble.setOpaque(false);
        this.add(demonteMeuble);

        this.emballageMeuble = new JCheckBox();
        this.emballageMeuble.setBounds(46,105,30,30);
        emballageMeuble.setOpaque(false);
        this.add(emballageMeuble);

        this.etatLieuSortie = new JCheckBox();
        this.etatLieuSortie.setBounds(46,145,30,30);
        etatLieuSortie.setOpaque(false);
        this.add(etatLieuSortie);

        this.etatLieuEntree = new JCheckBox();
        this.etatLieuEntree.setBounds(46,186,30,30);
        etatLieuEntree.setOpaque(false);
        this.add(etatLieuEntree);

        this.reductionGroupage = new JCheckBox();
        this.reductionGroupage.setBounds(641,64,30,30);
        reductionGroupage.setOpaque(false);
        this.add(reductionGroupage);

        this.devisTardif = new JCheckBox();
        this.devisTardif.setBounds(641,104,30,30);
        devisTardif.setOpaque(false);
        this.add(devisTardif);

        this.volumeDepart = new JTextField();
        this.volumeDepart.setBounds(44,307,288,55);
        this.add(volumeDepart);

        this.etageDepart = new JTextField();
        this.etageDepart.setBounds(339,307,288,55);
        this.add(etageDepart);

        this.distanceDepart= new JTextField();
        this.distanceDepart.setBounds(637,307,288,55);
        this.add(distanceDepart);

        this.monteMeubleDepart = new JCheckBox();
        this.monteMeubleDepart.setBounds(938,290,30,30);
        monteMeubleDepart.setOpaque(false);
        this.add(monteMeubleDepart);

        this.ascenseurDepart = new JCheckBox();
        this.ascenseurDepart.setBounds(938,331,30,30);
        ascenseurDepart.setOpaque(false);
        this.add(ascenseurDepart);

        this.volumeArrivee= new JTextField();
        this.volumeArrivee.setBounds(44,454,288,55);
        this.add(volumeArrivee);

        this.etageArrivee= new JTextField();
        this.etageArrivee.setBounds(339,454,288,55);
        this.add(etageArrivee);

        this.distanceArrivee= new JTextField();
        this.distanceArrivee.setBounds(637,454,288,55);
        this.add(distanceArrivee);

        this.ascenseurArrivee = new JCheckBox();
        this.ascenseurArrivee.setBounds(938,478,30,30);
        ascenseurArrivee.setOpaque(false);
        this.add(ascenseurArrivee);

        this.monteMeubleArrivee = new JCheckBox();
        this.monteMeubleArrivee.setBounds(938,437,30,30);
        monteMeubleArrivee.setOpaque(false);
        this.add(monteMeubleArrivee);

        this.boutonPrev= new BoutonPrev(this);
        this.boutonPrev.setBounds(25,537, 59, 62);
        this.add(boutonPrev);

        this.boutonValider = new BoutonValider(this);
        this.boutonValider.setBounds(1185,537,59,62);
        this.add(boutonValider);



    }


    public void goPrev(){
        this.panDevis.goPrev();
    }

    private int isDemonteMeuble(){
        int x = 0;
        if (demonteMeuble.isSelected()){
           x = 1;
        }
        return x;
    }
    private int isEmballageMeuble(){
        int x = 0;
        if (emballageMeuble.isSelected()){
            x = 1;
        }
        return x;
    }
    private int isEtatlieuSortie(){
        int x = 0;
        if (etatLieuSortie.isSelected()){
            x = 1;
        }
        return x;
    }
    private int isEtatlieuEntree(){
        int x = 0;
        if (etatLieuEntree.isSelected()){
            x = 1;
        }
        return x;
    }

    private int isReductionGroupage(){
        int x = 0;
        if (reductionGroupage.isSelected()){
            x = 1;
        }
        return x;
    }
    private int isDevisTardif(){
        int x = 0;
        if (devisTardif.isSelected()){
            x = 1;
        }
        return x;
    }
    private int isMonteMeubleDepart(){
        int x = 0;
        if (monteMeubleDepart.isSelected()){
            x = 1;
        }
        return x;
    }
    private int isAscenseurDepart(){
        int x = 0;
        if (ascenseurDepart.isSelected()){
            x = 1;
        }
        return x;
    }
    private int isMonteMeubleArrivee(){
        int x = 0;
        if (monteMeubleArrivee.isSelected()){
            x = 1;
        }
        return x;
    }
    private int isAscenseurArrivee(){
        int x = 0;
        if (ascenseurArrivee.isSelected()){
            x = 1;
        }
        return x;
    }




    public void valider(){

        if (this.isOk()) {
            this.base.createDevis(estCoutChauff, estCoutCarb, estCoutPea,
                    estCoutVehic, this.isDemonteMeuble(), this.isEmballageMeuble(),
                    this.isEtatlieuSortie(), this.isEtatlieuEntree(), this.isReductionGroupage(),
                    this.isDevisTardif(), Double.parseDouble(this.volumeDepart.getText()),
                    Double.parseDouble(this.etageDepart.getText()), Double.parseDouble(this.distanceDepart.getText()),
                    this.isMonteMeubleDepart(), this.isAscenseurDepart(), Double.parseDouble(this.volumeArrivee.getText()),
                    Double.parseDouble(this.etageArrivee.getText()), Double.parseDouble(this.distanceArrivee.getText()),
                    this.isMonteMeubleArrivee(), this.isAscenseurArrivee());
        }
        else{
            JOptionPane.showMessageDialog(null, "Certains champs ne sont pas remplis !");
        }

    }

    private boolean isOk(){

        if (volumeDepart.getText().equals("") || etageDepart.getText().equals("") || distanceDepart.getText().equals("") || volumeArrivee.getText().equals("") || etageArrivee.getText().equals("") || distanceArrivee.getText().equals("")){
            return false;
        }
        else{
            return true;
        }
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgFond,0,0,null);
    }
}
