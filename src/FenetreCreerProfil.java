import javax.swing.*;
import java.awt.*;

public class FenetreCreerProfil extends JFrame {

    private Bdd base;

    private JTextField nomField, departField, arriveeField, mailField;

    private JLabel nomLabel, departLabel, arriveeLabel, mailLabel;

    private JButton valider, annuler;

    private PanneauListeClient pan;

    public FenetreCreerProfil(Bdd base, PanneauListeClient pan) throws HeadlessException {

        super();
        this.base = base;
        this.pan = pan;
        base.connectSQL();
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        this.setLayout(grid);

        this.setSize(400, 200);
        this.setTitle("Créer un profil");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        nomField = new JTextField(10);
        nomLabel = new JLabel("Nom :");

        departField = new JTextField(10);
        departLabel = new JLabel("Depart :");

        arriveeField= new JTextField(10);
        arriveeLabel = new JLabel("Arrivee :");

        mailField = new JTextField(10);
        mailLabel = new JLabel("E-mail :");

        valider = new JButton("Valider");
        valider.addActionListener(new ValiderListener(this, this.base));
        annuler = new JButton("Annuler");
        annuler.addActionListener(new AnnulerListener(this));


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;

        this.add(nomLabel, gbc);

        gbc.gridx =1;
        this.add(nomField, gbc);

        gbc.gridx = 2;
        this.add(departLabel, gbc);

        gbc.gridx = 3;
        this.add(departField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(arriveeLabel, gbc);

        gbc.gridx = 1;
        this.add(arriveeField, gbc);

        gbc.gridx = 2;
        this.add(mailLabel, gbc);

        gbc.gridx = 3;
        this.add(mailField, gbc);

        gbc.gridy = 2;
        gbc.gridx = 1;
        this.add(valider, gbc);
        gbc.gridx = 2;
        this.add(annuler, gbc);




    }



    public void fermerFenetre(){
        base.closeSQL();
        this.dispose();
    }

    public String getNom(){
        return this.nomField.getText();
    }

    public String getDepart(){
        return this.departField.getText();
    }

    public String getArrivee(){
        return this.arriveeField.getText();
    }

    public String getMail(){
        return this.mailField.getText();
    }

    public void reBuildPan(){
        this.pan.Build();
    }
}