package app;

import javax.swing.JOptionPane;
import cobranca.Valores;

public class Principal {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		
		int opcao = 0;
		
		String menu = "Selecione uma op��o:\n"
				+ "1 - Para usu�rio Mensalista j� cadastrado\n"
				+ "2 - Para novo usu�rio Mensalista\n"
				+ "3 - Entrada Simples\n"
				+ "0 - Encerrar Programa\n";	
		do { 
			
			String strOpcao = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 1: {
					//Usu�rio Mensalista j� cadastrado
					int op1;
					do {
						String strOp1 = JOptionPane.showInputDialog("Escolha uma op��o:"
								+ "1 - Carro j� cadastrado\n"
								+ "2 - Cadastrar novo carro\n"
								+ "0 - Voltar\n");
						op1 = Integer.parseInt(strOp1);
						switch(op1) {
							case 1: {
								//1 - Buscar Ve�culo
								//2 - Registrar hor�rio de entrada e de sa�da 
								break;
							}
						
							case 2: {
								//1 - Cadastrar Ve�culo
								//2 - Registrar hor�rio de entrada e de sa�da 
								break;
							}
							
							case 0: {
								//Voltar
								break;
							}
						
						}
						
					}while(op1 != 0);
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
					int op3;
					do {
						String strOp3 = JOptionPane.showInputDialog("Escolha uma op��o:"
								+ "1 - Carro j� cadastrado\n"
								+ "2 - Cadastrar novo carro\n"
								+ "0 - Voltar\n");
						op3 = Integer.parseInt(strOp3);
						switch(op3) {
							case 1: {
								//1 - Buscar Ve�culo
								//2 - Registrar hor�rio de entrada e de sa�da 
								//3 - Calcular Valor
								break;
							}
						
							case 2: {
								//1 - Cadastrar Ve�culo
								//2 - Registrar hor�rio de entrada e de sa�da 
								//3 - Calcular Valor
								break;
							}
							
							case 0: {
								JOptionPane.showMessageDialog(null, "At� mais!");
								break;
							}
						
						}
						
					}while(op3 != 0);
					
					break;
				}
				case 0: {
					//Encerrar programa;
					JOptionPane.showMessageDialog(null, "At� mais!");
					break;
				}
				default:
					JOptionPane.showMessageDialog(null, "Op��o inv�lida, escolha uma das op��es dispon�veis!");
			}
			
		}while(opcao != 0);
	
	}

}
