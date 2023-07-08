package br.com.banco.interno;

public class Transferencia extends Transacao{

    public Transferencia(int idBanco) {
        super(idBanco);
    }
    public final boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta contaOrigem = this.localizarConta(numeroContaOrigem);
        Conta contaDestino = this.localizarConta(numeroContaDestino);

        if (contaOrigem == null || contaDestino == null) {
            return false;
        }

        if (contaOrigem.sacar(valor)) {
            return contaDestino.depositar(valor);
        }

        return false;

    }
}
