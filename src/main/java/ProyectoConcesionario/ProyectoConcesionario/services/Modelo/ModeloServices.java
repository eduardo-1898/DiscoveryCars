/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Modelo;

import ProyectoConcesionario.ProyectoConcesionario.entity.Modelo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ProyectoConcesionario.ProyectoConcesionario.repository.ModeloRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo JA
 */
@Service
public class ModeloServices implements IModeloServices{

    
    @Autowired
    private ModeloRepository _modeloRepository;   
    
    @Override
    public List<Modelo> getModelos() {
        return (List<Modelo>) _modeloRepository.findAll();
    }

    @Override
    public Modelo getModelosById(long id) {
        return _modeloRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteModelos(long id) {
        _modeloRepository.deleteById(id);
    }

    @Override
    public void saveModelos(Modelo clientes) {
        _modeloRepository.save(clientes);
    }
}
