public class LocadoraApp {

	public static void main(String[] args) {
        
		// Select e insert de clientes
		ClienteDAO cliente = new ClienteDAO();		
		Cliente c = cliente.findCliente("Gabriel");
		if (c == null) {
			System.out.println("cliente não encontrado!");
		} else {
			System.out.println(c);

			
		//Cliente cl = new Cliente(1, "Mario", "alexander", 33302233,"rua palmeiras");
		//cliente.inserir(cl);
		//System.out.println(cl);
		
		
		
		// Select e insert de Filmes
		FilmeDAO filme = new FilmeDAO();		
		Filme f = filme.findFilme("Anjos e Demonios");
		if (f == null) {
			System.out.println("Filme não encontrado!");
		} else {
			System.out.println(f);

			
		Filme fl = new Filme(1,"O Gato De Botas", "Infantil",115);
		filme.inserir(fl);
		System.out.println(fl);
		
		
		
		// Select e insert de Funcionarios
		FuncionarioDAO funcionario = new FuncionarioDAO();		
		Funcionario func = funcionario.findFuncionario("Leticia Silveira");
		if (func == null) {
			System.out.println("Funcionario não encontrado!");
		} else {
			System.out.println(func);

			
		Funcionario fu = new Funcionario(1,"eduardo",33301212,"123433","dudu","1234");
		funcionario.inserir(fu);
		System.out.println(fu);
		
		
		
	}
}
}
	}
}
