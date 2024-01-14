package ms_operar.operar.servicio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ms_operar.operar.entidad.Compra;
import ms_operar.operar.entidad.CompraDTO;
import ms_operar.operar.entidad.Producto;
import ms_operar.operar.facade.productoFacade;
import ms_operar.operar.repositorio.compraRepositorio;

@Service
public class compraServicio {
    @Autowired
    private compraRepositorio comprarepositorio;
    @Autowired
    private productoFacade productofacade;

    public List<CompraDTO> listarCompra() {
        List<CompraDTO> compras = new ArrayList<>();
        List<Compra> temporal = comprarepositorio.obtnerTodo();

        for (Compra compra : temporal) {
            Producto produc = productofacade.obtenerProductobyid(compra.getIdProducto());
            CompraDTO nuevaCompraDTO = new CompraDTO();
            nuevaCompraDTO.descripcion = produc.getDescripcion();
            nuevaCompraDTO.fecha = compra.getFecha();
            nuevaCompraDTO.idProducto = compra.getIdProducto();
            nuevaCompraDTO.idcompra = compra.getId();
            nuevaCompraDTO.nombre = produc.getNombre();
            nuevaCompraDTO.precio = produc.getPrecio();
            nuevaCompraDTO.precioCompra = compra.getPrecioCompra();
            compras.add(nuevaCompraDTO);

        }
        return compras;
    }

    public Compra crearCompra(Compra compra) {
        return comprarepositorio.save(compra);
    }
}
