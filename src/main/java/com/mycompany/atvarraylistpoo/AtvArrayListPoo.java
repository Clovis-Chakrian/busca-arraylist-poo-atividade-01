/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.atvarraylistpoo;

import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author sivolc05
 */
public class AtvArrayListPoo {

    public static Banco banco = new Banco();
    public static Scanner scan = new Scanner(System.in);
    public static boolean rodarPrograma = true;

    public static void main(String[] args) throws ContaNaoEncontradaException {
        while (rodarPrograma) {
            exibeMenu();
            System.out.print("Digite a opção ao lado: ");
            int opcao = scan.nextInt();
            try {
                tomaDecisao(opcao);
            } catch (ContaNaoEncontradaException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void exibeMenu() {
        System.out.println("Bem vindo! Selecione uma opção do programa: \n");
        System.out.println("1 - Adicionar Conta");
        System.out.println("2 - Mostrar Contas Armazenadas");
        System.out.println("3 - Procurar Conta pelo Número");
        System.out.println("4 - Procurar Conta por Número e Titular");
        System.out.println("5 - Sair do programa\n");
    }
    
    public static void tomaDecisao(int opcao) throws ContaNaoEncontradaException{
        switch (opcao) {
            case 1:
                adicionarConta();
                break;
            case 2:
                banco.mostrarContas();
                break;
            case 3:
                procurarConta(1);
                break;
            case 4:
                procurarConta(0);
                break;
            case 5:
                rodarPrograma = false;
                break;
            default:
                System.out.println("\nSelecione uma opção válida!!!\n");;
        }
    }

    public static void adicionarConta() {
        String nomeTitular;
        double saldo;
        Conta conta;
        
        System.out.println("\nPara adionar uma conta, preencha as informações solicitadas abaixo:\n");
        System.out.print("Nome do Titular: ");
        nomeTitular = scan.next();
        System.out.print("Depósito inicial: ");
        saldo = scan.nextDouble();

        banco.adicionarConta(nomeTitular, saldo);
        System.out.println("\nConta adicionada com sucesso! Veja os registros atualizados abaixo\n");
        banco.mostrarContas();
    }
    
    public static void procurarConta(int tipoBusca) throws ContaNaoEncontradaException {
        Conta contaEncontrada;
        switch (tipoBusca) {
            case 0:
                System.out.print("Digite o número da conta do titular está escrito no cartão: ");
                String numeroContaTitular = scan.next();
                System.out.print("Digite o nome do titular da conta como está escrito no cartão: ");
                String titular = scan.next();
                Conta conta = new Conta(numeroContaTitular, titular);
                contaEncontrada = banco.buscarConta(conta);
                break;

            case 1:
                System.out.print("Digite o número da conta do titular está escrito no cartão: ");
                String numeroConta = scan.next();
                contaEncontrada = banco.buscarContaPorNumero(numeroConta);
                break;
            default:
                System.out.print("Digite o número da conta do titular está escrito no cartão: ");
                String numero = scan.next();
                contaEncontrada = banco.buscarContaPorNumero(numero);
                break;
        }
        
        contaEncontrada.exibeConta();
    }


}
