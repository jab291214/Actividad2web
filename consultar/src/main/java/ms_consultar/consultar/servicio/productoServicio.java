package ms_consultar.consultar.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ms_consultar.consultar.entidad.Producto;
import ms_consultar.consultar.repositorio.productoRepositorio;

@Service
public class productoServicio {
    @Autowired
    private productoRepositorio productorepositorio;

    public List<Producto> obtenerProducto(){
        return (List<Producto>) productorepositorio.findAll();
    }
    public Producto crearProducto(Producto producto){
        return productorepositorio.save(producto);
    }
    public List<Producto> buscarByItems(String item){
        return (List<Producto>) productorepositorio.buscarByItem(item);
    }
    public Producto buscarbyid(String id){
        return productorepositorio.findById(id).orElse(null);
    }
   
    public Boolean eliminarProducto(String id){
        try {
            productorepositorio.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
