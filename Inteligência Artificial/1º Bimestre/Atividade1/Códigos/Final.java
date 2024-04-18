package Conjunto;
import java.util.Scanner;

import Conjunto.Node;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Final {
	private static Node raiz; //nó inicial
	private static ArrayList<Character> visitados = new ArrayList<>(); //array list do tipo char
	private static ArrayList<Character> acessados = new ArrayList<>();	//array list do tipo char
	
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		
		Node a = new Node(); //cria-se o nó a
		a.nome = 'a'; // o nome do nó a é setado como 'a'
		Node b = new Node(); //todos os casos de criação são iguais
		b.nome = 'b';
		Node c = new Node();
		c.nome = 'c';
		Node d = new Node();
		d.nome = 'd';
		Node e = new Node();
		e.nome = 'e';
		Node f = new Node();
		f.nome = 'f';
		Node g = new Node();
		g.nome = 'g';
		Node h = new Node();
		h.nome = 'h';
		Node i = new Node();
		i.nome = 'i';
		Node j = new Node();
		j.nome = 'j';
		Node k = new Node();
		k.nome = 'k';
		Node l = new Node();
		l.nome = 'l';
		Node m = new Node();
		m.nome = 'm';
		Node n = new Node();
		n.nome = 'n';
		Node o = new Node();
		o.nome = 'o';
		
		a.esquerda = b; //a "aponta", em sua esquerda, para b
		a.direita = c; // a "aponta", em sua direita, para c
		b.esquerda = d; //...
		b.direita = e;
		c.esquerda = f;
		c.direita = m;
		d.esquerda = g;
		d.direita = h;
		e.esquerda = i;
		e.direita = j;
		f.esquerda = k;
		f.direita = l;
		m.esquerda = n;
		m.direita = o;
		
		raiz = a; //raiz recebe a, indicando que é o nó inicial do grafo
		
		
		System.out.println("------------------------------ MÉTODOS DE BUSCA -----------------------------"); //impressão de título
		System.out.print("         Grafo inserido, em pré ordem: "); //impressão de título
		imprime(raiz);
		System.out.println();
		
		int x = 1;
		while (x < 3 && x > 0) { //vai repetir o menu até que seja pressionado o número 3
			System.out.println("-----------------------------------------------------------------------------"); //impressão de título
			System.out.println("|1 - BUSCA POR PROFUNDIDADE                                                 |");//impressão de título
			System.out.println("|2 - BUSCA EM LARGURA                                                       |");
			System.out.println("|3 - SAIR                                                                   |");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println ("Opção escolhida: " + (x = s.nextInt()));
			System.out.println("-----------------------------------------------------------------------------");
			switch (x) {
				case 1: // se a opção escolhida foi a busca em profundidade
					acessados.clear(); //limpamos os arrays list para evitar que estejam com dados antigos
					visitados.clear();
					
					System.out.print("Digite o nome para buscar no grafo: ");
					
					String nomebs = s.next();
					while (nomebs.length() != 1) { //conferindo se o nome é um char
						System.out.println("-----------------------------------------------------------------------------");
						System.out.print("Digite um nome válido: ");
						nomebs = s.next();
					}
					char nomeb = nomebs.charAt(0);
					System.out.println("-----------------------------------------------------------------------------");
					
					chamabusca(raiz, nomeb, 1); //chamamos a função que irá chamar a busca em questão, com o código 1, referente a busca em profundidade
					int es;
					
					do { // para buscar, ou não, outro nome
						System.out.println("Deseja buscar outro nome? 1 - SIM | 2 - NÃO");
						es = s.nextInt();
						if (es == 1) {
							acessados.clear();
							visitados.clear();
							System.out.print("Digite o nome para buscar no grafo: ");
							nomebs = s.next();
							while (nomebs.length() != 1) {
								System.out.println("-----------------------------------------------------------------------------");
								System.out.print("Digite um nome válido: ");
								nomebs = s.next();
							}
							nomeb = nomebs.charAt(0);
							System.out.println("-----------------------------------------------------------------------------");
							chamabusca (raiz, nomeb, 1);
						}
						else if (es != 1 && es != 2){
							System.out.println("\u001B[31mEscolha incorreta\u001B[0m");
							System.out.println("-----------------------------------------------------------------------------");
						}
					} while (es != 2);
					
				break;
				case 2: //se a opção escolhida for a busca em largura
					acessados.clear(); //limpamos os arrays list para evitar que estejam com dados antigos
					visitados.clear();
					
					System.out.print("Digite o nome para buscar no grafo: ");
					
					nomebs = s.next();
					while (nomebs.length() != 1) {
						System.out.println("-----------------------------------------------------------------------------");
						System.out.print("Digite um nome válido: ");
						nomebs = s.next();
					}
					nomeb = nomebs.charAt(0);
					System.out.println("-----------------------------------------------------------------------------");
					
					chamabusca(raiz, nomeb, 2); //chamamos a função que irá chamar a busca em questão, com o código 2, referente a busca em largura
					
					do { //se desejar, ou não, buscar outro nome
						System.out.println("Deseja buscar outro nome? 1 - SIM | 2 - NÃO");
						es = s.nextInt();
						if (es == 1) {
							acessados.clear();
							visitados.clear();
							System.out.print("Digite o nome para buscar no grafo: ");
							nomebs = s.next();
							while (nomebs.length() != 1) {
								System.out.println("-----------------------------------------------------------------------------");
								System.out.print("Digite um nome válido: ");
								nomebs = s.next();
							}
							nomeb = nomebs.charAt(0);
							System.out.println("-----------------------------------------------------------------------------");
							chamabusca (raiz, nomeb, 2);
						}
						else if (es != 1 && es != 2){
							System.out.println("\u001B[31mEscolha incorreta\u001B[0m");
							System.out.println("-----------------------------------------------------------------------------");
						}
					} while (es != 2);
				break;
				case 3:
					System.out.println("-----------------------------------------------------------------------------"); //título impresso ao final do programa
					System.out.println("             Obrigado por utilizar... Finalizando aplicação!");
					System.out.println("-----------------------------------------------------------------------------");
				break;
				default:
					System.out.println("\u001B[31mEscolha incorreta... Finalizando aplicação\u001B[0m");
					System.out.println("-----------------------------------------------------------------------------");
				break;
			}
		}
		
	}
	
	public Final () { //inicializando a árvore no construtor
		raiz = null;
	}
	
	public static void chamabusca (Node raiz, char nome, int cod) { //método que chama a função busca, somente existe para "desacumular" a main

		if (busca(raiz,nome,cod)) { // se busca retornou true, o nó foi encontrado
			System.out.println("\u001B[33mNó Encontrado!\u001B[0m");
		}
		else { // se a busca retornou false, o nó não foi encontrado
			System.out.println("\u001B[31mO nó não existe no grafo!\u001B[0m");
		}
		System.out.println("-----------------------------------------------------------------------------");
		
		System.out.print ("Nós Visitados: "); //mostra os nós visitados
		
		for (char no : visitados) {
			System.out.print(no + " ");
		}
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
		
		System.out.print("Nós Acessados: "); //mostra os nós acessados
		for (char no : acessados) {
			System.out.print(no + " ");
		}
		
		System.out.println();
		System.out.println("-----------------------------------------------------------------------------");
	}
	
	public static boolean busca(Node raiz, char nome, int cod) { //método de busca
		
		if (cod == 1) { //busca em profundidade
			
			if (raiz == null) {
		        return false; // se o início for nulo, não buscamos
		    }
			
			acessados.add(raiz.nome); //adiciona o nó em que estamos no array list acessados
			
			if (nome == raiz.nome) { // se o nome que procuramos for igual ao nome do nó atual
		        visitados.add(raiz.nome); //visitamos o nó atual
		        return true; //retornamos true, parando a função
		    }
			
			// se já encontrarmos o nó na subárvore esquerda ou na subárvore direita, retornamos true, entendendo que já foi encontrado o nó
			if (busca(raiz.esquerda, nome,1) || busca(raiz.direita, nome,1)) { //evita que busquemos, por exemplo, na direita, quando já foi encontrado na esquerda
		        return true;
		        //iniciamos a busca pela esquerda, se este retornar true, já enconrtramos, então paramos, se não, buscamos na direita
		    }
		    
		    if ((raiz.esquerda == null && raiz.direita == null) || (raiz.esquerda.visita && raiz.direita.visita)) { //se os nós filhos de um nó já foram visitados, ou este é um nó folha
				visitados.add(raiz.nome); //visitamos o nó
				raiz.visita = true; //declaramos que este foi visitado
			}
		}
		else if (cod == 2) { //busca em largura
			//fila A,B,C,D,E,F,M,G,H,I,J,K,L,N,O
			
			Queue<Node> filab = new LinkedList<Node>(); //uma fila de nós
	        filab.offer(raiz); // adicionando a raiz ao final da fila
	        
	        while (!filab.isEmpty()) { //enquanto a fila não está vazia
	            Node atual = filab.poll(); // removemos o primeiro nó da fila e colocamos no atual
	            acessados.add(atual.nome); 
	            visitados.add(atual.nome);
	            
	            if (nome == atual.nome) { //se o nome do nó atual é o que procuramos
	                //System.out.println("Encontrou!"); 
	                return true;
	               // break; //quando encontrar 
	            }
	            
	            if (atual.esquerda != null) { //adiciona o filho esquerdo ao final da fila
	                filab.offer(atual.esquerda);
	            }
	            
	            if (atual.direita != null) { //adiciona o filho direito ao final da fila
	                filab.offer(atual.direita);
	            }
	        }
		}
	    
	    return false;
	    
	}
	
	public static void imprime (Node raiz) { //impressão do grafo
		if (raiz != null){ //se a raiz não for nula
			System.out.printf ("%c " ,raiz.nome); //imprime-se o nome
			imprime (raiz.esquerda); //imprime-se os nomes da esquerda
			imprime (raiz.direita); //imprime-se os nomes da direita
		}
	}
}
