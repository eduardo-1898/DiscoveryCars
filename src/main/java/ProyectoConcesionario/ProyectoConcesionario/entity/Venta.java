/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.entity;

import java.io.Serializable;
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
    private Long IdVenta; 
    
    private Long IdFactura;
    private String Placa;
    private int PrecioVenta;

    public Long getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(Long IdVenta) {
        this.IdVenta = IdVenta;
    }

    public Long getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(Long IdFactura) {
        this.IdFactura = IdFactura;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public int getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(int PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }
    
    
    
}
