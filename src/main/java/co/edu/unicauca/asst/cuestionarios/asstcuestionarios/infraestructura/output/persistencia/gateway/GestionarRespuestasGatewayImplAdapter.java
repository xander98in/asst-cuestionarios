package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.gateway;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarRespuestasGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Respuesta;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.RespuestaEntity;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios.CuestionarioRepositoryInt;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios.DocenteRepositoryInt;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios.PreguntaRepositoryInt;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios.RespuestaRepositoryInt;

@Service
@Transactional
public class GestionarRespuestasGatewayImplAdapter implements GestionarRespuestasGatewayIntPort {

    private final RespuestaRepositoryInt respuestasRepositoryInt;
    private final DocenteRepositoryInt docenteRepositoryInt;
    private final CuestionarioRepositoryInt cuestionarioRepositoryInt;
    private final PreguntaRepositoryInt preguntaRepositoryInt;
    private final ModelMapper respuestasModelMapper;

    public GestionarRespuestasGatewayImplAdapter(
        RespuestaRepositoryInt respuestasRepositoryInt,
        DocenteRepositoryInt docenteRepositoryInt,
        CuestionarioRepositoryInt cuestionarioRepositoryInt,
        PreguntaRepositoryInt preguntaRepositoryInt,
        @Qualifier("modelMapperRespuestas") ModelMapper respuestasModelMapper
    ) {
        this.respuestasRepositoryInt = respuestasRepositoryInt;
        this.docenteRepositoryInt = docenteRepositoryInt;
        this.cuestionarioRepositoryInt = cuestionarioRepositoryInt;
        this.preguntaRepositoryInt = preguntaRepositoryInt;
        this.respuestasModelMapper = respuestasModelMapper;
    }

    @Override
    public List<Respuesta> guardarRespuestas(List<Respuesta> respuestas) {
        List<RespuestaEntity> respuestasEntity = this.respuestasModelMapper.map(respuestas, new TypeToken<List<RespuestaEntity>>() {   
        }.getType());
        respuestasEntity.forEach(r -> {
            r.setObjDocente(this.docenteRepositoryInt.findById(r.getObjDocente().getIdPersona()).get());
            r.setObjCuestionario(this.cuestionarioRepositoryInt.findById(r.getObjCuestionario().getIdCuestionario()).get());
            r.setObjPregunta(this.preguntaRepositoryInt.findById(r.getObjPregunta().getIdPregunta()).get());
        });
        List<RespuestaEntity> respuestasEntityRegistradas = new ArrayList<RespuestaEntity>();
        for(RespuestaEntity respuestaEntity: respuestasEntity) {
            RespuestaEntity objRespuestaEntityRegistrada = this.respuestasRepositoryInt.save(respuestaEntity);
            respuestasEntityRegistradas.add(objRespuestaEntityRegistrada);
        }
        List<Respuesta> respuestasRespuesta = this.respuestasModelMapper.map(respuestasEntityRegistradas, new TypeToken<List<Respuesta>>() {
        }.getType());
        return respuestasRespuesta;
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
        Iterable<RespuestaEntity> lista = this.respuestasRepositoryInt.findByNumeroIdentificacion(numeroIdentificacion);
        List<Respuesta> listaObtenida = this.respuestasModelMapper.map(lista, new TypeToken<List<Respuesta>>() {   
        }.getType());
        return listaObtenida;
    }

    @Override
    public List<Respuesta> listarRespuestasPorDocenteConId(Integer idPersona) {
        Iterable<RespuestaEntity> lista = this.respuestasRepositoryInt.findByIdPersona(idPersona);
        List<Respuesta> listaObtenida = this.respuestasModelMapper.map(lista, new TypeToken<List<Respuesta>>() {   
        }.getType());
        return listaObtenida;
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
