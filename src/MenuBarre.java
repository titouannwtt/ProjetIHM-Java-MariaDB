import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class MenuBarre extends JPanel {

    private BufferedImage imgFond;
    private Fenetre fen;
    private PanneauPrincipal pan;

    public MenuBarre(Fenetre fen, PanneauPrincipal pan) {
        this.fen = fen;
        this.pan = pan;
        Dimension dim = new Dimension(1280,100);
        this.setPreferredSize(dim);
        this.setSize(dim);
        try {
            this.imgFond = ImageIO.read(new File("images/src/barre/barre.png"));
        }catch(IOException e){
            System.err.println("An IOException was caught : "+e.getMessage());
        }

        Bouton exit = new Bouton(fen,"exit", new ImageIcon("images/src/barre/bouton_exit/exit_normal.png"),
                new ImageIcon("images/src/barre/bouton_exit/exit_hover.png"),
                new ImageIcon("images/src/barre/bouton_exit/exit_press.png"));

        Bouton reduce = new Bouton(fen,"reduce", new ImageIcon("images/src/barre/bouton_reduce/reduce_normal.png"),
                new ImageIcon("images/src/barre/bouton_reduce/reduce_hover.png"),
                new ImageIcon("images/src/barre/bouton_reduce/reduce_press.png"));

        Bouton client = new Bouton(pan, fen,"client", new ImageIcon("images/src/barre/boutons_menu/client/bouton_client_normal.png"),
                new ImageIcon("images/src/barre/boutons_menu/client/bouton_client_hover.png"),
                new ImageIcon("images/src/barre/boutons_menu/client/bouton_client_press.png"));

        Bouton devis = new Bouton(pan,fen,"devis", new ImageIcon("images/src/barre/boutons_menu/devis/bouton_devis_normal.png"),
                new ImageIcon("images/src/barre/boutons_menu/devis/bouton_devis_hover.png"),
                new ImageIcon("images/src/barre/boutons_menu/devis/bouton_devis_press.png"));

        Bouton planning = new Bouton(pan,fen,"planning", new ImageIcon("images/src/barre/boutons_menu/planning/bouton_planning_normal.png"),
                new ImageIcon("images/src/barre/boutons_menu/planning/bouton_planning_hover.png"),
                new ImageIcon("images/src/barre/boutons_menu/planning/bouton_planning_press.png"));


        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(new GridBagLayout());

        gbc.fill = GridBagConstraints.NONE;
        gbc.insets = new Insets(0,0,0,0);
        gbc.weightx = 60;
        gbc.weighty = 1;
        gbc.gridx = 6;
        gbc.gridy = 0;
        gbc.ipadx = 2;

        this.add(exit, gbc);

        gbc.gridx = 5;
        this.add(reduce,gbc);

        gbc.gridx = 1;
        gbc.weightx = 300;
        this.add(client, gbc);

        gbc.gridx = 2;
        this.add(devis, gbc);

        gbc.gridx = 3;
        this.add(planning, gbc);



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgFond,0,0,null);
    }
}
