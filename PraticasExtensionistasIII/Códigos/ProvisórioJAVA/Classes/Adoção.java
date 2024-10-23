package Classes;

import java.beans.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Adoção extends Conexão{

	Adoção() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<String[]> encontradados () throws SQLException {
		java.sql.Statement stmt = con.createStatement();
		
		// Lista para armazenar os dados
	    List<String[]> dadosList = new ArrayList<>();
	    
	    ResultSet dados = stmt.executeQuery("SELECT adotante_cpf, animal_codigo FROM adocao");
	    
	    // Verifica se o ResultSet tem resultados
	    while (dados.next()) {
	        String adotante_cpf = dados.getString("adotante_cpf");
	        String animal_codigo = dados.getString("animal_codigo");
	        
	        // Adiciona o par de dados à lista
	        dadosList.add(new String[]{adotante_cpf, animal_codigo});
	    }
	    
	    // Converte a lista para um array 2D
	    return dadosList;
	}
}
