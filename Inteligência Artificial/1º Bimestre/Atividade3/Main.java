package Arquivos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Double> IGs = new ArrayList<>();
        List<String> NomesClasse = new ArrayList<>();

        //Atributos de outlook
        Atributo sunny = new Atributo (true);
        sunny.adicionarValor(true);
        sunny.adicionarValor(false);
        sunny.adicionarValor(false);
        sunny.adicionarValor(false);

        Atributo overcast = new Atributo (true);
        overcast.adicionarValor(true);
        overcast.adicionarValor(true);
        overcast.adicionarValor(true);

        Atributo rainy = new Atributo (true);
        rainy.adicionarValor(true);
        rainy.adicionarValor(true);
        rainy.adicionarValor(false);
        rainy.adicionarValor(false);

        List<Atributo> outlook = new ArrayList<>();
        outlook.add(sunny);
        outlook.add(overcast);
        outlook.add(rainy);
        
        //---------------------------------

        //Atributos de temperature
        Atributo hot = new Atributo (true);
        hot.adicionarValor(true);
        hot.adicionarValor(false);
        hot.adicionarValor(false);

        Atributo mild = new Atributo (true);
        mild.adicionarValor(true);
        mild.adicionarValor(true);
        mild.adicionarValor(true);
        mild.adicionarValor(false);
        mild.adicionarValor(false);

        Atributo cool = new Atributo (true);
        cool.adicionarValor(true);
        cool.adicionarValor(true);
        cool.adicionarValor(false);

        List<Atributo> temperature = new ArrayList<>();
        temperature.add(hot);
        temperature.add(mild);
        temperature.add(cool);

        //---------------------------------

        //Atributos de humidity
        Atributo high = new Atributo (true);
        high.adicionarValor(true);
        high.adicionarValor(true);
        high.adicionarValor(false);
        high.adicionarValor(false);
        high.adicionarValor(false);
        high.adicionarValor(false);

        Atributo normal = new Atributo (true);
        normal.adicionarValor(true);
        normal.adicionarValor(true);
        normal.adicionarValor(true);
        normal.adicionarValor(true);
        normal.adicionarValor(true);
        normal.adicionarValor(false);

        List<Atributo> humidity = new ArrayList<>();
        humidity.add(high);
        humidity.add(normal);

        //---------------------------------

        //Atributos de windy
        Atributo falsee = new Atributo (true);
        falsee.adicionarValor(true);
        falsee.adicionarValor(true);
        falsee.adicionarValor(true);
        falsee.adicionarValor(true);
        falsee.adicionarValor(true);
        falsee.adicionarValor(false);
        falsee.adicionarValor(false);

        Atributo truee = new Atributo (true);
        truee.adicionarValor(true);
        truee.adicionarValor(true);
        truee.adicionarValor(false);
        truee.adicionarValor(false);
        truee.adicionarValor(false);

        List<Atributo> windy = new ArrayList<>();
        windy.add(falsee);
        windy.add(truee);

        //---------------------------------

        //impressões
        System.out.println("-------------------------------------------------");
        for (Atributo atributo : outlook) {
            ArrayList<Boolean> valores = atributo.getValores();
            System.out.print("Valores O: ");
            for (Boolean valor : valores) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        for (Atributo atributo : temperature) {
            ArrayList<Boolean> valores = atributo.getValores();
            System.out.print("Valores T: ");
            for (Boolean valor : valores) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        for (Atributo atributo : humidity) {
            ArrayList<Boolean> valores = atributo.getValores();
            System.out.print("Valores H: ");
            for (Boolean valor : valores) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------");
        for (Atributo atributo : windy) {
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

        for (Atributo atributo : outlook) {
            ArrayList<Boolean> valores = atributo.getValores();
            for (Boolean valor : valores) {
                if (valor) {
                    yes++;
                } else {
                    no++;
                }
            }
        }

        // Chamar a função entropiaGeral para calcular a entropia geral, passando o total de valores, a quantidade de yes e a qtd de no
        int total = yes + no;
        double eG = entropiaGeral(total, yes, no);
        System.out.println("Entropia Geral: " + eG);

        System.out.println();

        //impressões
        double eO = entropia(outlook);
        System.out.println("Entropia Outlook: " + eO);
        double gO = IG(eO,eG);
        System.out.println("Ganho de Informação Outlook: " + gO);

        System.out.println();

        double eT = entropia(temperature);
        System.out.println("Entropia Temperature: " + eT);
        double gT = IG(eT,eG);
        System.out.println("Ganho de Informação Temperature: " + gT);

        System.out.println();

        double eH = entropia(humidity);
        System.out.println("Entropia Humidity: " + eH);
        double gH = IG(eH,eG);
        System.out.println("Ganho de Informação Humidity: " + gH);

        System.out.println();

        double eW = entropia(windy);
        System.out.println("Entropia Windy: " + eW);
        double gW = IG(eW,eG);
        System.out.println("Ganho de Informação Windy: " + gW);

        NomesClasse.add("outlook");
        IGs.add(gO);
        NomesClasse.add("temperature");
        IGs.add(gT);
        NomesClasse.add("humidity");
        IGs.add(gH);
        NomesClasse.add("windy");
        IGs.add(gW);

        double maiorg = Double.MIN_VALUE;
        int indmaior = -1;

        for (int i = 0; i < IGs.size(); i++) {
            double ganho = IGs.get(i);
            if (ganho > maiorg) {
                maiorg = ganho;
                indmaior = i;
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("A raiz escolhida deve ser: " + NomesClasse.get(indmaior));
        System.out.println("-------------------------------------------------");

    }

    static double entropia(List<Atributo> atributos) {
        double entropiatotal = 0;
    
        int atributostotais = 0;
        for (Atributo atributo : atributos) { //soma todos os valores dos atributos, aqui 14
            atributostotais += atributo.getValores().size();
        }
    
        // calcula a entropia para cada atributo e soma elas
        for (Atributo atributo : atributos) {
            ArrayList<Boolean> valores = atributo.getValores();
            int total = valores.size();
            int totalTrue = 0;
    
            // conta o número de yes
            for (Boolean valor : valores) {
                if (valor) {
                    totalTrue++;
                }
            }
    
            // calculaa proporção de yes ou no
            double pTrue = (double) totalTrue / total;
            double pFalse = 1.0 - pTrue;
    
            // calcula a entropia mesmo
            double entropy = 0;
            if (pTrue != 0) { //se a proporção de yes for diferente de 0, se for igual não faz nada, logo, continua zero aqui
                entropy -= pTrue * (Math.log(pTrue) / Math.log(2)); //tem o menos no começo da fórmula
            }
            if (pFalse != 0) { //se a proporção de no for diferente de 0, se for igual não faz nada, logo, continua zero aqui
                entropy -= pFalse * (Math.log(pFalse) / Math.log(2)); //tem o menos no meio da fórmula, antes desse bloco
            }
    
            // soma a entropia de cada atributo multiplicado pelo total de valores dele dividido pela qauntidade total de valores
            entropiatotal += ((double) total / atributostotais) * entropy;
        }
    
        return entropiatotal;
    }

    static double entropiaGeral(int total, int yes, int no) {
        // calculando a proporção de yes e no
        double pTrue = (double) yes / total;
        double pFalse = (double) no / total;
    
        // calculando a entropia geral
        double entropia = 0;
        if (pTrue != 0) {
            entropia -= pTrue * (Math.log(pTrue) / Math.log(2));
        }
        if (pFalse != 0) {
            entropia -= pFalse * (Math.log(pFalse) / Math.log(2));
        }
    
        return entropia;
    }
    
    static double IG(double entropia, double entropiaGeral) {
        //double ganho = 0.940 - entropia;
        double ganho = entropiaGeral - entropia;
        return ganho;
    }
    
}