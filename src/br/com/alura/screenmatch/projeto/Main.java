package br.com.alura.screenmatch.projeto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Requisicoes api = new Requisicoes();
        Scanner sc = new Scanner(System.in);
        String cep;

        System.out.print("Digite o cep para realizar a consulta: ");
        cep = sc.nextLine();
        cep = api.formataCep(cep);

        try {
            System.out.println(api.fazRequisicao(cep));

        } catch (ErroCepInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
