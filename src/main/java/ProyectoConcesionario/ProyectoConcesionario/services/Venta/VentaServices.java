package ProyectoConcesionario.ProyectoConcesionario.services.Venta;

import ProyectoConcesionario.ProyectoConcesionario.entity.Venta;
import ProyectoConcesionario.ProyectoConcesionario.repository.VentaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaServices implements IVentaServices {

    @Autowired
    private VentaRepository _ventasRepository;
    
    @Override
    public List<Venta> getVentas() {
        return (List<Venta>) _ventasRepository.findAll();
    }

    @Override
    public Venta getVentasById(long id) {
        return _ventasRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteVentas(long id) {
        _ventasRepository.deleteById(id);
    }

    @Override
    public void saveVentas(Venta ventas) {
        _ventasRepository.save(ventas);
    }

}
