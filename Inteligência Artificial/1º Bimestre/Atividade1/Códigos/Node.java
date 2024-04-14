package Conjunto;

public class Node {
	char nome; //char que declara o nome do nó
	Node direita = null; // nó que está a direita do nó atual, iniciando em null
	Node esquerda = null; // nó que está a esquerda do nó atual, iniciando em null
	boolean visita = false; // boolean que declara se o nó foi visitado ou não, iniciando em false
}
