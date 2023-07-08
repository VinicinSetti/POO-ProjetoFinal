package br.com.banco.exception;

public class IdBancoInvalidoException extends Exception{
    public IdBancoInvalidoException(){
        super("ID do banco informado invalido");

    }
}
