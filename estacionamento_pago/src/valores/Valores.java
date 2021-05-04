package valores;

public abstract class Valores {
	
	public long tempoMin;
	
	public Valores(long tempoMin) {
		this.tempoMin = tempoMin;
	}

	public abstract double calculoDoValor();

}
