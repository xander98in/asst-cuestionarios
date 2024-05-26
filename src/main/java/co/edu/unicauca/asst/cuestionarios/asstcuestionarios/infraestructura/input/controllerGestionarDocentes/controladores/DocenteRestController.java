package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Docente;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.DTOPeticion.DocenteDTOPeticion;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.DTORespuesta.DocenteDTORespuesta;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarDocentes.mappers.DocenteMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/docentes")
@RequiredArgsConstructor
@Validated
public class DocenteRestController {

    private final GestionarDocenteCUIntPort objGestionarDocenteCUInt;
    private final DocenteMapperInfraestructuraDominio objMapeador;

    @PostMapping("/crear")
    public ResponseEntity<DocenteDTORespuesta> crearDocente(@Valid @RequestBody DocenteDTOPeticion objDocente) {
        Docente objDocenteCrear = this.objMapeador.mappearDePeticionADocente(objDocente);
        Docente objDocenteCreado = this.objGestionarDocenteCUInt.crearDocente(objDocenteCrear);
        ResponseEntity<DocenteDTORespuesta> objRespuesta = new ResponseEntity<DocenteDTORespuesta>(
            this.objMapeador.mappearDeDocenteARespuesta(objDocenteCreado),
            HttpStatus.CREATED
        );
        return objRespuesta;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<DocenteDTORespuesta>> listar() {
        ResponseEntity<List<DocenteDTORespuesta>> objRespuesta = new ResponseEntity<List<DocenteDTORespuesta>>(
            objMapeador.mappearDeDocentesARespuesta(this.objGestionarDocenteCUInt.listarDocentes()),
            HttpStatus.OK
        );
        return objRespuesta;
    }

}
