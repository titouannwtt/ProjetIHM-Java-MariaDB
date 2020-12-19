import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CreerProfilListener implements MouseListener {

    private BoutonCreerProfil bouton;

    public CreerProfilListener(BoutonCreerProfil bouton) {
        this.bouton = bouton;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        this.bouton.setPressed();

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        this.bouton.setNormal();
        this.bouton.creerProfil();
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        this.bouton.setHovered();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        this.bouton.setNormal();
    }
}
