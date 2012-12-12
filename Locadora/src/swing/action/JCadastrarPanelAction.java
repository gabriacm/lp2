package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import locadora.ClienteDAO;
import swing.Principal;
import locadora.Cliente;
	
	@SuppressWarnings("serial")
	public class JCadastrarPanelAction extends AbstractAction {
		private JPanel principal;
		private CardLayout cards;
		
		private JTextField nome;
		private JTextField sobrenome;
		private JTextField telefone;
		private JTextField endereco;

		public JCadastrarPanelAction(JPanel principal, CardLayout cards,JTextField nome,JTextField sobrenome,JTextField telefone,JTextField endereco) {
			super("Cadastrar");
			this.principal = principal;
			this.cards = cards;
			this.nome = nome;
			this.sobrenome = sobrenome;
			this.telefone = telefone;
			this.endereco = endereco;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			String nom,sob,end;
			int tel;
			
			ClienteDAO cliente = new ClienteDAO();
//      
		
					nom = (nome.getText());
					sob = (sobrenome.getText());
					end = (endereco.getText());
					tel=Integer.parseInt(telefone.getText());
					
					Cliente cli = new Cliente(0,nom ,sob,tel, end);
					
					cliente.inserir(cli);
					
			

					JOptionPane.showMessageDialog(null,
							"Cliente Cadastrado com Sucesso", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
			
		
			if (principal != null) {
				cards.show(principal, Principal.PRINCIPAL);
			}

		

				
}
}