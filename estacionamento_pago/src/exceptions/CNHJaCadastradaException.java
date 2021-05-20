package exceptions;

public class CNHJaCadastradaException extends Exception{
	public CNHJaCadastradaException(){
        super();
    }
   
	public CNHJaCadastradaException(String errorMessage){
        super(errorMessage);
    }
}
