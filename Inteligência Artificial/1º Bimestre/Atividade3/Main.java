package Arquivos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> IGs = new ArrayList<>(); //lista dos ganhos de informação
        List<String> NomesClasse = new ArrayList<>(); //lista dos nomes das classes (outlook, temperature, humidity e windy)

        //Atributos de outlook
        Atributo sunny = new Atributo (true); //cria um atributo sunny, que recebe true como o primeiro valor
        sunny.adicionarValor(true); //adiciona novo valor ao sunny
        sunny.adicionarValor(false); //adiciona novo valor ao sunny
        sunny.adicionarValor(false); //adiciona novo valor ao sunny
        sunny.adicionarValor(false); //adiciona novo valor ao sunny

        Atributo overcast = new Atributo (true); //cria um atributo overcast, que recebe true como o primeiro valor
        overcast.adicionarValor(true); //adiciona novo valor ao overcast
        overcast.adicionarValor(true); //adiciona novo valor ao overcast
        overcast.adicionarValor(true); //adiciona novo valor ao overcast

        Atributo rainy = new Atributo (true); //cria um atributo rainy, que recebe true como o primeiro valor
        rainy.adicionarValor(true); //adiciona novo valor ao rainy
        rainy.adicionarValor(true); //adiciona novo valor ao rainy
        rainy.adicionarValor(false); //adiciona novo valor ao rainy
        rainy.adicionarValor(false); //adiciona novo valor ao rainy

        List<Atributo> outlook = new ArrayList<>(); //cria uma lista outlook, que portará todos os atributos que fazem parte dele
        outlook.add(sunny); //adiciona sunny em outlook
        outlook.add(overcast); //adiciona overcast em outlook
        outlook.add(rainy); //adiciona rainy em outlook
        
        //---------------------------------

        //Atributos de temperature
        Atributo hot = new Atributo (true); //cria um atributo hot, que recebe true como o primeiro valor
        hot.adicionarValor(true);
        hot.adicionarValor(false);
        hot.adicionarValor(false);

        Atributo mild = new Atributo (true); //cria um atributo mild, que recebe true como o primeiro valor
        mild.adicionarValor(true);
        mild.adicionarValor(true);
        mild.adicionarValor(true);
        mild.adicionarValor(false);
        mild.adicionarValor(false);

        Atributo cool = new Atributo (true); //cria um atributo cool, que recebe true como o primeiro valor
        cool.adicionarValor(true);
        cool.adicionarValor(true);
        cool.adicionarValor(false);

        List<Atributo> temperature = new ArrayList<>(); //cria uma lista temperature, que portará todos os atributos que fazem parte dele
        temperature.add(hot);
        temperature.add(mild);
        temperature.add(cool);

        //---------------------------------

        //Atributos de humidity
        Atributo high = new Atributo (true); //cria um atributo high, que recebe true como o primeiro valor
        high.adicionarValor(true);
        high.adicionarValor(true);
        high.adicionarValor(false);
        high.adicionarValor(false);
        high.adicionarValor(false);
        high.adicionarValor(false);

        Atributo normal = new Atributo (true); //cria um atributo normal, que recebe true como o primeiro valor
        normal.adicionarValor(true);
        normal.adicionarValor(true);
        normal.adicionarValor(true);
        normal.adicionarValor(true);
        normal.adicionarValor(true);
        normal.adicionarValor(false);

        List<Atributo> humidity = new ArrayList<>(); //cria uma lista humidity, que portará todos os atributos que fazem parte dele
        humidity.add(high);
        humidity.add(normal);

        //---------------------------------

        //Atributos de windy
        Atributo falsee = new Atributo (true); //cria um atributo falsee, que recebe true como o primeiro valor
        falsee.adicionarValor(true);
        falsee.adicionarValor(true);
        falsee.adicionarValor(true);
        falsee.adicionarValor(true);
        falsee.adicionarValor(true);
        falsee.adicionarValor(false);
        falsee.adicionarValor(false);

        Atributo truee = new Atributo (true); //cria um atributo truee, que recebe true como o primeiro valor
        truee.adicionarValor(true);
        truee.adicionarValor(true);
        truee.adicionarValor(false);
        truee.adicionarValor(false);
        truee.adicionarValor(false);

        List<Atributo> windy = new ArrayList<>(); //cria uma lista windy, que portará todos os atributos que fazem parte dele
        windy.add(falsee);
        windy.add(truee);

        //---------------------------------

        //impressões
        System.out.println("-------------------------------------------------");
        System.out.println("\u001B[\u001B[33m Atividade de IA - Entropia e Ganho de Informação\u001B[0m");
        System.out.println("-------------------------------------------------");
        for (Atributo atributo : outlook) { //percorre todos os atributos de outlook
            ArrayList<Boolean> valores = atributo.getValores(); //coloca em um ArrayList, os valores do atributo, true e false
            System.out.print("Valores O: ");
            for (Boolean valor : valores) { //imprime os valores
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        for (Atributo atributo : temperature) { //percorre todos os atributos de temperature
            ArrayList<Boolean> valores = atributo.getValores();
            System.out.print("Valores T: ");
            for (Boolean valor : valores) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        for (Atributo atributo : humidity) { //percorre todos os atributos de humidity
            ArrayList<Boolean> valores = atributo.getValores();
            System.out.print("Valores H: ");
            for (Boolean valor : valores) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        for (Atributo atributo : windy) { //percorre todos os atributos de windy
            ArrayList<Boolean> valores = atributo.getValores();
            System.out.print("Valores W: ");
            for (Boolean valor : valores) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");

        //---------------------------------

        // conta o número total de instâncias, seja yes ou no
        int yes = 0;
        int no = 0;

        for (Atributo atributo : outlook) { //percorre todos os atributos de outlook
            ArrayList<Boolean> valores = atributo.getValores(); //armazena em uma lista os valores do atributo, false ou true
            for (Boolean valor : valores) {
                if (valor) { //se o valor for true (yes)
                    yes++;
                } else { //se o valor for false (no)
                    no++;
                }
            }
        }

        int total = yes + no; //a quantidade total de valores no atributo
        double eG = entropiaGeral(total, yes, no); // chama a função que calcula a entropia geral, passando o total de valores, a quantidade de yes e a qtd de no
        System.out.println("Entropia Geral: " + eG);

        System.out.println();

        //impressões
        double eO = entropia(outlook); //chama a função que calcula a entropia de outlook
        System.out.println("Entropia Outlook: " + eO);
        double gO = IG(eO,eG); //chama a função que calcula o ganho de informação de outlook
        System.out.println("Ganho de Informação Outlook: " + gO);

        System.out.println();

        double eT = entropia(temperature); //chama a função que calcula a entropia de temperature
        System.out.println("Entropia Temperature: " + eT);
        double gT = IG(eT,eG); //chama a função que calcula o ganho de informação de temperature
        System.out.println("Ganho de Informação Temperature: " + gT);

        System.out.println();

        double eH = entropia(humidity); //chama a função que calcula a entropia de humidity
        System.out.println("Entropia Humidity: " + eH);
        double gH = IG(eH,eG); //chama a função que calcula o ganho de informação de humidity
        System.out.println("Ganho de Informação Humidity: " + gH);

        System.out.println();

        double eW = entropia(windy); //chama a função que calcula a entropia de windy
        System.out.println("Entropia Windy: " + eW);
        double gW = IG(eW,eG); //chama a função que calcula o ganho de informação de windy
        System.out.println("Ganho de Informação Windy: " + gW);

        NomesClasse.add("outlook"); // adiciona outlook a lista de nomes de classes
        IGs.add(gO); //adiciona o ganho de informação de outlook na lista de ganhos da informação, na mesma posição do nome outlook
        NomesClasse.add("temperature"); // adiciona temperature a lista de nomes de classes
        IGs.add(gT); //adiciona o ganho de informação de temperature na lista de ganhos da informação, na mesma posição do nome temperature
        NomesClasse.add("humidity"); // adiciona humidity a lista de nomes de classes
        IGs.add(gH); //adiciona o ganho de informação de humidity na lista de ganhos da informação, na mesma posição do nome humidity
        NomesClasse.add("windy"); // adiciona windy a lista de nomes de classes
        IGs.add(gW); //adiciona o ganho de informação de windy na lista de ganhos da informação, na mesma posição do nome windy

        double maiorg = Double.MIN_VALUE; //maiorg recebe o menor valor double
        int indmaior = -1; //o índice inicia em -1

        for (int i = 0; i < IGs.size(); i++) { //percorre os ganhos de informação da lista
            double ganho = IGs.get(i); //ganho recebe cada ig
            if (ganho > maiorg) { //se o ganho atual for maior que o maior ganho até agora
                maiorg = ganho; //armazena-se o maior ganho
                indmaior = i; //armazenamos o índice do maior ganho
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("A raiz escolhida deve ser: \u001B[4m\u001B[35m" + NomesClasse.get(indmaior) + "\u001B[0m"); //imprime o nome na posição do maior ganho
        System.out.println("-------------------------------------------------");

    }

    static double entropia(List<Atributo> atributos) { //função que calcula a entropia de um conjunto de atributos
        double entropiatotal = 0; //entropia total do conjunto
    
        int valorestotais = 0; //quantidade de valores totais, de todos os atributos
        for (Atributo atributo : atributos) { //soma todos os valores dos atributos, aqui 14
            valorestotais += atributo.getValores().size();
        }
    
        // calcula a entropia para cada atributo e soma elas
        for (Atributo atributo : atributos) { //percorre todos os atributos
            ArrayList<Boolean> valores = atributo.getValores(); //uma lista recebe todos os valores do atributo
            int total = valores.size(); //total = a quantidade de valores neste atributo
            int totalTrue = 0; //quantidade de valores yes
    
            // conta o número de yes
            for (Boolean valor : valores) { //percorre os valores do atributo 
                if (valor) { //se o valor é verdadeiro, ou seja, yes
                    totalTrue++;
                }
            }
    
            // calculaa proporção de yes ou no
            double pTrue = (double) totalTrue / total; //proporção de yes
            double pFalse = 1.0 - pTrue; //proporção de no
    
            // calcula a entropia mesmo
            double e = 0;
            if (pTrue != 0) { //se a proporção de yes for diferente de 0, se for igual não faz nada, logo, continua zero aqui
                e -= pTrue * (Math.log(pTrue) / Math.log(2)); //tem o menos no começo da fórmula
            }
            if (pFalse != 0) { //se a proporção de no for diferente de 0, se for igual não faz nada, logo, continua zero aqui
                e -= pFalse * (Math.log(pFalse) / Math.log(2)); //tem o menos no meio da fórmula, antes desse bloco
            }
    
            // soma a entropia de cada atributo multiplicado pelo total de valores dele dividido pela qauntidade total de valores
            entropiatotal += ((double) total / valorestotais) * e; //a entropiatotal do conjunto (outlook) recebe as entropias dos atributos, somando-se
        }
    
        return entropiatotal; //retorna a entropia da classe
    }

    static double entropiaGeral(int total, int yes, int no) { //função que calcula a entropia geral de todas as classes
        // calculando a proporção de yes e no
        double pTrue = (double) yes / total; //calcula a proporção de yes
        double pFalse = (double) no / total; //calcula a proporção de no
    
        // calculando a entropia geral
        double entropia = 0;
        if (pTrue != 0) {
            entropia -= pTrue * (Math.log(pTrue) / Math.log(2)); //tem o menos no começo da fórmula
        }
        if (pFalse != 0) {
            entropia -= pFalse * (Math.log(pFalse) / Math.log(2)); //tem o menos no meio da fórmula, antes desse bloco
        }
    
        return entropia; //retorna a entropia da totalidade
    }
    
    static double IG(double entropia, double entropiaGeral) { //calcula o ganho de cada conjunto
        //double ganho = 0.940 - entropia;
        double ganho = entropiaGeral - entropia; // o ganho se baseia na entropiageral menos a entropia específica
        return ganho; //devolvemos o ganho para a chamada
    }
    
}