package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
   private String diretor;

   public Filme(String titulo, int anoDeLancamento){
       super(titulo, anoDeLancamento);
   }

   public void setDiretor(String diretor) {
       this.diretor = diretor;
   }

   public String getDiretor() {
       return diretor;
   }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia();
    }

    @Override
    public String toString() {
        return "Filme: " + this.getTitulo() + " (" + this.getAnoLancamento() + ")";
    }
}
