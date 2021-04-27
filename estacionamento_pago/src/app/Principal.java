package app;

import javax.swing.JOptionPane;
import cobranca.Valores;
import cadastros.CadastrarPessoaFisica;

public class Principal {

	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		
		int opcao = 0;
		
		String menu = "Selecione uma opcão:\n"
				+ "1 - Primeiro Acesso\n"
				+ "2 - Buscar Registro do Veículo\n"
				+ "3 - Veículo de Mensalistas\n"
				+ "0 - Encerrar Programa\n";	
		do { 
			
			String strOpcao = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 1: {
					//primeiro acesso
						String strMarca = JOptionPane.showInputDialog("Cadastre o seu veículo:\n"
								+ "Marca:\n");
						String strModelo = JOptionPane.showInputDialog("Modelo:\n");
						String strNPlaca = JOptionPane.showInputDialog("Número da Placa:\n");

						//cadastroPA(String strMarca, String strModelo, String strNPlaca);
						break;				
				}
				case 2: {
					int op2;

					String strOp2 = JOptionPane.showInputDialog("Escolha uma opção:\n"
							+ "1 - Acrescentar novo acesso\n"
							+ "2 - Pagamento\n"
							+ "0 - Voltar\n");
				op2 = Integer.parseInt(strOp2);
					switch(op2){
						case 1:
						//acrescentar acesso
						break;

						case 2:
						//pagamento
						break;
					}
					
				}
				
				case 3: {
					int op3;

					String strOp3 = JOptionPane.showInputDialog("Escolha uma opção:\n"
							+ "1 - Buscar Registro do veículo de mensalista\n"
							+ "2 - Cadastrar novo usuário mensalista\n"
							+ "0 - Voltar\n");
				op3 = Integer.parseInt(strOp3);
					
				switch(op3){
					case 1:
					//buscar registro mensalista
					break;

					case 2:
					//cadastrar usuário mensalista
					break;
				}

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
