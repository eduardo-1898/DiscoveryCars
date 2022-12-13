/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Venta")
public class Venta implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long Id; 
    
    @Column(name="Placa")
    private String Placa;
        
    @Column(name="Precio_Venta")
    private Long Precio_Venta;
    
    @Column(name="Factura")
    private Long Id_Factura;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public Long getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(Long Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }

    public Long getId_Factura() {
        return Id_Factura;
    }

    public void setId_Factura(Long Id_Factura) {
        this.Id_Factura = Id_Factura;
    }

    
    
}
