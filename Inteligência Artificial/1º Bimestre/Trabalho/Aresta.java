public class Aresta {
    private No destino; // no que a aresta se destina
    private double peso; // peso que colocaremos nesta aresta, para as ruas com dificuldades

    public Aresta(No destino, double peso) { //construtor que recebe o destino e o peso
        this.destino = destino;
        this.peso = peso;
    }

    public No getDestino() {
        return destino;
    }

    public double getPeso() {
        return peso;
    }
}
