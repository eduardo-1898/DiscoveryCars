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
        http.authorizeRequests().antMatchers("/**/*.js",
                "/**/*.css",
                "/**/*.jpg",
                "/**/*.JPG").permitAll()
                .antMatchers("/Home/Index",
                        "/Login/index",
                        "/Login/SingUp",
                        "/Mantenimiento/Index",
                        "/Mantenimiento/save",
                        "/Mantenimiento/Nuevo",
                        "/Mantenimiento/Actualizar/{id}",
                        "/Mantenimiento/delete/{id}")
                .hasAnyRole("Mantenimientos")
                .antMatchers("/Home/Index",
                        "/Login/index",
                        "/Login/SingUp",
                        "/Clientes/Nuevo",
                        "/Clientes/save",
                        "/Clientes/Actualizar/{id}",
                        "/Clientes/Index",
                        "/Vehiculos/Nuevo",
                        "/Vehiculos/Actualizar/{id}",
                        "/Vehiculos/save",
                        "/Vehiculos/Index")
                .hasAnyRole("Ventas")
                .antMatchers("/Home/Index",
                        "/Login/index",
                        "/Login/SingUp",
                        "/Clientes/Nuevo",
                        "/Clientes/save",
                        "/Clientes/Actualizar/{id}",
                        "/Clientes/Index",
                        "/Empleados/Nuevo",
                        "/Empleados/Actualizar/{id}",
                        "/Empleados/Index",
                        "/Empleados/save",
                        "/Mantenimiento/Index",
                        "/Mantenimiento/save",
                        "/Mantenimiento/Nuevo",
                        "/Mantenimiento/Actualizar/{id}",
                        "/Mantenimiento/delete/{id}",
                        "/Vehiculos/Nuevo",
                        "/Vehiculos/Actualizar/{id}",
                        "/Vehiculos/save",
                        "/Vehiculos/Index",
                        "/Ventas/Crear")
                .hasAnyRole("Administrador")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .defaultSuccessUrl("/Home/Index", true);

    }

}
