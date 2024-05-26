package co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.gateway;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.aplicacion.output.GestionarCuestionarioGatewayIntPort;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.dominio.modelos.Cuestionario;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.entidades.CuestionarioEntity;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios.CuestionarioRepositoryInt;
import co.edu.unicauca.asst.cuestionarios.asstcuestionarios.infraestructura.output.persistencia.repositorios.TipoPreguntaRepositoryInt;

@Service
@Transactional
public class GestionarCuestionarioGatewayImplAdapter implements GestionarCuestionarioGatewayIntPort {

    private final CuestionarioRepositoryInt cuestionarioRepositoryInt;
    private final TipoPreguntaRepositoryInt tipoPreguntaRepositoryInt;
    private final ModelMapper cuestionarioModelMapper;

    public GestionarCuestionarioGatewayImplAdapter(
        CuestionarioRepositoryInt cuestionarioRepositoryInt,
        TipoPreguntaRepositoryInt tipoPreguntaRepositoryInt,
        @Qualifier("modelMapperCuestionario") ModelMapper cuestionarioModelMapper) 
    {
        this.cuestionarioRepositoryInt = cuestionarioRepositoryInt;
        this.tipoPreguntaRepositoryInt = tipoPreguntaRepositoryInt;
        this.cuestionarioModelMapper = cuestionarioModelMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existeCuestionarioPorTitulo(String titulo) {
        return this.cuestionarioRepositoryInt.existeCuestionarioConTitulo(titulo);
    }

    @Override
    @Transactional
    public Cuestionario guardarCuestionario(Cuestionario objCuestionario) {
        CuestionarioEntity objCuestionarioEntity = this.cuestionarioModelMapper.map(objCuestionario, CuestionarioEntity.class);
        objCuestionarioEntity.getPreguntas().forEach(p -> p.setObjCuestionario(objCuestionarioEntity)); 
        objCuestionarioEntity.getPreguntas().forEach(p -> p.setObjTipoPregunta(
            this.tipoPreguntaRepositoryInt.findById(p.getObjTipoPregunta().getIdTipoPregunta()).get()));
        CuestionarioEntity objCuestionarioEntityRegistrado = this.cuestionarioRepositoryInt.save(objCuestionarioEntity);

        Cuestionario objCuestionarioRespuesta = this.cuestionarioModelMapper.map(objCuestionarioEntityRegistrado, Cuestionario.class);

        return objCuestionarioRespuesta;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Cuestionario> listarCuestionarios(String titulo) {
        Iterable<CuestionarioEntity> lista = this.cuestionarioRepositoryInt.findAllByTituloContainingIgnoreCaseOrderByIdCuestionarioDesc(titulo);
        List<Cuestionario> listaObtenida = this.cuestionarioModelMapper.map(lista, new TypeToken<List<Cuestionario>>() {
        }.getType());
        return listaObtenida;
    }

}
