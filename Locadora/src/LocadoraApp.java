public class LocadoraApp {

	public static void main(String[] args) {
        
		// Select
		ClienteDAO cliente = new ClienteDAO();		
		Cliente c = cliente.findCliente(1);
		if (c == null) {
			System.out.println("cliente não encontrado!");
		} else {
			System.out.println(c);}

			//insert
		Cliente asd = new Cliente(1, "Carlos", "manoel", 45302233,"rua palmeiras");
		cliente.inserir(asd);
		System.out.println(asd);
		
		//update
	//	ClienteDAO oi = new ClienteDAO();
	//	Cliente dsa = oi.findCliente(1);
	//	dsa.setNome("Jonas");
	//	oi.editar(dsa);
	//	System.out.println(dsa);
				
		//delete
	//		ClienteDAO clienteDao = new ClienteDAO();
	//		Cliente cd = clienteDao.findCliente(6);
	//		System.out.println(cd);
	//		clienteDao.deletar(cd);
//--------------------------------------------------------------
	
		
		// Select e insert delete de Filmes
		FilmeDAO filme = new FilmeDAO();		
		Filme f = filme.findFilme(1);
		if (f == null) {
			System.out.println("Filme não encontrado!");
		} else {
			System.out.println(f);}

			
		Filme fl = new Filme(1,"O Gato De Botas", "Infantil",115);
		filme.inserir(fl);
		System.out.println(fl);
		
	
	 
				//update
		FilmeDAO F = new FilmeDAO();
		Filme aux = F.findFilme(1);
		aux.setTitulo("Reliquias da morte");
		F.editar(aux);
		System.out.println(aux);
	
		
		FilmeDAO filmeDao = new FilmeDAO();
		Filme fi = filmeDao.findFilme(6);
		System.out.println(fi);
		filmeDao.deletar(fi);
		
		
//---------------------------------------------------------------
		
		
		// Select e insert e delete de Funcionarios
		FuncionarioDAO funcionario = new FuncionarioDAO();		
		Funcionario func = funcionario.findFuncionario(1);
		if (func == null) {
			System.out.println("Funcionario não encontrado!");
		} else {
			System.out.println(func);}

			
		Funcionario fu = new Funcionario(1,"eduardo",33301212,"123433","dudu","1234");
		funcionario.inserir(fu);
		System.out.println(fu);
		
		
		FuncionarioDAO funcionarioDao = new FuncionarioDAO();
		Funcionario d = funcionarioDao.findFuncionario(6);
		System.out.println(d);
		funcionarioDao.deletar(d);
				


		
		}

}
