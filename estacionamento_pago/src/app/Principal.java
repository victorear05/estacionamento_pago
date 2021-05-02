package app;

import javax.swing.JOptionPane; 
import cadastros.*;

public class Principal {
	
	static Mensalista cadM[] = new Mensalista[0];
	static Veiculo cadV[] = new Veiculo[0];
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		//Implementar menu
	}
	
	public void cadastrarVeiculo() {
		//Implementar Cadastros de Veículos
	}
	
	public void cadastrarMensalista() {
		//Implementar Cadastros de Mensalistas
	}
	
	public Veiculo pesquisarVeiculo(String placa) {
		//Implementar Pesquisas de Veiculos
		return cadV[0];
	}

	public Mensalista pesquisarMensalista(String cpf) {
		//Implementar Pesquisas de Mensalistas
		return cadM[0];
	}
	
	public static boolean ExcluirVeiculo() {
		//Implementar Exclusão de Veiculos
		return true;
	}
	
	public static boolean ExcluirMensalista() {
		//Implementar Exclusão de Mensalistas
		return true;
	}
}
