package app;

import cadastros.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
		
		String menu = "Digite a op��o desejada:\n"
				+ "1 - Nova entrada simples\n" 		
				+ "2 - Entrada de mensalista\n"		
				+ "0 - Encerrar Programa\n";
		do { 
			String strOpcao = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 1: {
					int op;
					String Menu = "Para ve�culo j� cadastrado, digite 1\n"
							+ "Para cadastrar um novo ve�culo, digite 2\n";		
					String strOp = JOptionPane.showInputDialog(Menu);				
					op = Integer.parseInt(strOp);
					switch (op){
						case 1: {
							String placa;
							placa = JOptionPane.showInputDialog("Digite a placa do ve�culo para busca");
							Veiculo v = pesquisarVeiculo(placa);
							novoAcesso(v);
							break;
						}
						case 2: {
							cadastrarVeiculoM(null);
							break;
						}
						default: {
							JOptionPane.showMessageDialog(null, "Op��o inv�lida!\n");
							break;				
						}
					}
				}
				
				case 2: {
					int op;

					String Menu = ("Para usu�rio j� cadastrado, digite 1\n"
							+ "Para cadastrar um novo usu�rio, digite 2\n"
							+ "Para cadastar um novo ve�culo de mensalista, digite 3\n");
					String strOp = JOptionPane.showInputDialog(Menu);
					op = Integer.parseInt(strOp);
					switch(op){
						case 1: {
							pesquisarVMensalista();
							break;	
						}

						case 2: {
							cadastrarMensalista();
							break;
						}
						
						case 3: {
							Mensalista M;
							String CNH;
							CNH = JOptionPane.showInputDialog("Digite a CNH a ser buscada:");
							M = pesquisarMensalista(CNH);
							cadastrarVeiculoM(M);
							break;
						}
						
						default: {
							JOptionPane.showMessageDialog(null, "Op��o inv�lida, voltando ao menu!");
							break;				
						}
					}	
				}
				
			}
			
		}while(opcao != 0);
	}
	
	public static void cadastrarVeiculoM(Mensalista mensalista) {
		//Registrando Ve�culo:
		String Marca = JOptionPane.showInputDialog("Marca:\n");
		String Modelo = JOptionPane.showInputDialog("Modelo:\n");
		String NPlaca = JOptionPane.showInputDialog("N�mero da Placa:\n");
		
		Veiculo v = new Veiculo(Marca, Modelo, NPlaca, mensalista);
		Veiculo tempV[] = new Veiculo[cadV.length + 1];	
		for(int i = 0; i < cadV.length;i++) {
			tempV[i] = cadV[i];
		}
		tempV[tempV.length -1] = v;
		cadV = tempV;
		
		//Registrando Acesso: 
		String strEntrada = JOptionPane.showInputDialog("Digite a data e hora de entrada do ve�culo como no exemplo:\n" + "DD/MM/AAAA HH:MM");
		String strSaida = JOptionPane.showInputDialog("Digite a data e hora de sa�da do ve�culo como no exemplo:\n" + "DD/MM/AAAA HH:MM");
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		LocalDateTime entrada = LocalDateTime.parse(strEntrada, formato);
		LocalDateTime saida = LocalDateTime.parse(strSaida, formato);
		
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
		
		cadastrarVeiculoM(M);
	}
	
	public static Veiculo pesquisarVeiculo(String placa) {
		for(int i = 0; i < cadM.length; i++) {
			if(placa == cadV[i].getPlaca())
				return cadV[0];
		}
		return null;	
	}
	
	public static Mensalista pesquisarMensalista(String CNH) {
		for(int i = 0; i < cadM.length; i++) {
			if(CNH == cadM[i].getCNH())
				return cadM[0];
		}
		return null;	
	}

	public static void novoAcesso(Veiculo v) {
		
		String strEntrada = JOptionPane.showInputDialog("Digite a data e hora de entrada do ve�culo como no exemplo:\n" + "DD/MM/AAAA HH:MM");
		String strSaida = JOptionPane.showInputDialog("Digite a data e hora de sa�da do ve�culo como no exemplo:\n" + "DD/MM/AAAA HH:MM");
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		LocalDateTime entrada = LocalDateTime.parse(strEntrada, formato);
		LocalDateTime saida = LocalDateTime.parse(strSaida, formato);
		
		Acessos A = new Acessos(v, entrada, saida);		//Tranformar String em LocalDateTime
		Acessos tempA[] = new Acessos[aces.length + 1];	
		for(int i = 0; i < aces.length;i++) {
			tempA[i] = aces[i];
		}
		tempA[tempA.length -1] = A;
		aces = tempA;
	}
	
	public static void pesquisarVMensalista() {
		
		Mensalista M = null;
		String CNH;
		int i= 0;
		CNH = JOptionPane.showInputDialog("Digite o CPF do usu�rio para busca");
		while(i < cadM.length) {
			if(CNH == cadM[i].getCNH())
				M = cadM[i];
			else	
				i++;
		}	
		if(M != null) {
			Veiculo VM[] = M.getCadVM();
			if(VM.length > 0) {
				int opV;
				for(i = 0; i < VM.length; i++)
					JOptionPane.showMessageDialog(null,"Ve�culo " + i + ": \n"  
													  +	"Marca: " + VM[i].getMarca() + "\n"
													  + "Modelo: " + VM[i].getModelo()+ "\n"
													  + "Placa: " + VM[i].getPlaca());
				
				String strOpV = JOptionPane.showInputDialog("Para qual carro deseja registrar um acesso?");
				opV = Integer.parseInt(strOpV);
				novoAcesso(VM[opV]);
				JOptionPane.showMessageDialog(null, "Acesso Registrado!");
			}
			else
				JOptionPane.showMessageDialog(null, "Usu�rio n�o possui ve�culos cadastrados");
		}
		else
			JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado!");
	}
	
	public void imprimiAcessos() {
		for(int i = 0;i < aces.length;i++) {
			JOptionPane.showMessageDialog(null, aces[i].getV().getMarca() + "\n" 
											  + aces[i].getV().getModelo() + "\n" 
											  + aces[i].getV().getPlaca() + "\n"
											  + aces[i].getEntrada() + "\n"
											  + aces[i].getSaida() + "\n"
											  + aces[i].getPreco());
		}
	}
}
