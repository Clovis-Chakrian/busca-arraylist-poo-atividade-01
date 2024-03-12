/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atvarraylistpoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 *
 * @author sivolc05
 */
public class Banco {

    private ArrayList<Conta> contas;

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public Banco() {
        this.contas = new ArrayList<Conta>();
    }

    public void adicionarConta(String titular, double saldo) {
        Conta conta = new Conta(titular, saldo, this.retornaNumeroConta());
        contas.add(conta);
        System.out.println("Conta de número: " + conta.getNumeroConta() + " adicionada com sucesso!");
    }

    public void removerConta(Conta conta) {
        contas.remove(conta);
        System.out.println("Conta de número: " + conta.getNumeroConta() + " removida com sucesso!");
    }

    public void mostrarContas() {
        this.getContas().forEach(conta -> {
            conta.exibeConta();
        });
    }
    
    public Conta buscarContaPorNumero(String numeroConta) throws ContaNaoEncontradaException {
        Optional<Conta> contaEncontrada = this.getContas().stream().filter(conta -> conta.getNumeroConta().equals(numeroConta)).findFirst();
        if (contaEncontrada.isEmpty()) {
            throw new ContaNaoEncontradaException("Conta não encontrada!");
        }

        return contaEncontrada.get();
    }

    public Conta buscarConta(Conta conta) throws ContaNaoEncontradaException {
        Optional<Conta> contaEncontrada = this.getContas().stream().filter(contaAtual -> contaAtual.equals(conta)).findFirst();
        if (contaEncontrada.isEmpty()) {
            throw new ContaNaoEncontradaException("A conta selecionada não foi encontrada!");
        }

        return contaEncontrada.get();
    }

    private String retornaNumeroConta() {
        String numero = String.valueOf(contas.size() + 1);
        while (numero.length() < 4) {
            numero = "0" + numero;
        }

        return numero;
    }
}
