
import javax.swing.*;
import java.awt.*;


public class PanneauDevis extends JPanel {

    private PanneauEtape1 etape1;
    private PanneauEtape2 etape2;
    private CardLayout card;
    private Bdd base;

    public PanneauDevis(Bdd base) {
        this.base = base;
        card = new CardLayout();
        this.setLayout(card);

        this.buildEtape1();

    }

    public void buildEtape1(){
        etape1 = new PanneauEtape1("images/src/pages/devis/etape1/etape1_sans_cadre.png", this);
        this.add(etape1, "E1");
    }

    public void buildEtape2(){
        etape2 = new PanneauEtape2("images/src/pages/devis/etape1/etape2_sans_cadre.png", this, this.base, etape1.getEstCoutCarb(), etape1.getEstCoutChauff(), etape1.getEstCoutPea(), etape1.getEstCoutVehic());
        this.add(etape2, "E2");
    }

    public void goNext(){

        buildEtape2();
        card.next(this);

    }

    public void goPrev(){
        card.previous(this);
    }
}
