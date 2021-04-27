package app;

import javax.swing.JOptionPane;
import cobranca.Valores;

public class Principal {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		
		int opcao = 0;
		
		String menu = "Selecione uma opção:\n"
				+ "1 - Para usuário Mensalista já cadastrado\n"
				+ "2 - Para novo usuário Mensalista\n"
				+ "3 - Entrada Simples\n"
				+ "0 - Encerrar Programa\n";	
		do { 
			
			String strOpcao = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 1: {
					//Usuário Mensalista já cadastrado
					int op1;
					do {
						String strOp1 = JOptionPane.showInputDialog("Escolha uma opção:"
								+ "1 - Carro já cadastrado\n"
								+ "2 - Cadastrar novo carro\n"
								+ "0 - Voltar\n");
						op1 = Integer.parseInt(strOp1);
						switch(op1) {
							case 1: {
								//1 - Buscar Veículo
								//2 - Registrar horário de entrada e de saída 
								break;
							}
						
							case 2: {
								//1 - Cadastrar Veículo
								//2 - Registrar horário de entrada e de saída 
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
					//Novo usuário Mensalista
					//1 - Cadastrar usuário 
					//2 - Cadastrar carro(s)
					//3 - Horário de entrada e de saída
					//4 - Calcular Valor
					break;
				}
				
				case 3: {
					//Entrada Simples
					int op3;
					do {
						String strOp3 = JOptionPane.showInputDialog("Escolha uma opção:"
								+ "1 - Carro já cadastrado\n"
								+ "2 - Cadastrar novo carro\n"
								+ "0 - Voltar\n");
						op3 = Integer.parseInt(strOp3);
						switch(op3) {
							case 1: {
								//1 - Buscar Veículo
								//2 - Registrar horário de entrada e de saída 
								//3 - Calcular Valor
								break;
							}
						
							case 2: {
								//1 - Cadastrar Veículo
								//2 - Registrar horário de entrada e de saída 
								//3 - Calcular Valor
								break;
							}
							
							case 0: {
								JOptionPane.showMessageDialog(null, "Até mais!");
								break;
							}
						
						}
						
					}while(op3 != 0);
					
					break;
				}
				case 0: {
					//Encerrar programa;
					JOptionPane.showMessageDialog(null, "Até mais!");
					break;
				}
				default:
					JOptionPane.showMessageDialog(null, "Opção inválida, escolha uma das opções disponíveis!");
			}
			
		}while(opcao != 0);
	
	}

}
