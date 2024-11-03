/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.sql.SQLException;
import modelo.entidades.Empleado;
import modelo.repositorio.RepositorioEmpleado;

/**
 *
 * @author Camila
 */
public class EmpleadoService {
    
    private final RepositorioEmpleado repositorioEmpleado = new RepositorioEmpleado();
    
    public Empleado consultarEmpleado(String login, String password) throws SQLException {
        Empleado empleado = repositorioEmpleado.consultarEmpleado(login, password);
        if(empleado == null) {
            throw new IllegalArgumentException("El empleado no exisite o valide las credenciales de acceso");
        }
        return empleado;
    }
    
}
