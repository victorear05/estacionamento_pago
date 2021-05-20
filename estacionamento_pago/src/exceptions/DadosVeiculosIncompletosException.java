package exceptions;

@SuppressWarnings("serial")
public class DadosVeiculosIncompletosException extends Exception{
	public DadosVeiculosIncompletosException(){
        super();
    }
   
	public DadosVeiculosIncompletosException(String errorMessage){
        super(errorMessage);
    }
}
