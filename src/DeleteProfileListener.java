import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DeleteProfileListener implements MouseListener {

    private BoutonDeleteProfile bouton;

    public DeleteProfileListener( BoutonDeleteProfile bouton) {
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
        this.bouton.deleteProfile();
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
