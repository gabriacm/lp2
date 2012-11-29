package swing;

	import java.awt.CardLayout;
	import java.awt.Dimension;

import javax.swing.*;

import swing.action.JAboutMenuAction;
import swing.action.JSairMenuAction;



	public class Principal {
		public static final String PRINCIPAL = "PRINCIPAL";

		private static void createAndShowGUI() {
			JFrame frame = new JFrame("Videolocadora Gabrinus");
			CardLayout cards = new CardLayout();
			//TODO: utilizar card layout para combinar telas.
			//http://docs.oracle.com/javase/tutorial/uiswing/layout/card.html
			JPanel principal = new JPanel(cards);

			
			
			frame.getContentPane().add(principal);

			JMenuBar menubar = new JMenuBar();	
		    JMenu filme = new JMenu("Cadastrar filme");
			menubar.add(filme);
			
			JMenu cliente = new JMenu("Cadastrar cliente");
			menubar.add(cliente);
		
			JMenu emprestimo = new JMenu("Efetuar emprestimo");
			menubar.add(emprestimo);
			
			JMenu help = new JMenu("Sobre");
			menubar.add(help);
			
			JMenu file = new JMenu("Sair");
			menubar.add(file);
			
//	sair
			Action exitAction = new JSairMenuAction();
			file.add(exitAction);
// sobre
			Action aboutAction = new JAboutMenuAction(frame);
			help.add(aboutAction);
			
			Action cadastrarAction = new JAboutMenuAction(frame);
			help.add(cadastrarAction);
			
			
			frame.setJMenuBar(menubar);
			
			frame.setMinimumSize(new Dimension(400,200));

			frame.pack();
			frame.setVisible(true);	
		}

		public static void main(String[] args) {
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					createAndShowGUI();
				}
			});
		}
	}


	
