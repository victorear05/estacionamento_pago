package cadastros;

import java.time.Duration;
import java.time.LocalDateTime;
import valores.*;

public class Acessos {
	
	Valores p[] = new Valores[0];
	
	Veiculo v;
	LocalDateTime entrada;
	LocalDateTime saida;
	double preco = calcularPreco();
	
	public Acessos(Veiculo v, LocalDateTime entrada, LocalDateTime saida) {
		
		this.v = v;
		this.entrada = entrada;
		this.saida = saida;
		
	}

	public double calcularPreco() {
		
		Duration duracao = Duration.between(entrada, saida);
		long duracao_h = duracao.toHours();
		long duracao_m = duracao.toMinutes();
		
		if(v.mensalista != null) {
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
