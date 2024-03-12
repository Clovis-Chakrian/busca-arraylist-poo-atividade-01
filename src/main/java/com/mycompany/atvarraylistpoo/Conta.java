/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.atvarraylistpoo;

import java.util.UUID;

/**
 *
 * @author sivolc05
 */
public class Conta {

    private String numeroConta;
    private String nomeTitular;
    private double saldo;

    public Conta() {
    }

    public Conta(String nomeTitular, double saldo, String numeroConta) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = saldo;
    }

    public Conta(String numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Conta)) {
            return false;
        }

        if (this == o) {
            return true;
        }

        Conta conta = (Conta) o;
        return this.getNomeTitular().equals(conta.getNomeTitular()) && this.getNumeroConta().equals(conta.getNumeroConta());
    }

    public void sacar(double valor) throws Exception {
        if (valor <= 0) {
            throw new Exception("Não é possível sacar um valor nulo ou negativo");
        }

        if (valor > this.saldo) {
            throw new Exception("Não é possível sacar um valor maior do que o existente na conta");
        }

        this.saldo -= valor;
    }

    public void exibeConta() {
        System.out.println("\n-----------------------------------------");
        System.out.println("Titular da conta: " + this.getNomeTitular());
        System.out.println("Número da conta: " + this.getNumeroConta());
        System.out.println("Saldo atual: " + this.getSaldo());
        System.out.println("-----------------------------------------\n");
    }
}
