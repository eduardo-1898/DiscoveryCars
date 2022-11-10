/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Mantenimiento;

import ProyectoConcesionario.ProyectoConcesionario.entity.Mantenimiento;
import ProyectoConcesionario.ProyectoConcesionario.repository.MantenimientoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo JA
 */
@Service
public class MantenimientoServices implements IMantenimientoServices{

    @Autowired
    private MantenimientoRepository _mantenimientoRepository;    
    
    @Override
    public List<Mantenimiento> getMantenimientos() {
        return (List<Mantenimiento>) _mantenimientoRepository.findAll();
    }

    @Override
    public Mantenimiento getMantenimientosById(long id) {
        return _mantenimientoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMantenimientos(long id) {
        _mantenimientoRepository.deleteById(id);
    }

    @Override
    public void saveMantenimientos(Mantenimiento mantenimientos) {
        _mantenimientoRepository.save(mantenimientos);
    }
    
}
