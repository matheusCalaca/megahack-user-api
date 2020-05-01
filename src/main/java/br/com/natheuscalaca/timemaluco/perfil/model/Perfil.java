package br.com.natheuscalaca.timemaluco.perfil.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.NavigableMap;
import java.util.Objects;

@Entity
@Table(name = "PERFIL")
public class Perfil extends PanacheEntity {


    @NotNull(message = "Nome Perfil não pode ser null")
    @Column(name = "PREFIL_NOME", unique = true)
    private String nome;
    @NotNull(message = "Cor Perfil não pode ser null")
    @Column(name = "PERFIL_COR", unique = true)
    private String cor;


    /**
     *
     * Salva o Perfil e retorna o mesmo
     *
     * @param perfil perfil para slavar
     * @return retorna o perfil salvo
     */
    public static Perfil saveAndReturn(Perfil perfil){
        persist(perfil);
        Perfil perfilSalve =  find("PREFIL_NOME", perfil.nome).firstResult();
        System.out.println(perfil.getId());
        return perfilSalve;
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

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Perfil perfil = (Perfil) o;
        return Objects.equals(id, perfil.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
