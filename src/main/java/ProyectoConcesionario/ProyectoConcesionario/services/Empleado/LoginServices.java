/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Empleado;

import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import ProyectoConcesionario.ProyectoConcesionario.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServices implements ILoginServices{

    @Autowired
    private LoginRepository _loginRepository;
    
    @Override
    public Empleado validateAccess(String user, String password) {
        return _loginRepository.getDataAccess(user, password);
    }
    
}
