/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Modelo;

import ProyectoConcesionario.ProyectoConcesionario.entity.Modelo;
import java.util.List;

/**
 *
 * @author Eduardo JA
 */
public interface IModeloServices {
    public List<Modelo> getModelos();
    public Modelo getModelosById(long id);
    public void deleteModelos(long id);
    public void saveModelos(Modelo modelos);
}
