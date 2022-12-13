package ProyectoConcesionario.ProyectoConcesionario.services.Venta;

import ProyectoConcesionario.ProyectoConcesionario.entity.VentasIntermedias;
import ProyectoConcesionario.ProyectoConcesionario.repository.VentasIntermediasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaIntermediaServices implements IVentaIntermediasServices{

    @Autowired
    private VentasIntermediasRepository _ventasRepository;
    
    @Override
    public List<VentasIntermedias> getVentasIntermedia() {
        return (List<VentasIntermedias>) _ventasRepository.findAll();
    }

    @Override
    public VentasIntermedias getVentasIntermediaById(long id) {
        return _ventasRepository.findById(id).orElse(null);
    }
    
    @Override
    public void deleteVentasIntermedia(long id) {
        _ventasRepository.deleteById(id);
    }

    @Override
    public void saveVentasIntermedia(VentasIntermedias ventas) {
        _ventasRepository.save(ventas);
    }
    
}
