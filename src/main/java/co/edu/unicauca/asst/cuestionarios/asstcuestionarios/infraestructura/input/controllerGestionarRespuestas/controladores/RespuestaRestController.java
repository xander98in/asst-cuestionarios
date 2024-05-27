package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Respuesta;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTOPeticion.RespuestaDTOPeticion;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTORespuesta.RespuestaDTORespuesta;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.mappers.RespuestaMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/respuestas")
@RequiredArgsConstructor
@Valid
public class RespuestaRestController {

    private final RespuestaMapperInfraestructuraDominio objMapeador;



    @PostMapping("/crear")
    public ResponseEntity<List<RespuestaDTORespuesta>> crearRespuestas(@RequestBody List<RespuestaDTOPeticion> respuestas) {
        List<Respuesta> respuestasCrear = this.objMapeador.mappearDePeticionesARespuestas(respuestas);
        ResponseEntity<List<RespuestaDTORespuesta>> objRespuesta = new ResponseEntity<List<RespuestaDTORespuesta>>(
            this.objMapeador.mappearDeRespuestasARespuesta(respuestasCrear),
            HttpStatus.CREATED
        );
        return objRespuesta;
    }

}
