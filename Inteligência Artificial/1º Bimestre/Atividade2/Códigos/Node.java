package CustoUniforme;

import java.util.ArrayList;

public class Node implements Comparable <Node>{ //implementa a interface Comparable
	char nome; //char que declara o nome do nó
	ArrayList <Aresta> ligações = new ArrayList<>();
	int custo = 0;
	int custoA = 0;
	Node noAnterior = null;
	
	
	public Node (char nome) {
		this.nome = nome;
	}
	
	public void addaresta (Node destino, int custo) {
		ligações.add(new Aresta (destino,custo));
	}

	@Override
	public int compareTo(Node o) { // * função para ordenar a fila (chamada automaticamente sempre que chamamos Node)
		return o.custo < this.custo ? 1: -1; //orienta a fila a ordenar em ordem crescente com base no campo custo.
	}
	
}

class Aresta {
	Node destino;
	int custo;
	
	Aresta (Node destino, int custo){
		this.destino = destino;
		this.custo = custo;
	}
}


// * o método utilizado não era previamente conhecido, assim, foi utilizado de um site para entender e aplicar a mesma
// Disponível em: <https://www.freecodecamp.org/portuguese/news/filas-de-prioridades-em-java-explicadas-e-com-exemplos/>. Acesso em: 24 de abr. de 2024.