package br.com.demo.exception;

public class JsonUtilsException extends RuntimeException {

    public JsonUtilsException(Throwable exception) {
        super(exception);
    }

    public JsonUtilsException(String msg) {
        super(msg);
    }
}
