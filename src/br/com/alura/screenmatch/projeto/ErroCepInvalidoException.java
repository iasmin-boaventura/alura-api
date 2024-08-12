package br.com.alura.screenmatch.projeto;

public class ErroCepInvalidoException extends RuntimeException {
    private String message;

    public ErroCepInvalidoException(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
