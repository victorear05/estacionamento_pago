package valores;

public class FQuinze extends Valores {

	public FQuinze(long tempoMin) {
		super(tempoMin);
	}
	
	public double calculoDoValor() {
		double valor;
		valor = tempoMin * 0.5;
		return valor;
	}
}
