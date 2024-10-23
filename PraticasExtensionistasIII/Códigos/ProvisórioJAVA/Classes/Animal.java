package Classes;

import java.sql.Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Animal extends Conexão {

    public Animal() throws ClassNotFoundException, SQLException {
        super();
    }

    /**
     * Cadastrar novo animal no banco de dados.
     */
    public void cadastrarAnimal(String codigo, boolean tipo, String raca, String cor, double peso) throws SQLException {
        String sql = "INSERT INTO Animal (codigo, tipo, raca, cor, peso, adotado) VALUES (?, ?, ?, ?, ?, FALSE)";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, codigo);
        stmt.setBoolean(2, tipo);
        stmt.setString(3, raca);
        stmt.setString(4, cor);
        stmt.setDouble(5, peso);

        stmt.executeUpdate();
        System.out.println("Animal cadastrado com sucesso.");
    }
    
    public boolean isAdotado(String codigo) throws SQLException {
        String sql = "SELECT adotado FROM Animal WHERE codigo = ?";
        
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, codigo);
            ResultSet dados = stmt.executeQuery();

            if (dados.next()) {
                return dados.getBoolean("adotado");
            } else {
                System.out.println("Nenhum animal encontrado com o código fornecido.");
                return false; // Ou você pode lançar uma exceção aqui
            }
        }
    }

    /**
     * Encontrar todos os animais no banco de dados.
     */
    public List<String[]> encontrarAnimais() throws SQLException {
        Statement stmt = con.createStatement();

        // Lista para armazenar os dados
        List<String[]> animaisList = new ArrayList<>();

        // Executa a consulta SQL para buscar os dados da tabela Animal
        ResultSet dados = stmt.executeQuery("SELECT codigo, tipo, raca, cor, peso FROM Animal");

        // Verifica se o ResultSet tem resultados
        while (dados.next()) {
            String codigo = dados.getString("codigo");
            String tipo = dados.getBoolean("tipo") ? "Cão" : "Gato"; // Considerando true = Cão, false = Gato
            String raca = dados.getString("raca");
            String cor = dados.getString("cor");
            String peso = String.valueOf(dados.getDouble("peso"));

            // Adiciona os dados à lista
            animaisList.add(new String[]{codigo, tipo, raca, cor, peso});
        }

        // Retorna a lista de animais
        return animaisList;
    }
    
    public List<String[]> encontrarAnimaisDisponiveis() throws SQLException {
        Statement stmt = con.createStatement();
        List<String[]> animaisList = new ArrayList<>();
        ResultSet dados = stmt.executeQuery("SELECT codigo, tipo, raca, cor, peso FROM Animal WHERE adotado = FALSE");

        while (dados.next()) {
            String codigo = dados.getString("codigo");
            String tipo = dados.getBoolean("tipo") ? "Cão" : "Gato";
            String raca = dados.getString("raca");
            String cor = dados.getString("cor");
            String peso = String.valueOf(dados.getDouble("peso"));

            animaisList.add(new String[]{codigo, tipo, raca, cor, peso});
        }

        return animaisList;
    }
    
    public void adotarAnimal(String codigo, String cpfAdotante) throws SQLException {
        String sql = "UPDATE Animal SET adotado = TRUE, cpf_adotante = ? WHERE codigo = ?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, cpfAdotante);
        stmt.setString(2, codigo);
        stmt.executeUpdate();

        System.out.println("Adoção registrada com sucesso.");
    }

    /**
     * Encontrar um animal específico pelo código.
     */
    public String[] encontrarAnimal(String codigoProcurado) throws SQLException {
        // Prepara a consulta SQL com o parâmetro código
        String sql = "SELECT codigo, tipo, raca, cor, peso FROM Animal WHERE codigo = ?";

        // Prepara a declaração SQL para evitar SQL injection
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, codigoProcurado);

        // Executa a consulta
        ResultSet dados = stmt.executeQuery();

        // Verifica se o resultado foi encontrado
        if (dados.next()) {
            String codigo = dados.getString("codigo");
            String tipo = dados.getBoolean("tipo") ? "Cão" : "Gato"; // Considerando true = Cão, false = Gato
            String raca = dados.getString("raca");
            String cor = dados.getString("cor");
            String peso = String.valueOf(dados.getDouble("peso"));

            // Retorna os dados do animal como um array de Strings
            return new String[]{codigo, tipo, raca, cor, peso};
        }

        // Se não encontrar o código, retorna null
        return null;
    }

    /**
     * Atualizar os dados de um animal.
     */
    public void atualizarAnimal(String novoRaca, String novaCor, double novoPeso, String codigo) throws SQLException {
        // SQL de atualização
        String SQLUpdate = "UPDATE Animal SET raca = ?, cor = ?, peso = ? WHERE codigo = ?";

        // Prepara o comando SQL
        PreparedStatement stmt = con.prepareStatement(SQLUpdate);
        stmt.setString(1, novoRaca);
        stmt.setString(2, novaCor);
        stmt.setDouble(3, novoPeso);
        stmt.setString(4, codigo);

        // Executa o comando de atualização
        stmt.executeUpdate();

        System.out.println("Animal atualizado com sucesso.");
    }

    /**
     * Deletar um animal pelo código.
     */
    public void deletarAnimal(String codigo) throws SQLException {
        // SQL de deletar
        String sql = "DELETE FROM Animal WHERE codigo = ?";

        // Prepara a declaração SQL
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, codigo);

        // Executa o comando de deletar
        stmt.executeUpdate();

        System.out.println("Animal deletado com sucesso.");
    }
}
