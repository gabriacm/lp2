package swing;


	import java.awt.CardLayout;

	import javax.swing.JButton;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JPanel;
	import javax.swing.JTextField;

	import swing.action.JCadastrarFilmePanelAction;
	import swing.action.JCadastrarFilmePanelCloseAction;

	@SuppressWarnings("serial")
	public class JCadastrarFilmePanel extends JPanel {

		JTextField titulo;
		JTextField categoria;
		JTextField duracao;
		
		public JCadastrarFilmePanel(JPanel principal, CardLayout cards) {
			add(new JLabel("Titulo:"));
			titulo = new JTextField(8);
			add(titulo);
			
			add(new JLabel("Categoria:"));
			categoria = new JTextField(8);
			add(categoria);
			
			add(new JLabel("Duracao:"));
			duracao = new JTextField(8);
			add(duracao);
			
			add(new JButton(new JCadastrarFilmePanelAction(principal, cards, titulo,categoria,duracao)));
			add(new JButton(new JCadastrarFilmePanelCloseAction(principal, cards)));
		}
		
		
		public void setVisible(boolean aFlag) {
			super.setVisible(aFlag);
			System.out.printf("JCadastrarFilmePanel::setVisible %b\n", aFlag);
			titulo.setText("");
			categoria.setText("");
			duracao.setText("");
			
		}

		public JCadastrarFilmePanel() {
			this(null, null);
		}
		
		private static void createAndShowGUI() {
			JFrame frame = new JFrame("Videolocadora Gabrinus - teste de cadastro");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel painel = new JCadastrarFilmePanel();
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
