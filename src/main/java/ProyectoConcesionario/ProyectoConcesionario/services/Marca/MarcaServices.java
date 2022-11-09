/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Marca;

import ProyectoConcesionario.ProyectoConcesionario.entity.Marca;
import ProyectoConcesionario.ProyectoConcesionario.repository.MarcaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class MarcaServices implements IMarcaServices{

    @Autowired
    private MarcaRepository _marcaRepository;    
    
    @Override
    public List<Marca> getMarcas() {
        return (List<Marca>) _marcaRepository.findAll();
    }

    @Override
    public Marca getMarcasById(long id) {
        return _marcaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteMarcas(long id) {
        _marcaRepository.deleteById(id);
    }

    @Override
    public void saveMarcas(Marca marcas) {
        _marcaRepository.save(marcas);
    }
    
}
