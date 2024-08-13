package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.projeto.excecoes.SenhaInvalidaException;
import br.com.alura.screenmatch.modelos.Senha;

import java.util.Scanner;

public class ExerciciosAula3 {
    public static void main(String[] args) {
        ex2();
    }

    public static void ex1() {
        Scanner sc = new Scanner(System.in);
        int n1, n2;
        double divisao;

        System.out.print("n1: ");
        n1 = sc.nextInt();

        System.out.print("n2: ");
        n2 = sc.nextInt();

        try {
            divisao = n1 / n2;
            System.out.println(divisao);
        } catch (ArithmeticException e){
            System.out.println("Erro de divisão por zero.");
        }
    }

    public static void ex2() {
        Scanner sc = new Scanner(System.in);
        Senha senha = new Senha();
        try {
            System.out.print("Digite sua senha: ");
            senha.setSenha(sc.nextLine());
        } catch (SenhaInvalidaException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public static void ex3() {

    }
}
