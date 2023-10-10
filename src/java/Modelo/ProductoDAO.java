package Modelo;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public ArrayList<Producto> listar() {
        String sql = "select * from producto";
        ArrayList<Producto> productos = new ArrayList<Producto>();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();

                p.setId(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setPrecio(rs.getDouble(3));
                p.setStock(rs.getInt(4));
                p.setEstado(rs.getString(5));
                productos.add(p);
            }
        } catch (SQLException e) {
        }
        return productos;
    }

    public void agregar(Producto p) {
        String sql = "INSERT INTO producto (Nombres, Precio, Stock, Estado) VALUES (?, ?, ?, ?)";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getPrecio() + "");
            ps.setString(3, p.getStock() + "");
            ps.setString(4, p.getEstado() + "");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
        }
    }

    public Producto findById(int id) {
        String sql = "select * from producto where IdProducto=" + id;
        Producto p = new Producto();
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                p.setNombres(rs.getString("Nombres"));
                p.setPrecio(Double.parseDouble(rs.getString("Precio")));
                p.setStock(Integer.parseInt(rs.getString("Stock")));
                p.setEstado(rs.getString("Estado"));
            }
        } catch (NumberFormatException | SQLException e) {
        }
        return p;
    }

    public void actualizar(Producto p) {
        String sql = "UPDATE producto SET Nombres = ?, Precio = ?, Stock = ?, Estado = ? WHERE IdProducto = ?";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getNombres());
            ps.setString(2, p.getPrecio()+"");
            ps.setString(3, p.getStock()+"");
            ps.setString(4, p.getEstado());
            ps.setString(5, p.getId()+"");
            ps.executeUpdate();
            ps.close();
        }catch(SQLException ex){
            
        }
    }
    
    public void delete(int id){
        String sql = "DELETE FROM producto WHERE IdProducto = ?";
        try {
            con = cn.Conexion();
            ps=con.prepareStatement(sql);
            ps.setString(1, id+"");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
        }
    }
}
