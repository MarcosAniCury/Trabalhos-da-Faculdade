package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="pesquisador_691290")
public class Pesquisador implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="cpf")
    private String cpf;

    @Column(name="nome")
    private String nome;

    @OneToOne
    @JoinColumn(name = "instituicao")
    private Instituicao instituicao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Instituicao getInstituicao() {
        return instituicao;
    }

    public void setInstituicao(Instituicao instituicao) {
        this.instituicao = instituicao;
    }
}