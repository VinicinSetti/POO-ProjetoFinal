package br.com.banco.interno;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Conta extends Banco {
    protected List<Movimentacao> movimentacoes;
    protected List<Cheque> cheques;
    protected List<Saque> saques;
    protected List<Transferencia> transferencias;
    protected double limite;
    protected double saldo;
    protected int numero;

    public Conta(double saldo, double limite, String nomeBanco, int idBanco) {
        super(nomeBanco, idBanco);
        Random gerador = new Random();
        int rand = gerador.nextInt(1000, 9999);
        for (int x = 0; x < contas.size(); x++) {
            if (contas.get(x).numero != rand) {
                this.numero = rand;
            }
        }
        this.saldo = saldo;
        this.movimentacoes = new LinkedList<Movimentacao>();
        this.saques = new LinkedList<Saque>();
        this.cheques = new LinkedList<Cheque>();
        this.transferencias = new LinkedList<Transferencia>();
    }


    public boolean depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            this.criarMovimentacao("deposito", valor);
            return true;
        }
        return false;
    }

    public boolean sacar(double valor) {
        if (valor <= this.saldo + this.limite) {
            this.saldo -= valor;
            this.criarMovimentacao("saque", valor * -1);
            return true;
        }
        return false;
    }

    private void criarMovimentacao(String descricao, double valor) {
        for (int x = 0; x <= this.movimentacoes.size(); x++) {
            if (this.movimentacoes.get(x) == null) {
                Movimentacao moni = new Conta.Movimentacao(descricao, valor);
                movimentacoes.add(moni);
                break;
            }
        }
    }


    private class Movimentacao {
        private String descricao;
        private double valor;

        public Movimentacao(String descricao, double valor) {
            this.descricao = descricao;
            this.valor = valor;
        }

        public String resumo() {
            return this.descricao + " R$ " + this.valor;
        }

    }
}
