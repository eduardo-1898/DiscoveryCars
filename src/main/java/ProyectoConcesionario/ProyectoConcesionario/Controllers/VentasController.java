/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import ProyectoConcesionario.ProyectoConcesionario.entity.VentasIntermedias;
import ProyectoConcesionario.ProyectoConcesionario.services.Venta.IVentaIntermediasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VentasController {
        
    @Autowired
    private IVentaIntermediasServices _ventasServices;
    
    @GetMapping("/Ventas/Crear")
    public String IndexMantenimientos(){
        //Cambiar el path a la la vista que se necesite
        return "Ventas/CreateSales";
    }
    
    @PostMapping("/Ventas/save")
    public String saveMantenimiento(@ModelAttribute VentasIntermedias ventas){
        _ventasServices.saveVentasIntermedia(ventas);  
        return "redirect:/Ventas/Crear";
    }
    
    @GetMapping("/Ventas/delete/{id}")
    public String deleteConcierto(@PathVariable("id") long idVentas){
        _ventasServices.deleteVentasIntermedia(idVentas);
        return "redirect:/Ventas/Crear";
    }
    
}
