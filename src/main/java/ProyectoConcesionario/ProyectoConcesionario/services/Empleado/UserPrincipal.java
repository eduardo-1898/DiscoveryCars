package ProyectoConcesionario.ProyectoConcesionario.services.Empleado;

import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class UserPrincipal implements UserDetails {

    private Empleado empleado;

    public UserPrincipal(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(this.empleado.getRoles()
                .getNombre_Role());
        authorities.add(authority);
        GrantedAuthority authorityroles = new SimpleGrantedAuthority("ROLE_"+this.empleado.getRoles()
                .getNombre_Role());
        authorities.add(authorityroles);
        
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        
        session.setAttribute("usersession", empleado);
        
        return authorities;
    }
    

    @Override
    public String getPassword() {
        return this.empleado.getPassword();
    }

    @Override
    public String getUsername() {
        return this.empleado.getNombre_Usuario();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.empleado.getActive() == 1;
    }

}
