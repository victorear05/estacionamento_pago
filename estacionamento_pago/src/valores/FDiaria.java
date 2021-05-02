package valores;

public class FDiaria extends Valores {
	
	public FDiaria(long tempoMin) {
		super(tempoMin);
	}

	public double calculoDoValor() {
		double valor;
		valor = tempoMin * 0.5;
		return valor;
	}
}
