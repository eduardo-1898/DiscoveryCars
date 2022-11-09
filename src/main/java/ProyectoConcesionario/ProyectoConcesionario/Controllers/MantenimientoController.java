/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MantenimientoController {
    
    @GetMapping("/Mantenimiento/Index")
    public String IndexMantenimientos(){
        //Cambiar el path a la la vista que se necesite
        return "Mantenimiento/HistorialMantenimiento";
    }
    
    @GetMapping("/Mantenimiento/Nuevo")
    public String CrearMantenimiento(){
        //Cambiar el path a la la vista que se necesite
        return "Mantenimiento/RegistroMantenimiento";
    }
    
}
