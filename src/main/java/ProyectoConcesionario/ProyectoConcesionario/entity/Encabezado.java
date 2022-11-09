/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="encabezado")
public class Encabezado implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdFactura;
    private Long IdEmpleado; 
    private Long IdCliente;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaVenta;

    public Long getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(Long IdFactura) {
        this.IdFactura = IdFactura;
    }

    public Long getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Long IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public Long getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(Long IdCliente) {
        this.IdCliente = IdCliente;
    }

    public Date getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(Date FechaVenta) {
        this.FechaVenta = FechaVenta;
    }
    
}
