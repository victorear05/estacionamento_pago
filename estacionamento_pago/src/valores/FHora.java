package valores;

public class FHora extends Valores{
	
	public FHora(long tempoMin) {
		super(tempoMin);
	}

	public double calculoDoValor() {
		double valor;
		valor = tempoMin * 0.5;
		return valor;
	}
	
}
