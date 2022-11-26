/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import ProyectoConcesionario.ProyectoConcesionario.services.Empleado.IEmpleadoServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Empleado.ILoginServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @Autowired
    private IEmpleadoServices _empleadoServices;

    @Autowired
    private ILoginServices _loginServices;

    @GetMapping("/Login/index")
    public String CrearClientes(Model model) {
        model.addAttribute("empleados", new Empleado());
        return "index";
    }

    @PostMapping("/Login/SingUp")
    public String ValidateAccess(@ModelAttribute Empleado empleado) {
        var response = _loginServices.validateAccess(empleado.getNombre_Usuario(), empleado.getPassword());
        //Operador ternario para validar si el usuario y la contraseña son correctos
//        return (response!= null)? "redirect:/Home/Index" : "redirect:/Login/index";
        return "redirect:/Home/Index";
    }
}
