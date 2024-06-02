import java.util.List;

public class Main {
    public static void main(String args []) {
        Grafo grafo = new Grafo(); //cria-se o grafo

    // adicionamos os nós (pontos nas ruas) com suas coordenadas, retiradas do Maps, a um grafo
    grafo.adicionarNo(new No("1", -23.54950, -51.45635));
	grafo.adicionarNo(new No("2", -23.55061, -51.45602));
	grafo.adicionarNo(new No("3", -23.55174, -51.45571));
	grafo.adicionarNo(new No("4", -23.54799, -51.45834));
	grafo.adicionarNo(new No("5", -23.54868, -51.45780));
	
	grafo.adicionarNo(new No("6", -23.54977, -51.45751));
	grafo.adicionarNo(new No("7", -23.55089, -51.45717));
	grafo.adicionarNo(new No("8", -23.55197, -51.45684));
	grafo.adicionarNo(new No("9", -23.55312, -51.45655));
	grafo.adicionarNo(new No("10", -23.55415, -51.45627));
	
	grafo.adicionarNo(new No("11", -23.54790, -51.45924));
	grafo.adicionarNo(new No("12", -23.54868, -51.45896));
	grafo.adicionarNo(new No("13", -23.55005, -51.45863));
	grafo.adicionarNo(new No("14", -23.55119, -51.45830));
	grafo.adicionarNo(new No("15", -23.55231, -51.45796));
	
	grafo.adicionarNo(new No("16", -23.55341, -51.45768));
	grafo.adicionarNo(new No("17", -23.55448, -51.45737));
	grafo.adicionarNo(new No("18", -23.54838, -51.46000));
	//grafo.adicionarNo(new No("19", -23.54950, -51.46963));
	grafo.adicionarNo(new No("20", -23.54922, -51.46012));
	
	grafo.adicionarNo(new No("21", -23.55031, -51.45978));
	grafo.adicionarNo(new No("22", -23.55120, -51.45957));
	grafo.adicionarNo(new No("23", -23.55143, -51.45922));
	grafo.adicionarNo(new No("24", -23.55177, -51.45940));
	grafo.adicionarNo(new No("25", -23.55258, -51.45912));
	
	grafo.adicionarNo(new No("26", -23.55368, -51.45880));
	grafo.adicionarNo(new No("27", -23.55477, -51.45850));
	grafo.adicionarNo(new No("28", -23.54788, -51.46097));
	grafo.adicionarNo(new No("29", -23.54949, -51.46122));
	grafo.adicionarNo(new No("30", -23.55060, -51.46091));
	
	grafo.adicionarNo(new No("31", -23.55133, -51.46071));
	grafo.adicionarNo(new No("32", -23.55213, -51.46042));
	grafo.adicionarNo(new No("33", -23.55285, -51.46024));
	grafo.adicionarNo(new No("34", -23.55393, -51.45995));
	//grafo.adicionarNo(new No("35", -23.54950, -51.46963));
	
	grafo.adicionarNo(new No("36", -23.55500, -51.45964));
	grafo.adicionarNo(new No("37", -23.55608, -51.45933));
	grafo.adicionarNo(new No("38", -23.54741, -51.46183));
	grafo.adicionarNo(new No("39", -23.54861, -51.46259));
	grafo.adicionarNo(new No("40", -23.54975, -51.46233));
	
	grafo.adicionarNo(new No("41", -23.55086, -51.46199));
	grafo.adicionarNo(new No("42", -23.55158, -51.46160));
	grafo.adicionarNo(new No("43", -23.55207, -51.46190));
	grafo.adicionarNo(new No("44", -23.55231, -51.46150));
	grafo.adicionarNo(new No("45", -23.55313, -51.46139));
	
	//parei aqui
	
	grafo.adicionarNo(new No("46", -23.55420, -51.46107));
	//grafo.adicionarNo(new No("47", -23.54950, -51.46963));
	grafo.adicionarNo(new No("48", -23.55528, -51.46077));
	grafo.adicionarNo(new No("49", -23.54897, -51.46380));
	grafo.adicionarNo(new No("50", -23.55004, -51.46348));
	
	grafo.adicionarNo(new No("51", -23.55115, -51.46318));
	grafo.adicionarNo(new No("52", -23.55227, -51.46285));
	grafo.adicionarNo(new No("53", -23.55337, -51.46253));
	grafo.adicionarNo(new No("54", -23.55449, -51.46221));
	grafo.adicionarNo(new No("55", -23.55557, -51.46190));
	
	grafo.adicionarNo(new No("56", -23.55028, -51.46467));
	//grafo.adicionarNo(new No("57", -23., -51.46963));
	//grafo.adicionarNo(new No("58", -23.54950, -51.46963));
	grafo.adicionarNo(new No("59", -23.55142, -51.46431));
	grafo.adicionarNo(new No("60", -23.55253, -51.46400));
	
	grafo.adicionarNo(new No("61", -23.55367, -51.46364));
	grafo.adicionarNo(new No("62", -23.55474, -51.46334));
	grafo.adicionarNo(new No("63", -23.55112, -51.46582));
	grafo.adicionarNo(new No("64", -23.55223, -51.46477));
	grafo.adicionarNo(new No("65", -23.55282, -51.46515));
	
	grafo.adicionarNo(new No("66", -23.55313, -51.46440));
	grafo.adicionarNo(new No("67", -23.55385, -51.46444));
	
	grafo.adicionarNo(new No("59,5", -23.55236, -51.46404));
	grafo.adicionarNo(new No("67", -23.55271, -51.46400));

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
        grafo.adicionarAresta("44", "42", 10.0);
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
