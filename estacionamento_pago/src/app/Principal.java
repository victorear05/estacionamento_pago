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
				+ "3 - Listar todos os Acessos\n"
				+ "0 - Encerrar Programa\n";
		do { 
			String strOpcao = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 1: {
					int op = 0;
					do {
						String Menu = "Digite a op��o desejada:\n" 
								+ "1 - Para ve�culo j� cadastrado\n"
								+ "2 - Para cadastrar um novo ve�culo\n"
								+ "0 - Para voltar ao Menu Principal\n";		
						String strOp = JOptionPane.showInputDialog(Menu);				
						op = Integer.parseInt(strOp);
						switch (op){
							case 1: {
								String placa;
								placa = JOptionPane.showInputDialog("Digite a placa do ve�culo para busca");
								Veiculo v = pesquisarVeiculo(placa);
								if (v != null)
									novoAcesso(v);
								else
									JOptionPane.showMessageDialog(null, "Ve�culo n�o encontrado!");
								op = 0;
								break;
							}
							
							case 2: {
								cadastrarVeiculoM(null);
								op = 0;
								break;
							}
							
							case 0: {
								break;
							}
							
							default: {
								JOptionPane.showMessageDialog(null, "Op��o inv�lida, por favor selecione uma op��o v�lida!\n");
								break;				
							}
						}
					}while(op != 0);
					break;
				}
				
				case 2: {
					int op = 0;
					do {
						String Menu = "Digite a op��o desejada:\n"
								+ "1 - Para usu�rio j� cadastrado\n"
								+ "2 - Para cadastrar um novo usu�rio\n"
								+ "0 - Para voltar ao Menu Principal\n";
						String strOp = JOptionPane.showInputDialog(Menu);
						op = Integer.parseInt(strOp);
						switch(op){
							case 1: {
								Veiculo v = null;
								String CNH = JOptionPane.showInputDialog("Digite a CNH a ser buscada:");
								Mensalista M = pesquisarMensalista(CNH);
								if(M != null) {
									int opc = 0;
									String strOpc= JOptionPane.showInputDialog("Digite a op��o desejada:"
																			 + "1 - Para pesquisar ve�culo j� cadastrado"
																			 + "2 - Para cadastrar .novo ve�culo");
									opc = Integer.parseInt(strOpc);
									if(opc == 1) {
										v = pesquisarVMensalista(M);
										novoAcesso(v);	
									}
									if(opc == 2)
										v = cadastrarVeiculoM(M);
									
									op = 0;
								}
								else
									JOptionPane.showInputDialog("Usu�rio n�o encontrado!");	
								break;	
							}
	
							case 2: {
								cadastrarMensalista();
								op = 0;
								break;
							}
							
							case 0: {
								break;
							}
							
							default: {
								JOptionPane.showMessageDialog(null, "Op��o inv�lida, por favor selecione uma op��o v�lida!\n");
								break;				
							}
						}	
					}while(op != 0);
					break;
				}
				
				case 3: {
					imprimeAcessos();
					break;
				}
				
				case 0: {
					break;
				}
				
				default: {
					JOptionPane.showMessageDialog(null, "Op��o inv�lida, por favor selecione uma op��o v�lida!");
					break;
				}
			}
			
		}while(opcao != 0);
	}
	
	public static Veiculo cadastrarVeiculoM(Mensalista mensalista) {
		//Registrando Ve�culo:
		String Marca = JOptionPane.showInputDialog("Marca:\n");
		String Modelo = JOptionPane.showInputDialog("Modelo:\n");
		String NPlaca = JOptionPane.showInputDialog("N�mero da Placa:\n");
		
		Veiculo v = new Veiculo(Marca, Modelo, NPlaca, mensalista);
		Veiculo tempV[] = new Veiculo[cadV.length + 1];	
		for(int i = 0; i < cadV.length;i++) {
			tempV[i] = cadV[i];
		}
		tempV[tempV.length - 1] = v;
		cadV = tempV;
		
		//Registrando Acesso: 
		novoAcesso(v);
		return v;
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
		Veiculo v = null;
		for(int i = 0; i < cadV.length; i++)
			if((cadV[i].getPlaca()).equals(placa))
				v = cadV[i];
		return v;	
	}
	
	public static Mensalista pesquisarMensalista(String CNH) {
		Mensalista M = null;
		for(int i = 0; i < cadM.length; i++) {
			if(CNH.equals(cadM[i].getCNH())) 
				M = cadM[i];
		}
		return M;	
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
	
	public static Veiculo pesquisarVMensalista(Mensalista M) {
		
		Veiculo VM[] = M.getCadVM();
		Veiculo v = null;
		if(VM.length > 0) {
			int opV;
			for(int i = 0; i < VM.length; i++)
				JOptionPane.showMessageDialog(null,"Ve�culo " + i + ": \n"  
												  +	"Marca: " + VM[i].getMarca() + "\n"
												  + "Modelo: " + VM[i].getModelo()+ "\n"
												  + "Placa: " + VM[i].getPlaca());
				String strOpV = JOptionPane.showInputDialog("Para qual carro deseja registrar o acesso?");
				opV = Integer.parseInt(strOpV);
				if(opV >= VM.length)
					JOptionPane.showMessageDialog(null, "Veiculo Inv�lido!");
				else
					v = VM[opV];
			}
			else
				JOptionPane.showMessageDialog(null, "Usu�rio n�o possui ve�culos cadastrados");
		return v;
	}
	
	public static void imprimeAcessos() {
		if(aces.length != 0)
			for(int i = 0;i < aces.length;i++) {
				JOptionPane.showMessageDialog(null, aces[i].getV().getMarca() + "\n" 
												  + aces[i].getV().getModelo() + "\n" 
												  + aces[i].getV().getPlaca() + "\n"
												  + aces[i].getEntrada() + "\n"
												  + aces[i].getSaida() + "\n"
												  + aces[i].getPreco());
		}
		else
			JOptionPane.showMessageDialog(null,"Sem acessos!");
	}
}
