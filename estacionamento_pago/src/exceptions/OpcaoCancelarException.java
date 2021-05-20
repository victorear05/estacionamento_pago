package exceptions;

public class OpcaoCancelarException extends Exception{
    
	public OpcaoCancelarException(){
        super();
    }
   
	public OpcaoCancelarException(String errorMessage){
        super(errorMessage);
    }
}
