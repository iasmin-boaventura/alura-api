package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Episodio implements Classificavel {
    private String nome;
    private int numero;
    private int quantidadeVisualizacoes;
    private Serie serie;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public int getClassificacao() {
        if (getQuantidadeVisualizacoes() > 100){
            return 5;
        } else {
            return 3;
        }
    }

    public int getQuantidadeVisualizacoes() {
        return quantidadeVisualizacoes;
    }

    public void setQuantidadeVisualizacoes(int quantidadeVisualizacoes) {
        this.quantidadeVisualizacoes = quantidadeVisualizacoes;
    }


}
