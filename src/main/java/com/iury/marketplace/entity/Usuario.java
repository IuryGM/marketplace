package com.iury.marketplace.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_usuario", nullable = false)
    private TipoUsuario tipo;

    @ManyToMany(mappedBy = "usuarios", fetch = FetchType.LAZY)
    private List<Estoque> estoque;

    @OneToMany(mappedBy = "usuario")
    List<Compra> compras;

    public Usuario() {
    }

    public Usuario(Long id, TipoUsuario tipo, List<Estoque> estoque, List<Compra> compras) {
        this.id = id;
        this.tipo = tipo;
        this.estoque = estoque;
        this.compras = compras;
    }
    
    public List<Estoque> getEstoque() {
        return this.estoque;
    }

    public void setEstoque(List<Estoque> estoque) {
        this.estoque = estoque;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoUsuario getTipo() {
        return this.tipo;
    }

    public void setTipo(TipoUsuario tipo) {
        this.tipo = tipo;
    }

    public List<Compra> getCompras() {
        return this.compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

}
