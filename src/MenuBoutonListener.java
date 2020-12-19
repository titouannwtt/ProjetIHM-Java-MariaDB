import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuBoutonListener implements MouseListener {

    private Bouton bouton;

    public MenuBoutonListener(Bouton bouton) {
        this.bouton = bouton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        bouton.setPressed();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        bouton.setNormal();
        bouton.activated();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        bouton.setHovered();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        bouton.setNormal();
    }
}
