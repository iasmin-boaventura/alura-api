package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.projeto.excecoes.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.projeto.excecoes.SenhaInvalidaException;

public class Titulo implements Comparable<Titulo>{
    private String titulo;
    private int anoLancamento;
    private boolean incluidoPlano;
    private int duracaoEmMinutos = 0;
    private double somaAvaliacoes = 0;
    private int totalAvaliacoes = 0;

    public Titulo(String titulo, int anoLancamento) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public Titulo(TituloOMDb tituloOMDb) {
        setTitulo(tituloOMDb.title());
        if (tituloOMDb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano porque tem mais de 4 caracteres.");
        }
        setAnoLancamento(Integer.valueOf(tituloOMDb.year()));
        setDuracaoEmMinutos(Integer.valueOf(tituloOMDb.runtime().substring(0,2)));
    }

    public static void validaSenha(String senha) {
        if (senha.length() < 8){
            throw new SenhaInvalidaException("A senha deve ter, pelo menos, 8 caracteres.");
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public boolean isIncluidoPlano() {
        return incluidoPlano;
    }

    public void setIncluidoPlano(boolean incluidoPlano) {
        this.incluidoPlano = incluidoPlano;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public double getSomaAvaliacoes() {
        return somaAvaliacoes;
    }

    public int getTotalAvaliacoes() {
        return totalAvaliacoes;
    }

    public void exibeFichaTecnica() {
        System.out.println("Titulo: " + titulo);
        System.out.println("Ano: " + anoLancamento);
        System.out.println("Avaliação: " + pegaMedia());
    }

    public void avalia(double nota){
        somaAvaliacoes += nota;
        totalAvaliacoes++;
    }

    public double pegaMedia(){
        return somaAvaliacoes / totalAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getTitulo().compareTo(outroTitulo.getTitulo());
    }

    @Override
    public String toString() {
        return getTitulo() + " (" + getAnoLancamento() + ") - " + getDuracaoEmMinutos();
    }
}
