package br.com.natheuscalaca.timemaluco.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "TELEFONE")
public class Telefone extends PanacheEntity {

    @Column(name = "TELEFONE_DDD")
    private String ddd;
    @Column(name = "TELEFONE_NUMERO")
    private String numero;
    @Column(name = "TELEFONE_TIPO")
    private String tipo;

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



}
