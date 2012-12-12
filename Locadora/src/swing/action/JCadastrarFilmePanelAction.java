package swing.action;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import locadora.FilmeDAO;
import swing.Principal;
import locadora.Filme;
	
	@SuppressWarnings("serial")
	public class JCadastrarFilmePanelAction extends AbstractAction {
		private JPanel principal;
		private CardLayout cards;
		private JTextField titulo;
		private JTextField categoria;
		private JTextField duracao;
		

		public JCadastrarFilmePanelAction(JPanel principal, CardLayout cards,JTextField titulo,JTextField categoria,JTextField duracao) {
			super("Cadastrar");
			this.principal = principal;
			this.cards = cards;
			this.titulo = titulo;
			this.categoria = categoria;
			this.duracao = duracao;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		
			
			String tit,cat;
			int dur;
			
			FilmeDAO filme = new FilmeDAO();
//      
		
					tit = (titulo.getText());
					cat = (categoria.getText());
					dur=Integer.parseInt(duracao.getText());
					
					Filme fil = new Filme(0,tit ,cat,dur);
					
					filme.inserir(fil);
					
			

					JOptionPane.showMessageDialog(null,
							"Filme Cadastrado com Sucesso", "Aviso",
							JOptionPane.INFORMATION_MESSAGE);
			
		
			if (principal != null) {
				cards.show(principal, Principal.PRINCIPAL);
			}

		

				
}
}