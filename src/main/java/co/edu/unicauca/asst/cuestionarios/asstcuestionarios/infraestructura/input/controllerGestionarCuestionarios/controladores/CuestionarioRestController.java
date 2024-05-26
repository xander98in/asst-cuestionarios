package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.controladores;

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

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Cuestionario;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.DTOPeticion.CuestionarioDTOPeticion;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.DTORespuesta.CuestionarioDTORespuesta;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.input.controllerGestionarCuestionarios.mappers.CuestionarioMapperInfraestructuraDominio;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cuestionarios")
@RequiredArgsConstructor
@Validated
public class CuestionarioRestController {

    private final GestionarCuestionarioCUIntPort objGestionarCuestionariosCUInt;
    private final CuestionarioMapperInfraestructuraDominio objMapeador;

    @PostMapping("/crear")
    public ResponseEntity<CuestionarioDTORespuesta> crearCuestionario(@Valid @RequestBody CuestionarioDTOPeticion objCuestionario) {
        Cuestionario objCuestionarioCrear = objMapeador.mappearDePeticionACuestionario(objCuestionario); 
        Cuestionario objCuestionarioCreado = objGestionarCuestionariosCUInt.crearCuestionario(objCuestionarioCrear);
        ResponseEntity<CuestionarioDTORespuesta> objRespuesta = new ResponseEntity<CuestionarioDTORespuesta>(
            objMapeador.mappearDeCuestionarioARespuesta(objCuestionarioCreado),
            HttpStatus.CREATED
        );
        
        return objRespuesta;
    }

    @GetMapping("/listar/{titulo}")
    public ResponseEntity<List<CuestionarioDTORespuesta>> listar(@PathVariable String titulo) {
        ResponseEntity<List<CuestionarioDTORespuesta>> objRespuesta = new ResponseEntity<List<CuestionarioDTORespuesta>>(
            objMapeador.mappearDeCuestionariosARespuesta(this.objGestionarCuestionariosCUInt.listarCuestionarios(titulo)),
            HttpStatus.OK
        );
        return objRespuesta;
    }

}
