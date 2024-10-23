package Classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Adotante extends Conexão {

    public Adotante() throws ClassNotFoundException, SQLException {
        super();
    }

    /**
     * Cadastrar novo adotante no banco de dados.
     */
    public void cadastrarAdotante(String cpf, String rg, String nome, String endereco, String telefone) throws SQLException {
        cpf = formatarCpf(cpf);
        telefone = formatarTelefone(telefone);
    	
    	String sql = "INSERT INTO Adotante (Cpf, RG, Nome, Endereco, Telefone) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cpf);
        stmt.setString(2, rg);
        stmt.setString(3, nome);
        stmt.setString(4, endereco);
        stmt.setString(5, telefone);

        stmt.executeUpdate();
        System.out.println("Adotante cadastrado com sucesso.");
    }
    
    public List<String[]> encontrarAdotantes() throws SQLException {
        Statement stmt = con.createStatement();

        // Lista para armazenar os dados dos adotantes
        List<String[]> adotantesList = new ArrayList<>();

        // Executa a consulta SQL para buscar os dados da tabela Adotante
        ResultSet dados = stmt.executeQuery("SELECT Cpf, RG, Nome, Endereco, Telefone FROM Adotante");

        // Verifica se o ResultSet tem resultados
        while (dados.next()) {
            String cpf = dados.getString("Cpf");
            String rg = dados.getString("RG");
            String nome = dados.getString("Nome");
            String endereco = dados.getString("Endereco");
            String telefone = dados.getString("Telefone");

            // Adiciona os dados à lista
            adotantesList.add(new String[]{cpf, rg, nome, endereco, telefone});
        }

        // Retorna a lista de adotantes
        return adotantesList;
    }
    
    public void adicionarAnimalAdotado(String cpf, String codigoAnimal) throws SQLException {
    	cpf = formatarCpf(cpf);
        String sql = "UPDATE Adotante SET adotados = array_append(adotados, ?) WHERE cpf = ?";
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, codigoAnimal);
            pstmt.setString(2, cpf);
            pstmt.executeUpdate();
        }
    }

    
    private String formatarCpf(String cpf) {
	    // Remove todos os caracteres não numéricos
	    cpf = cpf.replaceAll("[^0-9]", "");

	    // Verifica se o CPF tem 11 dígitos (caso contrário, retorna o CPF sem formatação)
	    if (cpf.length() != 11) {
	        return cpf; // Ou lance uma exceção, se preferir
	    }

	    // Formata o CPF para o padrão "###.###.###-##"
	    return String.format("%s.%s.%s-%s",
	            cpf.substring(0, 3),
	            cpf.substring(3, 6),
	            cpf.substring(6, 9),
	            cpf.substring(9, 11));
	}
    
    public static String formatarTelefone(String telefone) {
        // Remove todos os caracteres não numéricos
        telefone = telefone.replaceAll("[^0-9]", "");

        // Verifica o comprimento do número após a remoção de caracteres não numéricos
        if (telefone.length() == 11) { // Formato celular: (XX) XXXXX-XXXX
            return String.format("(%s) %s-%s",
                    telefone.substring(0, 2), // DDD
                    telefone.substring(2, 7), // Primeiros 5 dígitos
                    telefone.substring(7));   // Últimos 4 dígitos
        } else if (telefone.length() == 10) { // Formato fixo: (XX) XXXX-XXXX
            return String.format("(%s) %s-%s",
                    telefone.substring(0, 2), // DDD
                    telefone.substring(2, 6), // Primeiros 4 dígitos
                    telefone.substring(6));   // Últimos 4 dígitos
        } else {
            return "Número inválido"; // Retorna uma mensagem de erro para números com tamanho inesperado
        }
    }


    /**
     * Encontrar adotante pelo CPF.
     */
    public String[] encontrarAdotante(String cpf) throws SQLException {
    	cpf = formatarCpf(cpf);
        String sql = "SELECT * FROM Adotante WHERE Cpf = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cpf);
        ResultSet dados = stmt.executeQuery();

        if (dados.next()) {
            String rg = dados.getString("RG");
            String nome = dados.getString("Nome");
            String endereco = dados.getString("Endereco");
            String telefone = dados.getString("Telefone");

            return new String[]{cpf, rg, nome, endereco, telefone};
        }
        return null;
    }
}
