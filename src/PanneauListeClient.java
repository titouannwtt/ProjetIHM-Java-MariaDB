import javax.swing.*;
import java.awt.*;

public class PanneauListeClient extends JScrollPane {
    JPanel conteneur = new JPanel();
    private Bdd base;

    public PanneauListeClient(Bdd base) {
        this.base = base;
        base.connectSQL();
        GridLayout grid = new GridLayout(base.getNumberOfClient(), 1);
        grid.setVgap(0);
        grid.setHgap(0);

        this.setOpaque(false);
        this.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_NEVER);
        //this.setPreferredSize(new Dimension(1241,650));
        this.setBackground(new Color(0,0,0));
        conteneur.setLayout(grid);
        conteneur.setOpaque(false);
        this.setViewportView(conteneur);


        int i;
        for (i=0; i<base.getNumberOfClient();i++){
            addLigne(i, base.getNomClient(i), base.getLogementDepart(i),base.getLogementArrivee(i), base.getMailClient(i));
        }


        base.closeSQL();



    }

    public void addLigne(int id, String nom, String depart, String arrive, String modif){
        conteneur.add(new ligneProfilClient(base, id, nom, depart, arrive, modif));
    }

    public void Build(){

        base.connectSQL();
        this.conteneur= new JPanel();
        this.setViewportView(conteneur);
        GridLayout grid = new GridLayout(base.getNumberOfClient(), 1);
        conteneur.setLayout(grid);
        conteneur.setOpaque(false);

        int i;
        for (i=0; i<base.getNumberOfClient();i++){
            addLigne(i, base.getNomClient(i), base.getLogementDepart(i),base.getLogementArrivee(i), base.getMailClient(i));
        }


        base.closeSQL();
    }


}
