import javax.swing.*;
import java.awt.*;

public class Fenetre extends JFrame {
    private MenuBarre barre;
    private PanneauPrincipal mainPan;
    private Bdd base;

    public Fenetre() throws HeadlessException {
        this.setSize(1280, 720);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setTitle("");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0 ,0));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.base = new Bdd();
        this.mainPan = new PanneauPrincipal(this.base);
        this.barre = new MenuBarre(this, mainPan);
        this.add(barre);
        this.add(mainPan);
    }

}
