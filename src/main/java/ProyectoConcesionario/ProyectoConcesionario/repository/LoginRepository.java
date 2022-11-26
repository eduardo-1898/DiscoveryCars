/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.repository;

import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepository extends JpaRepository<Empleado, Long>{
    
    @Query("SELECT o FROM Empleado o WHERE o.Nombre_Usuario = :Nombre_Usuario and o.Password = :Password")
    public Empleado getDataAccess(
            @Param("Nombre_Usuario") String Nombre_Usuario, 
            @Param("Password") String Password);
    
}
