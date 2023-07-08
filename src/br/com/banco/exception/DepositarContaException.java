package br.com.banco.exception;

public class DepositarContaException extends Exception{
    public DepositarContaException(){
        super("Saldo insuficiente, Verifiquei seu saldo! ");
    }
}
