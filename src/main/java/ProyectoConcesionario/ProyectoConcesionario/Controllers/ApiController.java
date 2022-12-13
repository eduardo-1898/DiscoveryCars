/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import ProyectoConcesionario.ProyectoConcesionario.entity.Cliente;
import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import ProyectoConcesionario.ProyectoConcesionario.entity.Encabezado;
import ProyectoConcesionario.ProyectoConcesionario.entity.JsonResponse;
import ProyectoConcesionario.ProyectoConcesionario.entity.Vehiculos;
import ProyectoConcesionario.ProyectoConcesionario.entity.Venta;
import ProyectoConcesionario.ProyectoConcesionario.entity.VentasIntermedias;
import ProyectoConcesionario.ProyectoConcesionario.services.Cliente.IClienteServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Cliente.IEncabezadoServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Vehiculos.IVehiculosServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Venta.IVentaIntermediasServices;
import ProyectoConcesionario.ProyectoConcesionario.services.Venta.IVentaServices;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.HttpSession;
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
    
    @Autowired
    private IVentaIntermediasServices _ventasServices;
    
    @Autowired
    private IVentaServices _salesServices;
    
    @Autowired
    private IEncabezadoServices _encabezadoServices;
     
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
    
    @PostMapping(value = "/DeleteShoppingCart")
    public @ResponseBody boolean DeleteReservationByID(@RequestBody JsonResponse data){
        _ventasServices.deleteVentasIntermedia(data.Cliente);
        return true;
    }
    
    @PostMapping(value = "/GetShoppingCart")
    public @ResponseBody List<VentasIntermedias> GetShoppingCart(@RequestBody JsonResponse data){
        var listado = _ventasServices.getVentasIntermedia();
        var newList = _ventasServices.getVentasIntermedia();
        newList.clear();
        for (VentasIntermedias ventas : listado) {
            if(Objects.equals(ventas.getClientes().getId(), data.Cliente) && "ACTIVO".equals(ventas.getEstado()) ){
                newList.add(ventas);
            }
        }
        return newList;
    }
    
    @PostMapping(value = "/AddShoppingCart")
    public @ResponseBody boolean AddReservation(@RequestBody JsonResponse data){
        var model = new VentasIntermedias();
        
        model.setEstado(data.Estado);
        model.setFechaIngreso(data.fecha_ingreso);
        model.setVehiculo(_vehiculoServices.getVehiculosById(data.placa));
        model.setClientes(_clienteServices.getClientesById(data.Cliente));
        
        _ventasServices.saveVentasIntermedia(model);
        return true;
    }
    
    @PostMapping(value = "/AddSale")
    public @ResponseBody Venta AddSale(@RequestBody JsonResponse data, HttpSession sesion){
        try {
            var factura = new Encabezado();
            //Obteniendo el usuario con el que se autentifico
            Empleado empleado = (Empleado) sesion.getAttribute("usersession");
            
            //Crea encabezado de la venta
            var cliente = _clienteServices.getClientesById(data.Cliente);
            Date fecha = new Date();
            factura.setClientes(cliente);
            factura.setEmpleados(empleado);
            factura.setFecha_Venta(fecha);
            _encabezadoServices.saveEncabezado(factura);
            
            var Enca = _encabezadoServices.GetLastInsert();
            
            //Crea detalle de la venta
            var listado = _ventasServices.getVentasIntermedia();
            var newList = _ventasServices.getVentasIntermedia();
            newList.clear();
            
            for (VentasIntermedias ventas : listado) {
                if(Objects.equals(ventas.getClientes().getId(), data.Cliente) && "ACTIVO".equals(ventas.getEstado()) ){
                    newList.add(ventas);
                }
            }
            
            for (VentasIntermedias item : newList) {
                
                var newVenta = new Venta();
                var id = Enca.getId();
                newVenta.setId_Factura(id);
                newVenta.setPlaca(item.getVehiculo().getPlaca());
                newVenta.setPrecio_Venta(item.getVehiculo().getPrecio_Compra());
                
                _salesServices.saveVentas(newVenta);
                _ventasServices.deleteVentasIntermedia(item.getId());
                
                //Se desactiva vehiculo para venta
                item.getVehiculo().setEstado(false);
                _vehiculoServices.saveVehiculos(item.getVehiculo());
                
            }
            
            return new Venta();
        } catch (Exception e) {
            return new Venta();
        }
       
    }
    
}
