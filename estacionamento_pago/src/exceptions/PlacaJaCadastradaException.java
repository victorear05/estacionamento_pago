package exceptions;

public class PlacaJaCadastradaException extends Exception{
	public PlacaJaCadastradaException(){
        super();
    }
   
	public PlacaJaCadastradaException(String errorMessage){
        super(errorMessage);
    }
}
