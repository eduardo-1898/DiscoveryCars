/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.Controllers;

import ProyectoConcesionario.ProyectoConcesionario.entity.Cliente;
import ProyectoConcesionario.ProyectoConcesionario.services.Cliente.IClienteServices;
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

@RequestMapping("/Clientes/")
public class ClientesController {
    
    @Autowired
    private IClienteServices _clientesServices;
    
    @GetMapping("Nuevo")
    public String CrearClientes(Model model){
        model.addAttribute("cliente", new Cliente());
        return "Clientes/CreateCustomers";
    }
    
    @PostMapping("save")
    public String saveCliente(@ModelAttribute Cliente clientes){
        _clientesServices.saveClientes(clientes);
        return "redirect:/Clientes/Index";
    }
    
    @GetMapping("Actualizar/{id}")
    public String ActualizarClientes(@PathVariable("id") long idCustomer, Model model){
        Cliente DataCustomer = _clientesServices.getClientesById(idCustomer);
        model.addAttribute("cliente", DataCustomer);
        return "Clientes/UpdateCustomers";
    }
    
    @GetMapping("Index")
    public String IndexClientes(Model model){
        List<Cliente> listCustomers = _clientesServices.getClientes();
        model.addAttribute("clientes", listCustomers);
        return "Clientes/IndexCustomers";
    }
}
