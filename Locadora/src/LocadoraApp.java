

public class LocadoraApp {

	public static void main(String[] args) {
		ClienteDAO cliente = new ClienteDAO();
		
		ClienteDAO cc = new ClienteDAO();
		Cliente cl = cc.findCliente("2");
		if (cl == null) {
			System.out.println("Conta não encontrada!");
		} else {
			System.out.println(cl);
			
			
		Cliente c = new Cliente(1, "gabriel", "alexander", 33302233,"rua palmeiras");
		Cliente d = new Cliente(1, "Antonio", "macedo", 99871612,"rua guararapes");
		cliente.inserir(c);
		cliente.inserir(d);
		System.out.println(c);
		System.out.println(d);
	}
}
}
