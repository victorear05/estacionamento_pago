package valores;

public class FPernoite extends Valores{
	
	public FPernoite(long tempoMin) {
		super(tempoMin);
	}

	public double calculoDoValor() {
		double valor;
		valor = tempoMin * 0.5;
		return valor;
	}
}
