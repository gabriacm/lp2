package locadora;
public class LocadoraApp {

	public static void main(String[] args) {
        
		// Select
		ClienteDAO cliente = new ClienteDAO();		
	//	Cliente c = cliente.findCliente(2);
	//	if (c == null) {
		//	System.out.println("cliente não encontrado!");
		//} else {
		//	System.out.println(c);}

			//insert
	//	Cliente asd = new Cliente(1, "Geraldo", "Padilha", 43602233,"rua andarai");
	//	cliente.inserir(asd);
	//	System.out.println(asd);
		
		//update
//		ClienteDAO oi = new ClienteDAO();
//		Cliente dsa = oi.findCliente(1);
//		dsa.setNome("Felipe");
//		oi.editar(dsa);
//		System.out.println(dsa);
		
		//delete
			
//	Cliente cd = cliente.findCliente(1);
//			System.out.println(cd);
//			cliente.deletar(cd);
//--------------------------------------------------------------
	
		
		// Select e insert delete de Filmes
	//	FilmeDAO filme = new FilmeDAO();		
	//	Filme f = filme.findFilme(1);
	//	if (f == null) {
	//		System.out.println("Filme não encontrado!");
	//	} else {
	//		System.out.println(f);}

			
	//	Filme fl = new Filme(1,"O Gato De Botas", "Infantil",115);
	//	filme.inserir(fl);
	//	System.out.println(fl);
		
	
	 
				//update
	//	FilmeDAO F = new FilmeDAO();
	//	Filme aux = F.findFilme(4);
	//	aux.setCategoria("Terror");
	//	F.editar(aux);
	//	System.out.println(aux);
	
		
	//	FilmeDAO filmeDao = new FilmeDAO();
	//	Filme fi = filmeDao.findFilme(1);
	//	System.out.println(fi);
	//	filmeDao.deletar(fi);
		
		
//---------------------------------------------------------------
		
				
		// Select,insert,update,delete funcionario
		FuncionarioDAO funcionario = new FuncionarioDAO();		
	//			Funcionario func = funcionario.findFuncionario(1);
	//	if (func == null) {
	//		System.out.println("Funcionario não encontrado!");
	//	} else {
	//		System.out.println(func);}

			
	//	Funcionario fu = new Funcionario(1,"manolo",33301212,"123433","dudu","1234");
	//	funcionario.inserir(fu);
	//	System.out.println(fu);
		
		
		
		Funcionario d = funcionario.findFuncionario(1);
		System.out.println(d);
		funcionario.deletar(d);
			
		
		
		
	//	Funcionario dsa = funcionario.findFuncionario(1);
	//	dsa.setTelefone(33304454);
	//	funcionario.editar(dsa);
	//	System.out.println(dsa);

		
		}

}
