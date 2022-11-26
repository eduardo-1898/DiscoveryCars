package ProyectoConcesionario.ProyectoConcesionario;

import ProyectoConcesionario.ProyectoConcesionario.services.Empleado.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userDetailsService;

    //todavia hay que setear las claves encriptadas en la BD
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService getUserService() {
        return new UserService();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(getUserService());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    public SecurityConfig(UserService userPrincipalDetailService) {
        this.userDetailsService = userPrincipalDetailService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/Home/Index",
                        "/Login",
                        "/Mantenimiento/HistorialMantenimiento",
                        "/Mantenimiento/RegistroMantenimiento")
                .hasRole("Mantenimientos")
                .antMatchers("/Home/Index",
                        "/Login",
                        "/Vehiculos/Nuevo",
                        "/Vehiculos/Index")
                .hasAnyRole("Ventas")
                .antMatchers("/Home/Index",
                        "/Login",
                        "/Clientes/Nuevo",
                        "/Clientes/Index",
                        "/Empleados/Nuevo",
                        "/Empleados/Index",
                        "/Mantenimiento/Index",
                        "/Mantenimiento/Nuevo",
                        "/Vehiculos/Nuevo",
                        "/Vehiculos/Index",
                        "/Ventas/Crear")
                .hasAnyRole("Administrador")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/Login").permitAll()
                .defaultSuccessUrl("/Home/Index", true);

    }

}
