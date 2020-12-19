import javax.swing.*;

public class BoutonPrev extends JLabel {

    private ImageIcon imgBoutonNormal = new ImageIcon("images/src/pages/devis/etape1/previous_normal.png");
    private ImageIcon imgBoutonHover = new ImageIcon("images/src/pages/devis/etape1/previous_hover.png");
    private ImageIcon imgBoutonPress = new ImageIcon("images/src/pages/devis/etape1/previous_press.png");

    private PanneauEtape2 panneau;

    public BoutonPrev(PanneauEtape2 panneau) {
        this.panneau = panneau;
        this.setIcon(imgBoutonNormal);
        this.addMouseListener(new PrevListener(this));
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

    public void goPrev(){
        this.panneau.goPrev();
    }
}
