/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehiculos")
public class Vehiculos implements Serializable {
    
    @Id
    @Column(name="placa")
    private String placa;
    
    @Column(name="Ano")
    private Long Ano;
        
    @Column(name="Color")
    private String Color;
            
    @Column(name="PrecioCompra")
    private Long Precio_Compra;
                
    @Column(name="Estado")
    private boolean Estado;
    
    @ManyToOne
    @JoinColumn(name = "id_Marca")
    private Marca Marcas;
    
    @ManyToOne
    @JoinColumn(name = "id_Modelo")
    private Modelo Modelos;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getAno() {
        return Ano;
    }

    public void setAno(Long Ano) {
        this.Ano = Ano;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public Long getPrecio_Compra() {
        return Precio_Compra;
    }

    public void setPrecio_Compra(Long Precio_Compra) {
        this.Precio_Compra = Precio_Compra;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public Marca getMarcas() {
        return Marcas;
    }

    public void setMarcas(Marca Marcas) {
        this.Marcas = Marcas;
    }

    public Modelo getModelos() {
        return Modelos;
    }

    public void setModelos(Modelo Modelos) {
        this.Modelos = Modelos;
    }
    

}
