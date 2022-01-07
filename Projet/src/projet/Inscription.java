package projet;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Inscription extends JFrame implements ActionListener {
	
	private JPanel signinPanel = (JPanel) getContentPane();
	private JLabel titre = new JLabel("INSCRIPTION");
	private JLabel rappel = new JLabel("(!) : Informations à remplir obligatoirement");
	private JLabel nom = new JLabel("Nom (!)");
	private JLabel prenom = new JLabel("Prénom (!)");
	private JLabel id = new JLabel("Identifiant (!)");
	private JLabel mdp= new JLabel("Mot de passe (!)");
	private JLabel confirm = new JLabel("Confirmation mot de passe (!)");
    private JTextField saisieNom = new JTextField();
    private JTextField saisiePrenom = new JTextField();
    private JTextField saisieId = new JTextField();
    private JTextField saisieMdp = new JTextField();
    private JTextField saisieConfirm = new JTextField();
    private JButton valider = new JButton("Valider");
    private JButton retour = new JButton("Retour");
    private JCheckBox afficherMdp = new JCheckBox("Afficher le mot de passe");

    public Inscription() {
    	
    	this.setTitle("Inscription");
		this.setSize(375,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

    	setInterface();
        addActionEvent();
        this.setVisible(true);

    }

    
    public void setPositionBox(JPanel panel, Component... composants) {
    	Box ligne = new Box(BoxLayout.X_AXIS);
    	ligne.add(Box.createHorizontalGlue());
    	for(Component c : composants) { ligne.add(c); }
    	ligne.add(Box.createHorizontalGlue());
    	panel.add(ligne);
    }
// Positionnement des différents composants
    public void setInterface() {
    	signinPanel.setLayout(new BoxLayout(signinPanel,BoxLayout.Y_AXIS));
    	
    	setPositionBox(signinPanel, titre);
    	setPositionBox(signinPanel, rappel);
    	setPositionBox(signinPanel, nom, saisieNom);
    	setPositionBox(signinPanel, prenom, saisiePrenom);
    	setPositionBox(signinPanel, id, saisieId);
    	setPositionBox(signinPanel, mdp, saisieMdp);
    	setPositionBox(signinPanel, confirm, saisieConfirm);
    	setPositionBox(signinPanel, afficherMdp);
    	setPositionBox(signinPanel, valider, retour);

    }

// Composants ayant un comportement spécifique
    public void addActionEvent() {
    	valider.addActionListener(this);
    	retour.addActionListener(this);
    	afficherMdp.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent action) {
      
    }

}
