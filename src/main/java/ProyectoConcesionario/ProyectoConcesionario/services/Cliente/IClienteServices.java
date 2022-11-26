/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Cliente;

import ProyectoConcesionario.ProyectoConcesionario.entity.Cliente;
import java.util.List;

public interface IClienteServices {
    public List<Cliente> getClientes();
    public Cliente getClientesById(long id);
    public void deleteClientes(long id);
    public void saveClientes(Cliente clientes);
    public Cliente getClienteByDNI(String cedula);
}
