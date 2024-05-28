package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.casosDeUso;

import java.util.List;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.input.GestionarDocenteCUIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.FormateadorResultadosIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarDocenteGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Docente;

public class GestionarDocenteCUAdapter implements GestionarDocenteCUIntPort {

    private final GestionarDocenteGatewayIntPort objGestionarDocenteGateway;
    private final FormateadorResultadosIntPort objFormateadorResultados;

    public GestionarDocenteCUAdapter(
        GestionarDocenteGatewayIntPort objRegistrarDocenteGateway,
        FormateadorResultadosIntPort objFormateadorResultados
    ) {
        this.objGestionarDocenteGateway = objRegistrarDocenteGateway;
        this.objFormateadorResultados = objFormateadorResultados;
    }

    @Override
    public Docente crearDocente(Docente objDocente) {
        Docente objDocenteCreado = null;
        if (this.objGestionarDocenteGateway.existeDocentePorIdentificacion(objDocente.getNumeroIdentificacion())) {
            System.out.println("Docente con ese numero de identificación ya existe.");
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadExistente("Error, se encuentra en el sistema un docente con ese número de identificación");
        }
        else{

            if(this.objGestionarDocenteGateway.existeDocentePorCorreo(objDocente.getCorreo())) {
                this.objFormateadorResultados
                    .retornarRespuestaErrorEntidadExistente("Error, el correo ingresado ya existe en el sistema");
            }
            else {
                objDocenteCreado = this.objGestionarDocenteGateway.guardarDocente(objDocente);
            }
        }
        
        return objDocenteCreado;
    }

    @Override
    public List<Docente> listarDocentes() {
        List<Docente> listaObtenida = objGestionarDocenteGateway.listarDocentes();
        if(listaObtenida.isEmpty()) {
            this.objFormateadorResultados
                .retornarRespuestaErrorEntidadNoExistente("No existen docentes registrados");
        }
        return listaObtenida;
    }
}
