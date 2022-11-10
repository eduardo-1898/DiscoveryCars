/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Roles;
import ProyectoConcesionario.ProyectoConcesionario.entity.Roles;
import java.util.List;


public interface IRolesServices {
    public List<Roles> getRoles();
    public Roles getRolesById(long id);
    public void deleteRoles(long id);
    public void saveRoles(Roles roles);
}
