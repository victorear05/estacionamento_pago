package cadastros;

public class Mensalista {

	Veiculo cadVM[] = new Veiculo[0];
	
	protected String nome;
	protected String endereco;
	protected String celular;
	protected String telefone;
	protected String CNH;
	
	public Mensalista(String nome, String endereco, String celular, String telefone, String CNH) {
		
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
