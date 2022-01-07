package projet;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

@SuppressWarnings("serial")
public class Connexion extends JFrame implements ActionListener{
	
	private List<String> list = new ArrayList<>();
	private JPanel logPanel = (JPanel) getContentPane();
    private JLabel titre = new JLabel("AUTHENTIFICATION");
    private JLabel identifiant = new JLabel("Identifiant");
    private JLabel motDePasse = new JLabel("Mot De Passe");
    private JTextField saisieId = new JTextField();
    private JPasswordField saisieMdp = new JPasswordField();
    private JButton connexion = new JButton("Connexion");
    private JButton effacer = new JButton("Effacer");
    private JButton inscrire = new JButton("S'inscrire");
    private JCheckBox afficherMdp = new JCheckBox("Afficher le mot de passe");
   
    //TODO Identifiant et mdp de l'utilisateur a voir avec la BDD
    private String okId = new String("aze");
    private String okMdp = new String("azeaze");
 
 
    public Connexion() {
    	
    	this.setTitle("Authentification");
		this.setSize(375,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

    	positionComposants();
        addComposants();
        actionsEvents();
        this.setVisible(true);

    }

// Positionnement des différents composants
    public void positionComposants() {
    	logPanel.setLayout(null);
    	titre.setBounds(100, 100, 200, 30);
        identifiant.setBounds(50, 200, 100, 30);
        motDePasse.setBounds(50, 270, 100, 30);
        saisieId.setBounds(150, 200, 150, 30);
        saisieMdp.setBounds(150, 270, 150, 30);
        afficherMdp.setBounds(150, 300, 180, 30);
        connexion.setBounds(50, 350, 100, 30);
        effacer.setBounds(200, 350, 100, 30);
        inscrire.setBounds(125, 400, 100, 30);
    }

// Ajout des composants dans la panel
    public void addComposants() {
    	logPanel.add(titre);
        logPanel.add(identifiant);
        logPanel.add(motDePasse);
        logPanel.add(saisieId);
        logPanel.add(saisieMdp);
        logPanel.add(connexion);
        logPanel.add(effacer);
        logPanel.add(inscrire);
        logPanel.add(afficherMdp);
    }

// Composants ayant un comportement spécifique
    public void actionsEvents() {
        connexion.addActionListener(this);
        effacer.addActionListener(this);
        inscrire.addActionListener(this);
        afficherMdp.addActionListener(this);
        
    }
// Methodes qui décrivent les comportements des boutons
    public void authentification() {
    	String id;
    	String mdp;
    	char[] tabMdp;
    	id = saisieId.getText();
    	tabMdp = saisieMdp.getPassword();
    	mdp = String.valueOf(tabMdp);
    	if (id.equalsIgnoreCase("") && mdp.equalsIgnoreCase(""))
    		JOptionPane.showMessageDialog(this, "Veuillez saisir votre identifiant et votre mot de passe.");
    	if (id.equalsIgnoreCase(okId) && mdp.equalsIgnoreCase(okMdp)) {
    		this.setVisible(false);
    		@SuppressWarnings("unused")
			Messagerie chat = new Messagerie();
    	} else if (!id.equalsIgnoreCase(okId) && mdp.equalsIgnoreCase(okMdp)){
    		JOptionPane.showMessageDialog(this, "Identifiant invalide...");
    		}else if (id.equalsIgnoreCase(okId) && !mdp.equalsIgnoreCase(okMdp)) {	
    			JOptionPane.showMessageDialog(this, "Mot de passe invalide...");
    		}
    	
	}
    
    public void libereSaisie() {
        saisieId.setText("");
        saisieMdp.setText("");
    }
 
    public void inscription() {
    	this.setVisible(false);
    	@SuppressWarnings("unused")
		Inscription signin = new Inscription();
    }
    
    public void affichageMdp() {
    	if (afficherMdp.isSelected()) { 
    		saisieMdp.setEchoChar((char) 0);
    	}else{ 
    		saisieMdp.setEchoChar('•'); 
    	}
    }  	
    
    @Override
    public void actionPerformed(ActionEvent action) {
        //Traitement pour savoir si les logs sont bon ou pas
        if (action.getSource() == connexion) { authentification(); }
        
        //Effacer les champs de saisie de l'identifiant et du mot de passe
        if (action.getSource() == effacer) { libereSaisie(); }
        
        //inscrire la connexion entraine la fermeture de la fenêtre
        if(action.getSource() == inscrire) { inscription(); }
        
       //Afficher du mot de passe quand on coche la case "Afficher le mot de passe"
        if (action.getSource() == afficherMdp) { affichageMdp(); }
        
    }

 
}
