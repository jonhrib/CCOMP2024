package Arquivos;

import java.util.ArrayList;

public class Atributo {
    private ArrayList <Boolean> valores;

    public Atributo (boolean valor){
        this.valores = new ArrayList<>();
        this.valores.add(valor);
    }

    public void adicionarValor(boolean valor) {
        this.valores.add(valor);
    }

    public ArrayList<Boolean> getValores() {
        return this.valores;
    }
}
