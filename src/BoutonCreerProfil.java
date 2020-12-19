

import javax.swing.*;


public class BoutonCreerProfil extends JLabel{

    private ImageIcon imgBoutonNormal = new ImageIcon("images/src/pages/client/bouton_creer_profil_normal.png");
    private ImageIcon imgBoutonHover = new ImageIcon("images/src/pages/client/bouton_creer_profil_hover.png");
    private ImageIcon imgBoutonPress = new ImageIcon("images/src/pages/client/bouton_creer_profil_press.png");

    private Bdd base;
    private PanneauListeClient panListClient;


    public BoutonCreerProfil(Bdd base, PanneauListeClient pan) {
        super();
        this.setIcon(imgBoutonNormal);
        this.base = base;
        this.panListClient = pan;

        this.addMouseListener(new CreerProfilListener(this));


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

    public void creerProfil(){
        FenetreCreerProfil fenProfile = new FenetreCreerProfil(this.base, this.panListClient);
        fenProfile.setVisible(true);
    }
}
