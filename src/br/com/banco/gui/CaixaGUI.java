package br.com.banco.gui;

import br.com.banco.exception.DepositarContaException;
import br.com.banco.interno.Banco;
import br.com.banco.interno.Caixa;
import br.com.banco.interno.Conta;
import br.com.banco.interno.Saque;

import java.util.List;
import java.util.Scanner;

public class CaixaGUI {

    Caixa caixas = new Caixa();
    Banco bancos;
    Conta contas;

    public CaixaGUI(Banco banco) {
        this.bancos = banco;
    }

    public String lerValor(String rotulo) {
        System.out.print(rotulo + ": ");
        Scanner leitura = new Scanner(System.in);
        return leitura.nextLine();
    }

    public void iniciarAtendimento() {
        try {
            int opcao;
            do {
                System.out.println("Caixa Eletronica");
                System.out.println("Opções:");
                System.out.println("[1] Depositar");
                System.out.println("[2] Sacar");
                System.out.println("[3] Transferir");
                System.out.println("[4] Criar Conta");
                System.out.println("[6] Lista de bancos");
                System.out.println("[7] Lista de contas");
                opcao = Integer.parseInt(this.lerValor("Digite uma opcao"));
                switch (opcao) {
                    case 0 -> this.preset();
                    case 1 -> this.depositar();
                    case 2 -> this.sacar();
                    case 3 -> this.transferir();
                    case 4 -> this.criarConta();
                    case 6 -> this.listaBanco();
                    case 7 -> this.listaConta();
                    //case 5 -> this.cadastrarBanco();
                }
            } while (opcao != 8);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private void transferir() {
    }

    private void sacar() {
        int idBanco = Integer.parseInt(this.lerValor("Digite o ID do banco"));
        int idConta = Integer.parseInt(this.lerValor("Digite o  ID conta"));
        int numero = Integer.parseInt(this.lerValor("informe o numero da conta"));
        double valor = Double.parseDouble(this.lerValor("Digite o valor do saque"));
        Saque saque = new Saque(numero,valor,idBanco);
        if (!saque.saqueCaixa(idConta)){
            System.out.println("Não foi possível realizar o saque");
        } else {
            System.out.println("Tudo ok, saque realizado");
        }
    }

    private void depositar() {
        listaConta();
        int numero = Integer.parseInt(this.lerValor("informe o numero da conta"));
        double valor = Double.parseDouble(this.lerValor("Digite o valor do saque"));
        try {
            if (!this.bancos.depositarConta(numero, valor)){
                System.out.println("Não foi possível realizar o deposito");
            } else {
                System.out.println("Desposito foi um suceso");
            }
        } catch (DepositarContaException e) {
            throw new RuntimeException(e);
        }
    }

    private void criarConta() {
        try {
            int id = Integer.parseInt(this.lerValor("Digite o número de identificação: "));
            String nome = caixas.nomeBanco(id);
            double limite = Double.parseDouble(lerValor("Digite o limete: "));
            double saldo = Double.parseDouble(lerValor("Digite o saldo inicial"));
            Conta novaConta = new Conta(saldo, limite, nome, id);
            caixas.criarConta(novaConta);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void listaBanco() {
        List<String> lista = caixas.listaBanco();
        for (String banco : lista) {
            System.out.println(banco);
        }
    }

    public void listaConta() {
        System.out.println("______Lista de Conta______");
        List<String> lista = caixas.listaConta();
        for (String conta : lista) {
            System.out.println(conta);
        }
    }

    private void preset() {
        try {
            Banco novoBanco = new Banco("Nubank", 1);
            this.caixas.criarBanco(novoBanco);
            novoBanco = new Banco("Itau", 2);
            this.caixas.criarBanco(novoBanco);
            novoBanco = new Banco("Inter", 3);
            this.caixas.criarBanco(novoBanco);


            Conta novaConta = new Conta(1000, 100, caixas.nomeBanco(1), 1);
            this.caixas.criarConta(novaConta);
            novaConta = new Conta(2000, 0, caixas.nomeBanco(1), 1);
            this.caixas.criarConta(novaConta);
            novaConta = new Conta(1000, 100, caixas.nomeBanco(1), 1);
            this.caixas.criarConta(novaConta);
            novaConta = new Conta(1500, 1000, caixas.nomeBanco(2), 2);
            this.caixas.criarConta(novaConta);
            novaConta = new Conta(50, 100, caixas.nomeBanco(3), 3);
            this.caixas.criarConta(novaConta);
            novaConta = new Conta(100000, 10000, caixas.nomeBanco(2), 2);
            this.caixas.criarConta(novaConta);


        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

}