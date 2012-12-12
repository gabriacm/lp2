package swing;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import swing.action.JCadastrarFilmePanelCloseAction;
import locadora.FilmeDAO;
import locadora.Filme;


@SuppressWarnings("serial")
public class JConsultarFilmePanel extends JPanel{

	private JTextArea dados;
	public JConsultarFilmePanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20,60); 
		dados.setEditable(false);
		add(dados);
		add(new JButton(new JCadastrarFilmePanelCloseAction(principal, cards)));
	}

	public JConsultarFilmePanel() {
		this(null, null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		System.out.printf("JDepositarPanel::setVisible %b\n", aFlag);
		FilmeDAO filme = new FilmeDAO();
		
		List<Filme> fi = filme.consultarFilme();

	
			String s = "Titulo \t\t\t Categoria \t\t Duracao\n\n";
		
			for (Filme consultar : fi) {
			
				s += String.format("%s \t\t %s \t\t %d\n",	consultar.getTitulo(),consultar.getCategoria(),consultar.getDuracao());
			}
			
			dados.setText(s);
			
	}
	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("VideoLocadora Gabrinus - Teste do Painel Consultar cliente");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarFilmePanel();
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


