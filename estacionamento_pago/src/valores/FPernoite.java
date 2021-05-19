package valores;

public class FPernoite extends Valores{
	
	public FPernoite(long tempoMin) {
		super(tempoMin);
	}

	public double calculoDoValor() {
		double valor;
		
		tempoMin = tempoMin - 600;
		if (tempoMin < 15) {
			valor = tempoMin * 0.5;
		}else if(tempoMin < 60) {
			valor = tempoMin * 0.5;
			long t15 = tempoMin/15;
			valor = valor - t15;
		}else if(tempoMin < 540) {
			valor = tempoMin * 0.5;
			long t15 = tempoMin/15;
			long t60 = tempoMin/60;
			valor = valor - t15 - t60;
		}else {
			valor = (tempoMin - 540) * 0.2;
			valor = 110 + valor;
		}
		
		valor = valor + 30;
		return valor;
	}
}
