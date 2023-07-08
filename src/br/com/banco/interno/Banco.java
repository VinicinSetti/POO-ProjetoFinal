package br.com.banco.interno;

import br.com.banco.exception.DepositarContaException;
import br.com.banco.exception.IdBancoInvalidoException;

import java.util.LinkedList;
import java.util.List;

public class Banco {
    protected int idBanco;
    protected String nomeBanco;
    protected List<Conta> contas;
    public Banco(String nomeBanco, int idBanco) {
        this.idBanco = idBanco;
        this.nomeBanco = nomeBanco;
        this.contas = new LinkedList<>();
    }

    public Banco(int idBanco) {
        this.idBanco = idBanco;
    }


    public void novaConta(Conta conta) {
        contas.add(conta);
    }

    public boolean depositarConta(int numero, double valor) throws DepositarContaException {
        if (this.localizarConta(numero) != null) {
            throw new DepositarContaException();
        }
        return contas.get(numero).depositar(valor);
    }

    public boolean sacar(int numero, double valor) {
        if (this.localizarConta(numero) != null) {
            return false;
        }
        return contas.get(numero).sacar(valor);
    }

    public boolean transferir(int numeroContaOrigem, int numeroContaDestino, double valor) {
        return false;
    }

    public Conta localizarConta(int numero) {
        return contas.get(numero);
    }
    public List<String> listConta(){
        List<String> listaConta = new LinkedList<>();
        for (int x = 0; x<contas.size(); x++){
            listaConta.add("ID " + x + " " + contas.get(x).nomeBanco + " " + contas.get(x).numero);
        }
        return listaConta;
    }


}
