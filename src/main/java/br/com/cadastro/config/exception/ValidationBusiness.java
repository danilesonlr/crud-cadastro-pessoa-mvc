package br.com.cadastro.config.exception;

public class ValidationBusiness extends RuntimeException{

    public ValidationBusiness(String mensagem) {
        super(mensagem);
    }

    public ValidationBusiness(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
