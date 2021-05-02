package valores;

public class FMinuto extends Valores {

	public FMinuto(long tempoMin) {
		super(tempoMin);
	}

	public double calculoDoValor() {
		double valor;
		valor = tempoMin * 0.5;
		return valor;
	}
	
}
