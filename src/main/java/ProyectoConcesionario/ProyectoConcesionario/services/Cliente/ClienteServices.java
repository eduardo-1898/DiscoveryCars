/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Cliente;

import ProyectoConcesionario.ProyectoConcesionario.entity.Cliente;
import ProyectoConcesionario.ProyectoConcesionario.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServices implements IClienteServices{

    @Autowired
    private ClienteRepository _clienteRepository;
    
    @Override
    public List<Cliente> getClientes() {
        return (List<Cliente>) _clienteRepository.findAll();
    }

    @Override
    public Cliente getClientesById(long id) {
        return _clienteRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteClientes(long id) {
        _clienteRepository.deleteById(id);
    }

    @Override
    public void saveClientes(Cliente clientes) {
        _clienteRepository.save(clientes);
    }

    @Override
    public Cliente getClienteByDNI(String cedula) {
        return _clienteRepository.getCustomerByDNI(cedula);
    }    
}
