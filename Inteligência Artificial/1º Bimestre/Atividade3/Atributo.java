package Arquivos;

import java.util.ArrayList;

public class Atributo { //classe do Atributo
    private ArrayList <Boolean> valores; //atributo lista, que gardará os valores do Atributo

    public Atributo (boolean valor){ //construtor que recebe o valor diretamente, criando a lista e colocando o valor nela
        this.valores = new ArrayList<>();
        this.valores.add(valor);
    }

    public void adicionarValor(boolean valor) { // função que adiciona os valores diretamente na lista
        this.valores.add(valor);
    }

    public ArrayList<Boolean> getValores() { //retorna os valores 
        return this.valores;
    }
}
