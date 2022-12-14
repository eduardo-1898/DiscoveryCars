/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Vehiculos;

import ProyectoConcesionario.ProyectoConcesionario.entity.Vehiculos;
import ProyectoConcesionario.ProyectoConcesionario.repository.VehiculosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehiculosServices implements IVehiculosServices{

    @Autowired
    private VehiculosRepository _vehiculosRepository;
    
    @Override
    public List<Vehiculos> getVehiculos() {
        return (List<Vehiculos>) _vehiculosRepository.findAll();
    }

    @Override
    public Vehiculos getVehiculosById(String placa) {
        return _vehiculosRepository.findById(placa).orElse(null);
    }

    @Override
    public void deleteVehiculos(String placa) {
        _vehiculosRepository.deleteById(placa);
    }

    @Override
    public void saveVehiculos(Vehiculos vehiculos) {
        _vehiculosRepository.save(vehiculos);
    }
}
