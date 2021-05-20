package app;

import exceptions.*;
import cadastros.*;

import java.time.DateTimeException;
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

		String menu = "Digite a op��o desejada:\n"
				+ "1 - Nova entrada simples\n" 		
				+ "2 - Entrada de mensalista\n"		
				+ "3 - Listar todos os Acessos\n"
				+ "4 - Listar todos os ve�culo cadastrados\n"
				+ "5 - Listar todos os mensalistas cadastrados\n"
				+ "6 - Exibir faturamento total\n"
				+ "7 - Excluir cadastro de Mensalista\n"
				+ "8 - Excluir cadastro de ve�culo\n"
				+ "0 ou pressione cancelar - Encerrar programa\n";
		do {
			boolean repeat1 = true;
			while(repeat1 == true)
			try {
				String strOpcao = JOptionPane.showInputDialog(menu);
				if(strOpcao == null)
					throw new OpcaoCancelarException();
					opcao = Integer.parseInt(strOpcao);
					repeat1 = false;
			}catch(OpcaoCancelarException e) {
				repeat1 = false;
				opcao = 0;
			}catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "NumberFormatException\nDigite uma Op��o V�lida!");
				repeat1 = true;
				}
				switch(opcao) {
					case 1: {
						int op = 0;
						do {
							boolean repeat;
							
							String strOp = "";
							
							repeat = true;
							while(repeat == true) {
							try {
								String Menu = "Digite a op��o desejada:\n" 
										+ "1 - Para ve�culos j� cadastrado\n"
										+ "2 - Para cadastrar um novo ve�culo\n"
										+ "0 - Para voltar ao Menu Principal\n";		
								strOp = JOptionPane.showInputDialog(Menu);
								if(strOp == null)
									throw new OpcaoCancelarException();
								op = Integer.parseInt(strOp);
								repeat = false;
							}catch(OpcaoCancelarException e) {
								repeat = false;
								op = 0;
							}catch(NumberFormatException e) {
								JOptionPane.showMessageDialog(null, "NumberFormatException\nDigite uma Op��o V�lida!");
								repeat = true;
								}
							}		
			
							switch (op){
								case 1: {
									String placa = "";
									boolean cancelar = false;
									try {
										placa = JOptionPane.showInputDialog("Digite a placa do ve�culo para busca");
										if(placa == null)
											throw new OpcaoCancelarException();
									}catch (OpcaoCancelarException e) {
										cancelar = true;
									}
									if(cancelar == false) {
										Veiculo v = pesquisarVeiculo(placa);
										if (v != null) {
											novoAcesso(v);
											op = 0;
										}
										else
											JOptionPane.showMessageDialog(null, "Ve�culo n�o encontrado!");
									}
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
							boolean repeat = true;
							while(repeat == true) {
								String Menu = "Digite a op��o desejada:\n"
										+ "1 - Para usu�rio j� cadastrado\n"
										+ "2 - Para cadastrar um novo usu�rio\n"
										+ "0 - Para voltar ao Menu Principal\n";
								try {
									String strOp = JOptionPane.showInputDialog(Menu);
									if(strOp == null)
										throw new OpcaoCancelarException();
									op = Integer.parseInt(strOp);
									repeat = false;
								}catch(OpcaoCancelarException e) {
									repeat = false;
									op = 0;
								}catch(NumberFormatException e) {
									JOptionPane.showMessageDialog(null, "NumberFormatException\nDigite uma Op��o V�lida!");
									repeat = true;
								}
							}
							switch(op){
								case 1: {
									boolean cancelar = false;
									Veiculo v = null;
									String CNH = "";
									try {
										CNH = JOptionPane.showInputDialog("Digite a CNH a ser buscada:");
										if(CNH == null)
											throw new OpcaoCancelarException();
									}catch(OpcaoCancelarException e) {
										cancelar = true;
									}
									if(cancelar == false) {
										Mensalista M = pesquisarMensalista(CNH);
										if(M != null) {											
												int opc = 0;
												String strOpc = JOptionPane.showInputDialog("Digite a op��o desejada: \n"
														+ "1 - Para pesquisar ve�culo j� cadastrado\n"
														+ "2 - Para cadastrar novo ve�culo\n"
														+ "0 - Para voltar ao Menu Principal\n");
												opc = Integer.parseInt(strOpc);
												
												switch(opc) {
													case 1: {
														v = pesquisarVMensalista(M);
														if(v != null)
														{
															novoAcesso(v);						    	
														    break;
														}	
														else {
															JOptionPane.showMessageDialog(null, "Ve�culo n�o encontrado!\n");	
															
															break;
														}
													}
													
													case 2: {
														cadastrarVeiculoM(M);
													    op = 0;	
													    break;
													}
													
													case 0: {
													    op = 0;	
													    break;
													}
											}
										}
										else
											JOptionPane.showMessageDialog(null, "Usu�rio n�o encontrado!");	
									}
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
					
					case 7: {
						if(cadM.isEmpty())
							JOptionPane.showMessageDialog(null, "N�o h� Mensalistas cadastrados!");
						else {
							String CNH = "";
							boolean cancelar = false;
							try {
								CNH = JOptionPane.showInputDialog("Digite a CNH do usu�rio a ser exclu�do:\n");
								if(CNH == null)
									throw new OpcaoCancelarException();
							}catch(OpcaoCancelarException e){
								cancelar = true;
							}			
							if(cancelar == false)
								excluiMensalista(CNH);
						}
						break;
					}
					case 8: {
						if(cadV.isEmpty())
							JOptionPane.showMessageDialog(null, "N�o h� ve�culos cadastrados!");
						else {
							String NPlaca = "";
							boolean cancelar = false;
							try {
								NPlaca = JOptionPane.showInputDialog("Digite a placa do carro a ser exclu�do:\n");
								if(NPlaca == null)
									throw new OpcaoCancelarException();
							}catch(OpcaoCancelarException e){
								cancelar = true;
							}
							
							if(cancelar == false)
								excluiVeiculo(NPlaca);
						}
						break;
					}
					
					case 0: {
						break;
					}
					
					default: {
						JOptionPane.showMessageDialog(null, "Op��o inv�lida, por favor selecione uma op��o v�lida");
						break;
					}
				}
			
		}while(opcao != 0);
	}
	
	public static void cadastrarVeiculoM(Mensalista mensalista) {
					
		String Marca = "";
		String Modelo = "";
		String NPlaca = "";
		boolean repeat;
		repeat = true;
			
			while(repeat == true) {
				try {
					Marca = JOptionPane.showInputDialog("Marca do Ve�culo:\n");
					if(Marca.equals("") || Marca == null)
						throw new DadosVeiculosIncompletosException("Campo Marca Incompleto!");
					repeat = false;
				}catch(DadosVeiculosIncompletosException e) {
					String msg = "DadosVeiculosIncompletosException\n" + e.getMessage();
					JOptionPane.showMessageDialog(null, msg);
					repeat = true;
				}catch(NullPointerException e) {
					String msg = "NullPointerException\nOp��o cancelar indispon�vel quando se est� fazendo o cadastro!";
					JOptionPane.showMessageDialog(null, msg);
					repeat = true;
				}
			}
		
			repeat = true;
			while(repeat == true) {
				try {
					Modelo = JOptionPane.showInputDialog("Modelo do Ve�culo:\n");
					if(Modelo.equals("") || Modelo == null)
						throw new DadosVeiculosIncompletosException("Campo Modelo Incompleto!");
					repeat = false;
				}catch(DadosVeiculosIncompletosException e) {
					String msg = "DadosVeiculosIncompletosException\n" + e.getMessage();
					JOptionPane.showMessageDialog(null, msg);
					repeat = true;
				}catch(NullPointerException e) {
					String msg = "NullPointerException\nOp��o cancelar indispon�vel quando se est� fazendo o cadastro!";
					JOptionPane.showMessageDialog(null, msg);
					repeat = true;
				}
			}
			
			repeat = true;
			while(repeat == true) {
				try {
					NPlaca = JOptionPane.showInputDialog("Placa do Ve�culo:\n");
					if(NPlaca.equals("") || NPlaca == null)
						throw new DadosVeiculosIncompletosException("Campo Placa Incompleto!");
					Veiculo v = pesquisarVeiculo(NPlaca);
					if(v != null)
						throw new PlacaJaCadastradaException();
					repeat = false;
				}catch(DadosVeiculosIncompletosException e) {
					String msg = "DadosVeiculosIncompletosException\n" + e.getMessage();
					JOptionPane.showMessageDialog(null, msg);
					repeat = true;
				}catch(NullPointerException e) {
						String msg = "NullPointerException\nOp��o cancelar indispon�vel quando se est� fazendo o cadastro!";
						JOptionPane.showMessageDialog(null, msg);
						repeat = true;
				}catch(PlacaJaCadastradaException e) {
					JOptionPane.showMessageDialog(null,"PlacaJaCadastradaException\nPlaca digitada j� foi cadastrada!");
					repeat = true;
				}
			}

			Veiculo v = new Veiculo(Marca, Modelo, NPlaca, mensalista);
			cadV.add(v);
			novoAcesso(v);
		
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
				String msg = "DadosPessoaisIncompletosException\n" + e.getMessage();
				JOptionPane.showMessageDialog(null, msg);
				repeat = true;
			}catch(NullPointerException e) {
				String msg = "NullPointerException\nOp��o cancelar indispon�vel quando se est� fazendo o cadastro!";
				JOptionPane.showMessageDialog(null, msg);
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
				Mensalista M = pesquisarMensalista(CNH);
				if(M != null)
					throw new CNHJaCadastradaException();
				repeat = false;
			}catch(DadosPessoaisIncompletosException e) {
				String msg = "DadosPessoaisIncompletosException\n" + e.getMessage();
				JOptionPane.showMessageDialog(null, msg);
				repeat = true;
			}catch(NullPointerException e) {
				String msg = "NullPointerException\nOp��o cancelar indispon�vel quando se est� fazendo o cadastro!";
				JOptionPane.showMessageDialog(null, msg);
				repeat = true;
			}catch(CNHJaCadastradaException e) {
				JOptionPane.showMessageDialog(null,"CNHJaCadastradaException\nCNH digitada j� foi cadastrada!");
				repeat = true;
			}
		}
		
		repeat = true;
		while(repeat == true) {
			try {
				endereco = JOptionPane.showInputDialog("Endere�o:\n");
				if (endereco.equals("")) {
					throw new DadosPessoaisIncompletosException("Campo endere�o vazio!");
				}
				repeat = false;
			}catch(DadosPessoaisIncompletosException e) {
				String msg = "DadosPessoaisIncompletosException\n" + e.getMessage();
				JOptionPane.showMessageDialog(null, msg);
				repeat = true;
			}catch(NullPointerException e) {
				String msg = "NullPointerException\nOp��o cancelar indispon�vel quando se est� fazendo o cadastro!";
				JOptionPane.showMessageDialog(null, msg);
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
				String msg = "DadosPessoaisIncompletosException\n" + e.getMessage();
				JOptionPane.showMessageDialog(null, msg);
				repeat = true;
			}catch(NullPointerException e) {
				String msg = "NullPointerException\nOp��o cancelar indispon�vel quando se est� fazendo o cadastro!";
				JOptionPane.showMessageDialog(null, msg);
				repeat = true;
			}
		}
			try {
				telefone = JOptionPane.showInputDialog("Telefone (opcional):\n"
						+ "Caso n�o queira cadastrar um telefone, deixe em branco, ou selecione a op��o Cancelar\n");
				if(telefone == null || telefone.equals(""))
					throw new OpcaoCancelarException();
			}catch(OpcaoCancelarException e) {
				telefone = "";
			}
				
		
		Mensalista M = new Mensalista(nome, endereco, celular, telefone, CNH);
		cadM.add(M);
		JOptionPane.showMessageDialog(null, "Usu�rio Cadastrado, cadastre agora o ve�culo de acesso!\n");
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
		
		String strEntrada = "";
		String strSaida = "";
		LocalDateTime entrada = null;
		LocalDateTime saida = null;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		boolean repeat, repeat1 = true;
		
		while(repeat1 == true) {
			try {
				repeat = true;
				while(repeat == true) {
					try {
						strEntrada = JOptionPane.showInputDialog("Digite a data e hora de entrada do ve�culo, como no exemplo:\n" + 
																 "DD/MM/AAAA HH:MM");
						if(strEntrada.equals(""))
							throw new DadosAcessoIncompletosException("Campo entrada vazio!");
						entrada = LocalDateTime.parse(strEntrada, formato);
						if(entrada.getHour() > 20 || (entrada.getHour() == 20 && entrada.getMinute() > 0) || entrada.getHour() < 6)
							throw new EstacionamentoFechadoException("Hor�rio de entrada inv�lido, estacionamento fechado!");
						repeat = false;
					}catch(NullPointerException e) {
						String msg = "NullPointerException\nOp��o cancelar indispon�vel quando se est� fazendo o cadastro!";
						JOptionPane.showMessageDialog(null, msg);
						repeat = true;
					}catch(DateTimeException e) {
						String msg = "DateTimeException\nFormato da data informada � inv�lido!\n"
								+ "Informe uma data nesse formato:\n"
								+ "DD/MM/AAAA HH:MM";
						JOptionPane.showMessageDialog(null, msg);
						repeat = true;
					}catch(DadosAcessoIncompletosException e) {
						String msg = "DadosAcessoIncompletosException\n" + e.getMessage();
						JOptionPane.showMessageDialog(null, msg);
						repeat = true;
					}catch(EstacionamentoFechadoException e) {
						String msg = "EstacionamentoFechadoException\n" + e.getMessage();
						JOptionPane.showMessageDialog(null, msg);
						repeat = true;
					}
				}
				if(repeat == true)
					break;
				repeat = true;
				while(repeat == true) {
					try {
						strSaida = JOptionPane.showInputDialog("Digite a data e hora de sa�da do ve�culo como no exemplo:\n" + 
															   "DD/MM/AAAA HH:MM");
						if(strSaida.equals(""))
							throw new DadosAcessoIncompletosException("Campo sa�da vazio!");
						saida = LocalDateTime.parse(strSaida, formato);
						if(saida.getHour() > 20 || (saida.getHour() == 20 && saida.getMinute() > 0) || saida.getHour() < 6)
							throw new EstacionamentoFechadoException("Hor�rio de sa�da inv�lido, estacionamento fechado!");
						repeat = false;
					}catch(NullPointerException e) {
						String msg = "NullPointerException\nOp��o cancelar indispon�vel quando se est� fazendo o cadastro!";;
						JOptionPane.showMessageDialog(null, msg);
						repeat = true;
					}catch(DateTimeException e) {
						String msg = "DateTimeException\nFormato da data informada � inv�lido!\n"
								+ "Informe uma data nesse formato:\n"
								+ "DD/MM/AAAA HH:MM";
						JOptionPane.showMessageDialog(null, msg);
						repeat = true;
					}catch(DadosAcessoIncompletosException e ) {
						String msg = "DadosAcessoIncompletosException\n" + e.getMessage();
						JOptionPane.showMessageDialog(null, msg);
						repeat = true;
					}catch(EstacionamentoFechadoException e) {
						String msg = "EstacionamentoFechadoException\n" + e.getMessage();
						JOptionPane.showMessageDialog(null, msg);
						repeat = true;
					}
				}
				if(repeat == true )
					break;
				if(saida.isBefore(entrada) == true || saida.isEqual(entrada))
					throw new PeriodoInvalidoException("Per�odo igual ou inferior a zero, digite uma data de entrada e de sa�da v�lidas!");
				repeat1 = false;
			}catch(PeriodoInvalidoException e) {
				String msg = "PeriodoInv�lidoException\n" + e.getMessage();
				JOptionPane.showMessageDialog(null, msg);
				repeat1 = true;
			}
		}
		if(repeat1 == false) {
			Acessos A = new Acessos(v, entrada, saida);
			aces.add(A);
		}
	}
	
	public static Veiculo pesquisarVMensalista(Mensalista M) {
		List<Veiculo> VM = M.getCadVM();
		String placa = "";
		boolean cancelar = false;
		try {
			placa = JOptionPane.showInputDialog("Digite a placa do carro o qual deseja registrar o acesso: ");
			if(placa == null)
				throw new OpcaoCancelarException();
		}catch(OpcaoCancelarException e) {
			cancelar = true;
		}
		
		if(cancelar == false) {
			for(Veiculo v : VM) {
				if(placa.equalsIgnoreCase(v.getPlaca()));
					return v;
			}
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
				Acess += "Entrada Simples\n";
				
			Acess += "Marca: " + a.getV().getMarca() + '\n' 
				   + "Modelo: " + a.getV().getModelo() + '\n' 
				   + "Placa: " + a.getV().getPlaca() + '\n'
				   + "Entrada: " + a.getEntrada() + '\n'
				   + "Sa�da: " + a.getSaida() + '\n'
				   + "Pre�o: " + "R$" + a.getPreco() + "\n\n";
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
			Veic += "Ve�culo " + i + ":\n"
				  +	"Marca: " + v.getMarca() + '\n' 
			      + "Modelo: " + v.getModelo() + '\n' 
			      + "Placa: " + v.getPlaca() + '\n';
			if(v.getMensalista() != null)
				Veic += "Mensalista:\n" + v.getMensalista().getNome() + "/" + v.getMensalista().getCNH() + "\n";
			else
				Veic += "Mensalista: - \n\n";
			i++;
		}
		if(Veic.equals(""))
			JOptionPane.showMessageDialog(null, "Sem registros de ve�culos!");
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
			      + "Endere�o: " + M.getEndereco() + '\n'
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
	
	public static void excluiVeiculo(String NPlaca) {

		Veiculo v = pesquisarVeiculo(NPlaca);
		if(v != null) {
			JOptionPane.showMessageDialog(null, "Ve�culo: " + v.getMarca() + " " + v.getModelo() + "\nPlaca: " + v.getPlaca()
					+ "\nExclu�do com sucesso!");
			cadV.remove(v);
		}
		else
			JOptionPane.showMessageDialog(null,"Ve�culo possuidor da placa: " + NPlaca + " n�o foi encontrado!");
	}
	
	public static void excluiMensalista(String CNH) {
		Mensalista M = pesquisarMensalista(CNH);
		if(M != null) {
			for(Veiculo v : cadV)
				if(v.getMensalista() != null)
					if(v.getMensalista().getCNH().equals(M.getCNH()))
						cadV.remove(v);
			JOptionPane.showMessageDialog(null, "Usu�rio: " + M.getNome() + "\n" + "CNH: " + M.getCNH() + "\nExclu�do com sucesso!");
			M.getCadVM().clear();
			cadM.remove(M);
		}
		else
			JOptionPane.showMessageDialog(null,"Usu�rio possuidor da CNH: " + CNH + " n�o foi encontrado!");
	}
}
