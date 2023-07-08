package br.com.banco.interno;

import br.com.banco.exception.IdBancoInvalidoException;

import java.util.LinkedList;
import java.util.List;

public class Caixa {
    List<Banco> bancos;
    List<Conta> contas;

    public Caixa() {
        this.bancos = new LinkedList<Banco>();
        this.contas = new LinkedList<Conta>();
    }

    public void criarBanco(Banco novoBanco) {
        bancos.add(novoBanco);
    }

    public void criarConta(Conta conta) {
        contas.add(conta);
    }

    public List<String> listaBanco() {
        List<String> lista = new LinkedList<>();
        for (int x = 0; bancos.size() > x; x++) {
            lista.add("ID " + x + " " + bancos.get(x).nomeBanco);
        }
        return lista;
    }
    public List<String> listaConta() {
        List<String> lista = new LinkedList<>();
        for (int x = 0; contas.size() > x; x++) {
            lista.add("ID " + x + " " + contas.get(x).nomeBanco);
        }
        return lista;
    }

    public String nomeBanco(int id) throws IdBancoInvalidoException {
        for (int x = 0; bancos.size() > x; x++) {
            if (bancos.get(x).idBanco == id)
            return bancos.get(x).nomeBanco;
        }
        throw new IdBancoInvalidoException();
    }
    public Banco localizarBanco(int numero) {
        return bancos.get(numero);
    }

    public int verificarIdBanco(int idBanco) throws IdBancoInvalidoException {
        for (int x = 0; x < bancos.size(); x++) {
            Banco novoBanco = bancos.get(x);
            if (novoBanco != null && novoBanco.idBanco == bancos.get(x).idBanco) {
                return x;
            }
        }
        throw new IdBancoInvalidoException();
    }
}
