import javax.swing.*;
import java.awt.*;

public class PanneauPlanning extends JScrollPane {
    private Bdd base;
    private JPanel conteneur = new JPanel();

    public PanneauPlanning(Bdd base) {
        this.base = base;
        this.base.connectSQL();
        GridLayout grid = new GridLayout(base.getNumberOfCamion(), 1);
        grid.setVgap(0);
        grid.setHgap(0);

        this.setOpaque(false);
        this.setBounds(20,92, 1237, 469);
        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        conteneur.setLayout(grid);
        conteneur.setOpaque(false);
        this.setViewportView(conteneur);

        int i;
        for (i=1; i<=this.base.getNumberOfCamion();i++){
            addLigne(i, this.base.getHeureDepart(i), this.base.getLieuDepart(i),this.base.getHeureArrivee(i), this.base.getLieuArrivee(i));
        }

        base.closeSQL();

    }
    public void addLigne(int id, String hDepart, String lieuDepart, String hArrivee, String lieuArrivee){
        this.conteneur.add(new LignePlanning(id, hDepart, lieuDepart, hArrivee, lieuArrivee));
    }
}
