import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Panneau extends JPanel {

    private Image imgFond;
    private String path;

    public Panneau(LayoutManager layoutManager, String path) {
        super(layoutManager);
        this.setOpaque(false);
        this.path = path;
        this.setPreferredSize(new Dimension(1280,620));
        this.setSize(1280,620);
        try {
            this.imgFond = ImageIO.read(new File(this.path));
        }catch(IOException e){
            System.err.println("An IOException was caught : "+e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(imgFond,0,0,null);
    }
}
