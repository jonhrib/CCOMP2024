package BuscaBinaria;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		
        int[] vetor = {11, 21, 24, 34, 64, 90, 154, 201, 345};
        
        int x = 1;
		while (x < 3 && x > 0) { //vai repetir o menu até que seja pressionado o número 3
			System.out.println("-----------------------------------------------------------------------------"); //impressão de título
			System.out.println("|1 - BUSCA BINÁRIA                                                          |");//impressão de título
			System.out.println("|2 - BUSCA HORRÍVEL                                                         |");
			System.out.println("|3 - SAIR                                                                   |");
			System.out.println("-----------------------------------------------------------------------------");
			System.out.println ("Opção escolhida: " + (x = s.nextInt()));
			System.out.println("-----------------------------------------------------------------------------");
			
			if (x != 3) {
				System.out.print("Digite o elemento buscado: ");
				int elemento = s.nextInt();
		        int indice = 0;
		        
		        	if (x == 1) { // se a opção escolhida foi a busca binária
						System.out.println();
						System.out.print("Valores passados: ");
						indice = buscaBinariaRecursiva(vetor, elemento, 0, vetor.length - 1); //passa o vetor, o elemento procurado, o início e o final
						System.out.println();
		        	}
		        	else if (x == 2) {
						System.out.println();
						System.out.print("Valores passados: ");
						indice = buscaPiorada(vetor, elemento); //passa o vetor, o elemento procurado, o início e o final
						System.out.println();
					}
		        	
		        	System.out.println();
					if (indice != -1) {
			            System.out.println("+++++++ Elemento encontrado no índice " + indice + "+++++++");
			        } 
			        else {
			            System.out.println("+++++++ Elemento não encontrado +++++++");
			        }
			        
			        System.out.println("-------------------------------------------------------------");
				}
			else {
				System.out.println("END");
			}
	        
		}
        
//        System.out.println("Deseja procurar outro elemento? 1 - SIM | 2 - NÃO");
//        int escolha = s.nextInt();
//        
//        System.out.println("-------------------------------------------------------------");
//        
//        while (escolha != 2) {
//        	
//	    	System.out.print("Digite o elemento buscado: ");
//	        elemento = s.nextInt();
//	        
//	        indice = buscaBinariaRecursiva(vetor, elemento, 0, vetor.length - 1); //passa o vetor, o elemento procurado, o início e o final
//
//	        if (indice != -1) {
//	            System.out.println("+++++++ Elemento encontrado no índice +++++++" + indice);
//	        } 
//	        else {
//	            System.out.println("+++++++ Elemento não encontrado +++++++");
//	        }
//	        
//	        System.out.println("-------------------------------------------------------------");
//	        
//	        System.out.println("Deseja procurar outro elemento? 1 - SIM | 2 - NÃO");
//	        escolha = s.nextInt();
//	        
//	        System.out.println("-------------------------------------------------------------");
//        }
    }

    public static int buscaBinariaRecursiva(int[] vet, int elemento, int inicio, int fim) {
    	
        if (inicio > fim) {
        	
            return -1; // Elemento não encontrado, retorna -1
        }

        int pivo = (inicio + fim) / 2;
        
        if (vet[pivo] == elemento) {
        	System.out.print(vet[pivo]);
            return pivo; // Elemento encontrado, retorna o índice
        } 
        
        else if (vet[pivo] < elemento) {
        	System.out.print(vet[pivo] + ",");
            return buscaBinariaRecursiva(vet, elemento, pivo + 1, fim); // O elemento está na metade direita (passamos o início para depois do pivo)
        } 
       
        else {
        	System.out.print(vet[pivo] + ",");
            return buscaBinariaRecursiva(vet, elemento, inicio, pivo - 1); // O elemento está na metade esquerda (passamos o fim para antes do pivo)
        }
    }
    
    public static int buscaPiorada (int[] vet, int elemento) {
    	int pos = -1, i = 0;
    	
    	for (int valor : vet) {
    		if (i == vet.length-1 || valor == elemento) {
    			System.out.print(valor);
    		}
    		else System.out.print(valor + ",");
    		i++;
    		if (valor == elemento) {
    			pos = i-1;
    			break;
    		}
    	}
		return pos;
    }
}
