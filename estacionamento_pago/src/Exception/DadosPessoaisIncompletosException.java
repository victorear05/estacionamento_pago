package Exception;

public class DadosPessoaisIncompletosException extends Exception{
    public DadosPessoaisIncompletosException(String errorMessage, Throwable e){
        super(errorMessage, e);
    }
    public DadosPessoaisIncompletosException(String errorMessage){
        super(errorMessage);
    }
}
