package cadastros;

public class Veiculo {
	
	private String marca;
	private String modelo;
	private String placa;
	private Mensalista mensalista;
	
	public Veiculo(String marca, String modelo, String placa, Mensalista mensalista) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.mensalista = mensalista;
		
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public Mensalista getMensalista() {
		return mensalista;
	}

}
