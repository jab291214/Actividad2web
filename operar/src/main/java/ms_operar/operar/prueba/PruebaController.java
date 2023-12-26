package ms_operar.operar.prueba;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
 
 



@RestController
@RequestMapping("/prueba")
public class PruebaController {

    @GetMapping("saludo")
    public String getAll() {
        return "asdasda";
    }
    
    
}
