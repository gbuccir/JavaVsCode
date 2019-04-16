package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String operacao = request.getParameter("operacao");
		Usuarios usuario;

		String json;
		// json = new Gson().toJson("Erro ao salvar filme");
		// response.setContentType("application/json");
		// response.getWriter().write(json);

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		String cidade = request.getParameter("cidade");
		String estado = request.getParameter("estado");
		String sexo = request.getParameter("sexo");
		String dataNascimento = request.getParameter("dataNascimento");
		String senha = request.getParameter("senha");
		String tipoLogin = request.getParameter("tipoLogin");
		Integer idUser;
		try {
			switch (operacao) {
			case "1":
				// CADASTRO (INSERT)
				usuario = new Usuarios(nome, email, cpf, cidade, estado, sexo, dataNascimento, senha, tipoLogin);
				BD.usuarios.cadastro(usuario);
				json = new Gson().toJson("Usu�rio salvo com sucesso");
				break;
			case "2":
				// ATUALIZAR (UPDATE)
				idUser = Integer.parseInt(request.getParameter("id_user"));
				usuario = new Usuarios(nome, email, cpf, cidade, estado, sexo, dataNascimento, senha, tipoLogin);
				BD.usuarios.atualizar(usuario, idUser);
				json = new Gson().toJson("Dado(s) atualizado(s) com sucesso");
				break;
			case "3":
				// getUser (SELECT)
				Usuarios userLogado;
				userLogado = (Usuarios) BD.usuarios.logado(email, senha);
				json = new Gson().toJson(userLogado);
				break;
			default:
				json = new Gson().toJson("Opera��o desconhecida");
				break;
			}

			response.setContentType("application/json");
			response.getWriter().write(json);
		} catch (Exception e) {
			json = new Gson().toJson("Erro com o usuarios");
			response.setContentType("application/json");
			response.getWriter().write(json);
		}

	}

}
