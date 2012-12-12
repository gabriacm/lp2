package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

	@SuppressWarnings("serial")
	public class JConsultarFuncionarioMenuAction  extends AbstractAction {
		public static final String CONSULTAR3 = "CONSULTAR3";

		private JPanel principal;
		private CardLayout cards;
		
		public JConsultarFuncionarioMenuAction(JPanel principal, CardLayout cards) {
			super("Consultar Funcionario");
			this.principal = principal;
			this.cards = cards;		
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			cards.show(principal, CONSULTAR3);
		}
	}
