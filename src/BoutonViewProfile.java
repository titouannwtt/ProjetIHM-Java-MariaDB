import javax.swing.*;

public class BoutonViewProfile extends JLabel {

    private ImageIcon imgBoutonNormal = new ImageIcon("images/src/pages/client/profil_bouton_consulter_normal.png");
    private ImageIcon imgBoutonHover = new ImageIcon("images/src/pages/client/profil_bouton_consulter_hover.png");
    private ImageIcon imgBoutonPress = new ImageIcon("images/src/pages/client/profil_bouton_consulter_press.png");

    private int id;

    public BoutonViewProfile(int id) {
        super();
        this.setIcon(imgBoutonNormal);
        this.id = id;
        this.addMouseListener(new ViewProfileListener(this));


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

    public void viewProfile(){

    }

}
