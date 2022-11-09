/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Roles;

import ProyectoConcesionario.ProyectoConcesionario.entity.Roles;
import ProyectoConcesionario.ProyectoConcesionario.repository.RolesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Eduardo JA
 */
public class RolesServices implements IRolesServices{

    @Autowired
    private RolesRepository _rolesRepository;
    
    @Override
    public List<Roles> getRoles() {
        return (List<Roles>) _rolesRepository.findAll();
    }

    @Override
    public Roles getRolesById(long id) {
        return _rolesRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteRoles(long id) {
        _rolesRepository.deleteById(id);
    }

    @Override
    public void saveRoles(Roles roles) {
        _rolesRepository.save(roles);
    }
    
}
