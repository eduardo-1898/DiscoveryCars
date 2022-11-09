/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.repository;

import ProyectoConcesionario.ProyectoConcesionario.entity.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RolesRepository extends CrudRepository<Roles, Long>{
    
}
