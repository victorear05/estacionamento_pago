package cadastros;

import java.time.*; 
import valores.*;

public class Veiculo {
	
	Valores p[] = new Valores[0];
	
	String marca;
	String modelo;
	String placa;
	LocalDateTime entrada;
	LocalDateTime saida;
	boolean mensalista;
	double preco = calcularPreco();
	
	public Veiculo(String marca, String modelo, String placa, LocalDateTime entrada, LocalDateTime saida, boolean mensalista) {
		
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.entrada = entrada;
		this.saida = saida;
		this.mensalista = mensalista;
		
	}
	
	public double calcularPreco() {
		
		Duration duracao = Duration.between(entrada, saida);
		long duracao_h = duracao.toHours();
		long duracao_m = duracao.toMinutes();
		
		if(mensalista == true) {
			p[0] = new FMensalista(duracao_m);
		}else if (duracao_m == 0) {  			 //Implementar condição do if para caso seja pernoite
			p[0] = new FPernoite(duracao_m);
		}else if (duracao_m < 15) {
			p[0] = new FMinuto(duracao_m);
		}else if(duracao_m < 60) {
			p[0] = new FQuinze(duracao_m);
		}else if(duracao_h < 9) {
			p[0] = new FHora(duracao_m);
		}else if(duracao_h >= 9) {
			p[0] = new FDiaria(duracao_m);
		}
			
		return p[0].calculoDoValor();
	}
	
}
