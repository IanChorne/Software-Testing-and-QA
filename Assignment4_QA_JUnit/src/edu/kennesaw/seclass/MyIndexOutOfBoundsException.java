package edu.kennesaw.seclass;

public class MyIndexOutOfBoundsException extends RuntimeException {
    public MyIndexOutOfBoundsException() {
        super();
    }

    public MyIndexOutOfBoundsException(String message) {
        super(message);
    }

    public MyIndexOutOfBoundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyIndexOutOfBoundsException(Throwable cause) {
        super(cause);
    }
}
