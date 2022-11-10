/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import ProyectoConcesionario.ProyectoConcesionario.entity.Cliente;
import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import ProyectoConcesionario.ProyectoConcesionario.entity.Roles;
import ProyectoConcesionario.ProyectoConcesionario.services.Empleado.IEmpleadoServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Roles.IRolesServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmpleadosController {
    
    @Autowired
    private IEmpleadoServices _empleadoServices;
    
    @Autowired
    private IRolesServices _rolesServices;
    
    @GetMapping("/Empleados/Nuevo")
    public String CrearEmpleado(Model model){
        List<Roles> listRoles = _rolesServices.getRoles();
        model.addAttribute("empleados", new Empleado());
        model.addAttribute("rol", listRoles);
        return "Empleados/AdmCreacionEmpleado";
    }
    
    @GetMapping("/Empleados/Index")
    public String IndexEmpleado(Model model){
        List<Empleado> listEmployes = _empleadoServices.getEmpleados();
        model.addAttribute("empleados", listEmployes);
        return "Empleados/HistorialAdmEmpleado";
    }
    
    @PostMapping("/Empleados/save")
    public String saveEmpleados(@ModelAttribute Empleado empleados){
        _empleadoServices.saveEmpleados(empleados);
        return "redirect:/Empleados/Index";
    }
}
