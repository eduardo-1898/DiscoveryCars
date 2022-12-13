/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.repository;

import ProyectoConcesionario.ProyectoConcesionario.entity.Encabezado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eduardo JA
 */
@Repository
public interface EncabezadoRepository extends JpaRepository<Encabezado, Long> {
 
    @Query("SELECT o FROM Encabezado o WHERE o.id = (SELECT MAX(a.id) FROM Encabezado a)")
    public Encabezado findLastInsert();
}
