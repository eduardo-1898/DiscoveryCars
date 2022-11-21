/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import ProyectoConcesionario.ProyectoConcesionario.entity.Cliente;
import ProyectoConcesionario.ProyectoConcesionario.entity.JsonResponse;
import ProyectoConcesionario.ProyectoConcesionario.entity.Vehiculos;
import ProyectoConcesionario.ProyectoConcesionario.services.Cliente.IClienteServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Vehiculos.IVehiculosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Api")
public class ApiController {
    
    @Autowired
    private IVehiculosServices _vehiculoServices;
    
    @Autowired 
    private IClienteServices _clienteServices;
    
    //Usado en pantalla de mantenimientos y vehiculos
    @PostMapping(value = "/PlacaExist")
    public @ResponseBody String SearchPlaca(@RequestBody JsonResponse data){
        var result = _vehiculoServices.getVehiculosById(data.placa);
        return (result!=null)?"true":"false";
    }
    
    //Usado en la pantalla de ventas para obtener la información del vehiculo
    @PostMapping(value = "/SearchVehicle")
    public @ResponseBody Vehiculos SearchVehicle(@RequestBody JsonResponse data){
        return  _vehiculoServices.getVehiculosById(data.placa);
    }
    
    //Usado en la pantalla de ventas para obtener la información del cliente
    @PostMapping(value = "/SearchCustomer")
    public @ResponseBody Cliente SearchCustomerByDNI(@RequestBody JsonResponse data){
        return _clienteServices.getClienteByDNI(data.Cedula);
    }
    
}
