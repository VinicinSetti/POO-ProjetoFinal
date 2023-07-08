package br.com.banco.interno;

public abstract class  Transacao extends Banco{
    public Transacao(int idBanco) {
        super(idBanco);
    }
    public abstract boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor);

}
