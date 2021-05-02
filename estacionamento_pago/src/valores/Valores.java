package valores;

public abstract class Valores {
	
	long tempoMin;
	
	public Valores(long tempoMin) {
		this.tempoMin = tempoMin;
	}

	public abstract double calculoDoValor();

}
