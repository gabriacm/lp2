package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;

import swing.Principal;

@SuppressWarnings("serial")
public class JConsultarClientePanelCancelAction  extends AbstractAction {
	private JPanel principal;
	private CardLayout cards;

	public JConsultarClientePanelCancelAction(JPanel principal, CardLayout cards) {
		super("Ok");
		this.principal = principal;
		this.cards = cards;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (principal != null) {
			cards.show(principal, Principal.PRINCIPAL);
		}

	}
}
