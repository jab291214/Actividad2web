package ms_consultar.consultar.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ms_consultar.consultar.entidad.Producto;
import ms_consultar.consultar.servicio.productoServicio;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/producto")
@Slf4j
public class productoControler {
    @Autowired
    private productoServicio productoservicio;

    @GetMapping("/listar")
    public ResponseEntity<List<Producto>> obtenerProducto() {
        List<Producto> producto = productoservicio.obtenerProducto();
        return new ResponseEntity<>(producto, HttpStatus.OK);

    }
     @GetMapping("/buscar/{item}")
    public ResponseEntity<Object> getByItem(@PathVariable String item) {
        log.info("solicitud recibida para el prodcuto {}", item);
        if (productoservicio.buscarByItems(item) == null) {
            return new ResponseEntity<>("producto no encontrado", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productoservicio.buscarByItems(item), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoByid(@PathVariable String id) {
        Producto producto = productoservicio.buscarbyid(id);
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String id,  @Valid @RequestBody Producto producto) {
        producto.setId(id);
       Producto productoActualizado = productoservicio.crearProducto(producto);
        if(productoActualizado != null){
            return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
        }
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

    @PostMapping("/crear")
    public ResponseEntity<Producto> CrearProducto(@Valid @RequestBody Producto producto) {
        Producto productocreado = productoservicio.crearProducto(producto);

        return new ResponseEntity<>(productocreado, HttpStatus.CREATED);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarProducto (@PathVariable String id){
        Boolean respuesta = productoservicio.eliminarProducto(id);
        if(respuesta){
            return new ResponseEntity<>( HttpStatus.NO_CONTENT) ;
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

   

}
