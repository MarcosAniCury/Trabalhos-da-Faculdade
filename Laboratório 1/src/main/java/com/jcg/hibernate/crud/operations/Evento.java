package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="1266642_evento")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="nome_evento")
	private String NomeEvento;

	@Column(name="data")
	private String Data;

	@Column(name="hora")
	private String Hora;

	@Column(name="logradouro")
	private String Logradouro;

	@Column(name="numero")
	private String Numero;

	@Column(name="id_bairro")
	private int IdBairro;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeEvento() {
		return NomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		NomeEvento = nomeEvento;
	}

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public String getLogradouro() {
		return Logradouro;
	}

	public void setLogradouro(String logradouro) {
		Logradouro = logradouro;
	}

	public String getNumero() {
		return Numero;
	}

	public void setNumero(String numero) {
		Numero = numero;
	}

	public int getIdBairro() {
		return IdBairro;
	}

	public void setIdBairro(int idBairro) {
		IdBairro = idBairro;
	}

	@Override
	public String toString() {
		return "Evento{" +
				"id=" + id +
				", NomeEvento='" + NomeEvento + '\'' +
				", Data='" + Data + '\'' +
				", Hora='" + Hora + '\'' +
				", Logradouro='" + Logradouro + '\'' +
				", Numero='" + Numero + '\'' +
				", IdBairro=" + IdBairro +
				'}';
	}
}