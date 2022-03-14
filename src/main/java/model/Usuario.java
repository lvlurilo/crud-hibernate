package model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@NamedQueries({
	
	@NamedQuery(name = "Usuario.readAll", query = "SELECT u FROM Usuario u"),
 	@NamedQuery(name = "Usuario.readOne", query = "SELECT u FROM Usuario u WHERE u.nome = :nome")
	
})

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String cidade;
	@Column(nullable = false)
	private int idade;
	
	@OneToMany(mappedBy = "usuarioTelefone", fetch=FetchType.EAGER) //é necessario relacionar a tabela/classe pai com filho,  para issp usa o mappedby idicando a coluna que o representa e com o @ contrario ao do filho,
	private List<TelefoneUsuario> Telefone;  //list pois sao varios telefones
	
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public List<TelefoneUsuario> getTelefone() {
		return Telefone;
	}
	public void setTelefone(List<TelefoneUsuario> telefone) {
		Telefone = telefone;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", cidade=" + cidade + ", idade=" + idade + "]";
	}
	
	
		

}
