package cadastros;

public class Mensalista {

	String nome;
	String endereco;
	String celular;
	String telefone;
	int CNH;
	Veiculo cadVM[] = new Veiculo[0];
	
	public Mensalista(String nome, String endereco, String celular, String telefone, int CNH) {
		
		this.nome = nome;
		this.endereco = endereco;
		this.celular = celular;
		this.telefone = telefone;
		this.CNH = CNH;
	
	}
	
	public void cadastrarVeiculo() {
		//Implementar cadastrar veiculo
	}

}
