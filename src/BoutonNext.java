import javax.swing.*;

public class BoutonNext extends JLabel {
    private ImageIcon imgBoutonNormal = new ImageIcon("images/src/pages/devis/etape1/next_normal.png");
    private ImageIcon imgBoutonHover = new ImageIcon("images/src/pages/devis/etape1/next_hover.png");
    private ImageIcon imgBoutonPress = new ImageIcon("images/src/pages/devis/etape1/next_press.png");

    private PanneauEtape1 panneau;

    public BoutonNext(PanneauEtape1 panneau) {

        this.panneau = panneau;
        this.setIcon(imgBoutonNormal);
        this.addMouseListener(new NextListener(this));
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

    public void goNext(){
        this.panneau.goNext();
    }
}
