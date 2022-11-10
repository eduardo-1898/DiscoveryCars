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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="encabezado")
public class Encabezado implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long Id;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="FechaVenta")
    private Date Fecha_Venta;

    @ManyToOne
    @JoinColumn(name = "Id_Empleado")
    private Empleado Empleados;
    
    @ManyToOne
    @JoinColumn(name = "Id_Cliente")
    private Cliente Clientes;

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Date getFecha_Venta() {
        return Fecha_Venta;
    }

    public void setFecha_Venta(Date Fecha_Venta) {
        this.Fecha_Venta = Fecha_Venta;
    }

    public Empleado getEmpleados() {
        return Empleados;
    }

    public void setEmpleados(Empleado Empleados) {
        this.Empleados = Empleados;
    }

    public Cliente getClientes() {
        return Clientes;
    }

    public void setClientes(Cliente Clientes) {
        this.Clientes = Clientes;
    }

    
    
}
