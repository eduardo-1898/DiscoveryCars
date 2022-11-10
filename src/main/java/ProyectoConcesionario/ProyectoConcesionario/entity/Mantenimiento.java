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
@Table(name="Mantenimiento")
public class Mantenimiento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Id")
    private Long Id;
    
    @Column(name="Placa")
    private String Placa;
    
    @Column(name="DescripcionMantenimiento")
    private String Descripcion_Mantenimiento;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="FechaIngreso")
    private Date Fecha_Ingreso;
    
    @ManyToOne
    @JoinColumn(name = "Id_Departamento")
    private Departamento Departamentos;
    
    @ManyToOne
    @JoinColumn(name = "Id_Empleado")
    private Empleado Empleados;

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

    public String getDescripcion_Mantenimiento() {
        return Descripcion_Mantenimiento;
    }

    public void setDescripcion_Mantenimiento(String Descripcion_Mantenimiento) {
        this.Descripcion_Mantenimiento = Descripcion_Mantenimiento;
    }

    public Date getFecha_Ingreso() {
        return Fecha_Ingreso;
    }

    public void setFecha_Ingreso(Date Fecha_Ingreso) {
        this.Fecha_Ingreso = Fecha_Ingreso;
    }

    public Departamento getDepartamentos() {
        return Departamentos;
    }

    public void setDepartamentos(Departamento Departamentos) {
        this.Departamentos = Departamentos;
    }

    public Empleado getEmpleados() {
        return Empleados;
    }

    public void setEmpleados(Empleado Empleados) {
        this.Empleados = Empleados;
    }

    
    
}
