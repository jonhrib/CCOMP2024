package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Protetor extends Conexão {

	public Protetor() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void cadastrarProtetor(String cpf, String rg, String nome, String endereco, String telefone, int qtdGatos, int qtdCaes, double qtdRacao) throws SQLException {
        // SQL de inserção
		qtdRacao = (qtdGatos * 2500) + (qtdCaes * 5000);
		cpf = formatarCpf(cpf);
		telefone = formatarTelefone(telefone);
		
        String sql = "INSERT INTO Protetor (Cpf, RG, Nome, Endereco, Telefone, Qtd_gatos, Qtd_caes, Qtd_racao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        // Prepara o comando SQL
        PreparedStatement stmt = con.prepareStatement(sql);
        
        // Define os parâmetros
        stmt.setString(1, cpf);
        stmt.setString(2, rg);
        stmt.setString(3, nome);
        stmt.setString(4, endereco);
        stmt.setString(5, telefone);
        stmt.setInt(6, qtdGatos);
        stmt.setInt(7, qtdCaes);
        stmt.setDouble(8, qtdRacao);
        
        // Executa o comando de inserção
        stmt.executeUpdate();
        
        System.out.println("Protetor cadastrado com sucesso.");
    }

	
	public List<String[]> encontrarProtetores() throws SQLException {
	    Statement stmt = con.createStatement();
	    
	    // Lista para armazenar os dados
	    List<String[]> protetoresList = new ArrayList<>();
	    
	    // Executa a consulta SQL para buscar os dados da tabela Protetor
	    ResultSet dados = stmt.executeQuery("SELECT Cpf, RG, Nome, Endereco, Telefone, Qtd_gatos, Qtd_caes, Qtd_racao FROM Protetor");
	    
	    // Verifica se o ResultSet tem resultados
	    while (dados.next()) {
	        String cpf = dados.getString("Cpf");
	        String rg = dados.getString("RG");
	        String nome = dados.getString("Nome");
	        String endereco = dados.getString("Endereco");
	        String telefone = dados.getString("Telefone");
	        String qtdGatos = String.valueOf(dados.getInt("Qtd_gatos"));
	        String qtdCaes = String.valueOf(dados.getInt("Qtd_caes"));
	        String qtdRacao = String.valueOf(dados.getDouble("Qtd_racao"));
	        
	        // Adiciona os dados à lista
	        protetoresList.add(new String[]{cpf, rg, nome, endereco, telefone, qtdGatos, qtdCaes, qtdRacao});
	    }
	    
	    // Retorna a lista de protetores
	    return protetoresList;
	}
	
	public String[] encontrarProtetor(String cpfProcurado) throws SQLException {
		
		String cpfFormatado = formatarCpf(cpfProcurado);
	    // Prepara a consulta SQL com o parâmetro CPF
	    String sql = "SELECT Cpf, RG, Nome, Endereco, Telefone, Qtd_gatos, Qtd_caes, Qtd_racao FROM Protetor WHERE Cpf = ?";
	    
	    // Prepara a declaração SQL para evitar SQL injection
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setString(1, cpfFormatado);
	    
	    // Executa a consulta
	    ResultSet dados = stmt.executeQuery();
	    
	    // Verifica se o resultado foi encontrado
	    if (dados.next()) {
	        String cpf = dados.getString("Cpf");
	        String rg = dados.getString("RG");
	        String nome = dados.getString("Nome");
	        String endereco = dados.getString("Endereco");
	        String telefone = dados.getString("Telefone");
	        String qtdGatos = String.valueOf(dados.getInt("Qtd_gatos"));
	        String qtdCaes = String.valueOf(dados.getInt("Qtd_caes"));
	        String qtdRacao = String.valueOf(dados.getDouble("Qtd_racao"));
	        
	        // Retorna os dados do protetor como um array de Strings
	        return new String[]{cpf, rg, nome, endereco, telefone, qtdGatos, qtdCaes, qtdRacao};
	    }
	    
	    // Se não encontrar o CPF, retorna null
	    return null;
	}
	
	public boolean protetorExiste(String cpfSemFormatacao) throws SQLException {
	    // Formata o CPF sem formatação para o padrão "###.###.###-##"
	    String cpfFormatado = formatarCpf(cpfSemFormatacao);

	    // Prepara a consulta SQL para verificar se o protetor já existe
	    String sql = "SELECT COUNT(*) FROM Protetor WHERE Cpf = ?";

	    // Prepara a declaração SQL
	    PreparedStatement stmt = con.prepareStatement(sql);
	    stmt.setString(1, cpfFormatado);

	    // Executa a consulta
	    ResultSet rs = stmt.executeQuery();
	    rs.next();

	    // Retorna true se o protetor já existir, caso contrário, false
	    return rs.getInt(1) > 0;
	}

	// Método auxiliar para formatar o CPF
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



	public void atualizarProtetor(String novoNome, String novoEndereco, String novoTelefone,
			int novaQtdGatos, int novaQtdCaes, String cpf) throws SQLException {
		cpf = formatarCpf(cpf);
		String SQLInsert = "update Protetor set Nome = '" + novoNome + "', Endereco = '" + novoEndereco + "', Telefone = '" + novoTelefone + "', Qtd_gatos = " + novaQtdGatos + ", Qtd_caes = " + novaQtdCaes +  " where Cpf = '" + cpf + "'";
		Statement stmts = con.createStatement();
		stmts.executeUpdate(SQLInsert);
		
	}



}
