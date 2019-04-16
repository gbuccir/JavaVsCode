package Service;

import java.sql.*;
import Service.*;

public class BD {
	
	public static final MeuPreparedStatement comando;
    public static final DAOSFilmes filmes; //um como esse para cada classe DAO
    public static final DAOSUsuarios usuarios;


	static {

		MeuPreparedStatement _comando = null;
		DAOSFilmes _filmes = null; // um como esse para cada classe DAO
		DAOSUsuarios _usuarios = null; 

		try {

			_comando = new MeuPreparedStatement("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/baseCineRemoto", "root", "root");

			// Connection conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/baseBingo", "root",
			// "root");
			// PreparedStatement statement = conn.prepareStatement(null);
			// statement.executeUpdate();
            _filmes = new DAOSFilmes ();
            _usuarios = new DAOSUsuarios();
		} catch (Exception e) {
			System.err.println("Problemas de conexao com o BD");
		}

		comando = _comando;
		filmes = _filmes;
		usuarios = _usuarios;
	}
}
