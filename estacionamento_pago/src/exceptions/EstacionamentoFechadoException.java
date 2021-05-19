package exceptions;

public class EstacionamentoFechadoException extends Exception{
	public EstacionamentoFechadoException(){ 
        super();
    }
   
	public EstacionamentoFechadoException(String errorMessage){
        super(errorMessage);
    }
}
