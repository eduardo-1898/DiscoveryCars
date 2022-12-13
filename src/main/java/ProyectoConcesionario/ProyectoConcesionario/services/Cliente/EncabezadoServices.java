/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Cliente;

import ProyectoConcesionario.ProyectoConcesionario.entity.Encabezado;
import ProyectoConcesionario.ProyectoConcesionario.repository.EncabezadoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eduardo JA
 */
@Service
public class EncabezadoServices implements IEncabezadoServices {

    @Autowired
    private EncabezadoRepository _encabezadoRepository;
    
    @Override
    public List<Encabezado> getEncabezado() {
        return (List<Encabezado>) _encabezadoRepository.findAll();
    }

    @Override
    public Encabezado getEncabezadoById(long id) {
        return _encabezadoRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteEncabezado(long id) {
        _encabezadoRepository.deleteById(id);
    }

    @Override
    public void saveEncabezado(Encabezado encabezado) {
        _encabezadoRepository.save(encabezado);
    }    

    @Override
    public Encabezado GetLastInsert() {
        return _encabezadoRepository.findLastInsert();
    }
}
