package ms_operar.operar.servicio;

import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ms_operar.operar.entidad.Producto;
import ms_operar.operar.entidad.operadorRequerido;
import ms_operar.operar.facade.productoFacade;

@Service
public class operadorServicio implements OperadorServicioInt {
    /*
     * @Value("${obtenerUrlby.item}")
     * private String getProductosurl;
     */

    @Autowired
    private productoFacade productofacade;
    RestTemplate restemplate;

    public String crearOperacion(operadorRequerido operador) {
        List<Producto> productos = operador.getProductos().stream().map(productofacade::obtenerProductobyid)
                .filter(Objects::nonNull).collect(Collectors.toList());
        return productos.size() == operador.getProductos().size() ? "OK" : "KO";
    }

    public List<Producto> getByItem (operadorRequerido operador){
        List<Producto> productos = operador.getProductos().stream().map(productofacade::obtenerProductobyid)
                .filter(Objects::nonNull).collect(Collectors.toList());
                return productos;

    }

    public List<Producto> obtenerProductosByItem(operadorRequerido item) {
         
        List<Producto> productos = item.getProductos().stream()
                .flatMap(subItem -> {

                    try {
                        List<Producto> result = productofacade.obtenerProductobyitem(subItem);
                        return result != null ? result.stream() : null;
                    } catch (Exception e) {
                        // Log or handle the exception as needed
                        return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());

        return productos;
    }
}
/*
 * ResponseEntity<Producto[]> resultado =
 * restemplate.getForEntity(String.format(getProductosurl,id
 * ),Producto[].class);
 * Producto[] productoDto = resultado.getBody();
 * List<Producto> listaProductos= Arrays.asList(productoDto);
 */