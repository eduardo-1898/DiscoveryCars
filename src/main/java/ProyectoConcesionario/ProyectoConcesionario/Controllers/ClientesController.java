/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientesController {
    
    
    @GetMapping("/Clientes/Nuevo")
    public String CrearClientes(){
        //Cambiar el path a la la vista que se necesite
        return "Clientes/CreateCustomers";
    }
    
    @GetMapping("/Clientes/Landing")
    public String Landing(){
        //Cambiar el path a la la vista que se necesite
        return "LandingPage";
    }
    
    @GetMapping("/Clientes/Actualizar")
    public String ActualizarClientes(){
        //Cambiar el path a la la vista que se necesite
        return "Clientes/UpdateCustomers";
    }
    
    @GetMapping("/Clientes/Index")
    public String IndexClientes(){
        //Cambiar el path a la la vista que se necesite
        return "Clientes/IndexCustomers";
    }
}
