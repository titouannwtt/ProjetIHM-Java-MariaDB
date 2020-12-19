import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ligneProfilClient extends JPanel{

    private Image imgFond;
    private JLabel id, nom, arrive, depart, modif;
    private int idnumber;
    private Bdd base;


    public ligneProfilClient(Bdd base, int idnumber, String nom, String depart, String arrive, String modif) {

        this.setLayout(new FlowLayout());
        this.base = base;

        this.setOpaque(false);
        this.setPreferredSize(new Dimension(1241,52));
        this.setSize(1241,52);

        try {
            this.imgFond = ImageIO.read(new File("images/src/pages/client/profil_line.png"));
        }catch(IOException e){
            System.err.println("An IOException was caught : "+e.getMessage());
        }
        this.idnumber = idnumber;

        this.id = new JLabel(Integer.toString(this.idnumber));
        this.id.setPreferredSize(new Dimension(93,50));
        this.nom = new JLabel(nom);
        this.nom.setPreferredSize(new Dimension(140, 50));
        this.arrive = new JLabel(arrive);
        this.arrive.setPreferredSize(new Dimension(255, 50));
        this.depart = new JLabel(depart);
        this.depart.setPreferredSize(new Dimension(270,50));
        this.modif = new JLabel(modif);
        this.modif.setPreferredSize(new Dimension(173, 50));

        this.add(this.id);
        this.add(this.nom);
        this.add(this.depart);
        this.add(this.arrive);
        this.add(this.modif);
        this.add(new BoutonViewProfile(this.idnumber));
        this.add(new BoutonDeleteProfile(base, this.idnumber));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgFond,0,0,null);
    }
}
