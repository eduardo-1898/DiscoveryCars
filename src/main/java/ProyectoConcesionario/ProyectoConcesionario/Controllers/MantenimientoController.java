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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Mantenimiento/")
public class MantenimientoController {
    
    @Autowired
    private IMantenimientoServices _mantenimientoServices;
    
    @Autowired
    private IDepartamentoServices _departamentoServices;
    
    @Autowired
    private IEmpleadoServices _empleadoServices;
    
    @GetMapping("Index")
    public String IndexMantenimientos(Model model){
        List<Mantenimiento> listMantenimientos = _mantenimientoServices.getMantenimientos();
        model.addAttribute("mantenimientos", listMantenimientos);
        return "Mantenimiento/HistorialMantenimiento";
    }
    
    @PostMapping("save")
    public String saveMantenimiento(@ModelAttribute Mantenimiento mantenimiento){
        _mantenimientoServices.saveMantenimientos(mantenimiento);
        return "redirect:/Mantenimiento/Index";
    }
    
    @GetMapping("Nuevo")
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
    
    @GetMapping("Actualizar/{id}")
    public String ActualizarMantenimiento(@PathVariable("id") Long idMantenimiento, Model model){
        
        List<Departamento> listDepartments = _departamentoServices.getDepartamentos();
        Collections.sort(listDepartments, (a, b)->{
            return a.getNombreDepartamento().compareTo(b.getNombreDepartamento());
        });
        
        List<Empleado> listEmployees = _empleadoServices.getEmpleados();
        Collections.sort(listEmployees, (a, b)->{
            return a.getNombre_Usuario().compareTo(b.getNombre_Usuario());
        });
        Mantenimiento getMaintenance = _mantenimientoServices.getMantenimientosById(idMantenimiento);
        
        model.addAttribute("empleado", listEmployees);
        model.addAttribute("departamento", listDepartments);
        model.addAttribute("mantenimiento", getMaintenance);
        return "Mantenimiento/UpdateMaintenance";
    }
    
    @GetMapping("delete/{id}")
    public String deleteConcierto(@PathVariable("id") long idMantenimiento){
        _mantenimientoServices.deleteMantenimientos(idMantenimiento);
        return "redirect:/Mantenimiento/Index";
    }
    
}
