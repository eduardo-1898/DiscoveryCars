/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmpleadosController {
    
    @GetMapping("/Empleados/Nuevo")
    public String CrearEmpleado(){
        //Cambiar el path a la la vista que se necesite
        return "Empleados/AdmCreacionEmpleado";
    }
    
    @GetMapping("/Empleados/Index")
    public String IndexEmpleado(){
        //Cambiar el path a la la vista que se necesite
        return "Empleados/HistorialAdmEmpleado";
    }
    
}
