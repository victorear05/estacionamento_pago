package valores;

public class FDiaria extends Valores {
	
	public FDiaria(long tempoMin) {
		super(tempoMin);
	}

	public double calculoDoValor() {
		tempoMin = tempoMin - 540;
		double valor = 110 + (tempoMin * 0.2);
		return valor;
	}
}
