package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input.GestionarRespuestasCUIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Respuesta;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTOPeticion.RespuestaDTOPeticion;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.DTORespuesta.RespuestaDTORespuesta;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarRespuestas.mappers.RespuestaMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/respuestas")
@RequiredArgsConstructor
@Validated
public class RespuestaRestController {

    private final GestionarRespuestasCUIntPort objGestionarRespuestasCUIntPort;
    private final RespuestaMapperInfraestructuraDominio objMapeador;

    @PostMapping("/crear")
    public ResponseEntity<List<RespuestaDTORespuesta>> crearRespuestas(@Valid @RequestBody List<RespuestaDTOPeticion> respuestas) {
        List<Respuesta> respuestasCrear = this.objMapeador.mappearDePeticionesARespuestas(respuestas);
        List<Respuesta> respuestasCreadas = this.objGestionarRespuestasCUIntPort.crearRespuestas(respuestasCrear);
        ResponseEntity<List<RespuestaDTORespuesta>> objRespuesta = new ResponseEntity<List<RespuestaDTORespuesta>>(
            this.objMapeador.mappearDeRespuestasARespuesta(respuestasCreadas),
            HttpStatus.CREATED
        );
        return objRespuesta;
    }

    @GetMapping("/consultar-por-id/{idPersona}")
    public ResponseEntity<List<RespuestaDTORespuesta>> consultarRespuestas(@Positive @PathVariable Integer idPersona) {
        ResponseEntity<List<RespuestaDTORespuesta>> objRespuesta = new ResponseEntity<List<RespuestaDTORespuesta>>(
            this.objMapeador.mappearDeRespuestasARespuesta(this.objGestionarRespuestasCUIntPort.listarRespuestasPorDocenteConId(idPersona)),
            HttpStatus.OK
        );
        return objRespuesta;
    }

    @GetMapping("/consultar/{numeroIdentificacion}")
    public ResponseEntity<List<RespuestaDTORespuesta>> consultarRespuestas(@PathVariable String numeroIdentificacion) {
        ResponseEntity<List<RespuestaDTORespuesta>> objRespuesta = new ResponseEntity<List<RespuestaDTORespuesta>>(
            this.objMapeador.mappearDeRespuestasARespuesta(this.objGestionarRespuestasCUIntPort.listarRespuestasPorDocente(numeroIdentificacion)),
            HttpStatus.OK
        );
        return objRespuesta;
    }



}
