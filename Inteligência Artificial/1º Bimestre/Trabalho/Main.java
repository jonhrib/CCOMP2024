import java.util.List;

public class Main {
    public static void main(String args []) {
        Grafo grafo = new Grafo(); //cria-se o grafo

        // adicionamos os nós (pontos nas ruas) com suas coordenadas, retiradas do Maps, a um grafo
        grafo.adicionarNo(new No("1", -23.54950, -51.46963));
        grafo.adicionarNo(new No("2", -23.55220, -51.46940));
        grafo.adicionarNo(new No("3", -23.55194, -51.46921));
        grafo.adicionarNo(new No("4", -23.55173, -51.46904));
        grafo.adicionarNo(new No("5", -23.55154, -51.46893));
        grafo.adicionarNo(new No("6", -23.55143, -51.46884));
        grafo.adicionarNo(new No("7", -23.55130, -51.46872));
        grafo.adicionarNo(new No("8", -23.55122, -51.46863));
        grafo.adicionarNo(new No("9", -23.55114, -51.46857));
        grafo.adicionarNo(new No("10", -23.55102, -51.46845));
        grafo.adicionarNo(new No("11", -23.55088, -51.46835));
        grafo.adicionarNo(new No("12", -23.55078, -51.46826));
        grafo.adicionarNo(new No("13", -23.55067, -51.46817));
        grafo.adicionarNo(new No("14", -23.55054, -51.46810));
        grafo.adicionarNo(new No("15", -23.55044, -51.46803));
        grafo.adicionarNo(new No("16", -23.55034, -51.46796));
        grafo.adicionarNo(new No("17", -23.55022, -51.46791));
        grafo.adicionarNo(new No("18", -23.55010, -51.46785));
        grafo.adicionarNo(new No("19", -23.54999, -51.46779));
        grafo.adicionarNo(new No("20", -23.54987, -51.46775));
        grafo.adicionarNo(new No("21", -23.54974, -51.46770));
        grafo.adicionarNo(new No("22", -23.54961, -51.46765));
        grafo.adicionarNo(new No("23", -23.54949, -51.46760));
        grafo.adicionarNo(new No("24", -23.54936, -51.46755));
        grafo.adicionarNo(new No("25", -23.54924, -51.46752));
        grafo.adicionarNo(new No("26", -23.54911, -51.46749));
        grafo.adicionarNo(new No("27", -23.54898, -51.46745));
        grafo.adicionarNo(new No("28", -23.54884, -51.46742));
        grafo.adicionarNo(new No("29", -23.54871, -51.46739));
        grafo.adicionarNo(new No("30", -23.54857, -51.46737));
        grafo.adicionarNo(new No("31", -23.54844, -51.46734));
        grafo.adicionarNo(new No("32", -23.54831, -51.46732));
        grafo.adicionarNo(new No("33", -23.54818, -51.46729));
        grafo.adicionarNo(new No("34", -23.54804, -51.46727));
        grafo.adicionarNo(new No("35", -23.54790, -51.46726));
        grafo.adicionarNo(new No("36", -23.54776, -51.46724));
        grafo.adicionarNo(new No("37", -23.54763, -51.46722));
        grafo.adicionarNo(new No("38", -23.54749, -51.46721));
        grafo.adicionarNo(new No("39", -23.54735, -51.46719));
        grafo.adicionarNo(new No("40", -23.54721, -51.46718));
        grafo.adicionarNo(new No("41", -23.54706, -51.46716));
        grafo.adicionarNo(new No("42", -23.54692, -51.46715));
        grafo.adicionarNo(new No("43", -23.54678, -51.46714));
        grafo.adicionarNo(new No("44", -23.54664, -51.46713));
        grafo.adicionarNo(new No("45", -23.54650, -51.46712));
        grafo.adicionarNo(new No("46", -23.54636, -51.46711));
        grafo.adicionarNo(new No("47", -23.54622, -51.46711));
        grafo.adicionarNo(new No("48", -23.54608, -51.46710));
        grafo.adicionarNo(new No("49", -23.54594, -51.46709));
        grafo.adicionarNo(new No("50", -23.54579, -51.46708));
        grafo.adicionarNo(new No("51", -23.54565, -51.46708));
        grafo.adicionarNo(new No("52", -23.54551, -51.46707));
        grafo.adicionarNo(new No("53", -23.54537, -51.46707));
        grafo.adicionarNo(new No("54", -23.54523, -51.46706));
        grafo.adicionarNo(new No("55", -23.54509, -51.46706));
        grafo.adicionarNo(new No("56", -23.54494, -51.46705));
        grafo.adicionarNo(new No("57", -23.54480, -51.46705));
        grafo.adicionarNo(new No("58", -23.54466, -51.46704));
        grafo.adicionarNo(new No("59", -23.54452, -51.46704));
        grafo.adicionarNo(new No("60", -23.54438, -51.46703));
        grafo.adicionarNo(new No("61", -23.54424, -51.46703));
        grafo.adicionarNo(new No("62", -23.54410, -51.46702));
        grafo.adicionarNo(new No("63", -23.54396, -51.46702));
        grafo.adicionarNo(new No("64", -23.54382, -51.46701));
        grafo.adicionarNo(new No("65", -23.54382, -51.46701));
        grafo.adicionarNo(new No("66", -23.54382, -51.46701));
        grafo.adicionarNo(new No("67", -23.54382, -51.46701)); 

        // adicionamos as arestas, que representam as ligações entre os pontos (ruas), ao grafo, com pesos para cada situação:
        // peso 0.0 = rua recém reformada
        // peso 1.0 = rua e calçadas em boas condições
        // peso 5.0 = calçada com buracos, mas cadeirantes conseguem passar pela rua sem muitos perigos
        // peso 10.0 = calçada com buracos, rua perigosa, mas existe possibilidade de períodos menos perigosos, sem caminhões
        // peso 100.0 = calçada com buracos ou em condições péssimas, e cadeirantes não podem passar pela rua, visto o perigo, evitar ao máximo

        grafo.adicionarAresta("1", "2", 1.0);
        grafo.adicionarAresta("1", "6", 1.0);
        grafo.adicionarAresta("2", "1", 1.0);
        grafo.adicionarAresta("2", "3", 1.0);
        grafo.adicionarAresta("2", "7", 1.0);
        grafo.adicionarAresta("3", "2", 1.0);
        grafo.adicionarAresta("3", "8", 1.0);

        grafo.adicionarAresta("22", "23", 1.0);
        grafo.adicionarAresta("22", "24", 1.0);
        grafo.adicionarAresta("22", "31", 1.0);
        grafo.adicionarAresta("23", "14", 1.0);
        grafo.adicionarAresta("23", "24", 1.0);
        grafo.adicionarAresta("23", "22", 10.0);
        grafo.adicionarAresta("24", "22", 1.0);
        grafo.adicionarAresta("24", "23", 1.0);
        grafo.adicionarAresta("24", "25", 1.0);
        grafo.adicionarAresta("24", "32", 1.0);

        grafo.adicionarAresta("31", "22", 1.0);
        grafo.adicionarAresta("31", "30", 1.0);
        grafo.adicionarAresta("31", "42", 1.0);
        grafo.adicionarAresta("32", "24", 1.0);
        grafo.adicionarAresta("32", "33", 1.0);
        grafo.adicionarAresta("32", "44", 1.0);

        grafo.adicionarAresta("42", "31", 1.0);
        grafo.adicionarAresta("42", "41", 1.0);
        grafo.adicionarAresta("42", "43", 1.0);
        grafo.adicionarAresta("42", "44", 1.0);

        grafo.adicionarAresta("44", "32", 1.0);
        grafo.adicionarAresta("44", "42", 1.0);
        grafo.adicionarAresta("44", "43", 1.0);
        grafo.adicionarAresta("44", "45", 1.0);

        // encontramos, aqui, o melhor caminho do ponto inicial até o ponto final
        String pontoInicial = "23";
        String pontoFinal = "42";
        List<No> caminho = Estrelinha.melhorCaminho(grafo, pontoInicial, pontoFinal);

        if (caminho != null) {
            System.out.println("-----------------------------------------------------------------");
            System.out.println("O melhor caminho para chegar do ponto " + pontoInicial + " até o ponto " + pontoFinal + " é: ");
            for (No no : caminho) {
                System.out.print(no.getNome() + " ");
            }

            System.out.println();
            System.out.println("-----------------------------------------------------------------");
        } 

        else { // se não existe um caminho que ligue os pontos
            System.out.println("Caminho não encontrado, tente outros pontos!");
        }
    }
}
