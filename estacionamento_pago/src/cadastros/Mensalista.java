package cadastros;

import java.util.LinkedList;
import java.util.List;

public class Mensalista {

	List<Veiculo> cadVM = new LinkedList<Veiculo>();
	private String nome;
	private String endereco;
	private String celular;
	private String telefone;
	private String CNH;
	
	public Mensalista(String nome, String endereco, String celular, String telefone, String CNH) {
		
		this.nome = nome;
		this.endereco = endereco;
		this.celular = celular;
		this.telefone = telefone;
		this.CNH = CNH;
	
	}
	
	public List<Veiculo> getCadVM() {
		return cadVM;
	}
	
	public String getCNH() {
		return CNH;
	}

	public String getNome() {
		return nome;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public String getCelular() {
		return celular;
	}
	
}
