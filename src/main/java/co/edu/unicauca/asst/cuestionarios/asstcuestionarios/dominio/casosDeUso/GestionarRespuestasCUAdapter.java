package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input.GestionarRespuestasCUIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarRespuestasGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Respuesta;

public class GestionarRespuestasCUAdapter implements GestionarRespuestasCUIntPort {

    private final GestionarRespuestasGatewayIntPort objGestionarRespuestasGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarRespuestasCUAdapter(
        GestionarRespuestasGatewayIntPort objRegistrarRespuestasGateway,
        FormateadorResultadosIntPort objFormateadorResultados
    ) {
        this.objGestionarRespuestasGateway = objRegistrarRespuestasGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public List<Respuesta> crearRespuestas(List<Respuesta> respuestas) {
        List<Respuesta> respuestasCreadas = null;
        if(!this.objGestionarRespuestasGateway.sePuedeResponderCuestionario(respuestas)) {
            System.out.println("Cuestionario ya respondido");
            this.objFormateadorResultados
                .retornarRespuestaErrorReglaDeNegocio("Error, el cuestionario ya fue respondido por un docente");
        }
        else {
            respuestasCreadas = this.objGestionarRespuestasGateway.guardarRespuestas(respuestas);
        }
    
        return respuestasCreadas;
    }

    @Override
    public List<Respuesta> listarRespuestas() {
        List<Respuesta> listaObtenida = this.objGestionarRespuestasGateway.listarRespuestas();
        return listaObtenida;
    }

    @Override
    public List<Respuesta> listarRespuestasPorDocente(String numeroIdentificacion) {
        List<Respuesta> listaObtenida = this.objGestionarRespuestasGateway.listarRespuestasPorDocente(numeroIdentificacion);
        if(listaObtenida.isEmpty()) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExistente("No existen respuestas asociadas al docente con ID: " + numeroIdentificacion);
        }
        return listaObtenida;
    }

    @Override
    public List<Respuesta> listarRespuestasPorDocenteConId(Integer idPersona) {
        List<Respuesta> listaObtenida = this.objGestionarRespuestasGateway.listarRespuestasPorDocenteConId(idPersona);
        if(listaObtenida.isEmpty()) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExistente("No existen respuestas asociadas al docente con ID: " + idPersona);
        }
        return listaObtenida;
    }

}
