package projet;


import javax.swing.*;


public class Main{
	
	public static void main(String[] args) throws Exception{	
		SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                @SuppressWarnings("unused")
				Connexion mainGUI = new Connexion();
            }
        });
	}

}