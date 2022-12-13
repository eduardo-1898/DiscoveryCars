package ProyectoConcesionario.ProyectoConcesionario.repository;

import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

    @Query("SELECT o FROM Empleado o WHERE o.Nombre_Usuario = :Nombre_Usuario")
    public Empleado findByNombreUsuario(@Param("Nombre_Usuario") String Nombre_Usuario);

}
