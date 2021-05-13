package cadastros;

import java.time.Duration; 
import java.time.LocalDateTime;

import javax.swing.JOptionPane;

import valores.*;

public class Acessos {
	
	private Veiculo v;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	private double preco;
	
	public Acessos(Veiculo v, LocalDateTime entrada, LocalDateTime saida) {
		
		this.v = v;
		this.entrada = entrada;
		this.saida = saida;
		calcularPreco();
	}

	public void calcularPreco() {
		
		Duration duracao = Duration.between(entrada, saida);
		long duracao_h = duracao.toHours();
		long duracao_m = duracao.toMinutes();
		
		int DiaE = entrada.getDayOfMonth();
		int DiaS = saida.getDayOfMonth();
		
		Valores preco = null;
		
		if(v.getMensalista() == null) {
			if (DiaE != DiaS) {
				preco = new FPernoite(duracao_m);
			}else if (duracao_m < 15) {
				preco = new FMinuto(duracao_m);
			}else if(duracao_m < 60) {
				preco = new FQuinze(duracao_m);
			}else if(duracao_h < 9) {
				preco = new FHora(duracao_m);
			}else if(duracao_h >= 9) {
				JOptionPane.showMessageDialog(null, duracao_m);
				preco = new FDiaria(duracao_m);
			}
		}
		else
			preco = new FMensalista(duracao_m);
		
		setPreco(preco.calculoDoValor());
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getPreco() {
		return preco;
	}
	
	public Veiculo getV() {
		return v;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

}
