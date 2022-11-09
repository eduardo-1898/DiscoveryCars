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
@Table(name="Mantenimiento")
public class Mantenimiento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdMantenimiento;
    private String Placa;
    private Long IdDepartamento;
    private Long IdEmpleado;
    private String DescripcionMantenimiento;
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date FechaIngreso;

    public Long getIdMantenimiento() {
        return IdMantenimiento;
    }

    public void setIdMantenimiento(Long IdMantenimiento) {
        this.IdMantenimiento = IdMantenimiento;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public Long getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(Long IdDepartamento) {
        this.IdDepartamento = IdDepartamento;
    }

    public Long getIdEmpleado() {
        return IdEmpleado;
    }

    public void setIdEmpleado(Long IdEmpleado) {
        this.IdEmpleado = IdEmpleado;
    }

    public String getDescripcionMantenimiento() {
        return DescripcionMantenimiento;
    }

    public void setDescripcionMantenimiento(String DescripcionMantenimiento) {
        this.DescripcionMantenimiento = DescripcionMantenimiento;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date FechaIngreso) {
        this.FechaIngreso = FechaIngreso;
    }
    
    
    
}
