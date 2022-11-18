/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Mantenimiento;

import ProyectoConcesionario.ProyectoConcesionario.entity.Mantenimiento;
import java.util.List;

/**
 *
 * @author Eduardo JA
 */
public interface IMantenimientoServices {
    public List<Mantenimiento> getMantenimientos();
    public Mantenimiento getMantenimientosById(long id);
    public void deleteMantenimientos(long id);
    public void saveMantenimientos(Mantenimiento mantenimientos);
}
