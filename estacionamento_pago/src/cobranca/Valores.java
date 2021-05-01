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
			valor = (duracao_m * 0.5) - Desconto(duracao_h,duracao_m);
		}else if(duracao_h < 9) {
			valor = (duracao_m * 0.5) - Desconto(duracao_h,duracao_m);
		}else if(duracao_h >= 9) {
			valor = 110 + ( (duracao_m - 540) * 0.2);
		}
		
		return valor;
	}
	public double Desconto(long Horas,long Minutos) {
	    
		int valdes = 0; 
		
		if (Minutos>15){
	    	long des15 = Minutos/15 ;
	    	int desmin = (int) des15;
		    int deshor = (int) Horas;
		    valdes = (int) ((desmin * 0.5) + deshor);
		    
	    }else {
	    	valdes = 0;
	    } 
	    	

		return (valdes);
	}
}
