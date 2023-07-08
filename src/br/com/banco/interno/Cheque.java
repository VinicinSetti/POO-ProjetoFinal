package br.com.banco.interno;

public class Cheque extends Transacao{
    int valor;
    public Cheque(int idBanco) {
        super(idBanco);
    }

    @Override
    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        Conta contaOrigem = this.localizarConta(numeroContaOrigem);
        Conta contaDestino = this.localizarConta(numeroContaDestino);
        if (localizarConta(numeroContaOrigem).idBanco != localizarConta(numeroContaDestino).idBanco) {
            if (contaOrigem == null || contaDestino == null) {
                return false;
            }
            if (contaOrigem.sacar(valor)) {
                return contaDestino.depositar(valor);
            }
            return false;
        }
        return false;
    }
}
