import javax.swing.*;

public class BoutonEstimation extends JLabel {
    private ImageIcon imgBoutonNormal = new ImageIcon("images/src/pages/devis/etape1/estimation.png");
    private ImageIcon imgBoutonHover = new ImageIcon("images/src/pages/devis/etape1/estimation_hover.png");
    private ImageIcon imgBoutonPress = new ImageIcon("images/src/pages/devis/etape1/estimation_press.png");

    private PanneauEtape1 panneau;

    public BoutonEstimation(PanneauEtape1 panneau) {

        this.panneau = panneau;
        this.setIcon(imgBoutonNormal);
        this.addMouseListener(new EstimationListener(this));
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

    public void estimate(){
        panneau.estimate();
    }

}
