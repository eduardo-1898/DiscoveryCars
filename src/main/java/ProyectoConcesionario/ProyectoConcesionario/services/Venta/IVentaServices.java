/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Venta;

import ProyectoConcesionario.ProyectoConcesionario.entity.Venta;
import java.util.List;

/**
 *
 * @author Eduardo JA
 */
public interface IVentaServices {
    public List<Venta> getVentas();
    public Venta getVentasById(long id);
    public void deleteVentas(long id);
    public void saveVentas(Venta ventas);
}
