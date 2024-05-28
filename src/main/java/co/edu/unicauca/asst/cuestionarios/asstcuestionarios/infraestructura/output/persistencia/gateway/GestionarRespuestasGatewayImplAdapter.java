package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarRespuestasGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Respuesta;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.RespuestaEntity;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios.RespuestaRepositoryInt;

@Service
@Transactional
public class GestionarRespuestasGatewayImplAdapter implements GestionarRespuestasGatewayIntPort {

    private final RespuestaRepositoryInt respuestasRepositoryInt;
    private final ModelMapper respuestasModelMapper;

    public GestionarRespuestasGatewayImplAdapter(
        RespuestaRepositoryInt respuestasRepositoryInt,
        @Qualifier("modelMapperRespuestas") ModelMapper respuestasModelMapper
    ) {
        this.respuestasRepositoryInt = respuestasRepositoryInt;
        this.respuestasModelMapper = respuestasModelMapper;
    }

    @Override
    public List<Respuesta> guardarRespuestas(List<Respuesta> respuestas) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'guardarRespuestas'");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Respuesta> listarRespuestas() {
        Iterable<RespuestaEntity> lista = this.respuestasRepositoryInt.findAll();
        List<Respuesta> listaObtenida = this.respuestasModelMapper.map(lista, new TypeToken<List<Respuesta>>() {   
        }.getType());
        return listaObtenida;
    }

    @Override
    public List<Respuesta> listarRespuestasPorDocente(String numeroIdentificacion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listarRespuestasPorDocente'");
    }

    @Override
    public Boolean sePuedeResponderCuestionario(List<Respuesta> respuestas) {
        for (Respuesta r : respuestas) {
            if (this.respuestasRepositoryInt.existeCuestionarioRespondido(r.getObjCuestionario().getIdCuestionario())) {
                return false;
            }
        }
        return true;
    }

}
