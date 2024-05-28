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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'crearRespuestas'");
    }

    @Override
    public List<Respuesta> listarRespuestas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarRespuestas'");
    }

    @Override
    public List<Respuesta> listarRespuestasPorDocente(String numeroIdentificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarRespuestasPorDocente'");
    }

}
