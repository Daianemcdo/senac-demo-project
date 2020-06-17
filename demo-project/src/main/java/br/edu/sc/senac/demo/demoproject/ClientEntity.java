package br.edu.sc.senac.demo.demoproject;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Client")
final class ClientEntity implements Serializable {

	private static final long serialVersionUID = -1680063932529930775L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Colum
	private Long clientId;

	@Colum
	private String nome;

	@Colum
	private String dataNascimento;

	@Colum
	private String email;

	protected ClientEntity() {

	}

	public ClientEntity(final String nome, final String dataNascimento, final String email) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

	@Override
	public String toString() {
		return "ClientEntity [clientId=" + this.clientId + ", nome=" + this.nome + ", dataNascimento="
				+ this.dataNascimento + ", email=" + this.email + "]";
	}

	public Long getClientId() {
		return this.clientId;
	}

	public void setNome(final String nome) {
		if (nome != null) {
			this.nome = nome;
		}
	}

	public String getNome() {
		return this.nome;
	}

	public void setDataNascimento(final String dataNascimento) {
		if (dataNascimento != null) {
			this.dataNascimento = dataNascimento;
		}
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		if (email != null) {
			this.email = email;
		}
	}

}
