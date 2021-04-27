package app;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		int opcao = 0;
		
		do { 
			String menu = "Veículo e/ou pessoa cadastrada?";
			
			String strOpcao = JOptionPane.showInputDialog(null, menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 0: {
					//Usuário Mensalista já cadastrado
					
					//Carro já cadastrado?
					//Sim:
					//1 - Buscar Veículo
					//2 - Registrar horário de entrada e de saída 
					//Não:
					//1 - Cadastrar Veículo
					//2 - Registrar horário de entrada e de saída 
					break;
				}
			
				case 1: {
					//Novo usuário Mensalista
					
					//1 - Cadastrar usuário 
					//2 - Cadastrar carro(s)
					//3 - Horário de entrada e de saída
					//4 - Calcular Valor
					break;
				}
				
				case 2: {
					//Entrada Simples
					
					//Carro já cadastrado?
					//Sim:
					//1 - Buscar Veículo
					//2 - Registrar horário de entrada e de saída 
					//3 - Calcular Valor
					//Não:
					//1 - Cadastrar Veículo
					//2 - Registrar horário de entrada e de saída 
					//3 - Calcular Valor
			
				}
			
			}
			
		}while(opcao != 2);
	
	}
}
