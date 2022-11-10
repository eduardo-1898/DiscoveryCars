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
    public Vehiculos getVehiculosById(long id) {
        return _vehiculosRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVehiculos(long id) {
        _vehiculosRepository.deleteById(id);
    }

    @Override
    public void saveVehiculos(Vehiculos vehiculos) {
        _vehiculosRepository.save(vehiculos);
    }
}
