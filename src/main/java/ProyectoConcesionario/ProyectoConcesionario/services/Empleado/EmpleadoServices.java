/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Empleado;

import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import ProyectoConcesionario.ProyectoConcesionario.repository.EmpleadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo JA
 */
@Service
public class EmpleadoServices implements IEmpleadoServices {

    @Autowired
    private EmpleadoRepository _empleadoRepository;

    @Override
    public List<Empleado> getEmpleados() {
        return (List<Empleado>) _empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadosById(long id) {
        return _empleadoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEmpleados(long id) {
        _empleadoRepository.deleteById(id);
    }

    @Override
    public void saveEmpleados(Empleado empleados) {
        _empleadoRepository.save(empleados);
    }

    @Override
    public Empleado findByNombre_Usuario(String Nombre_Usuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
