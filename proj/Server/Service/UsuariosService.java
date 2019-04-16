package Service;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class UsuariosService extends BD {

	public void cadastro(Usuarios user) throws Exception {
		if (user != null) {
			try {
				String sql;

				sql = "INSERT INTO usuario "
						+ "(nome, email, cpf, cidade, estado, sexo, dataNascimento, senha, tipoLogin)" + "VALUES "
						+ "(?,?,?,?,?,?,?,?,?)";

				BD.comando.prepareStatement(sql);

				BD.comando.setString(1, user.getNome());
				BD.comando.setString(2, user.getEmail());
				BD.comando.setString(3, user.getCpf());
				BD.comando.setString(4, user.getCidade());
				BD.comando.setString(5, user.getEstado());
				BD.comando.setString(6, user.getSexo());
				BD.comando.setString(7, user.getDataNascimento());
				BD.comando.setString(8, user.getSenha());
				BD.comando.setString(9, user.getTipoLogin());

				BD.comando.executeUpdate();
				BD.comando.commit();
			} catch (SQLException erro) {
				throw new Exception("Erro ao cadastrar");
			}
		} else {
			throw new Exception("Usu�rio n�o fornecido");
		}
	}

	public void atualizar(Usuarios user, Integer id) throws Exception {
		if (user != null) {
			try {
				String sql;

				sql = "UPDATE usuario " + "SET nome=? " + ", email=? " + ", cpf=? " + ", cidade=? "
						+ ", estado=? " + ", sexo=? " + ", dataNascimento=? " + ", senha=? " + ", tipoLogin=? " + "WHERE id_user = ?";

				BD.comando.prepareStatement(sql);

				BD.comando.setString(1, user.getNome());
				BD.comando.setString(2, user.getEmail());
				BD.comando.setString(3, user.getCpf());
				BD.comando.setString(4, user.getCidade());
				BD.comando.setString(5, user.getEstado());
				BD.comando.setString(6, user.getSexo());
				BD.comando.setString(7, user.getDataNascimento());
				BD.comando.setString(8, user.getSenha());
				BD.comando.setString(9, user.getTipoLogin());
				if (user.getId_user() == 0)
					user.setId_user(id);

				BD.comando.setInt(10, user.getId_user());

				BD.comando.executeUpdate();
				BD.comando.commit();
			} catch (SQLException erro) {
				throw new Exception("Erro ao atualizar seus dados");
			}
		} else {
			throw new Exception("Usu�rio n�o fornecido");
		}
	}

	public Usuarios logado(String email, String senha) throws Exception {

		Usuarios userLogado = new Usuarios();

		try {
			String sql;

			sql = "SELECT * " + "FROM usuario where email = ? and senha = ?";

			BD.comando.prepareStatement(sql);

			BD.comando.setString(1, email);
			BD.comando.setString(2, senha);

			ResultSet rs = BD.comando.executeQuery();

			while (rs.next()) {

				userLogado.setId_user(rs.getInt("id_user"));
				userLogado.setNome(rs.getString("nome"));
				userLogado.setEmail(rs.getString("email"));
				userLogado.setCpf(rs.getString("cpf"));
				userLogado.setCidade(rs.getString("cidade"));
				userLogado.setEstado(rs.getString("estado"));
				userLogado.setSexo(rs.getString("sexo"));
				userLogado.setDataNascimento(rs.getString("dataNascimento"));
				userLogado.setSenha(rs.getString("senha"));
				userLogado.setTipoLogin(rs.getString("tipoLogin"));

			}
			rs.close();
			// ps.close();

		} catch (SQLException erro) {
			throw new Exception("Login ou senha incorretos");
		}

		return userLogado;

	}

}
