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
@Table(name="Departamento")
public class Departamento implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdDepartamento;
    private String NombreDepartamento;

    public Long getIdDepartamento() {
        return IdDepartamento;
    }

    public void setIdDepartamento(Long IdDepartamento) {
        this.IdDepartamento = IdDepartamento;
    }

    public String getNombreDepartamento() {
        return NombreDepartamento;
    }

    public void setNombreDepartamento(String NombreDepartamento) {
        this.NombreDepartamento = NombreDepartamento;
    }
    
    
}
