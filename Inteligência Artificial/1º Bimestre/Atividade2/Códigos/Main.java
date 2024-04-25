package CustoUniforme;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	private static Node raiz;
	static Queue<Node> fila = new PriorityQueue<>(); // fila principal
	static ArrayList<Node> teste = new ArrayList<>(); // fila que vai armazenar aqueles que forem retirados da fila principal
	static ArrayList<Node> nos = new ArrayList<>(); // guarda os nós que existem no grafo
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		Node s = new Node('s');
		
		Node a = new Node('a');
		
		Node b = new Node('b');
		
		Node c = new Node('c');
		
		Node g = new Node('g');
		
		s.addaresta(a,1); // diz que s tem uma aresta que o liga a 'a', com o valor de 1
		s.addaresta(b,5);
		s.addaresta(c,15);
		a.addaresta(g,10);
		b.addaresta(g,16);
		c.addaresta(g,10);
		
		nos.add(s);nos.add(a);nos.add(b);nos.add(c);nos.add(g); // adiciona todos os nós ao array de nós
		
		raiz = s; // a raiz inicial é s
		
		System.out.println("---------------------------- CUSTO UNIFORME ----------------------------");
		System.out.print("Grafo inserido: ");
		imprime(raiz);
		System.out.println();
		System.out.println("------------------------------------------------------------------------");
		
		System.out.print("Digite o nome para buscar no grafo: ");
		String nomebs = sc.next();
		Node procurado = null; // No que vai ser procurado
		boolean achou = false; // se encontrei um nó que tem o nome igual ao que foi digitado
		for (Node n: nos) {
			if (nomebs.charAt(0) == n.nome) { // conferindo se existe um nó com o mesmo nome
				procurado = n;
				achou = true;
				break;
			}
		}
		while (nomebs.length() != 1 || !achou) { // enquanto o tamanho da palavra for diferente de 1 (char) ou não existir um nó correspondente
			System.out.println("--------------------------------------------------------------------");
			System.out.print("Digite um nome válido: ");
			nomebs = sc.next();
			for (Node n: nos) {
				if (nomebs.charAt(0) == n.nome) {
					procurado = n;
					achou = true;
					break;
				}
			}
		}
		
		System.out.println("--------------------------------------------------------------------");
		
		chamabusca(raiz,procurado); // chama a função que chama a busca
		
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Obrigado!");
		System.out.println("--------------------------------------------------------------------");
		
	}
	
	public Main () { // inicializando a árvore no construtor
		raiz = null;
	}
	
	public static void chamabusca (Node raiz, Node dest) {
		System.out.println("------------------------ HISTÓRICO DA FILA -------------------------");
		if (busca(raiz,dest)) {
			System.out.println();
			System.out.println("--------------------------------------------------------------------");
			System.out.println("\u001B[33mNó Encontrado!\u001B[0m");
		}
		else {
			System.out.println();
			System.out.println("\u001B[31mO nó não existe no grafo!\u001B[0m");
		}
		//busca(raiz,nome);
		System.out.println("--------------------------------------------------------------------");

		if (fila.isEmpty()) { // se a fila está vazia
			System.out.println("Não restou nada na fila!");
		}
		
		for (Node no : fila) { // imprime o que ainda está na fila, mesmo depois de finalizar
            System.out.println("Resta na fila: " + no.nome + ", com custo de : " + no.custo);
        }
		System.out.println("--------------------------------------------------------------------");
	}
	
	public static boolean busca(Node raiz, Node dest) {
		if (raiz == null) { // se a raiz inicial é vazia, retornamos falso
	        return false;
		}
		else {
			fila.offer(raiz); // a raiz é colocada na fila principal
		}
		
		while (!fila.isEmpty()) { // enquanto a fila não estiver vazia
			
			for (Node n: fila) { //imprime a fila
				System.out.print(n.nome + "(" + n.custo + ") ");
			}
			System.out.println();
			
			Node primeiro = fila.poll(); // o nó atual é retirado da fila e colocado na variável 'primeiro'
			teste.add(primeiro); // adicionamos 'primeiro' a fila teste 

			if (!fila.isEmpty()) {
				for (Node n: fila) { //imprime a fila
					System.out.print(n.nome + "(" + n.custo + ") ");
				}
				System.out.println();
			}
			System.out.println();

			if (primeiro.nome == dest.nome) { // se encontrei o nó procurado
				System.out.println("--------------------------------------------------------------------");
				System.out.println("Custo acumulado: " + dest.custoA); // mostro o custo mínimo
				System.out.print("Caminho percorrido: "); // mostro o caminho percorrido até aqui
				for (Node no: teste) { // exibo o nome dos nós que estão na fila 'teste'
					System.out.print(no.nome + " ");
				}
				return true; //retornamos verdadeiro para interromper
			}
			for (Aresta ligação: primeiro.ligações) { // percorrendo as arestas do nó atual
				int custoN = ligação.custo; // o custo novo será o custo do nó atual somado ao custo da aresta
				ligação.destino.custoA = ligação.custo + primeiro.custoA; // o custo acumulado recebe o custo da aresta mais o custo acumuçado do nó atual
				if (ligação.destino.custo == 0) { // se o custo do destino da aresta ainda é 0
					ligação.destino.custo = custoN; // o custo do destino da aresta recebe o custo novo
					fila.offer(ligação.destino); // adicionamos o destino a fila
				}
				else if (custoN < ligação.destino.custo) {
					ligação.destino.custo = custoN;
				}
			}
			
//			for (Aresta ligação: primeiro.ligações) { // serve para verificar se o custo atual de alguma ligação é menor que aquela que existe na fila
//				int custoN = ligação.custo; // o custo novo é o custo do nó atual somado ao custo da aresta
//				if (custoN < ligação.destino.custo) { // se esse novo custo for menor que o custo do destino
//					ligação.destino.custo = custoN; // o custo do destino é modificado pelo atual custo
//					//fila.offer(ligação.destino);
//				}
//			}
//			else {
//				if (!primeiro.filhos.isEmpty()) {
//					for (Node no : primeiro.filhos) {
//						no.custoA = no.custo + primeiro.custoA;
//					}
//					fila.addAll(primeiro.filhos);
//				}
//			}
		}

        return false;
    }
	
	public static void imprime (Node raiz) { //imprime as ligações dos nós
		if (raiz != null){
			System.out.printf ("%c " ,raiz.nome);
			for (Aresta ligação : raiz.ligações) {
	            imprime(ligação.destino);
	        }
		}
	}
}
