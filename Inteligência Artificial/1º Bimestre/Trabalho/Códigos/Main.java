import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String args []) {
		Scanner s = new Scanner(System.in);
        Grafo grafo = new Grafo(); //cria-se o grafo

		// adicionamos os nós (pontos nas ruas) com suas coordenadas, retiradas do Maps, a um grafo
		grafo.adicionaNo(new No("1", -23.54950, -51.45635));
		grafo.adicionaNo(new No("2", -23.55061, -51.45602));
		grafo.adicionaNo(new No("3", -23.55174, -51.45571));
		grafo.adicionaNo(new No("4", -23.54799, -51.45834));
		grafo.adicionaNo(new No("5", -23.54868, -51.45780));
		
		grafo.adicionaNo(new No("6", -23.54977, -51.45751));
		grafo.adicionaNo(new No("7", -23.55089, -51.45717));
		grafo.adicionaNo(new No("8", -23.55197, -51.45684));
		grafo.adicionaNo(new No("9", -23.55312, -51.45655));
		grafo.adicionaNo(new No("10", -23.55415, -51.45627));
		
		grafo.adicionaNo(new No("11", -23.54790, -51.45924));
		grafo.adicionaNo(new No("12", -23.54868, -51.45896));
		grafo.adicionaNo(new No("13", -23.55005, -51.45863));
		grafo.adicionaNo(new No("14", -23.55119, -51.45830));
		grafo.adicionaNo(new No("15", -23.55231, -51.45796));
		
		grafo.adicionaNo(new No("16", -23.55341, -51.45768));
		grafo.adicionaNo(new No("17", -23.55448, -51.45737));
		grafo.adicionaNo(new No("18", -23.54838, -51.46000));
		grafo.adicionaNo(new No("19", -23.54863, -51.45957));
		grafo.adicionaNo(new No("20", -23.54922, -51.46012));
		
		grafo.adicionaNo(new No("21", -23.55031, -51.45978));
		grafo.adicionaNo(new No("22", -23.55120, -51.45957));
		grafo.adicionaNo(new No("23", -23.55143, -51.45922));
		grafo.adicionaNo(new No("24", -23.55177, -51.45940));
		grafo.adicionaNo(new No("25", -23.55258, -51.45912));
		
		grafo.adicionaNo(new No("26", -23.55368, -51.45880));
		grafo.adicionaNo(new No("27", -23.55477, -51.45850));
		grafo.adicionaNo(new No("28", -23.54788, -51.46097));
		grafo.adicionaNo(new No("29", -23.54949, -51.46122));
		grafo.adicionaNo(new No("30", -23.55060, -51.46091));
		
		grafo.adicionaNo(new No("31", -23.55133, -51.46071));
		grafo.adicionaNo(new No("32", -23.55213, -51.46042));
		grafo.adicionaNo(new No("33", -23.55285, -51.46024));
		grafo.adicionaNo(new No("34", -23.55393, -51.45995));
		grafo.adicionaNo(new No("35", -23.554491, -51.459867));
		
		grafo.adicionaNo(new No("36", -23.55500, -51.45964));
		grafo.adicionaNo(new No("37", -23.55608, -51.45933));
		grafo.adicionaNo(new No("38", -23.54741, -51.46183));
		grafo.adicionaNo(new No("39", -23.54861, -51.46259));
		grafo.adicionaNo(new No("40", -23.54975, -51.46233));
		
		grafo.adicionaNo(new No("41", -23.55086, -51.46199));
		grafo.adicionaNo(new No("42", -23.55158, -51.46160));
		grafo.adicionaNo(new No("43", -23.55207, -51.46190));
		grafo.adicionaNo(new No("44", -23.55231, -51.46150));
		grafo.adicionaNo(new No("45", -23.55313, -51.46139));
		
		grafo.adicionaNo(new No("46", -23.55420, -51.46107));
		grafo.adicionaNo(new No("47", -23.554705, -51.460905));
		grafo.adicionaNo(new No("48", -23.55528, -51.46077));
		grafo.adicionaNo(new No("49", -23.54897, -51.46380));
		grafo.adicionaNo(new No("50", -23.55004, -51.46348));
		
		grafo.adicionaNo(new No("51", -23.55115, -51.46318));
		grafo.adicionaNo(new No("52", -23.55227, -51.46285));
		grafo.adicionaNo(new No("53", -23.55337, -51.46253));
		grafo.adicionaNo(new No("54", -23.55449, -51.46221));
		grafo.adicionaNo(new No("55", -23.55557, -51.46190));
		
		grafo.adicionaNo(new No("56", -23.55028, -51.46467));
		grafo.adicionaNo(new No("57", -23.55064, -51.46395));
		grafo.adicionaNo(new No("58", -23.54950, -51.46963));
		grafo.adicionaNo(new No("59", -23.55142, -51.46431));
		grafo.adicionaNo(new No("59.5", -23.55236, -51.46404));
		grafo.adicionaNo(new No("60", -23.55253, -51.46400));
		grafo.adicionaNo(new No("60.5", -23.552768, -51.463926));
		
		grafo.adicionaNo(new No("61", -23.55367, -51.46364));
		grafo.adicionaNo(new No("62", -23.55474, -51.46334));
		grafo.adicionaNo(new No("63", -23.55112, -51.46582));
		grafo.adicionaNo(new No("64", -23.55223, -51.46477));
		grafo.adicionaNo(new No("65", -23.55282, -51.46515));
	
		grafo.adicionaNo(new No("66", -23.55313, -51.46440));
		grafo.adicionaNo(new No("67", -23.55385, -51.46444));

        // adicionamos as arestas, que representam as ligações entre os pontos (ruas), ao grafo, com pesos para cada situação:
        // peso 0.0 = rua recém reformada
        // peso 1.0 = rua e calçadas em boas condições
        // peso 5.0 = calçada com buracos, mas cadeirantes conseguem passar pela rua sem muitos perigos
        // peso 10.0 = calçada com buracos, rua perigosa, mas existe possibilidade de períodos menos perigosos, sem caminhões
        // peso 100.0 = calçada com buracos ou em condições péssimas, e cadeirantes não podem passar pela rua, visto o perigo, evitar ao máximo

        grafo.adicionaAresta("1", "2",1.0);
        grafo.adicionaAresta("1", "6", 1.0);
        grafo.adicionaAresta("2", "1", 5.0);
        grafo.adicionaAresta("2", "3", 1.0);
        grafo.adicionaAresta("2", "7", 1.0);
        grafo.adicionaAresta("3", "2", 5.0);
        grafo.adicionaAresta("3", "8", 0.0);
		grafo.adicionaAresta("4", "5", 1.0);
		grafo.adicionaAresta("4", "11", 10.0);
		grafo.adicionaAresta("5", "4", 10.0);
		grafo.adicionaAresta("5", "6", 1.0);
		grafo.adicionaAresta("5", "12", 0.0);
		grafo.adicionaAresta("6", "1", 1.0);
		grafo.adicionaAresta("6", "5", 5.0);
		grafo.adicionaAresta("6", "7", 1.0);
		grafo.adicionaAresta("6", "13", 1.0);
		grafo.adicionaAresta("7", "2", 1.0);
		grafo.adicionaAresta("7", "6", 5.0); 
		grafo.adicionaAresta("7", "8", 1.0);
		grafo.adicionaAresta("7", "14", 1.0);
		grafo.adicionaAresta("8", "3", 0.0);
		grafo.adicionaAresta("8", "7", 5.0);
		grafo.adicionaAresta("8", "9", 1.0);
		grafo.adicionaAresta("8", "15", 0.0);
		grafo.adicionaAresta("9", "8", 5.0);
		grafo.adicionaAresta("9", "16", 1.0);
		grafo.adicionaAresta("10", "9", 5.0);
		grafo.adicionaAresta("10", "17", 10.0);

		grafo.adicionaAresta("11", "4", 1.0);
		grafo.adicionaAresta("11", "12", 5.0);
		grafo.adicionaAresta("11", "18", 10.0);
		grafo.adicionaAresta("12", "5", 5.0);
		grafo.adicionaAresta("12", "11", 0.0);
		grafo.adicionaAresta("12", "13", 1.0);
		grafo.adicionaAresta("12", "20", 1.0);
		grafo.adicionaAresta("13", "6", 1.0);
		grafo.adicionaAresta("13", "12", 1.0);
		grafo.adicionaAresta("13", "14", 1.0);
		grafo.adicionaAresta("13", "21", 5.0);
		grafo.adicionaAresta("14", "7", 1.0);
		grafo.adicionaAresta("14", "13", 1.0);
		grafo.adicionaAresta("14", "15", 1.0);
		grafo.adicionaAresta("14", "23", 1.0);
		grafo.adicionaAresta("15", "8", 0.0);
		grafo.adicionaAresta("15", "14", 1.0);
		grafo.adicionaAresta("15", "16", 1.0);
		grafo.adicionaAresta("15", "25", 0.0);
		grafo.adicionaAresta("16", "9", 1.0);
		grafo.adicionaAresta("16", "15", 0.0);
		grafo.adicionaAresta("16", "17", 10.0);
		grafo.adicionaAresta("16", "26", 1.0);
		grafo.adicionaAresta("17", "10", 1.0);
		grafo.adicionaAresta("17", "16", 1.0);
		grafo.adicionaAresta("17", "27", 1.0);
		grafo.adicionaAresta("18", "11", 1.0);
		grafo.adicionaAresta("18", "20", 10.0);
		grafo.adicionaAresta("18", "28", 1.0);
		grafo.adicionaAresta("19", "20", 5.0);
		grafo.adicionaAresta("20", "12", 1.0);
		grafo.adicionaAresta("20", "18", 0.0);
		grafo.adicionaAresta("20", "19", 1.0);
		grafo.adicionaAresta("20", "21", 10.0);
		grafo.adicionaAresta("20", "29", 1.0);

		grafo.adicionaAresta("21", "13", 1.0);
		grafo.adicionaAresta("21", "20", 1.0);
		grafo.adicionaAresta("21", "22", 1.0);
		grafo.adicionaAresta("21", "30", 10.0);
		grafo.adicionaAresta("22", "21", 1.0);
        grafo.adicionaAresta("22", "23", 1.0);
        grafo.adicionaAresta("22", "24", 1.0);
        grafo.adicionaAresta("22", "31", 1.0);
        grafo.adicionaAresta("23", "14", 1.0);
        grafo.adicionaAresta("23", "22", 1.0);
        grafo.adicionaAresta("23", "24", 10.0);
        grafo.adicionaAresta("24", "22", 1.0);
        grafo.adicionaAresta("24", "23", 0.0);
        grafo.adicionaAresta("24", "25", 1.0);
        grafo.adicionaAresta("24", "32", 1.0);
		grafo.adicionaAresta("25", "15", 0.0);
		grafo.adicionaAresta("25", "24", 5.0);
		grafo.adicionaAresta("25", "26", 5.0);
		grafo.adicionaAresta("25", "33", 0.0);
		grafo.adicionaAresta("26", "16", 1.0);
		grafo.adicionaAresta("26", "25", 1.0);
		grafo.adicionaAresta("26", "27", 0.0);
		grafo.adicionaAresta("26", "34", 1.0);
		grafo.adicionaAresta("27", "17", 1.0);
		grafo.adicionaAresta("27", "26", 1.0);
		grafo.adicionaAresta("27", "36", 10.0);
		grafo.adicionaAresta("28", "18", 1.0);
		grafo.adicionaAresta("28", "29", 1.0);
		grafo.adicionaAresta("28", "38", 1.0);
		grafo.adicionaAresta("29", "20", 1.0);
		grafo.adicionaAresta("29", "28", 0.0);
		grafo.adicionaAresta("29", "30", 1.0);
		grafo.adicionaAresta("29", "40", 1.0);
		grafo.adicionaAresta("30", "21", 1.0);
		grafo.adicionaAresta("30", "29", 5.0);
		grafo.adicionaAresta("30", "31", 0.0);
		grafo.adicionaAresta("30", "41", 1.0);

        grafo.adicionaAresta("31", "22", 1.0);
        grafo.adicionaAresta("31", "30", 1.0);
        grafo.adicionaAresta("31", "42", 1.0);
        grafo.adicionaAresta("32", "24", 1.0);
        grafo.adicionaAresta("32", "33", 5.0);
        grafo.adicionaAresta("32", "44", 1.0);
		grafo.adicionaAresta("33", "25", 0.0);
		grafo.adicionaAresta("33", "32", 10.0);
		grafo.adicionaAresta("33", "34", 1.0);
		grafo.adicionaAresta("33", "45", 0.0);
		grafo.adicionaAresta("34", "26", 1.0);
		grafo.adicionaAresta("34", "33", 0.0);
		grafo.adicionaAresta("34", "35", 1.0);
		grafo.adicionaAresta("34", "46", 1.0);
		grafo.adicionaAresta("35", "34", 5.0);
		grafo.adicionaAresta("35", "36", 1.0);
		grafo.adicionaAresta("35", "47", 1.0);
		grafo.adicionaAresta("36", "27", 1.0);
		grafo.adicionaAresta("36", "35", 5.0);
		grafo.adicionaAresta("36", "37", 1.0);
		grafo.adicionaAresta("36", "48", 1.0);
		grafo.adicionaAresta("37", "36", 0.0);
		grafo.adicionaAresta("38", "28", 1.0);
		grafo.adicionaAresta("38", "39", 5.0);
		grafo.adicionaAresta("39", "38", 1.0);
		grafo.adicionaAresta("39", "40", 0.0);
		grafo.adicionaAresta("40", "29", 1.0);
		grafo.adicionaAresta("40", "39", 5.0);
		grafo.adicionaAresta("40", "41", 1.0);
		grafo.adicionaAresta("40", "50", 0.0);

		grafo.adicionaAresta("41", "30", 1.0);
		grafo.adicionaAresta("41", "40", 1.0);
		grafo.adicionaAresta("41", "42", 1.0);
		grafo.adicionaAresta("41", "51", 0.0);
        grafo.adicionaAresta("42", "31", 1.0);
        grafo.adicionaAresta("42", "41", 1.0);
        grafo.adicionaAresta("42", "43", 10.0);
        grafo.adicionaAresta("42", "44", 1.0);
		grafo.adicionaAresta("43", "42", 1.0);
		grafo.adicionaAresta("43", "44", 5.0);
		grafo.adicionaAresta("43", "52", 1.0);
        grafo.adicionaAresta("44", "32", 1.0);
        grafo.adicionaAresta("44", "42", 10.0);
        grafo.adicionaAresta("44", "43", 1.0);
        grafo.adicionaAresta("44", "45", 1.0);
		grafo.adicionaAresta("45", "33", 0.0);
		grafo.adicionaAresta("45", "44", 5.0);
		grafo.adicionaAresta("45", "46", 1.0);
		grafo.adicionaAresta("45", "53", 0.0);
		grafo.adicionaAresta("46", "34", 1.0);
		grafo.adicionaAresta("46", "45", 5.0);
		grafo.adicionaAresta("46", "47", 1.0);
		//grafo.adicionaAresta("46", "48", 1.0);
		grafo.adicionaAresta("46", "54", 1.0);
		grafo.adicionaAresta("47", "35", 0.0);
		grafo.adicionaAresta("47", "46", 5.0);
		grafo.adicionaAresta("47", "48", 1.0);
		grafo.adicionaAresta("48", "36", 1.0);
		//grafo.adicionaAresta("48", "46", 1.0);
		grafo.adicionaAresta("48", "47", 1.0);
		grafo.adicionaAresta("48", "55", 10.0);
		grafo.adicionaAresta("49", "50", 1.0);
		grafo.adicionaAresta("50", "40", 1.0);
		grafo.adicionaAresta("50", "49", 5.0);
		grafo.adicionaAresta("50", "51", 0.0);
		grafo.adicionaAresta("50", "56", 1.0);

		grafo.adicionaAresta("51", "41", 1.0);
		grafo.adicionaAresta("51", "50", 1.0);
		grafo.adicionaAresta("51", "52", 1.0);
		grafo.adicionaAresta("51", "59", 0.0);
		grafo.adicionaAresta("52", "43", 1.0);
		grafo.adicionaAresta("52", "51", 1.0);
		grafo.adicionaAresta("52", "53", 1.0);
		grafo.adicionaAresta("52", "60", 10.0);
		grafo.adicionaAresta("53", "45", 0.0);
		grafo.adicionaAresta("53", "52", 1.0);
		grafo.adicionaAresta("53", "54", 5.0);
		grafo.adicionaAresta("53", "61", 0.0);
		grafo.adicionaAresta("54", "46", 1.0);
		grafo.adicionaAresta("54", "53", 1.0);
		grafo.adicionaAresta("54", "55", 1.0);
		grafo.adicionaAresta("54", "62", 5.0);
		grafo.adicionaAresta("55", "48", 10.0);
		grafo.adicionaAresta("55", "54", 1.0);
		grafo.adicionaAresta("56", "50", 5.0);
		grafo.adicionaAresta("56", "59", 1.0);
		grafo.adicionaAresta("56", "58", 0.0);
		//grafo.adicionaAresta("57", "58", 1.0);
		grafo.adicionaAresta("58", "56", 1.0);
		//grafo.adicionaAresta("58", "57", 1.0);
		grafo.adicionaAresta("58", "59", 0.0);
		grafo.adicionaAresta("59", "51", 1.0);
		grafo.adicionaAresta("59", "58", 1.0);
		grafo.adicionaAresta("59", "59.5", 5.0);
		grafo.adicionaAresta("59", "63", 1.0);
		grafo.adicionaAresta("59.5", "59", 1.0);
		grafo.adicionaAresta("59.5", "60", 1.0);
		grafo.adicionaAresta("60", "52", 5.0);
		grafo.adicionaAresta("60", "59.5", 10.0);
		grafo.adicionaAresta("60", "60.5", 1.0);
		grafo.adicionaAresta("60", "64", 0.0);
		grafo.adicionaAresta("60", "66", 10.0);
		grafo.adicionaAresta("60.5", "60", 1.0);
		grafo.adicionaAresta("60.5", "61", 5.0);

		grafo.adicionaAresta("61", "53", 0.0);
		grafo.adicionaAresta("61", "60.5", 1.0);
		grafo.adicionaAresta("61", "62", 5.0);
		grafo.adicionaAresta("61", "67", 0.0);
		grafo.adicionaAresta("62", "54", 1.0);
		grafo.adicionaAresta("62", "61", 0.0);
		grafo.adicionaAresta("63", "59", 1.0);
		grafo.adicionaAresta("64", "60", 5.0);
		grafo.adicionaAresta("64", "65", 10.0);
		grafo.adicionaAresta("65", "64", 1.0);
		grafo.adicionaAresta("65", "66", 0.0);
		grafo.adicionaAresta("66", "60", 1.0);
		grafo.adicionaAresta("66", "65", 5.0);
		grafo.adicionaAresta("67", "61", 0.0);

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