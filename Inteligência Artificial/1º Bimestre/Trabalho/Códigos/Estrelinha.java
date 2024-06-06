import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class Estrelinha {
    Scanner s = new Scanner(System.in);

    public static List<No> melhorCaminho (Grafo grafo, String inicial, String objetivofinal) { //função que encontra o melhor caminho, dado o grafo, o inicio e o final
        No inicio = grafo.getNo(inicial); //cria-se um nó interno, com as características do nó inicial
        No objetivo = grafo.getNo(objetivofinal); //cria-se um nó interno, com as características do nó objetivo

        // criamos dois mapas para armazenar g e f de cada nó
        // a chave é o nó, e seu elemento é o valor double, g e f
        Map<No, Double> g = new HashMap<>(); // g = armazena o custo do nó inicial até o nó corrente.
        Map<No, Double> f = new HashMap<>(); // f = armazena o custo total do nó inicial até o nó objetivo, passando pelo nó corrente. f = g + heurística.

        // inicializamos todos os nós com um valor infinito
        for (No no : grafo.nos.values()) { //todos os valores do grafo
            g.put(no, Double.POSITIVE_INFINITY); //coloca um valor muito alto para todos os nós
            f.put(no, Double.POSITIVE_INFINITY);
        }

        // inicializamos os valores para o nó inicial
        g.put(inicio, 0.0); //o custo para chegar até o nó inicial é zero //se a chave já existe ele sobreescreve
        f.put(inicio, heuristica(inicio, objetivo)); //o valor f é 0 + a heurística do nó inicial e objetivo

        // criamos uma fila de prioridade para nós que serão explorados, a lista aberta
        PriorityQueue<No> ListaAberta = new PriorityQueue<>(1,Comparator.comparingDouble(no -> f.get(no))); //nós que precisamos explorar ainda, colocando em prioridade os nós que tem o menor valor f  //https://www.alura.com.br/artigos/java-8-lambda-ou-method-reference-entenda-a-diferenca?utm_term=&utm_campaign=%5BSearch%5D+%5BPerformance%5D+-+Dynamic+Search+Ads+-+Artigos+e+Conteúdos&utm_source=adwords&utm_medium=ppc&hsa_acc=7964138385&hsa_cam=11384329873&hsa_grp=111087461203&hsa_ad=687448474447&hsa_src=g&hsa_tgt=aud-396128415587:dsa-2276348409543&hsa_kw=&hsa_mt=&hsa_net=adwords&hsa_ver=3&gad_source=1&gclid=CjwKCAjwjeuyBhBuEiwAJ3vuoVL5j_YcBJMnh5H4BTyaAo-I9NSx8aV8voqL_FDkDdg-YAD_ekBwQBoC-foQAvD_BwE //https://www.coffeeandtips.com/post/usando-comparator-comparing-para-ordenar-java-stream
        Set<No> ListaFechada = new HashSet<>(); //contém os nós que já exploramos //usamos hashset pq não precisamos de ordenação aqui, e é mais rápido

        // criamos outro map, para armazenar o antecessor de cada nó, para que seja possível reconstuir o caminho
        Map<No, No> antecessores = new HashMap<>(); //o map é de nó para nó

        ListaAberta.add(inicio); // adicionamos o nó inicial na lista aberta, para iniciar o processo

        while (!ListaAberta.isEmpty()) { //equanto tiver algo na lista
            No atual = ListaAberta.poll(); //atual recebe o primeiro nó da lista aberta, ou seja, o com o menor valor f (remove o nó assim que dá o poll)

            if (atual.equals(objetivo)) { //se o nó atual é igual ao ovbjetivo
                return caminho(antecessores, atual); //retornamos o caminho reconstruído desse nó
            }

            ListaFechada.add(atual); //adicionamos o nó na lista fechada, indicando que ele já foi explorado

            for (Aresta aresta : atual.getArestas()) { // visita todos os filhos desse nó, pelas arestas
                No filho = aresta.getDestino(); // filho recebe o nó destino da aresta
                if (ListaFechada.contains(filho)) { // se o filho já estiver na lista fechada
                    continue; // partimos para o próximo filho
                }

                double gaux = g.get(atual) + aresta.getPeso(); // calculamos o valor de g para o filho atual, que seria o g dele mais o custo para chegar, ou seja, o peso da aresta

                if (gaux < g.get(filho)) { // se o valor auxiliar calculado é menor que o g anterior do filho
                    antecessores.put(filho, atual); // adicionamos no registro de caminho esse nó
                    g.put(filho, gaux); //atualizamos o valor de g, no filho que estamos
                    f.put(filho, gaux + heuristica(filho, objetivo)); // atualizamos o valor de f, calculando com a heurística e somando ao valor de g

                    if (!ListaAberta.contains(filho)) { // se esse filho não estiver na lista aberta ainda 
                        ListaAberta.add(filho); // adicionamos ele, para que possamos verificar seus filhos
                    }
                }
            }
        }

        return null; // se, no processo de busca, não retornarmos o nó encontrado, quer dizer que o caminho não existe, portanto, retornamos null
    }

    private static double heuristica(No noAtual, No objetivo) { //calculamos a heurística com base na distância euclidiana
        double dx = noAtual.getX() - objetivo.getX();
        double dy = noAtual.getY() - objetivo.getY();
        //System.out.println(Math.sqrt((dx * dx) + (dy * dy)));
        return Math.sqrt((dx * dx) + (dy * dy));
    }    

    private static List<No> caminho(Map<No, No> antecessores, No atual) { //reconstrói o caminho do objetivo até o nó inicial, pelo map 'veioDe' e nó atual
        List<No> caminho = new ArrayList<>(); //adicionaremos o caminho numa lista de nós, ele virá ao contrário, do objetivo até o inicial
        
        while (atual != null) { //enquanto o caminho atual não está vazio ou ainda existe, ou seja, enquanto tem nó para adicionar
            caminho.add(atual); //adicionamos o nó atual ao caminho total
            atual = antecessores.get(atual); //atual recebe o seu antecessor, armazenado no map
        }

        Collections.reverse(caminho); //inverte a lista, para que tenhamos o caminho do inicio até o objetivo
        return caminho; //retorna o caminho corretinho
    }
}
