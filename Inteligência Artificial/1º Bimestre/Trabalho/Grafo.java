import java.util.HashMap;
import java.util.Map;

public class Grafo {
    Map<String, No> nos; //cria um map, com uma string associada a um nó //https://www.alura.com.br/artigos/iterando-por-um-hashmap-em-java?utm_term=&utm_campaign=%5BSearch%5D+%5BPerformance%5D+-+Dynamic+Search+Ads+-+Artigos+e+Conteúdos&utm_source=adwords&utm_medium=ppc&hsa_acc=7964138385&hsa_cam=11384329873&hsa_grp=111087461203&hsa_ad=687448474447&hsa_src=g&hsa_tgt=aud-409949667484:dsa-2276348409543&hsa_kw=&hsa_mt=&hsa_net=adwords&hsa_ver=3&gad_source=1&gclid=CjwKCAjwjeuyBhBuEiwAJ3vuoW_EWoq0hKMcjK-kwR24tBtvbH4i7ZeRFoHLkB2xWCLctzelBfuKPxoCLmAQAvD_BwE

    public Grafo() {
        this.nos = new HashMap<>(); //inicializa o map
    }

    public void adicionarNo(No no) { //adicionamos o nó, com a chave sendo seu nome
        nos.put(no.getNome(), no);
    }

    public No getNo(String nome) { //resgata o nó daquele nó
        return nos.get(nome);
    }

    public boolean procuraNo (String nome){
        return nos.containsKey(nome); //vai retornar se existe o nó ou não
    }

    public void adicionarAresta(String de, String para, double peso) { //método para adiconar as arestas
        No noDe = nos.get(de); // o nó origem
        No noPara = nos.get(para); // o nó destino
        if (noDe != null && noPara != null) { // se os dois nós existirem
            noDe.adicionarAresta(new Aresta(noPara, peso)); //criamos uma nova aresta no nó origem, com o destino sendo o nó 'para', com o peso dado
        }
    }
}
