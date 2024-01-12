package ms_operar.operar.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ms_operar.operar.entidad.Producto;
import ms_operar.operar.entidad.operadorRequerido;
import ms_operar.operar.servicio.operadorServicio;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/compra")
public class operadorControler {
    @Autowired
    private operadorServicio operadorservicio;

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

}
