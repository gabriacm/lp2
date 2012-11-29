package swing.action;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

	
	@SuppressWarnings("serial")
	public class JAboutMenuAction extends AbstractAction {

		private JFrame frame;
		public JAboutMenuAction(JFrame frame) {
			super("Sobre");
			this.frame = frame;
			putValue(SHORT_DESCRIPTION, "Sobre a aplicação.");
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Mostrar tela com About...");
			JOptionPane.showMessageDialog(frame, "Videolocadora gabrinus.\n(c) 2012 Gabriel Machado", "Sobre...", JOptionPane.INFORMATION_MESSAGE);		
		}
	}

	

