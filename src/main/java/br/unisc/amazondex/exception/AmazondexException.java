package br.unisc.amazondex.exception;

public class AmazondexException extends RuntimeException {

    private static final long serialVersionUID = 2957975892450955220L;

    public AmazondexException(String message) {
        super(message);
    }

    public AmazondexException(String message, Throwable cause) {
        super(message, cause);
    }

    public AmazondexException(Throwable cause) {
        super(cause);
    }

    public AmazondexException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
