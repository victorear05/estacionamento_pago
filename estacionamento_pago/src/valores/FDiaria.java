package valores;

public class FDiaria extends Valores {
	
	public FDiaria(long tempoMin) {
		super(tempoMin);
	}

	public double calculoDoValor() {
		double valor = (tempoMin - 540)* 0.2;
		valor = 110 + valor;
		return valor;
	}
}
