package exceptions;

@SuppressWarnings("serial")
public class DadosPessoaisIncompletosException extends Exception{
    
	public DadosPessoaisIncompletosException(){
        super();
    }
   
	public DadosPessoaisIncompletosException(String errorMessage){
        super(errorMessage);
    }
}
