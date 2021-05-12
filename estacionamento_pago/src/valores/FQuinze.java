package valores;

public class FQuinze extends Valores {

	public FQuinze(long tempoMin) {
		super(tempoMin);
	}
	
	public double calculoDoValor() {
		double valor = tempoMin * 0.5;
		long t15 = tempoMin/15;
		valor = valor - t15;
		return valor;
	}
}
