package valores;

public class FHora extends Valores{
	
	public FHora(long tempoMin) {
		super(tempoMin);
	}

	public double calculoDoValor() {
		double valor = tempoMin * 0.5;
		long t15 = tempoMin/15;
		long t60 = tempoMin/60;
		valor = valor - t15 - t60;
		return valor;
	}
	
}
