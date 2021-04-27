package app;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		int opcao = 0;
		
		do { 
			String menu = "Selecione uma opção:"
					+ "1 - Para usuário Mensalista já cadastrado"
					+ "2 - Para novo usuário Mensalista"
					+ "3 - Entrada Simples"
					+ "0 - Encerrar Programa";
			
			String strOpcao = JOptionPane.showInputDialog(null, menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 1: {
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
			
				case 2: {
					//Novo usuário Mensalista
					
					//1 - Cadastrar usuário 
					//2 - Cadastrar carro(s)
					//3 - Horário de entrada e de saída
					//4 - Calcular Valor
					break;
				}
				
				case 3: {
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
					break;
				}
				case 0:{
					//Encerrar programa;
					break;
				}
			}
			
		}while(opcao != 0);
	
	}
}
