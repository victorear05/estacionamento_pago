package exceptions;

@SuppressWarnings("serial")
public class PeriodoInvalidoException extends Exception{
	public PeriodoInvalidoException(){ 
        super();
    }
   
	public PeriodoInvalidoException(String errorMessage){
        super(errorMessage);
    }
}