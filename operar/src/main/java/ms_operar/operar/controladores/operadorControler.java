package ms_operar.operar.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import ms_operar.operar.entidad.Compra;
import ms_operar.operar.entidad.CompraDTO;
import ms_operar.operar.entidad.Producto;
import ms_operar.operar.entidad.operadorRequerido;
import ms_operar.operar.servicio.compraServicio;
import ms_operar.operar.servicio.operadorServicio;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/compra")
public class operadorControler {
    @Autowired
    private operadorServicio operadorservicio;
    @Autowired
    private compraServicio compraservicio;

    //endpoint que conectan con el microservicio consultar
    @PostMapping("/validarproductolistaByid")
    public ResponseEntity<String> postMethodName(@RequestBody operadorRequerido listaID) {

        String resultado = operadorservicio.crearOperacion(listaID);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping("/consultaproductoCustom")
    public List<Producto> obtnerByItem(@RequestBody operadorRequerido item) {
        List<Producto> productosDto = operadorservicio.obtenerProductosByItem(item);
        return productosDto;
    }

    @PostMapping("/id")
    public ResponseEntity<List<Producto>> obtenerById(@RequestBody operadorRequerido id) {
        List<Producto> resultado = operadorservicio.getByItem(id);
        if (resultado != null) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    // endpoint de la compra 
    @PostMapping("/crear")
    public ResponseEntity<Compra> CrearCompra( @RequestBody  @Valid Compra producto) {
        Producto resultado = operadorservicio.getById(producto.getIdProducto());
        if(resultado == null){
            return ResponseEntity.badRequest().build();

        }
        Compra compraCreada = compraservicio.crearCompra(producto);

        return new ResponseEntity<>(compraCreada, HttpStatus.CREATED);
    }
    @GetMapping("listarcompras")
    public ResponseEntity<List<CompraDTO>> listarcompras() {
        return new ResponseEntity<>(compraservicio.listarCompra(),HttpStatus.OK);
    }
    
}
