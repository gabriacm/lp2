package swing;



import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import swing.action.JCadastrarFuncionarioPanelAction;
import swing.action.JCadastrarFuncionarioPanelCloseAction;


	@SuppressWarnings("serial")
	public class JCadastrarFuncionarioPanel extends JPanel {

		JTextField nome;
		JTextField telefone;
		JTextField cpf;
		JTextField usuario;
		JTextField senha;
		
		public JCadastrarFuncionarioPanel(JPanel principal, CardLayout cards) {
			add(new JLabel("Nome:"));
			nome = new JTextField(8);
			add(nome);
			
			add(new JLabel("Telefone:"));
			telefone = new JTextField(8);
			add(telefone);
			
			add(new JLabel("CPF:"));
			cpf = new JTextField(8);
			add(cpf);
			
			add(new JLabel("Usuario:"));
			usuario = new JTextField(8);
			add(usuario);
			
			add(new JLabel("Senha:"));
			senha = new JTextField(8);
			add(senha);
			
			add(new JButton(new JCadastrarFuncionarioPanelAction(principal, cards, nome,telefone,cpf,usuario,senha)));
			add(new JButton(new JCadastrarFuncionarioPanelCloseAction(principal, cards)));
		}
		
		
		public void setVisible(boolean aFlag) {
			super.setVisible(aFlag);
			System.out.printf("JCadastrarFuncionarioPanel::setVisible %b\n", aFlag);
			nome.setText("");
			telefone.setText("");
			cpf.setText("");
			usuario.setText("");
			senha.setText("");
		}

		public JCadastrarFuncionarioPanel() {
			this(null, null);
		}
		
		private static void createAndShowGUI() {
			JFrame frame = new JFrame("Videolocadora Gabrinus - teste de cadastro");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel painel = new JCadastrarFuncionarioPanel();
			frame.getContentPane().add(painel);

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
