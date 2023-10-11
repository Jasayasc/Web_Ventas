package Controlador;

/*import Modelo.Cliente;
import Modelo.ClienteDAO;
import Modelo.Empleado;
import Modelo.EmpleadoDAO;*/
import Modelo.Producto;
import Modelo.ProductoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author joels
 */
public class Controlador extends HttpServlet {

    /*Empleado empleado = new Empleado();
    EmpleadoDAO edao = new EmpleadoDAO();*/
    
    Producto producto = new Producto();
    ProductoDAO pdao = new ProductoDAO();
    
    /*Cliente cliente = new Cliente();
    ClienteDAO cdao = new ClienteDAO();*/
    
    int id;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String value = request.getParameter("param1");
        String value2 = request.getParameter("param2");

        if (value.equalsIgnoreCase("principal")) {
            request.getRequestDispatcher("/principal.jsp").forward(request, response);
        }
        if (value.equalsIgnoreCase("producto")) {
            switch (value2) {
                case "listar":
                    ArrayList<Producto> productos = pdao.listar();
                    request.setAttribute("productos", productos);
                    break;
                case "Agregar":
                    String nombre = request.getParameter("txtNombre");
                    double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String estado = request.getParameter("txtEstado");
                    producto.setNombres(nombre);
                    producto.setPrecio(precio);
                    producto.setStock(stock);
                    producto.setEstado(estado);
                    pdao.agregar(producto);
                    //out.print("SISISISI");
                    request.getRequestDispatcher("Controlador?param1=producto&param2=listar").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    pdao.delete(id);
                    request.getRequestDispatcher("Controlador?param1=producto&param2=listar").forward(request, response);
                    break;
                case "modificar":
                    id = Integer.parseInt(request.getParameter("id"));
                    Producto p = pdao.findById(id);
                    request.setAttribute("atribProducto", p);
                    request.getRequestDispatcher("Controlador?param1=producto&param2=listar").forward(request, response);
                    //request.getRequestDispatcher("Controlador?param1=empleado&param2=listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nombre1 = request.getParameter("txtNombre");
                    double precio1 = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock1 = Integer.parseInt(request.getParameter("txtStock"));
                    String estado1 = request.getParameter("txtEstado");
                    producto.setNombres(nombre1);
                    producto.setPrecio(precio1);
                    producto.setStock(stock1);
                    producto.setEstado(estado1);
                    producto.setId(id);
                    pdao.actualizar(producto);
                    request.getRequestDispatcher("Controlador?param1=producto&param2=listar").forward(request, response);
                    break;
                default:

                    throw new AssertionError();
            }
            request.getRequestDispatcher("/producto.jsp").forward(request, response);
        }
        if (value.equalsIgnoreCase("empleado")) {
            
            request.getRequestDispatcher("/empleado.jsp").forward(request, response);
        }
        if (value.equalsIgnoreCase("cliente")) {
             switch (value2) {
                case "listar":
                    ArrayList<Cliente> clientes = cdao.listar();
                    request.setAttribute("clientes", clientes);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nombre = request.getParameter("txtNombres");
                    String direccion = request.getParameter("txtDireccion");
                    String estado = request.getParameter("txtEstado");
                    cliente.setDni(dni);
                    cliente.setNombre(nombre);
                    cliente.setDireccion(direccion);
                    cliente.setEstado(estado);
                    cdao.agregar(cliente);
                    //out.print("SISISISI");
                    request.getRequestDispatcher("Controlador?param1=cliente&param2=listar").forward(request, response);
                    break;
                case "eliminar":
                    id = Integer.parseInt(request.getParameter("id"));
                    cdao.delete(id);
                    request.getRequestDispatcher("Controlador?param1=cliente&param2=listar").forward(request, response);
                    break;
                case "modificar":
                    id = Integer.parseInt(request.getParameter("id"));
                    Cliente c = cdao.finById(id);
                    request.setAttribute("atribCliente", c);
                    request.getRequestDispatcher("Controlador?param1=cliente&param2=listar").forward(request, response);
                    //request.getRequestDispatcher("Controlador?param1=empleado&param2=listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dni1 = request.getParameter("txtDni");
                    String nombre1 = request.getParameter("txtNombres");
                    String direccion1 = request.getParameter("txtDireccion");
                    String estado1 = request.getParameter("txtEstado");
                    cliente.setDni(dni1);
                    cliente.setNombre(nombre1);
                    cliente.setDireccion(direccion1);
                    cliente.setEstado(estado1);
                    cliente.setId(id);
                    cdao.actualizar(cliente);
                    request.getRequestDispatcher("Controlador?param1=cliente&param2=listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }
            request.getRequestDispatcher("/clientes.jsp").forward(request, response);
        }
        if (value.equalsIgnoreCase("nuevaVenta")) {
            request.getRequestDispatcher("/registrarVenta.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
