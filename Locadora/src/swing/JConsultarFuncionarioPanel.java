package swing;

import java.awt.CardLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import swing.action.JCadastrarFuncionarioPanelCloseAction;
import locadora.FuncionarioDAO;
import locadora.Funcionario;


@SuppressWarnings("serial")
public class JConsultarFuncionarioPanel extends JPanel{

	private JTextArea dados;
	public JConsultarFuncionarioPanel(JPanel principal, CardLayout cards) {
		dados = new JTextArea(20,60); 
		dados.setEditable(false);
		add(dados);
		add(new JButton(new JCadastrarFuncionarioPanelCloseAction(principal, cards)));
	}

	public JConsultarFuncionarioPanel() {
		this(null, null);
	}
	
	@Override
	public void setVisible(boolean aFlag) {
		super.setVisible(aFlag);
		if (aFlag == false) {
			return;
		}
		System.out.printf("JCadastrarFuncionarioPanel::setVisible %b\n", aFlag);
		FuncionarioDAO funcionario = new FuncionarioDAO();
		
		List<Funcionario> fu = funcionario.consultarFuncionario();

	
			String s = "Nome \t Telefone \t CPF \t Usuario \t Senha \n\n";
		
			for (Funcionario consultar : fu) {
			
				s += String.format("%s \t %d \t %s \t %s \t %s \n",	consultar.getNome(),consultar.getTelefone(),consultar.getCpf(),consultar.getUsuario(),consultar.getSenha());
			}
			
			dados.setText(s);
			
	}
	
	
	private static void createAndShowGUI() {
		JFrame frame = new JFrame("VideoLocadora Gabrinus - Teste do Painel Consultar funcionario");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel painel = new JConsultarFuncionarioPanel();
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

