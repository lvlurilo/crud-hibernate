package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class TelefoneUsuario {

	@Id // torna a variavel o id da tabela
	@GeneratedValue(strategy = GenerationType.AUTO) // torna a geraçao do id incremental automatica
	private Long id;

	@Column(nullable = false) // coluna nao pode estar vazia
	private String numero;

	@ManyToOne(optional = false, fetch = FetchType.EAGER) // manytoone = relacao muitos para um, interpretar de cima
															// para baixo (mtos telefone para um usuario)
	// optional false = torna o dado obrigatorio
	// fetch eager = sempre carrega os dados quando buscado
	private Usuario usuarioTelefone;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Usuario getUsuarioTelefone() {
		return usuarioTelefone;
	}

	public void setUsuarioTelefone(Usuario usuarioTelefone) {
		this.usuarioTelefone = usuarioTelefone;
	}

	@Override
	public String toString() {
		return "TelefoneUsuario [id=" + id + ", numero=" + numero + ", usuarioTelefone=" + usuarioTelefone + "]";
	}

}
