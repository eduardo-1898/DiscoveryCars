/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import ProyectoConcesionario.ProyectoConcesionario.entity.JsonResponse;
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
    
    @PostMapping(value = "/PlacaExist")
    public @ResponseBody String SearchPlaca(@RequestBody JsonResponse data){
        var result = _vehiculoServices.getVehiculosById(data.placa);
        return (result!=null)?"true":"false";
    }
}
