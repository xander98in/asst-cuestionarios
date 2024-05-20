package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.CuestionarioFormateadorResultadosIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Cuestionario;

public class GestionarCuestionarioCUAdapter implements GestionarCuestionarioCUIntPort {

    private final GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway;
    private final CuestionarioFormateadorResultadosIntPort objCuestionarioFormateadorResultados;

    public GestionarCuestionarioCUAdapter(
        GestionarCuestionarioGatewayIntPort objRegistrarCuestionarioGateway,
        CuestionarioFormateadorResultadosIntPort objCuestionarioFormateadorResultados
    ) {
        this.objGestionarCuestionarioGateway = objRegistrarCuestionarioGateway;
        this.objCuestionarioFormateadorResultados = objCuestionarioFormateadorResultados;
    }

    @Override
    public Cuestionario crearCuestionario(Cuestionario objCuestionario) {
        Cuestionario objCuestionarioCreado = null;
        if(this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(objCuestionario.getTitulo())) {
            System.out.println("Cuestionario con ese titulo ya existe. ");
            this.objCuestionarioFormateadorResultados
                .retornarRespuestaErrorEntidadExistente("Error, se encuentra en el sistema un cuestionario con ese titulo");
        }
        else{
            objCuestionarioCreado = this.objGestionarCuestionarioGateway.guardarCuestionario(objCuestionario);
        }
        
        return objCuestionarioCreado;
    }

    @Override
    public List<Cuestionario> listarCuestionarios(String titulo) {
        List<Cuestionario> listaObtenida = objGestionarCuestionarioGateway.listarCuestionarios(titulo);
        return listaObtenida;
    }

    
}
