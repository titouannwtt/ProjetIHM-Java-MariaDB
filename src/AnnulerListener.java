import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnnulerListener implements ActionListener {
    private FenetreCreerProfil fen;

    public AnnulerListener(FenetreCreerProfil fen) {
        this.fen = fen;

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        fen.fermerFenetre();
    }
}
