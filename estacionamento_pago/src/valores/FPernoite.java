package valores;

public class FPernoite extends Valores{
	private int dia;
	private int mes;

	public FPernoite(long tempoMin, int dia, int mes) {
		super(tempoMin);
		this.dia = dia;
		this.mes = mes;
	}

	public double calculoDoValor() {
			double valor = 0.0;
			int controle = 0;

			if (dia > 1 || mes >= 1) {
				if (mes <= 1) {
					while (controle < dia) {
						tempoMin = tempoMin - 600;
						if (tempoMin < 15) {
							valor = tempoMin * 0.5;
						} else if (tempoMin < 60) {
							valor = tempoMin * 0.5;
							long t15 = tempoMin / 15;
							valor = valor - t15;
						} else if (tempoMin < 540) {
							valor = tempoMin * 0.5;
							long t15 = tempoMin / 15;
							long t60 = tempoMin / 60;
							valor = valor - t15 - t60;
						} else {
							valor = (tempoMin - 540) * 0.2;
							valor = 110 + valor;
						}
						controle++;
					}
					valor = valor + 30 * dia;
					return valor;
				} else {
					dia = dia + 30;
					while (controle < dia){
						tempoMin = tempoMin - 600;
						if (tempoMin < 15) {
							valor = tempoMin * 0.5;
						} else if (tempoMin < 60) {
							valor = tempoMin * 0.5;
							long t15 = tempoMin / 15;
							valor = valor - t15;
						} else if (tempoMin < 540) {
							valor = tempoMin * 0.5;
							long t15 = tempoMin / 15;
							long t60 = tempoMin / 60;
							valor = valor - t15 - t60;
						} else {
							valor = (tempoMin - 540) * 0.2;
							valor = 110 + valor;
						}
						controle++;
					}
					valor = valor + 30 * dia * (mes - 1);
					return valor;
				}
			} else {
				tempoMin = tempoMin - 600;
				if (tempoMin < 15) {
					valor = tempoMin * 0.5;
				} else if (tempoMin < 60) {
					valor = tempoMin * 0.5;
					long t15 = tempoMin / 15;
					valor = valor - t15;
				} else if (tempoMin < 540) {
					valor = tempoMin * 0.5;
					long t15 = tempoMin / 15;
					long t60 = tempoMin / 60;
					valor = valor - t15 - t60;
				} else {
					valor = (tempoMin - 540) * 0.2;
					valor = 110 + valor;
				}

				valor = valor + 30;
				return valor;
			}

		}
}