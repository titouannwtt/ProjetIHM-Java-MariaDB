import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PanneauPrincipal extends JPanel {

    private Image imgFond;
    CardLayout gest;
    Panneau clientPan, planningPan;
    PanneauDevis devisPan;
    private Bdd base;

    public PanneauPrincipal(Bdd base) {
        this.setPreferredSize(new Dimension(1280,620));
        this.setSize(1280,620);
        this.base = base;
        gest = new CardLayout();
        this.setLayout(gest);
        try {
            this.imgFond = ImageIO.read(new File("images/src/background.png"));
        }catch(IOException e){
            System.err.println("An IOException was caught : "+e.getMessage());
        }

        buildClientPan();

        buildDevisPan();

        buildPlanningPan();




        gest.next(this);

    }

    public void changerOnglet(String onglet){
        gest.show(this, onglet);
    }

    public void buildClientPan(){
        clientPan = new Panneau(new GridBagLayout(), "images/src/pages/client/client.png");
        PanneauListeClient clientListePan = new PanneauListeClient(this.base);

        BoutonCreerProfil bouton = new BoutonCreerProfil(this.base, clientListePan);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.weighty = 0;
        gbc.insets = new Insets(15,10,60,0);

        clientPan.add(bouton, gbc);

        gbc.gridy = 1;
        gbc.weighty = 1;
        gbc.insets = new Insets(0,17, 55, 10);
        gbc.fill = GridBagConstraints.BOTH;

        clientPan.add(clientListePan, gbc);
        this.add(clientPan, "CLIENT");

    }

    public void buildPlanningPan(){
        planningPan = new Panneau(null, "images/src/pages/planning/planning.png");
        planningPan.add(new PanneauPlanning(this.base));
        this.add(planningPan,"PLANNING");
    }

    public void buildDevisPan(){
        this.devisPan = new PanneauDevis(this.base);
        this.add(devisPan, "DEVIS");
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgFond,0,0,null);
    }
}
