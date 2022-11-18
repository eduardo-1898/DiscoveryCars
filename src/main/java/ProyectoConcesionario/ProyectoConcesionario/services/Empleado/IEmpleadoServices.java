/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.services.Empleado;

import ProyectoConcesionario.ProyectoConcesionario.entity.Empleado;
import java.util.List;


public interface IEmpleadoServices {
    public List<Empleado> getEmpleados();
    public Empleado getEmpleadosById(long id);
    public void deleteEmpleados(long id);
    public void saveEmpleados(Empleado empleados);
}
