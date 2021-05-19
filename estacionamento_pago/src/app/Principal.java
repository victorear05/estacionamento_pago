package app;

import Exception.*;
import cadastros.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class Principal {

	static List<Mensalista> cadM = new LinkedList<Mensalista>();
	static List<Veiculo> cadV = new LinkedList<Veiculo>();
	static List<Acessos> aces = new LinkedList<Acessos>();
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		
		int opcao = 0;
		
		String menu = "Digite a opção desejada:\n"
				+ "1 - Nova entrada simples\n" 		
				+ "2 - Entrada de mensalista\n"		
				+ "3 - Listar todos os Acessos\n"
				+ "4 - Listar todos os veículos cadastrados\n"
				+ "5 - Listar todos os mensalistas cadastrados\n"
				+ "6 - Exibir faturamento total\n"
				+ "0 - Encerrar programa\n";
		do { 
			String strOpcao = JOptionPane.showInputDialog(menu);
			opcao = Integer.parseInt(strOpcao);
			
			switch(opcao) {
				
				case 1: {
					int op = 0;
					do {
						String Menu = "Digite a opção desejada:\n" 
								+ "1 - Para veículo já cadastrado\n"
								+ "2 - Para cadastrar um novo veículo\n"
								+ "0 - Para voltar ao Menu Principal\n";		
						String strOp = JOptionPane.showInputDialog(Menu);				
						op = Integer.parseInt(strOp);
						switch (op){
							case 1: {
								String placa;
								placa = JOptionPane.showInputDialog("Digite a placa do veículo para busca");
								Veiculo v = pesquisarVeiculo(placa);
								if (v != null)
									novoAcesso(v);
								else
									JOptionPane.showMessageDialog(null, "Veículo não encontrado!");
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
								JOptionPane.showMessageDialog(null, "Opção inválida, por favor selecione uma opção válida!\n");
								break;				
							}
						}
					}while(op != 0);
					break;
				}
				
				case 2: {
					int op = 0;
					do {
						String Menu = "Digite a opção desejada:\n"
								+ "1 - Para usuário já cadastrado\n"
								+ "2 - Para cadastrar um novo usuário\n"
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
									String strOpc= JOptionPane.showInputDialog("Digite a opção desejada: \n"
											+ "1 - Para pesquisar veículo já cadastrado\n"
											+ "2 - Para cadastrar novo veículo\n");
									opc = Integer.parseInt(strOpc);
									if(opc == 1) {
										v = pesquisarVMensalista(M);
										if(v != null)
											novoAcesso(v);	
										else
											JOptionPane.showMessageDialog(null, "Veículo não encontrada!\n");
									}
									if(opc == 2)
										v = cadastrarVeiculoM(M);
									
									op = 0;
								}
								else
									JOptionPane.showMessageDialog(null, "Usuário não encontrado!");	
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
								JOptionPane.showMessageDialog(null, "Opção inválida, por favor selecione uma opçãoo válida!\n");
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
				
				case 4: {
					imprimeVeiculos();
					break;
				}
				
				case 5: {
					imprimeMensalistas();
					break;
				}
				
				case 6: {
					imprimeFaturamento();
					break;
				}
				
				case 0: {
					break;
				}
				
				default: {
					JOptionPane.showMessageDialog(null, "Opção inválida, por favor selecione uma opção válida!");
					break;
				}
			}
			
		}while(opcao != 0);
	}
	
	public static Veiculo cadastrarVeiculoM(Mensalista mensalista) {
		//Registrando Ve�culo:			
		String Marca = JOptionPane.showInputDialog("Marca:\n");
		String Modelo = JOptionPane.showInputDialog("Modelo:\n");
		String NPlaca = JOptionPane.showInputDialog("Número da Placa:\n");
		
		Veiculo v = new Veiculo(Marca, Modelo, NPlaca, mensalista);
		cadV.add(v);
		//Registrando Acesso: 
		novoAcesso(v);
		return v;
	}
	
	public static void cadastrarMensalista(){
		
		String nome = "";
		String endereco = "";
		String celular = "";
		String telefone = "";
		String CNH = "";
		boolean repeat;
		
		repeat = true;
		while(repeat == true) {
			try {
				nome = JOptionPane.showInputDialog("Nome:\n");
				if(nome.equals(""))
					throw new DadosPessoaisIncompletosException("Campo nome vazio!");
				repeat = false;
			}catch(DadosPessoaisIncompletosException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				repeat = true;
			}
		}
		
		repeat = true;
		while(repeat == true) {
			try {
				CNH = JOptionPane.showInputDialog("CNH:\n");
				if (CNH.equals("")) {
					throw new DadosPessoaisIncompletosException("Campo CNH vazio!");
				}
				repeat = false;
			}catch(DadosPessoaisIncompletosException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				repeat = true;
			}
		}
		
		repeat = true;
		while(repeat == true) {
			try {
				endereco = JOptionPane.showInputDialog("Endereco:\n");
				if (endereco.equals("")) {
					throw new DadosPessoaisIncompletosException("Campo endereco vazio!");
				}
				repeat = false;
			}catch(DadosPessoaisIncompletosException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				repeat = true;
			}
		}
		
		repeat = true;
		while(repeat == true) {	
			try {
				celular = JOptionPane.showInputDialog("Celular:\n");
				if (celular.equals("")) {
					throw new DadosPessoaisIncompletosException("Campo celular vazio!");
				}
				repeat = false;
			}catch(DadosPessoaisIncompletosException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				repeat = true;
			}
		}
		
		telefone = JOptionPane.showInputDialog("Telefone (opcional):\nCaso n�o queira cadastrar um telefone, deixe em branco\n");			
		
		Mensalista M = new Mensalista(nome, endereco, celular, telefone, CNH);
		cadM.add(M);
		JOptionPane.showMessageDialog(null, "Usuário Cadastrado, cadastre agora o veículo de acesso!\n");
		cadastrarVeiculoM(M);
	}

	public static Veiculo pesquisarVeiculo(String placa) {
		for(Veiculo v : cadV) {
			if(placa.equalsIgnoreCase(v.getPlaca())) 
				return v;
		}
		return null;	
	}
	
	public static Mensalista pesquisarMensalista(String CNH) {
		for(Mensalista M : cadM) {
			if(CNH.equalsIgnoreCase(M.getCNH())) 
				return M;
		}
		return null;	
	}

	public static void novoAcesso(Veiculo v) {
		
		String strEntrada = JOptionPane.showInputDialog("Digite a data e hora de entrada do veículo como no exemplo:\n" + "DD/MM/AAAA HH:MM");
		String strSaida = JOptionPane.showInputDialog("Digite a data e hora de saída do veículo como no exemplo:\n" + "DD/MM/AAAA HH:MM");
		
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		LocalDateTime entrada = LocalDateTime.parse(strEntrada, formato);
		LocalDateTime saida = LocalDateTime.parse(strSaida, formato);
		
		Acessos A = new Acessos(v, entrada, saida);		//Tranformar String em LocalDateTime
		aces.add(A);
	}
	
	public static Veiculo pesquisarVMensalista(Mensalista M) {
		List<Veiculo> VM = M.getCadVM();
		String placa = JOptionPane.showInputDialog("Digite a placa do carro o qual deseja registrar o acesso: ");
		for(Veiculo v : VM) {
			if(placa.equalsIgnoreCase(v.getPlaca()));
				return v;
		}
		
		return null;
	}
	
	public static void imprimeAcessos() {
			int i = 1;
			String Acess = "";
			for(Acessos a : aces) {
				Acess += "Acesso " + i + ":\n";
				if(a.getV().getMensalista() != null) {
					Acess += "Mensalista \nNome: " + a.getV().getMensalista().getNome() + '\n'
						   + "CNH: " + a.getV().getMensalista().getCNH() + '\n';
				}
				else
					Acess += "Entrada Simples \n";
					
				Acess += "Marca: " + a.getV().getMarca() + '\n' 
					   + "Modelo: " + a.getV().getModelo() + '\n' 
					   + "Placa: " + a.getV().getPlaca() + '\n'
					   + "Entrada: " + a.getEntrada() + '\n'
					   + "Saída: " + a.getSaida() + '\n'
					   + "Preço: " + "R$" + a.getPreco() + "\n\n";
				i++;
			}
	if(Acess.equals(""))
		JOptionPane.showMessageDialog(null, "Sem registros!");
	else
		JOptionPane.showMessageDialog(null, Acess);
	}

	public static void imprimeVeiculos() {
		int i = 1;
		String Veic = "";
		for(Veiculo v : cadV) {
			Veic += "Veículo " + i + ":\n"
				  +	"Marca: " + v.getMarca() + '\n' 
			      + "Modelo: " + v.getModelo() + '\n' 
			      + "Placa: " + v.getPlaca() + '\n';
			if(v.getMensalista() != null)
				Veic += "Mensalista:\n" + v.getMensalista().getNome() + "/" + v.getMensalista().getCNH();
			else
				Veic += "Mensalista: - \n\n";
			i++;
		}
		if(Veic.equals(""))
			JOptionPane.showMessageDialog(null, "Sem registros de Veículo!");
		else
			JOptionPane.showMessageDialog(null, Veic);
	}
	
	public static void imprimeMensalistas () {
		int i = 1;
		String Mens = "";
		for(Mensalista M : cadM) {
			Mens += "Mensalista " + i + ":\n"
				  +	"Nome: " + M.getNome() + '\n' 
			      + "CNH: " + M.getCNH() + '\n' 
			      + "Endereço: " + M.getEndereco() + '\n'
			      + "Celular: " + M.getCelular() + '\n'
			      + "Telefone: " + M.getTelefone() + "\n\n";
			i++;
		}
		if(Mens.equals(""))
			JOptionPane.showMessageDialog(null, "Sem registros de Mensalistas!");
		else
			JOptionPane.showMessageDialog(null, Mens);
	}
	
	public static void imprimeFaturamento() {
		double faturamentoS = 0;
		double faturamentoM = 0;
		
		for(Acessos a : aces) 
			if(a.getV().getMensalista() == null)
				faturamentoS += a.getPreco();
		
		faturamentoM = cadM.size() * 500;
		
		double faturamentoT = faturamentoS + faturamentoM;
		
		JOptionPane.showMessageDialog(null, faturamentoT);
	}

}


/*			if(endereco == "")
throw new DadosPessoaisIncompletosException("Campo endereço vazio");		
if(celular == "")
throw new DadosPessoaisIncompletosException("Campo celular vazio");			
if(CNH == "")
throw new DadosPessoaisIncompletosException("Campo CNH vazio");
*/	