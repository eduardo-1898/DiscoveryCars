/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import ProyectoConcesionario.ProyectoConcesionario.entity.Departamento;
import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import ProyectoConcesionario.ProyectoConcesionario.entity.Mantenimiento;
import ProyectoConcesionario.ProyectoConcesionario.services.Departamento.IDepartamentoServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Empleado.IEmpleadoServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Mantenimiento.IMantenimientoServices;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MantenimientoController {
    
    @Autowired
    private IMantenimientoServices _mantenimientoServices;
    
    @Autowired
    private IDepartamentoServices _departamentoServices;
    
    @Autowired
    private IEmpleadoServices _empleadoServices;
    
    @GetMapping("/Mantenimiento/Index")
    public String IndexMantenimientos(){ 
        return "Mantenimiento/HistorialMantenimiento";
    }
    
    @PostMapping("/Mantenimiento/save")
    public String saveMantenimiento(@ModelAttribute Mantenimiento mantenimiento){
        _mantenimientoServices.saveMantenimientos(mantenimiento);
        return "redirect:/Clientes/Index";
    }
    
    @GetMapping("/Mantenimiento/Nuevo")
    public String CrearMantenimiento(Model model){
        
        List<Departamento> listDepartments = _departamentoServices.getDepartamentos();
        Collections.sort(listDepartments, (a, b)->{
            return a.getNombreDepartamento().compareTo(b.getNombreDepartamento());
        });
        
        List<Empleado> listEmployees = _empleadoServices.getEmpleados();
        Collections.sort(listEmployees, (a, b)->{
            return a.getNombre_Usuario().compareTo(b.getNombre_Usuario());
        });
        
        model.addAttribute("empleado", listEmployees);
        model.addAttribute("departamento", listDepartments);
        model.addAttribute("mantenimiento", new Mantenimiento());
        return "Mantenimiento/RegistroMantenimiento";
    }
    
}
