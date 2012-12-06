package swing;

	import java.awt.CardLayout;
	import java.awt.Dimension;

import javax.swing.*;

import swing.action.JAboutMenuAction;
import swing.action.JCadastrarMenuAction;
import swing.action.JSairMenuAction;
import swing.JCadastrarPanel;


	public class Principal {
		public static final String PRINCIPAL = "PRINCIPAL";

		private static void createAndShowGUI() {
			JFrame frame = new JFrame("Videolocadora Gabrinus");
			CardLayout cards = new CardLayout();
			JPanel principal = new JPanel(cards);
			
			
			JPanel cadastrar = new JCadastrarPanel(principal, cards);
			JPanel vazio = new JPanel();
			JLabel label = new JLabel("Videolocadora Gabrinus.");
			vazio.add(label);
			
			principal.add(vazio, PRINCIPAL);
			principal.add(cadastrar, JCadastrarMenuAction.CADASTRAR1);
			
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			
	    	Action cadastrarAction = new JCadastrarMenuAction(principal,cards);
			cliente.add(cadastrarAction);
			
			
			frame.setJMenuBar(menubar);
			
			frame.setMinimumSize(new Dimension(500,300));

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


	
	
	
