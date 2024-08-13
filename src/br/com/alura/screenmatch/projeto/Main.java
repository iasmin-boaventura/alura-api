package br.com.alura.screenmatch.projeto;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsultaCep api = new ConsultaCep();
        Scanner sc = new Scanner(System.in);
        GeraArquivo arquivos = new GeraArquivo();
        String cep;
        Endereco endereco;

        System.out.print("Digite o cep para realizar a consulta: ");
        cep = sc.nextLine();

        try {
            endereco = api.fazRequisicao(cep);
            System.out.println(endereco.toString());

            arquivos.salvaJson(endereco);
            System.out.println("Arquivo gerado com sucesso!");

        } catch (ErroCepInvalidoException | IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }

    }
}
