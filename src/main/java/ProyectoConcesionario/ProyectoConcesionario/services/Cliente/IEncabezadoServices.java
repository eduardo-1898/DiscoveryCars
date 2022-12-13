/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Cliente;

import ProyectoConcesionario.ProyectoConcesionario.entity.Encabezado;
import java.util.List;

/**
 *
 * @author Eduardo JA
 */
public interface IEncabezadoServices {
    
    public List<Encabezado> getEncabezado();
    public Encabezado getEncabezadoById(long id);
    public void deleteEncabezado(long id);
    public void saveEncabezado(Encabezado encabezado);
    public Encabezado GetLastInsert();   
}
