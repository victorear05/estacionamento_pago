package cobranca;

import java.time.*;

public class Valores {
	
	public double CalculaValor(LocalDateTime entrada, LocalDateTime saida){
		double valor = 0;
		
		Duration duracao = Duration.between(entrada, saida);
		
		long duracao_h = duracao.toHours();
		long duracao_m = duracao.toMinutes();
		
		if (duracao_m < 15) {
			valor = duracao_m * (0.5);
		}else if(duracao_m < 60) {
			double divi15 = duracao_m / 15;
			valor = (duracao_m * 0.5) - (divi15 * 0.5);
		}else if(duracao_h < 9) {
			double divi15 = duracao_m / 15;
			valor = (duracao_m * 0.5) - (divi15 * 0.5) - (duracao_h * 1);
		}else if(duracao_h >= 9) {
			valor = 110 + ( (duracao_m - 540) * 0.2);
		}
		
		return valor;
	}
}
