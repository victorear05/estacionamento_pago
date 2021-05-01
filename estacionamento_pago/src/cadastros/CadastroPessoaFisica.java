package cadastros;

import javax.swing.JOptionPane;

public class CadastroPessoaFisica {
	
    private PessoaFisica[] pro;
	
	public CadastroPessoaFisica() {
		pro = new PessoaFisica[0]; 
		
	}
	
	public PessoaFisica cadastrarPessoaFisica() {
		
		String NomPro = "";
		String EndPro = "";
		String TelCel = "";
		String TelFix = "";
		String NumCnh = "";
		
		do {
			NomPro = JOptionPane.showInputDialog("Informe o nome do propriet�rio");
			 if (NomPro.isEmpty()){
				 JOptionPane.showMessageDialog(null, "Informe um nome v�lido!");	
			}
		}while(NomPro.isEmpty());
		do {
			EndPro = JOptionPane.showInputDialog("Informe o endere�o do propriet�rio");
			 if (EndPro.isEmpty()){
				 JOptionPane.showMessageDialog(null, "Informe um endere�o v�lido!");	
			}
		}while(EndPro.isEmpty());
		do {
			TelCel = JOptionPane.showInputDialog("Informe o telefone celular do propriet�rio");
			 if (TelCel.isEmpty()){
				 JOptionPane.showMessageDialog(null, "Informe um telefone celular v�lido!");	
			}
		}while (TelCel.isEmpty());
		
		TelFix = JOptionPane.showInputDialog("Informe o telefone fixo do propriet�rio (Opcional)");
		
		do {
			NumCnh = JOptionPane.showInputDialog("Informe o numero da CNH do propriet�rio");
			 if (NumCnh.isEmpty()){
				 JOptionPane.showMessageDialog(null, "Informe uma CNH v�lido!");	
			}
		}while(NumCnh.isEmpty());
		
		PessoaFisica pesfis = new PessoaFisica(NomPro,EndPro,TelCel,TelFix,NumCnh);
		
		PessoaFisica pesfispro[] = new PessoaFisica[pro.length + 1]; 
		for (int i = 0; i < pro.length; i++) { 
			pesfispro[i] = pro[i];
		}
		pesfispro[pesfispro.length - 1] = pesfis; 
		pro = pesfispro;  
		
		return pesfis; 
	}
	
}