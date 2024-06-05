import java.util.ArrayList;
import java.util.List;

public class No {
    private String nome;
    private double x; //cordenada x
    private double y; //coordenada y
    private List<Aresta> arestas; //lista das arestas que esse nó possui

    public No (String nome, double x, double y) { //construtor do nó, com nome e as coordenadas
        this.nome = nome;
        this.x = x;
        this.y = y;
        this.arestas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void adicionaAresta(Aresta aresta) {
        arestas.add(aresta);
    }
}
