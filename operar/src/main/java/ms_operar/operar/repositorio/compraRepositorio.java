package ms_operar.operar.repositorio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import ms_operar.operar.entidad.Compra;
@Repository
public class compraRepositorio {
    private List<Compra> compras = new ArrayList<>();

    public List<Compra> obtnerTodo(){
        return compras;
    }

    public Compra save (Compra compra){
        compras.add(compra);
        return compra;

    }
}
