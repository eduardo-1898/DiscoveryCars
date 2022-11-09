/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Departamento;

import ProyectoConcesionario.ProyectoConcesionario.entity.Departamento;
import java.util.List;

/**
 *
 * @author Eduardo JA
 */
public interface IDepartamentoServices {
    public List<Departamento> getDepartamentos();
    public Departamento getDepartamentosById(long id);
    public void deleteDepartamentos(long id);
    public void saveDepartamentos(Departamento departamento);
}
