/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Eduardo JA
 */
@Controller
public class VehiculosController {
    
    @GetMapping("/Vehiculos/Nuevo")
    public String CrearVehiculo(){
        //Cambiar el path a la la vista que se necesite
        return "Vehiculos/AdmVehicular";
    }
    
    @GetMapping("/Vehiculos/Index")
    public String IndexVehiculo(){
        //Cambiar el path a la la vista que se necesite
        return "Vehiculos/HistorialAdmVehicular";
    }
}
