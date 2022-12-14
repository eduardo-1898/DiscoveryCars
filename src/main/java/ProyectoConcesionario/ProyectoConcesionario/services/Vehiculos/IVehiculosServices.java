/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Vehiculos;

import ProyectoConcesionario.ProyectoConcesionario.entity.Vehiculos;
import java.util.List;

/**
 *
 * @author Eduardo JA
 */
public interface IVehiculosServices {
    public List<Vehiculos> getVehiculos();
    public Vehiculos getVehiculosById(String placa);
    public void deleteVehiculos(String placa);
    public void saveVehiculos(Vehiculos vehiculos);
}
