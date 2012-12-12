package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import locadora.FuncionarioDAO;
import swing.Principal;
import locadora.Funcionario;
	
	@SuppressWarnings("serial")
	public class JCadastrarFuncionarioPanelAction extends AbstractAction {
		private JPanel principal;
		private CardLayout cards;
		
		private JTextField nome;	
		private JTextField telefone;
		private JTextField cpf;
		private JTextField usuario;
		private JTextField senha;

		public JCadastrarFuncionarioPanelAction(JPanel principal, CardLayout cards,JTextField nome,JTextField telefone, JTextField cpf, JTextField usuario, JTextField senha) {
			super("Cadastrar");
			this.principal = principal;
			this.cards = cards;
			this.nome = nome;
			this.telefone = telefone;
			this.cpf = cpf;
			this.usuario = usuario;
			this.senha = senha;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			String nom,cpef,usu,sen;
			int tel;
			
			FuncionarioDAO funcionario = new FuncionarioDAO();
//      
		
					nom = (nome.getText());
				
					usu = (usuario.getText());
					sen = (senha.getText());
					cpef = (cpf.getText());
					tel=Integer.parseInt(telefone.getText());
					
				Funcionario fun = new Funcionario(0,nom,tel,cpef,usu,sen);
					
					funcionario.inserir(fun);
					
			

					JOptionPane.showMessageDialog(null,
							"Funcionario Cadastrado com Sucesso", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
			
		
			if (principal != null) {
				cards.show(principal, Principal.PRINCIPAL);
			}

		

				
}
}