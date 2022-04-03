package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="artigo_691290")
public class Artigo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="codigo")
    private int codigo;

    @Column(name="titulo")
    private String titulo;

    @Column(name="pagina_inicial")
    private String paginaInicial;

    @Column(name="pagina_final")
    private String paginaFinal;

    @OneToOne
    @JoinColumn(name = "veiculo_de_publicacao")
    private VeiculoDePublicacao veiculoDePublicacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        titulo = titulo;
    }

    public String getPaginaInicial() {
        return paginaInicial;
    }

    public void setPaginaInicial(String paginaInicial) {
        paginaInicial = paginaInicial;
    }

    public String getPaginaFinal() {
        return paginaFinal;
    }

    public void setPaginaFinal(String paginaFinal) {
        paginaFinal = paginaFinal;
    }

    public VeiculoDePublicacao getVeiculoDePublicacao() {
        return veiculoDePublicacao;
    }

    public void setVeiculoDePublicacao(VeiculoDePublicacao veiculoDePublicacao) {
        this.veiculoDePublicacao = veiculoDePublicacao;
    }
}