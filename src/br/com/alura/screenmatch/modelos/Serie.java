package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Serie extends Titulo implements Classificavel {
    private int temporadas;
    private boolean ativa;
    private int episodiosTemporada;
    private int minutoEpisodio;

    public Serie(String titulo, int anoLancamento) {
        super(titulo, anoLancamento);
    }

    public int getTemporadas() {

        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public int getEpisodiosTemporada() {
        return episodiosTemporada;
    }

    public void setEpisodiosTemporada(int episodiosTemporada) {
        this.episodiosTemporada = episodiosTemporada;
    }

    public int getMinutoEpisodio() {
        return minutoEpisodio;
    }

    public void setMinutoEpisodio(int minutoEpisodio) {
        this.minutoEpisodio = minutoEpisodio;
    }

    @Override
    public int getDuracaoEmMinutos(){
        return temporadas * episodiosTemporada * minutoEpisodio;
    }

    @Override
    public int getClassificacao() {
        if (temporadas > 3){
            return 4;
        } else {
            return 5;
        }
    }

    @Override
    public String toString() {
        return "Série: " + getTitulo();
    }
}
