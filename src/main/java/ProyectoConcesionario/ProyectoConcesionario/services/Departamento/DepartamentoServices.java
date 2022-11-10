/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Departamento;

import ProyectoConcesionario.ProyectoConcesionario.entity.Departamento;
import ProyectoConcesionario.ProyectoConcesionario.repository.DepartamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartamentoServices implements IDepartamentoServices {

    @Autowired
        private DepartamentoRepository _departamentoRepository;
    
    @Override
    public List<Departamento> getDepartamentos() {
        return (List<Departamento>) _departamentoRepository.findAll();
    }

    @Override
    public Departamento getDepartamentosById(long id) {
        return _departamentoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteDepartamentos(long id) {
        _departamentoRepository.deleteById(id);
    }

    @Override
    public void saveDepartamentos(Departamento departamento) {
        _departamentoRepository.save(departamento);
    }
}
