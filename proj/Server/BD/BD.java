package Service;

import java.sql.*;
import Service.*;

/*  Classe de conexão com o banco.
	precisa dos drivers para fazer a conexao */
public class BD {

	public static final MeuPreparedStatement comando;
	public static final Usuarios usuarios;// um como esse para cada classe DAO (service)

	static {

		MeuPreparedStatement _comando = null;
		Usuarios _usuarios = null; // um como esse para cada classe DAO

		try {
			// Driver e connection string
			_comando = new MeuPreparedStatement("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/baseCineRemoto",
					"root", "root");

			// Connection conn =
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/baseBingo", "root",
			// "root");
			// PreparedStatement statement = conn.prepareStatement(null);
			// statement.executeUpdate();
			_usuarios = new Usuarios();
		} catch (Exception e) {
			System.err.println("Problemas de conexao com o BD");
		}

		comando = _comando;
		usuarios = _usuarios;
	}
}
