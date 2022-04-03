package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="grupo_pesquisador_artigo_691290")
public class GrupoPesquisadorArtigo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "artigo")
    private Artigo artigo;

    @ManyToOne
    @JoinColumn(name = "pesquisador")
    private Pesquisador pesquisador;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public Pesquisador getPesquisador() {
        return pesquisador;
    }

    public void setPesquisador(Pesquisador pesquisador) {
        this.pesquisador = pesquisador;
    }
}