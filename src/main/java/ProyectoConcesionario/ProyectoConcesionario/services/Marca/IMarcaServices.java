/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Marca;

import ProyectoConcesionario.ProyectoConcesionario.entity.Marca;
import java.util.List;


public interface IMarcaServices {
    public List<Marca> getMarcas();
    public Marca getMarcasById(long id);
    public void deleteMarcas(long id);
    public void saveMarcas(Marca marcas);
}
