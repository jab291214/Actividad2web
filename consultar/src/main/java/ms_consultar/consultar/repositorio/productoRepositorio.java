package ms_consultar.consultar.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ms_consultar.consultar.entidad.Producto;

@Repository
public interface productoRepositorio extends CrudRepository<Producto, String> {

    @Query(value = "select * from productos where nombre like %:query% OR descripcion like %:query% OR precio like %:query% OR id like %:query%", nativeQuery = true)
    public List<Producto> buscarByItem(@Param("query") String query);

}