package ProyectoConcesionario.ProyectoConcesionario.services.Venta;

import ProyectoConcesionario.ProyectoConcesionario.entity.VentasIntermedias;
import java.util.List;

/**
 *
 * @author Eduardo JA
 */
public interface IVentaIntermediasServices {
    public List<VentasIntermedias> getVentasIntermedia();
    public VentasIntermedias getVentasIntermediaById(long id);
    public void deleteVentasIntermedia(long id);
    public void saveVentasIntermedia(VentasIntermedias ventas); 
}
