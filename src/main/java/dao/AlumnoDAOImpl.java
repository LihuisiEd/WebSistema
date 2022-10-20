/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import modelos.Alumnos;
import modelos.Conexion;
/**
 *
 * @author 51950
 */
public class AlumnoDAOImpl implements IAlumnosDAO {
    @Override
    public List<Alumnos> obtener(){
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql="SELECT * FROM alumnos ORDER BY codigo";
        List<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
        try{
            Conexion con = new Conexion();
            co=con.Conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                Alumnos alumno = new Alumnos();
                alumno.setCodigo(rs.getInt(1));
                alumno.setNombre(rs.getString(2));
                alumno.setDireccion(rs.getString(3));
                alumno.setEmail(rs.getString(4));
                alumno.setTelefono(rs.getString(5));
                alumno.setCelular(rs.getString(6));
                alumno.setSexo(rs.getString(7));
                alumno.setFec_nac(rs.getDate(8));
                alumno.setEstado(rs.getString(9));
                listaAlumnos.add(alumno);
            }
            stm.close();
            rs.close();
            co.close();
        } catch(SQLException e){
            System.out.println("Error: Clase AlumnoDaoImpl," + "Metodo obtener");
        }
        return listaAlumnos;
    }
    
    @Override
    public boolean actualizar(Alumnos alumno){
        Conexion co = new Conexion();
        boolean actualizar = false;
        Connection con = null;
        Statement stm = null;
        String sql="UPDATE alumnos set "+
                "nombre='" + alumno.getNombre() +"',direccion='"+ alumno.getDireccion() +"',"+
                "email='" + alumno.getEmail() + "',telefono='" + alumno.getTelefono() + "',"+
                "celular='" + alumno.getFec_nac() + "',estado='" + alumno.getEstado() + "'"+
                "WHERE codigo = " + alumno.getCodigo();
        try{
            con = co.Conectar();
            stm=con.createStatement();
            
            stm.execute(sql);
            actualizar=true;
            stm.close();
            con.close();
           
        }catch (SQLException e){
            System.out.println("Error: Clase AlumnoDaoImpl,"
            + "metodo actualizar");
            e.printStackTrace();
        }
        return actualizar;
          
    }
    @Override
    public boolean registrar(Alumnos alumno) {
        Conexion co = new Conexion();
        String xcod = co.generarCodigo("alumnos", "codigo");
        boolean register = false;
        Statement stm = null;
        Connection con = null;
        String sql = "INSERT INTO alumnos values (" + xcod + "," +
                "'" + alumno.getNombre() + "','"+alumno.getDireccion()+"',"+
                "'"+ alumno.getEmail()+"','" + alumno.getTelefono()+"',"+
                "'"+ alumno.getCelular()+"','" + alumno.getSexo()+ "'," +
                "'"+alumno.getFec_nac()+ "','" + alumno.getEstado()+"')";
        try{
            con = co.Conectar();
            stm=con.createStatement();
            stm.execute(sql);
            con.close(); 
        }catch (SQLException e){
            System.out.println("Errpr: Clase AlumnoDaoImpl, "
            + "metodo registrar");
            e.printStackTrace();
            
        }
        return register;
    }

    @Override
    public boolean eliminar(String[] codigos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public Alumnos buscar (int codigo){
        Connection co = null;
        Statement stm = null;
        ResultSet rs = null;
        String sql="SELECT * FROM alumnos WHERE codigo="+codigo;
        Alumnos alumno= new Alumnos();
        try{
            Conexion con = new Conexion();
            co=con.Conectar();
            stm=co.createStatement();
            rs=stm.executeQuery(sql);
            while(rs.next()){
                alumno.setCodigo(rs.getInt(1));
                alumno.setNombre(rs.getString(2));
                alumno.setDireccion(rs.getString(3));
                alumno.setEmail(rs.getString(4));
                alumno.setTelefono(rs.getString(5));
                alumno.setCelular(rs.getString(6));
                alumno.setSexo(rs.getString(7));
                alumno.setFec_nac(rs.getDate(8));
                alumno.setEstado(rs.getString(9));
            }
            stm.close();
            rs.close();
            co.close();
        }catch(SQLException e){
            System.out.println("Error:Clase AlumnoDaoIml,"+"metodo buscar");
            e.printStackTrace();
        }
        return alumno;
    }
    
}
