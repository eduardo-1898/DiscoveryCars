
package ProyectoConcesionario.ProyectoConcesionario.services.Empleado;

import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService{
    
    @Autowired
    public IEmpleadoServices empleadoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Empleado empleado = this.empleadoService.findByNombre_Usuario(username);
        UserPrincipal userPrincipal = new UserPrincipal(empleado);
        return userPrincipal;       
    }
    
}
