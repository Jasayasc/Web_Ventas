package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Cliente> listar() {
        String sql = "select * from cliente";
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cliente cli = new Cliente();
                cli.setId(rs.getInt(1));
                cli.setDni(rs.getString(2));
                cli.setNombre(rs.getString(3));
                cli.setDireccion(rs.getString(4));
                cli.setEstado(rs.getString(5));
                clientes.add(cli);
            }
        } catch (SQLException e) {
        }
        return clientes;
    }

    public void agregar(Cliente e) {
        String sql = "insert into cliente(Dni,Nombres,Direccion,Estado) values (?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getDireccion());
            ps.setString(4, e.getEstado());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
        }
    }

    public Cliente finById(int id){
        String sql = "select * from cliente where IdCliente="+id;
        Cliente cli = new Cliente();
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                cli.setDni(rs.getString("Dni"));
                cli.setNombre(rs.getString("Nombres"));
                cli.setDireccion(rs.getString("Direccion"));
                cli.setEstado(rs.getString("Estado"));
            }
        } catch (SQLException e) {
        }
        return cli;
    }
    
    public void actualizar(Cliente e) {
        String sql = "UPDATE cliente SET Dni = ?, Nombres = ?, Direccion = ?, Estado = ? WHERE IdCliente= ?";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, e.getDni());
            ps.setString(2, e.getNombre());
            ps.setString(3, e.getDireccion());
            ps.setString(4, e.getEstado());
            ps.setString(5, e.getId()+"");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM cliente WHERE IdCliente = ?";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, id+"");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
        }
    }
    
}
