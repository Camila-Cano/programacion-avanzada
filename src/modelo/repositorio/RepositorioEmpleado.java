/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.repositorio;

import configuracion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.entidades.Empleado;

/**
 *
 * @author Camila
 */
public class RepositorioEmpleado {

    private final Conexion conexion = new Conexion();

    public Empleado consultarEmpleado(String login, String password) throws SQLException {

        String sql = "select * from empleados where login = ? and password = ?";
        Connection conn = conexion.crearConexionBd();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, login);
        pstm.setString(2, password);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            return obtenerEmpleado(rs);
        }
        return null;
    }

    private Empleado obtenerEmpleado(ResultSet rs) throws SQLException {
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(rs.getInt("ID_Empleado"));
        empleado.setNombres(rs.getString("Nombres"));
        empleado.setApellidos(rs.getString("Apellidos"));
        empleado.setIdentificacion(rs.getString("Identificacion"));
        empleado.setTelefono(rs.getString("Telefono"));
        empleado.setDepartamento(rs.getString("Departamento"));
        empleado.setCorreoElectronico(rs.getString("Correo_Electronico"));
        empleado.setEmpresa(rs.getString("Empresa"));
        empleado.setRol(rs.getString("Rol"));
        return empleado;
    }

}
