package app;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		int opcao = 0;
		
		do { 
			String menu = "Selecione uma op��o:"
					+ "1 - Para usu�rio Mensalista j� cadastrado"
					+ "2 - Para novo usu�rio Mensalista"
					+ "3 - Entrada Simples"
					+ "0 - Encerrar Programa";
			
			String strOpcao = JOptionPane.showInputDialog(null, menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 1: {
					//Usu�rio Mensalista j� cadastrado
					
					//Carro j� cadastrado?
					//Sim:
					//1 - Buscar Ve�culo
					//2 - Registrar hor�rio de entrada e de sa�da 
					//N�o:
					//1 - Cadastrar Ve�culo
					//2 - Registrar hor�rio de entrada e de sa�da 
					break;
				}
			
				case 2: {
					//Novo usu�rio Mensalista
					
					//1 - Cadastrar usu�rio 
					//2 - Cadastrar carro(s)
					//3 - Hor�rio de entrada e de sa�da
					//4 - Calcular Valor
					break;
				}
				
				case 3: {
					//Entrada Simples
					
					//Carro j� cadastrado?
					//Sim:
					//1 - Buscar Ve�culo
					//2 - Registrar hor�rio de entrada e de sa�da 
					//3 - Calcular Valor
					//N�o:
					//1 - Cadastrar Ve�culo
					//2 - Registrar hor�rio de entrada e de sa�da 
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
