package com.jcg.hibernate.crud.operations;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="1266642_bairro")
public class Bairro implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="nome")
    private String Nome;

    @Column(name="id_regional")
    private String Id_Regional;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getIdRegional() {
        return Id_Regional;
    }

    public void setIdRegional(String id_Regional) {
        Id_Regional = id_Regional;
    }

    @Override
    public String toString() {
        return "Bairro{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", Id_Regional='" + Id_Regional + '\'' +
                '}';
    }
}