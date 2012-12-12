package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;




	@SuppressWarnings("serial")
	public class JCadastrarFilmeMenuAction  extends AbstractAction {
		public static final String CADASTRAR2 = "CADASTRAR2";

		private JPanel principal;
		private CardLayout cards;
		
		public JCadastrarFilmeMenuAction(JPanel principal, CardLayout cards) {
			super("Inserir Filmes");
			this.principal = principal;
			this.cards = cards;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			cards.show(principal, CADASTRAR2);
		
}
	}
