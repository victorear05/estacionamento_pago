package cadastros;

public class Veiculo {
	
	protected String marca;
	protected String modelo;
	public String placa;
	protected Mensalista mensalista;
	
	public Veiculo(String marca, String modelo, String placa, Mensalista mensalista) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.mensalista = mensalista;
		
	}
}
