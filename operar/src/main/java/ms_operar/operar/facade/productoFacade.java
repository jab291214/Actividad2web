package ms_operar.operar.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ms_operar.operar.entidad.Producto;


@Component
@Slf4j
@RequiredArgsConstructor
public class productoFacade {
    @Value("${Producto.get_obtenerProductoByid}")
    private String Producto_get_obtenerProductoByid;
    @Value("${Producto.getByItem}")
    private String Producto_getByItem;

    private final RestTemplate restTemplate;

    public Producto obtenerProductobyid(String id) {

        try {
            return restTemplate.getForObject(String.format(Producto_get_obtenerProductoByid, id), Producto.class);
        } catch (HttpClientErrorException e) {
            log.error("cliente error {}, producto con id {}", e.getStatusCode(), id);
            return null;

        }
    }
   public List<Producto> obtenerProductobyitem(String id) {
    try {
        ResponseEntity<List<Producto>> responseEntity = restTemplate.exchange(
                String.format(Producto_getByItem, id),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Producto>>() {}
        );

        return responseEntity.getBody();
    } catch (HttpClientErrorException e) {
        log.error("Cliente error {}, producto con id {}", e.getStatusCode(), id);
        return null;
    }
}

}
