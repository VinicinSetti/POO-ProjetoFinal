package br.com.banco.interno;

public class Saque extends Transacao {
    Caixa caixa = new Caixa();
    int conta;
    int caixaBanco = 0;
    int banco;
    double valor;
    public Saque(int conta, double valor, int banco) {
        super(banco);
        this.conta = conta;
        this.valor = valor;
        this.banco = banco;
    }


    @Override
    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        return false;
    }

    public final boolean saqueCaixa(int sacador) {
        Conta contaOrigem = this.localizarConta(sacador);
        caixa.localizarBanco(banco);
        if (localizarConta(sacador).idBanco != caixa.localizarBanco(caixaBanco).idBanco) {
            if (contaOrigem == null || caixa.localizarBanco(caixaBanco) == null) {
                return false;
            }
            contaOrigem.sacar(valor);
        }
        return false;
    }
}

