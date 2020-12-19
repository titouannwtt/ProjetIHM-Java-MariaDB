import javax.swing.*;
import java.awt.*;

public class Bouton extends JLabel {

    private String text;

    private ImageIcon imgBoutonNormal;
    private ImageIcon imgBoutonHover;
    private ImageIcon imgBoutonPress;

    private Fenetre fen;
    private PanneauPrincipal pan;

    public Bouton(Fenetre fen, String text, ImageIcon imgBoutonNormal, ImageIcon imgBoutonHover, ImageIcon imgBoutonPress) {
        super(imgBoutonNormal);
        this.text = text;
        this.imgBoutonNormal = imgBoutonNormal;
        this.imgBoutonHover = imgBoutonHover;
        this.imgBoutonPress = imgBoutonPress;
        this.setPreferredSize(new Dimension(300,100));
        this.addMouseListener(new MenuBoutonListener(this));
        this.fen = fen;
    }
    public Bouton(PanneauPrincipal pan,Fenetre fen, String text, ImageIcon imgBoutonNormal, ImageIcon imgBoutonHover, ImageIcon imgBoutonPress) {
        super(imgBoutonNormal);
        this.pan = pan;
        this.text = text;
        this.imgBoutonNormal = imgBoutonNormal;
        this.imgBoutonHover = imgBoutonHover;
        this.imgBoutonPress = imgBoutonPress;
        this.setPreferredSize(new Dimension(300,100));
        this.addMouseListener(new MenuBoutonListener(this));
        this.fen = fen;
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

    public void activated(){
        if (this.text == "exit"){
            fen.dispose();
        }
        if (this.text == "reduce"){

        }
        if (this.text.equals("client")){
            pan.changerOnglet("CLIENT");
        }
        if (this.text == "devis"){
            pan.changerOnglet("DEVIS");
        }
        if (this.text == "planning"){
            pan.changerOnglet("PLANNING");
        }


    }

}
