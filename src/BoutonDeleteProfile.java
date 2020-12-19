import javax.swing.*;

public class BoutonDeleteProfile extends JLabel {
    private int id;
    private ImageIcon imgBoutonNormal = new ImageIcon("images/src/pages/client/profil_bouton_supprimer_normal.png");
    private ImageIcon imgBoutonHover = new ImageIcon("images/src/pages/client/profil_bouton_supprimer_hover.png");
    private ImageIcon imgBoutonPress = new ImageIcon("images/src/pages/client/profil_bouton_supprimer_press.png");
    private Bdd base;

    public BoutonDeleteProfile(Bdd base, int id) {

        super();

        this.base = base;
        this.setIcon(imgBoutonNormal);
        this.id = id;
        this.addMouseListener(new DeleteProfileListener( this));

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

    public void deleteProfile(){

    }
}
