package app;

import cadastros.*;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

public class Principal {
	
	static Mensalista cadM[] = new Mensalista[0];
	static Veiculo cadV[] = new Veiculo[0];
	static Acessos aces[] = new Acessos[0];
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		
		int opcao = 0;
		
		String menu = "Digite a opção desejada:\n"
				+ "1 - Nova entrada simples\n" 		//OK
				+ "2 - Entrada de mensalista\n"		//OK
				+ "0 - Encerrar Programa\n";
		do { 
			String strOpcao = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 1: {
					int op;
					String Menu = "Para veículo já cadastrado, digite 1\n"
							+ "Para cadastrar um novo veículo, digite 2\n";		
					String strOp = JOptionPane.showInputDialog(Menu);				
					op = Integer.parseInt(strOp);
					switch (op){
						case 1: {
							String placa;
							placa = JOptionPane.showInputDialog("Digite a placa do veículo para busca");
							Veiculo v = pesquisarVeiculo(placa);
							novoAcesso(v);
							break;
						}
						case 2: {
							cadastrarVeiculo(null);
							break;
						}
						default: {
							JOptionPane.showMessageDialog(null, "Opção inválida, voltando ao menu!");
							break;				
						}
					}
				}
				
				case 2: {
					int op;

					String Menu = ("Para veículo já cadastrado, digite 1\n"
							+ "Para cadastrar um novo veículo, digite 2\n");
					String strOp = JOptionPane.showInputDialog(Menu);
					op = Integer.parseInt(strOp);
					switch(op){
						case 1: {
							String CNH;
							CNH = JOptionPane.showInputDialog("Digite o CPF do usuário para busca");
							pesquisarMensalista(CNH);
							break;	
						}

						case 2: {
							cadastrarMensalista();
							break;
						}
						default: {
							JOptionPane.showMessageDialog(null, "Opção inválida, voltando ao menu!");
							break;				
						}
					}	
				}
				
			}
			
		}while(opcao != 0);
	}
	
	public static void cadastrarVeiculo(Mensalista mensalista) {
		
		//Registrando Veículo:
		String Marca = JOptionPane.showInputDialog("Marca:\n");
		String Modelo = JOptionPane.showInputDialog("Modelo:\n");
		String NPlaca = JOptionPane.showInputDialog("Número da Placa:\n");
		
		Veiculo v = new Veiculo(Marca, Modelo, NPlaca, mensalista);
		Veiculo tempV[] = new Veiculo[cadV.length + 1];	
		for(int i = 0; i < cadV.length;i++) {
			tempV[i] = cadV[i];
		}
		tempV[tempV.length -1] = v;
		cadV = tempV;
		
		//Registrando Acesso: 
		String DEntrada = JOptionPane.showInputDialog("Digite a data de entrada:\n");
		String HEntrada = JOptionPane.showInputDialog("Digite a hora de entrada:\n");
		String DSaida = JOptionPane.showInputDialog("Digite a data de saída:\n");
		String HSaida = JOptionPane.showInputDialog("Digite a hora de saída:\n");
		LocalDateTime entrada;
		LocalDateTime saida;
		
		Acessos A = new Acessos(v, entrada, saida);    	//Tranformar String em LocalDateTime
		Acessos tempA[] = new Acessos[aces.length + 1];	
		for(int i = 0; i < aces.length;i++) {
			tempA[i] = aces[i];
		}
		tempA[tempA.length -1] = A;
		aces = tempA;
	
	}
	
	public static void cadastrarMensalista() {
		String nome = JOptionPane.showInputDialog("Nome:\n");
		String endereco = JOptionPane.showInputDialog("Endereco:\n");
		String celular = JOptionPane.showInputDialog("Celular:\n");
		String telefone = JOptionPane.showInputDialog("Telefone:\n");
		String CNH = JOptionPane.showInputDialog("CNH:\n");
		
		Mensalista M = new Mensalista(nome, endereco, celular, telefone, CNH);
		Mensalista tempM[] = new Mensalista[cadM.length + 1];	
		for(int i = 0; i < cadM.length;i++) {
			tempM[i] = cadM[i];
		}
		tempM[tempM.length -1] = M;
		cadM = tempM;
	}
	
	public static Mensalista pesquisarMensalista(String CNH) {
		for(int i = 0; i < cadM.length; i++) {
			if(CNH == cadM[i].CNH)
				return cadM[0];
		}
		return null;
	}
	
	public static Veiculo pesquisarVeiculo(String placa) {
		for(int i = 0; i < cadM.length; i++) {
			if(placa == cadV[i].placa)
				return cadV[0];
		}
		return null;	
	}

	public static void novoAcesso(Veiculo v) {
		String DEntrada = JOptionPane.showInputDialog("Digite a data de entrada:\n");
		String HEntrada = JOptionPane.showInputDialog("Digite a hora de entrada:\n");
		String DSaida = JOptionPane.showInputDialog("Digite a data de saída:\n");
		String HSaida = JOptionPane.showInputDialog("Digite a hora de saída:\n");
		LocalDateTime entrada;
		LocalDateTime saida;
		
		Acessos A = new Acessos(v, entrada, saida);		//Tranformar String em LocalDateTime
		Acessos tempA[] = new Acessos[aces.length + 1];	
		for(int i = 0; i < aces.length;i++) {
			tempA[i] = aces[i];
		}
		tempA[tempA.length -1] = A;
		aces = tempA;
	}

}
