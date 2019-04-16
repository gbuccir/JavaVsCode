package Service;

import java.sql.*;

public class Usuarios {

	//cada atributo da classe Usuario, geralmente um espelho das colunas do banco
	private int id_user;
	private String nome;
	private String email;
	private String cpf;
	private String cidade;
	private String estado;
	private String sexo;
	private String dataNascimento;
	private String senha;
	private String tipoLogin;

	//Por causa das variaveis serem 'private' para guardar e retornar os valores precisa dos metodos getters e setters

	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getTipoLogin() {
		return tipoLogin;
	}
	public void setTipoLogin(String tipoLogin) {
		this.tipoLogin = tipoLogin;
	}


	//hashCode é um metodo obrigatorio quando cria uma classe, torna um objeto unico (gera um 'rg' pro obj)
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((dataNascimento == null) ? 0 : dataNascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + id_user;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
		result = prime * result + ((tipoLogin == null) ? 0 : tipoLogin.hashCode());
		return result;
	}


//Equals tambem é um metodo obrigatorio, server para comparar dois obj do tipo Usuario
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DBOUsuarios other = (DBOUsuarios) obj;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (dataNascimento == null) {
			if (other.dataNascimento != null)
				return false;
		} else if (!dataNascimento.equals(other.dataNascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id_user != other.id_user)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		if (sexo == null) {
			if (other.sexo != null)
				return false;
		} else if (!sexo.equals(other.sexo))
			return false;
		if (tipoLogin == null) {
			if (other.tipoLogin != null)
				return false;
		} else if (!tipoLogin.equals(other.tipoLogin))
			return false;
		return true;
	}

	//ToString tambem é metodo obrigatorio, retorna o obj em forma de String
	@Override
	public String toString() {
		return "DBOUsuarios [id_user=" + id_user + ", nome=" + nome + ", email=" + email + ", cpf=" + cpf + ", cidade="
				+ cidade + ", estado=" + estado + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", senha="
				+ senha + ", tipoLogin=" + tipoLogin + "]";
	}
	


	//Construtor, para criar um obj ja com os valores atribuidos
	public Usuarios(String nome, String email, String cpf, String cidade, String estado, String sexo,
			String dataNascimento, String senha, String tipoLogin) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.cidade = cidade;
		this.estado = estado;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.tipoLogin = tipoLogin;
	}
	
	public Usuarios() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	//Gera um clone do objeto Usuario
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	

}
