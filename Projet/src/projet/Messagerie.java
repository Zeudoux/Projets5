package projet;

import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;


public class Messagerie extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel chatPanel = (JPanel) getContentPane();
	private JToolBar toolBar = new JToolBar();   
    private JButton envoyer = new JButton("Envoyer");
    private JButton deconnexion = new JButton("Deconnexion");
    private JTextField saisieTexte = new JTextField();
    private JTextArea discussion = new JTextArea();
    private JTree  arbre = new JTree();
    private JScrollPane textDiscussion = new JScrollPane(discussion);
    private JScrollPane ticket = new JScrollPane(arbre);
    
    
    public Messagerie() {
    	
    	this.setTitle("Messagerie");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
		this.setLocationRelativeTo(null);
        this.setResizable(false);

        setInterface();
        actionsEvents();
        this.setVisible(true);
    }
    
    public String dateAndTime() {
    	 LocalDateTime myDateObj = LocalDateTime.now();
    	 DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    	 String formattedDate = myDateObj.format(myFormatObj);
    	 return formattedDate;
    }
   
    public void setInterface() {
        chatPanel.setLayout(new BorderLayout());
    	
        toolBar.add(deconnexion);
        chatPanel.add(toolBar, BorderLayout.NORTH);
        
        saisieTexte.requestFocusInWindow();
        
        ticket.setPreferredSize(new Dimension(200,100));
        chatPanel.add(ticket, BorderLayout.WEST);
        
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());
   	 	discussion.setEditable(false);
   	 	discussion.setLineWrap(true);
        textPanel.add(textDiscussion, BorderLayout.CENTER);
        textPanel.add(setZoneDeSaisie(), BorderLayout.SOUTH);

        chatPanel.add(textPanel, BorderLayout.CENTER);
    }

    public JPanel setZoneDeSaisie() {
    	 JPanel saisie = new JPanel();
    	 saisie.setLayout(new GridBagLayout());
    	 saisie.setBackground(Color.LIGHT_GRAY);
    	 
    	 saisieTexte.setPreferredSize(new Dimension(200,100));
    	 
    	 GridBagConstraints left = new GridBagConstraints();
         left.anchor = GridBagConstraints.LINE_START;
         left.fill = GridBagConstraints.HORIZONTAL;
         left.weightx = 512.0D;
         left.weighty = 1.0D;

         GridBagConstraints right = new GridBagConstraints();
         right.anchor = GridBagConstraints.LINE_END;
         right.fill = GridBagConstraints.VERTICAL;
         right.weightx = 1.0D;
         right.weighty = 1.0D;

         saisie.add(saisieTexte, left);
         saisie.add(envoyer,right);
         
         return saisie;

    }
    
    public void actionsEvents(){
        envoyer.addActionListener(this);
        deconnexion.addActionListener(this);
    }
    
    public void saisieDeTexte() {
    	if (saisieTexte.getText().length() < 1) {
        } else if (saisieTexte.getText().equals(".clear")) {
        	discussion.setText("Tous les messages ont bien été effacés.\n");
            saisieTexte.setText("");
        } else {
        	// TODO Récupérer nom prenom de la BDD
        	discussion.append(dateAndTime() +  " [" + "USER" + "]:  " + saisieTexte.getText() + "\n");
        	saisieTexte.setText("");
        }
        saisieTexte.requestFocusInWindow();
    }
    
    public void deco() {
    	this.setVisible(false);
    	Connexion login = new Connexion();
    }
   
    public void actionPerformed(ActionEvent event) {
    	saisieDeTexte();
    	if(event.getSource() == deconnexion) {deco();}
    }
 
}
