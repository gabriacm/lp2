package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;




	@SuppressWarnings("serial")
	public class JCadastrarFuncionarioMenuAction  extends AbstractAction {
		public static final String CADASTRAR3 = "CADASTRAR3";

		private JPanel principal;
		private CardLayout cards;
		
		public JCadastrarFuncionarioMenuAction(JPanel principal, CardLayout cards) {
			super("Inserir Funcionarios");
			this.principal = principal;
			this.cards = cards;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			cards.show(principal, CADASTRAR3);
		
}
	}
