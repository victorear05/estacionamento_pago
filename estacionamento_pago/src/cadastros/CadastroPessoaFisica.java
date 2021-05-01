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
			NomPro = JOptionPane.showInputDialog("Informe o nome do proprietário");
			 if (NomPro.isEmpty()){
				 JOptionPane.showMessageDialog(null, "Informe um nome válido!");	
			}
		}while(NomPro.isEmpty());
		do {
			EndPro = JOptionPane.showInputDialog("Informe o endereço do proprietário");
			 if (EndPro.isEmpty()){
				 JOptionPane.showMessageDialog(null, "Informe um endereço válido!");	
			}
		}while(EndPro.isEmpty());
		do {
			TelCel = JOptionPane.showInputDialog("Informe o telefone celular do proprietário");
			 if (TelCel.isEmpty()){
				 JOptionPane.showMessageDialog(null, "Informe um telefone celular válido!");	
			}
		}while (TelCel.isEmpty());
		
		TelFix = JOptionPane.showInputDialog("Informe o telefone fixo do proprietário (Opcional)");
		
		do {
			NumCnh = JOptionPane.showInputDialog("Informe o numero da CNH do proprietário");
			 if (NumCnh.isEmpty()){
				 JOptionPane.showMessageDialog(null, "Informe uma CNH válido!");	
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