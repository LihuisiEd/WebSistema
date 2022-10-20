/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.List;
import modelos.Conexion;
import modelos.Cursos;

/**
 *
 * @author 51950
 */
public class CursoDAOImpl implements ICursosDAO{


    @Override
    public Cursos buscar(int codigo) {
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql="SELECT * FROM cursos WHERE codigo="+codigo;
        Cursos curso= new Cursos();
        try{
            Conexion con = new Conexion();
            co=con.Conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                curso.setCodigo(rs.getInt(1));
                curso.setNombre(rs.getString(2));
                curso.setCosto(rs.getDouble(3));
                curso.setFec_ini(rs.getDate(4));
                curso.setFec_fin(rs.getDate(5));
                curso.setDuracion(rs.getInt(6));
                curso.setSesiones(rs.getInt(7));
                curso.setCapacidad(rs.getInt(8));
                curso.setInscritos(rs.getInt(8));
                curso.setEstado(rs.getString(9));
            }
            stm.close();
            rs.close();
            co.close();
        }catch(SQLException e){
            System.out.println("Error:Clase CursoDaoIml,"+"metodo buscar");
            e.printStackTrace();
        }
        return curso;
    }

    @Override
    public boolean registrar(Cursos curso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Cursos> obtener() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean actualizar(Cursos curso) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(String[] codigos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
