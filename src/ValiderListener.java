
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValiderListener implements ActionListener {

    private FenetreCreerProfil fen;
    private Bdd base;

    public ValiderListener(FenetreCreerProfil fen, Bdd base) {
        this.fen = fen;
        this.base = base;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        base.createClient(fen.getNom(), fen.getDepart(),fen.getArrivee(), fen.getMail());
        System.out.println("Test");
        fen.reBuildPan();
        fen.fermerFenetre();
    }
}
