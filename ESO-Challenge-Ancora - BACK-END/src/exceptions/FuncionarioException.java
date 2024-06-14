package exceptions;

public class FuncionarioException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public FuncionarioException() {
        super();
    }

    public FuncionarioException(String message) {
        super(message);
    }

    public FuncionarioException(String message, Throwable cause) {
        super(message, cause);
    }

    public FuncionarioException(Throwable cause) {
        super(cause);
    }
}
