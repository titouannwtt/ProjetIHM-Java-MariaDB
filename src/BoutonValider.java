import javax.swing.*;

public class BoutonValider extends JLabel {
    private ImageIcon imgBoutonNormal = new ImageIcon("images/src/pages/devis/etape1/valider_normal.png");
    private ImageIcon imgBoutonHover = new ImageIcon("images/src/pages/devis/etape1/valider_hover.png");
    private ImageIcon imgBoutonPress = new ImageIcon("images/src/pages/devis/etape1/valider_press.png");

    private PanneauEtape2 panneau;

    public BoutonValider(PanneauEtape2 panneau) {

        this.panneau = panneau;
        this.setIcon(imgBoutonNormal);
        this.addMouseListener(new BoutonValiderListener(this));
    }

    public void setHovered(){

        this.setIcon(imgBoutonHover);
        this.repaint();
    }

    public void setPressed(){
        this.setIcon(imgBoutonPress);
        this.repaint();
    }

    public void setNormal(){
        this.setIcon(imgBoutonNormal);
        this.repaint();
    }

    public void valider(){
        this.panneau.valider();
    }
}