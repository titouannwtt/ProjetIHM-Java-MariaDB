import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class LignePlanning extends JPanel {

    private Image imgFond;
    private JLabel id, hDepart, lieuDepart, hArrive, lieuArrivee;

    public LignePlanning(int id, String hDepart, String lieuDepart, String hArrive, String lieuArrivee) {

        this.setOpaque(false);
        this.setPreferredSize(new Dimension(1241,52));
        this.setSize(1241,52);
        this.setLayout(new FlowLayout());

        try {
            this.imgFond = ImageIO.read(new File("images/src/pages/planning/camion_line.png"));
        }catch(IOException e){
            System.err.println("An IOException was caught : "+e.getMessage());
        }

        this.id = new JLabel(Integer.toString(id));
        this.id.setPreferredSize(new Dimension(217, 52));
        this.hDepart = new JLabel(hDepart);
        this.hDepart.setPreferredSize(new Dimension(240,52));
        this.lieuDepart = new JLabel(lieuDepart);
        this.lieuDepart.setPreferredSize(new Dimension(259,52));
        this.hArrive = new JLabel(hArrive);
        this.hArrive.setPreferredSize(new Dimension(230,52));
        this.lieuArrivee = new JLabel(lieuArrivee);
        this.lieuArrivee.setPreferredSize(new Dimension(268,52));

        this.add(this.id);
        this.add(this.hDepart);
        this.add(this.lieuDepart);
        this.add(this.hArrive);
        this.add(this.lieuArrivee);



    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgFond,0,0,null);
    }
}
