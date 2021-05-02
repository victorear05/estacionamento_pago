package cadastros;

public class Mensalista {

	Veiculo cadVM[] = new Veiculo[0];
	
	String nome;
	String endereco;
	String celular;
	String telefone;
	int CNH;
	
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
