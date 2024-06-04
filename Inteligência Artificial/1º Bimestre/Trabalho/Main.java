import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String args []) {
		Scanner s = new Scanner(System.in);
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
		grafo.adicionarNo(new No("19", -23.54863, -51.45957));
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
		grafo.adicionarNo(new No("35", -23.554491, -51.459867));
		
		
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
		
		grafo.adicionarNo(new No("46", -23.55420, -51.46107));
		grafo.adicionarNo(new No("47", -23.554705, -51.460905));
		grafo.adicionarNo(new No("48", -23.55528, -51.46077));
		grafo.adicionarNo(new No("49", -23.54897, -51.46380));
		grafo.adicionarNo(new No("50", -23.55004, -51.46348));
		
		grafo.adicionarNo(new No("51", -23.55115, -51.46318));
		grafo.adicionarNo(new No("52", -23.55227, -51.46285));
		grafo.adicionarNo(new No("53", -23.55337, -51.46253));
		grafo.adicionarNo(new No("54", -23.55449, -51.46221));
		grafo.adicionarNo(new No("55", -23.55557, -51.46190));
		
		grafo.adicionarNo(new No("56", -23.55028, -51.46467));
		grafo.adicionarNo(new No("57", -23.55064, -51.46395));
		grafo.adicionarNo(new No("58", -23.54950, -51.46963));
		grafo.adicionarNo(new No("59", -23.55142, -51.46431));
		grafo.adicionarNo(new No("59.5", -23.552397, -51.464040));
		grafo.adicionarNo(new No("60", -23.55253, -51.46400));
		grafo.adicionarNo(new No("60.5", -23.552768, -51.463926));
		
		grafo.adicionarNo(new No("61", -23.55367, -51.46364));
		grafo.adicionarNo(new No("62", -23.55474, -51.46334));
		grafo.adicionarNo(new No("63", -23.55112, -51.46582));
		grafo.adicionarNo(new No("64", -23.55223, -51.46477));
		grafo.adicionarNo(new No("65", -23.55282, -51.46515));
		
		grafo.adicionarNo(new No("66", -23.55313, -51.46440));
		grafo.adicionarNo(new No("67", -23.55385, -51.46444));
		
		grafo.adicionarNo(new No("59.5", -23.55236, -51.46404));
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
		grafo.adicionarAresta("4", "5", 1.0);
		grafo.adicionarAresta("4", "11", 1.0);
		grafo.adicionarAresta("5", "4", 1.0);
		grafo.adicionarAresta("5", "6", 1.0);
		grafo.adicionarAresta("5", "12", 1.0);
		grafo.adicionarAresta("6", "1", 1.0);
		grafo.adicionarAresta("6", "5", 1.0);
		grafo.adicionarAresta("6", "7", 1.0);
		grafo.adicionarAresta("6", "13", 1.0);
		grafo.adicionarAresta("7", "2", 1.0);
		grafo.adicionarAresta("7", "6", 1.0);
		grafo.adicionarAresta("7", "8", 1.0);
		grafo.adicionarAresta("7", "14", 1.0);
		grafo.adicionarAresta("8", "3", 1.0);
		grafo.adicionarAresta("8", "7", 1.0);
		grafo.adicionarAresta("8", "9", 1.0);
		grafo.adicionarAresta("8", "15", 1.0);
		grafo.adicionarAresta("9", "8", 1.0);
		grafo.adicionarAresta("9", "16", 1.0);
		grafo.adicionarAresta("10", "9", 1.0);
		grafo.adicionarAresta("10", "17", 1.0);

		grafo.adicionarAresta("11", "4", 1.0);
		grafo.adicionarAresta("11", "12", 1.0);
		grafo.adicionarAresta("11", "18", 1.0);
		grafo.adicionarAresta("12", "5", 1.0);
		grafo.adicionarAresta("12", "11", 1.0);
		grafo.adicionarAresta("12", "13", 1.0);
		grafo.adicionarAresta("12", "20", 1.0);
		grafo.adicionarAresta("13", "6", 1.0);
		grafo.adicionarAresta("13", "12", 1.0);
		grafo.adicionarAresta("13", "14", 1.0);
		grafo.adicionarAresta("13", "21", 1.0);
		grafo.adicionarAresta("14", "7", 1.0);
		grafo.adicionarAresta("14", "13", 1.0);
		grafo.adicionarAresta("14", "15", 1.0);
		grafo.adicionarAresta("14", "23", 1.0);
		grafo.adicionarAresta("15", "8", 1.0);
		grafo.adicionarAresta("15", "14", 1.0);
		grafo.adicionarAresta("15", "16", 1.0);
		grafo.adicionarAresta("15", "25", 1.0);
		grafo.adicionarAresta("16", "9", 1.0);
		grafo.adicionarAresta("16", "15", 1.0);
		grafo.adicionarAresta("16", "17", 1.0);
		grafo.adicionarAresta("16", "26", 1.0);
		grafo.adicionarAresta("17", "10", 1.0);
		grafo.adicionarAresta("17", "16", 1.0);
		grafo.adicionarAresta("17", "27", 1.0);
		grafo.adicionarAresta("18", "11", 1.0);
		grafo.adicionarAresta("18", "20", 1.0);
		grafo.adicionarAresta("18", "28", 1.0);
		grafo.adicionarAresta("19", "20", 1.0);
		grafo.adicionarAresta("20", "12", 1.0);
		grafo.adicionarAresta("20", "18", 1.0);
		grafo.adicionarAresta("20", "19", 1.0);
		grafo.adicionarAresta("20", "21", 1.0);
		grafo.adicionarAresta("20", "29", 1.0);

		grafo.adicionarAresta("21", "13", 1.0);
		grafo.adicionarAresta("21", "20", 1.0);
		grafo.adicionarAresta("21", "22", 1.0);
		grafo.adicionarAresta("21", "30", 1.0);
		grafo.adicionarAresta("22", "21", 1.0);
        grafo.adicionarAresta("22", "23", 1.0);
        grafo.adicionarAresta("22", "24", 1.0);
        grafo.adicionarAresta("22", "31", 1.0);
        grafo.adicionarAresta("23", "14", 1.0);
        grafo.adicionarAresta("23", "22", 1.0);
        grafo.adicionarAresta("23", "24", 10.0);
        grafo.adicionarAresta("24", "22", 1.0);
        grafo.adicionarAresta("24", "23", 1.0);
        grafo.adicionarAresta("24", "25", 1.0);
        grafo.adicionarAresta("24", "32", 1.0);
		grafo.adicionarAresta("25", "15", 1.0);
		grafo.adicionarAresta("25", "24", 1.0);
		grafo.adicionarAresta("25", "26", 1.0);
		grafo.adicionarAresta("25", "33", 1.0);
		grafo.adicionarAresta("26", "16", 1.0);
		grafo.adicionarAresta("26", "25", 1.0);
		grafo.adicionarAresta("26", "27", 1.0);
		grafo.adicionarAresta("26", "34", 1.0);
		grafo.adicionarAresta("27", "17", 1.0);
		grafo.adicionarAresta("27", "26", 1.0);
		grafo.adicionarAresta("27", "36", 1.0);
		grafo.adicionarAresta("28", "18", 1.0);
		grafo.adicionarAresta("28", "29", 1.0);
		grafo.adicionarAresta("28", "38", 1.0);
		grafo.adicionarAresta("29", "20", 1.0);
		grafo.adicionarAresta("29", "28", 1.0);
		grafo.adicionarAresta("29", "30", 1.0);
		grafo.adicionarAresta("29", "40", 1.0);
		grafo.adicionarAresta("30", "21", 1.0);
		grafo.adicionarAresta("30", "29", 1.0);
		grafo.adicionarAresta("30", "31", 1.0);
		grafo.adicionarAresta("30", "41", 1.0);

        grafo.adicionarAresta("31", "22", 1.0);
        grafo.adicionarAresta("31", "30", 1.0);
        grafo.adicionarAresta("31", "42", 1.0);
        grafo.adicionarAresta("32", "24", 1.0);
        grafo.adicionarAresta("32", "33", 1.0);
        grafo.adicionarAresta("32", "44", 1.0);
		grafo.adicionarAresta("33", "25", 1.0);
		grafo.adicionarAresta("33", "32", 1.0);
		grafo.adicionarAresta("33", "34", 1.0);
		grafo.adicionarAresta("33", "45", 1.0);
		grafo.adicionarAresta("34", "26", 1.0);
		grafo.adicionarAresta("34", "33", 1.0);
		grafo.adicionarAresta("34", "35", 1.0);
		grafo.adicionarAresta("34", "46", 1.0);
		grafo.adicionarAresta("35", "34", 1.0);
		grafo.adicionarAresta("35", "36", 1.0);
		grafo.adicionarAresta("35", "47", 1.0);
		grafo.adicionarAresta("36", "27", 1.0);
		grafo.adicionarAresta("36", "35", 1.0);
		grafo.adicionarAresta("36", "37", 1.0);
		grafo.adicionarAresta("36", "48", 1.0);
		grafo.adicionarAresta("37", "36", 1.0);
		grafo.adicionarAresta("38", "28", 1.0);
		grafo.adicionarAresta("38", "39", 1.0);
		grafo.adicionarAresta("39", "38", 1.0);
		grafo.adicionarAresta("39", "40", 1.0);
		grafo.adicionarAresta("40", "29", 1.0);
		grafo.adicionarAresta("40", "39", 1.0);
		grafo.adicionarAresta("40", "41", 1.0);
		grafo.adicionarAresta("40", "50", 1.0);

		grafo.adicionarAresta("41", "30", 1.0);
		grafo.adicionarAresta("41", "40", 1.0);
		grafo.adicionarAresta("41", "42", 1.0);
		grafo.adicionarAresta("41", "51", 1.0);
        grafo.adicionarAresta("42", "31", 1.0);
        grafo.adicionarAresta("42", "41", 1.0);
        grafo.adicionarAresta("42", "43", 1.0);
        grafo.adicionarAresta("42", "44", 1.0);
		grafo.adicionarAresta("43", "42", 1.0);
		grafo.adicionarAresta("43", "44", 1.0);
		grafo.adicionarAresta("43", "52", 1.0);
        grafo.adicionarAresta("44", "32", 1.0);
        grafo.adicionarAresta("44", "42", 10.0);
        grafo.adicionarAresta("44", "43", 1.0);
        grafo.adicionarAresta("44", "45", 1.0);
		grafo.adicionarAresta("45", "33", 1.0);
		grafo.adicionarAresta("45", "44", 1.0);
		grafo.adicionarAresta("45", "46", 1.0);
		grafo.adicionarAresta("45", "53", 1.0);
		grafo.adicionarAresta("46", "34", 1.0);
		grafo.adicionarAresta("46", "45", 1.0);
		grafo.adicionarAresta("46", "47", 1.0);
		//grafo.adicionarAresta("46", "48", 1.0);
		grafo.adicionarAresta("46", "54", 1.0);
		grafo.adicionarAresta("47", "35", 1.0);
		grafo.adicionarAresta("47", "46", 1.0);
		grafo.adicionarAresta("47", "48", 1.0);
		grafo.adicionarAresta("48", "36", 1.0);
		//grafo.adicionarAresta("48", "46", 1.0);
		grafo.adicionarAresta("48", "47", 1.0);
		grafo.adicionarAresta("48", "55", 1.0);
		grafo.adicionarAresta("49", "50", 1.0);
		grafo.adicionarAresta("50", "40", 1.0);
		grafo.adicionarAresta("50", "49", 1.0);
		grafo.adicionarAresta("50", "51", 1.0);
		grafo.adicionarAresta("50", "56", 1.0);

		grafo.adicionarAresta("51", "41", 1.0);
		grafo.adicionarAresta("51", "50", 1.0);
		grafo.adicionarAresta("51", "52", 1.0);
		grafo.adicionarAresta("51", "59", 1.0);
		grafo.adicionarAresta("52", "43", 1.0);
		grafo.adicionarAresta("52", "51", 1.0);
		grafo.adicionarAresta("52", "53", 1.0);
		grafo.adicionarAresta("52", "60", 1.0);
		grafo.adicionarAresta("53", "45", 1.0);
		grafo.adicionarAresta("53", "52", 1.0);
		grafo.adicionarAresta("53", "54", 1.0);
		grafo.adicionarAresta("53", "61", 1.0);
		grafo.adicionarAresta("54", "46", 1.0);
		grafo.adicionarAresta("54", "53", 1.0);
		grafo.adicionarAresta("54", "55", 1.0);
		grafo.adicionarAresta("54", "62", 1.0);
		grafo.adicionarAresta("55", "48", 1.0);
		grafo.adicionarAresta("55", "54", 1.0);
		grafo.adicionarAresta("56", "50", 1.0);
		grafo.adicionarAresta("56", "59", 1.0);
		grafo.adicionarAresta("56", "58", 1.0);
		//grafo.adicionarAresta("57", "58", 1.0);
		grafo.adicionarAresta("58", "56", 1.0);
		//grafo.adicionarAresta("58", "57", 1.0);
		grafo.adicionarAresta("58", "59", 1.0);
		grafo.adicionarAresta("59", "51", 1.0);
		grafo.adicionarAresta("59", "58", 1.0);
		grafo.adicionarAresta("59", "59.5", 1.0);
		grafo.adicionarAresta("59", "63", 1.0);
		grafo.adicionarAresta("59.5", "59", 1.0);
		grafo.adicionarAresta("59.5", "60", 1.0);
		grafo.adicionarAresta("60", "52", 1.0);
		grafo.adicionarAresta("60", "59.5", 1.0);
		grafo.adicionarAresta("60", "60.5", 1.0);
		grafo.adicionarAresta("60", "64", 1.0);
		grafo.adicionarAresta("60", "66", 1.0);
		grafo.adicionarAresta("60.5", "60", 1.0);
		grafo.adicionarAresta("60.5", "61", 1.0);

		grafo.adicionarAresta("61", "53", 1.0);
		grafo.adicionarAresta("61", "60.5", 1.0);
		grafo.adicionarAresta("61", "62", 1.0);
		grafo.adicionarAresta("61", "67", 1.0);
		grafo.adicionarAresta("62", "54", 1.0);
		grafo.adicionarAresta("62", "61", 1.0);
		grafo.adicionarAresta("63", "59", 1.0);
		grafo.adicionarAresta("64", "60", 1.0);
		grafo.adicionarAresta("64", "65", 1.0);
		grafo.adicionarAresta("65", "64", 1.0);
		grafo.adicionarAresta("65", "66", 1.0);
		grafo.adicionarAresta("66", "60", 1.0);
		grafo.adicionarAresta("66", "65", 1.0);
		grafo.adicionarAresta("67", "61", 1.0);

		int e = 0;
		while (e != 2){
			// encontramos, aqui, o melhor caminho do ponto inicial até o ponto final
			String pontoInicial;
			String pontoFinal;
			int conta = 0, contb = 0;

			do {
				if (conta == 0) {
					System.out.print("Digite o ponto inicial: "); pontoInicial = s.nextLine();
				}
				else {
					System.out.print("Digite o ponto inicial existente: "); pontoInicial = s.nextLine();
				}
				conta++;
			} while (!grafo.procuraNo(pontoInicial));

			do {
				if (contb == 0) {
					System.out.print("Digite o ponto final: "); pontoFinal = s.nextLine();
				}
				else {
					System.out.print("Digite o ponto final existente: "); pontoFinal = s.nextLine();
				}
				contb++;
			} while (!grafo.procuraNo(pontoFinal));

			System.out.println("-----------------------------------------------------------------");
			System.out.println("PONTO INICIAL: " + pontoInicial);
			System.out.println("PONTO FINAL: " + pontoFinal);
			System.out.println("-----------------------------------------------------------------");
			System.out.println("PROCURANDO CAMINHO...");
			
			
			List<No> caminho = Estrelinha.melhorCaminho(grafo, pontoInicial, pontoFinal);

			if (caminho != null) {
				System.out.println("-----------------------------------------------------------------");
				System.out.println("O melhor caminho para chegar do ponto " + pontoInicial + " até o ponto " + pontoFinal + " é: ");
				for (No no : caminho) {
					System.out.println(no.getNome());
				}
				System.out.println("-----------------------------------------------------------------");
			} 

			else { // se não existe um caminho que ligue os pontos
				System.out.println("Caminho não encontrado, tente outros pontos!");
			}

			System.out.println("-----------------------------------------------------------------");
			int contc = 0;
			e = 0;
			while (e != 1 && e != 2) {
				if (contc == 0){
					System.out.println("Deseja tentar outro caminho? -> 1- SIM | 2 - NÃO");
					System.out.print("Escolha: "); e = s.nextInt();
					s.nextLine(); // limpar o buffer após nextInt()
				}
				else {
					System.out.println("Digite uma escolha válida -> 1- SIM | 2 - NÃO");
					System.out.print("Escolha: "); e = s.nextInt();
					s.nextLine(); // limpar o buffer após nextInt()
				}
				contc++;
			}
			System.out.println("-----------------------------------------------------------------");
		}
		if (e == 2){
			System.out.println("-----------------------------------------------------------------");
			System.out.println("                            OBRIGADO                             ");
			System.out.println("-----------------------------------------------------------------");
		}

		s.close();
    }
}
