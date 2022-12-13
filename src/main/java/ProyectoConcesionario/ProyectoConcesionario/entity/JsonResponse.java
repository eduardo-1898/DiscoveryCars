/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoConcesionario.ProyectoConcesionario.entity;

import java.util.Date;
import lombok.Data;

/**
 *
 * @author Eduardo JA
 */
@Data
public class JsonResponse {
    public String placa;
    public String Cedula;
    public Long Cliente;
    
    public String Estado;
    public Date fecha_ingreso;
    
}
