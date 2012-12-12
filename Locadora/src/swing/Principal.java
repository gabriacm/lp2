
package swing;

	import java.awt.CardLayout;
	import java.awt.Dimension;

import javax.swing.*;

import swing.action.JAboutMenuAction;
import swing.action.JCadastrarFilmeMenuAction;
import swing.action.JCadastrarFuncionarioMenuAction;
import swing.action.JCadastrarMenuAction;
import swing.action.JConsultarClienteMenuAction;
import swing.action.JConsultarFilmeMenuAction;
import swing.action.JConsultarFuncionarioMenuAction;
import swing.action.JSairMenuAction;
import swing.JCadastrarPanel;


	public class Principal {
		public static final String PRINCIPAL = "PRINCIPAL";

		private static void createAndShowGUI() {
			JFrame frame = new JFrame("Videolocadora Gabrinus");
			CardLayout cards = new CardLayout();
			JPanel principal = new JPanel(cards);
			
			JPanel consultarCliente = new JConsultarClientePanel(principal, cards);
			JPanel cadastrar = new JCadastrarPanel(principal, cards);
			
			JPanel cadastrarFilme = new JCadastrarFilmePanel(principal, cards);
			JPanel consultarFilme = new JConsultarFilmePanel(principal, cards);
			
			JPanel cadastrarFuncionario = new JCadastrarFuncionarioPanel(principal, cards);
			JPanel consultarFuncionario = new JConsultarFuncionarioPanel(principal, cards);
			
			JPanel vazio = new JPanel();
			JLabel label = new JLabel("Videolocadora Gabrinus.");
			vazio.add(label);
			
			principal.add(vazio, PRINCIPAL);
			principal.add(cadastrar, JCadastrarMenuAction.CADASTRAR1);
			principal.add(consultarCliente, JConsultarClienteMenuAction.CONSULTAR1);
			
			principal.add(cadastrarFilme, JCadastrarFilmeMenuAction.CADASTRAR2);
			principal.add(consultarFilme, JConsultarFilmeMenuAction.CONSULTAR2);
			
			principal.add(cadastrarFuncionario, JCadastrarFuncionarioMenuAction.CADASTRAR3);
			principal.add(consultarFuncionario, JConsultarFuncionarioMenuAction.CONSULTAR3);
			
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(principal);

			JMenuBar menubar = new JMenuBar();	
		    
			JMenu filme = new JMenu("Cadastrar filme");
			menubar.add(filme);
			
			JMenu cliente = new JMenu("Cadastrar cliente");
			menubar.add(cliente);
		
			//JMenu deletar = new JMenu("Deletar cliente");
			//menubar.add(deletar);
			
			JMenu funcionario = new JMenu("Cadastrar funcionario");
			menubar.add(funcionario);
			
			JMenu help = new JMenu("Sobre");
			menubar.add(help);
			
			JMenu file = new JMenu("Sair");
			menubar.add(file);
			
			
//	sair
			Action exitAction = new JSairMenuAction();
			file.add(exitAction);			
			
// cadastrar cliente	

	//		Action deletarAction = new JdeletarMenuAction(principal,cards);
		//	cliente.add(deletarAction);
			
		    Action cadastrarAction = new JCadastrarMenuAction(principal,cards);
			cliente.add(cadastrarAction);
			
			Action consultarAction = new JConsultarClienteMenuAction(principal,cards);
			cliente.add(consultarAction);
			
			
// cadastrar funcionario
			
			   Action cadastrarFuncionarioAction = new JCadastrarFuncionarioMenuAction(principal,cards);
				funcionario.add(cadastrarFuncionarioAction);
				
				Action consultarFuncionarioAction = new JConsultarFuncionarioMenuAction(principal,cards);
				funcionario.add(consultarFuncionarioAction);
				
			
// cadastrar filme	
			
				
			Action cadastrarFilmeAction = new JCadastrarFilmeMenuAction(principal,cards);
			filme.add(cadastrarFilmeAction);
				
			Action consultarFilmeAction = new JConsultarFilmeMenuAction(principal,cards);
			filme.add(consultarFilmeAction);
			
		
			
			

// sobre
			Action aboutAction = new JAboutMenuAction(frame);
			help.add(aboutAction);
			
	    	
			
			
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


	
	
	
