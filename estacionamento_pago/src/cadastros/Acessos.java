package cadastros;

import java.time.Duration;
import java.time.LocalDateTime;
import valores.*;

public class Acessos {
	
	private Valores p[] = new Valores[0];
	
	private Veiculo v;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private double preco;
	
	public Acessos(Veiculo v, LocalDateTime entrada, LocalDateTime saida) {
		
		this.v = v;
		this.entrada = entrada;
		this.saida = saida;
		
	}

	public void calcularPreco() {setPreco(p[0].calculoDoValor());}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}
	
	public Veiculo getV() {
		return v;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

}
