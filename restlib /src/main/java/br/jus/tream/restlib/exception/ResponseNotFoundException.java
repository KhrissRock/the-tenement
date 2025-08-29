package br.jus.tream.restlib.exception;

@SuppressWarnings("serial")
public class ResponseNotFoundException extends RuntimeException {

	public ResponseNotFoundException(String message) {
        super(message);
    }
}
