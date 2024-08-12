package br.com.alura.screenmatch.calculos;

public class FiltroRecomendacao {

    public void filtra(Classificavel classificavel){
        if (classificavel.getClassificacao() >= 4) {
            System.out.println("Muito bem recomendado!");
        } else {
            System.out.println("Já teve dias melhores!");
        }
    }
}
