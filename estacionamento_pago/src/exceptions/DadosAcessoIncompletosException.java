package exceptions;

public class DadosAcessoIncompletosException extends Exception{
	public DadosAcessoIncompletosException(){
        super();
    }
   
	public DadosAcessoIncompletosException(String errorMessage){
        super(errorMessage);
    }
}
