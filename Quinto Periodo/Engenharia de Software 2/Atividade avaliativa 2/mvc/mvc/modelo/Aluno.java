// To change this license header, choose License Headers in Project Properties.
// To change this template file, choose Tools | Templates
// and open the template in the editor.

package mvc.modelo;

import java.util.Date;

public class Aluno implements java.io.Serializable
{
    private static final long serialVersionUID = 1L;
    private String dre;
    private String nome;
    private String telefone;
    private String endereco;
    private Date dataNasc;

    public Aluno(String dre, String nome, String telefone, String endereco, Date dataNasc) 
    {
        super();
        this.dre = dre;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
    }

    public String getDre() 
    {
        return dre;
    }

    public void setDre(String dre) 
    {
        this.dre = dre;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getTelefone()
    {
        return this.telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

    public String getEndereco()
    {
        return this.endereco;
    }

    public void setEndereco(String endereco)
    {
        this.endereco = endereco;
    }

    public Date getDataNasc()
    {
        return this.dataNasc;
    }

    public void setDataNasc(Date dataNasc)
    {
        this.dataNasc = dataNasc;
    }
}

