package app;

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
	
	public static void cadastrarMensalista() {
		//Implementar Cadastros de Mensalistas
	}
	
	public static void cadastrarVeiculo() {
		//Implementar Cadastros de Veículos
	}
	
	public static Mensalista pesquisarMensalista(String CPF) {
		//Implementar Pesquisas de Veiculos
		return cadM[0];
	}
	
	public static Veiculo pesquisarVeiculo(String placa) {
		//Implementar Pesquisas de Veiculos
		return cadV[0];
	}
	
	public static boolean ExcluirMensalista() {
		//Implementar Exclusão de Veiculos
		return true;
	}
	
	public static boolean ExcluirVeiculo() {
		//Implementar Exclusão de Veiculos
		return true;
	}
}
