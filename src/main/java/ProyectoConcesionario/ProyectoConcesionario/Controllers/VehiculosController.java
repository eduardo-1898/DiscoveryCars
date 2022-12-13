/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import ProyectoConcesionario.ProyectoConcesionario.entity.Marca;
import ProyectoConcesionario.ProyectoConcesionario.entity.Modelo;
import ProyectoConcesionario.ProyectoConcesionario.entity.Vehiculos;
import ProyectoConcesionario.ProyectoConcesionario.services.Marca.IMarcaServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Modelo.IModeloServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Vehiculos.IVehiculosServices;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Eduardo JA
 */
@Controller
@RequestMapping("/Vehiculos/")
public class VehiculosController {
    
    @Autowired
    private IVehiculosServices _vehiculoServices;
    
    @Autowired 
    private IMarcaServices _marcaServices;
    
    @Autowired 
    private IModeloServices _modeloServices;
    
    
    @GetMapping("Nuevo")
    public String CrearVehiculo(Model model){
        
        List<Modelo> listModelos = _modeloServices.getModelos();
        //Codigo con expresión lambda para ordenar la lista de modelos
        Collections.sort(listModelos, (a, b)->{
            return a.getModelo().compareTo(b.getModelo());
        });
        
        List<Marca> listMarcas = _marcaServices.getMarcas();
        //Codigo con expresión lambda para ordenar la lista de marcas
        Collections.sort(listMarcas, (a, b)->{
            return a.getMarca().compareTo(b.getMarca());
        });
        
        model.addAttribute("modelo", listModelos);
        model.addAttribute("marca", listMarcas);
        model.addAttribute("vehiculo", new Vehiculos());
        
        //Se envía año actual para el campo de año en la vista
        model.addAttribute("Year", UtilMethodGetYear());
        return "Vehiculos/AdmVehicular";
    }
    
    @GetMapping("Actualizar/{id}")
    public String ActualizarClientes(@PathVariable("id") String placa, Model model){

        List<Modelo> listModelos = _modeloServices.getModelos();
        Collections.sort(listModelos, (a, b)->{
            return a.getModelo().compareTo(b.getModelo());
        });
        
        List<Marca> listMarcas = _marcaServices.getMarcas();
        Collections.sort(listMarcas, (a, b)->{
            return a.getMarca().compareTo(b.getMarca());
        });
        
        Vehiculos DataVehicle = _vehiculoServices.getVehiculosById(placa);
        
        model.addAttribute("modelo", listModelos);
        model.addAttribute("marca", listMarcas);
        model.addAttribute("vehiculo", DataVehicle);
        
        return "Vehiculos/UpdateVehicle";
    }
    
    @GetMapping("Index")
    public String IndexVehiculo(Model model){
        List<Vehiculos> getVehicles = _vehiculoServices.getVehiculos();
        model.addAttribute("vehiculo", getVehicles);
        return "Vehiculos/HistorialAdmVehicular";
    }
    
    @PostMapping("save")
    public String SaveVehiculos(@ModelAttribute Vehiculos vehiculos){
        _vehiculoServices.saveVehiculos(vehiculos);
        return "redirect:/Vehiculos/Index";
    }
    
    //Metodo privado para obtener el año actual del servidor.
    //No eliminar ya que delimita el año del vehículo.
    private int UtilMethodGetYear(){
        Date yearDate = new Date();
        SimpleDateFormat getYearFormat = new SimpleDateFormat("yyyy");
        String currentYear = getYearFormat.format(yearDate);
        return Integer.parseInt(currentYear);
    }
    
}
