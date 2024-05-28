package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input.GestionarCuestionarioCUIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Cuestionario;

public class GestionarCuestionarioCUAdapter implements GestionarCuestionarioCUIntPort {

    private final GestionarCuestionarioGatewayIntPort objGestionarCuestionarioGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarCuestionarioCUAdapter(
        GestionarCuestionarioGatewayIntPort objRegistrarCuestionarioGateway,
        FormateadorResultadosIntPort objFormateadorResultados
    ) {
        this.objGestionarCuestionarioGateway = objRegistrarCuestionarioGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public Cuestionario crearCuestionario(Cuestionario objCuestionario) {
        Cuestionario objCuestionarioCreado = null;
        if(this.objGestionarCuestionarioGateway.existeCuestionarioPorTitulo(objCuestionario.getTitulo())) {
            System.out.println("Cuestionario con ese titulo ya existe. ");
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadExistente("Error, se encuentra en el sistema un cuestionario con ese titulo");
        }
        else{
            objCuestionarioCreado = this.objGestionarCuestionarioGateway.guardarCuestionario(objCuestionario);
        }
        
        return objCuestionarioCreado;
    }

    @Override
    public List<Cuestionario> listarCuestionariosConTitulo(String titulo) {
        List<Cuestionario> listaObtenida = objGestionarCuestionarioGateway.listarCuestionariosConTitulo(titulo);
        if(listaObtenida.isEmpty()) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExistente("No existen cuestionarios registrados con: " + titulo);
        }
        return listaObtenida;
    }

    @Override
    public List<Cuestionario> listarCuestionarios() {
        List<Cuestionario> listaObtenida = objGestionarCuestionarioGateway.listarCuestionarios();
        if(listaObtenida.isEmpty()) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExistente("No existen cuestionarios registrados");
        }
        return listaObtenida;
    }
}
